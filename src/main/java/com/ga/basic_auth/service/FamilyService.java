package com.ga.basic_auth.service;

import com.ga.basic_auth.dto.response.ResponseTemplate;
import com.ga.basic_auth.exception.InformationExistsException;
import com.ga.basic_auth.model.Family;
import com.ga.basic_auth.model.User;
import com.ga.basic_auth.model.UserRole;
import com.ga.basic_auth.repository.IFamilyRepository;
import com.ga.basic_auth.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FamilyService implements BaseService{

  @Autowired
  private IFamilyRepository familyRepository;
  @Autowired
  private IUserRepository userRepository;

  public ResponseEntity<?> createFamily(Family family) throws InformationExistsException {
    if (familyRepository.existsByFamilyName(family.getFamilyName())) {
      throw new InformationExistsException("Family name already exists.");
    }

    family.setId(0L);
    Family savedFamily = familyRepository.save(family);
    User currentUser = getCurrUser();
    currentUser.setFamily(savedFamily);

    if(currentUser.getRole() != UserRole.ADMIN) {
      currentUser.setRole(UserRole.FAMILY_ADMIN);
    }
    userRepository.save(currentUser);

    return new ResponseTemplate(HttpStatus.OK, "Family created successfully");
  }
}
