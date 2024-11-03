package com.ga.basic_auth.service;

import com.ga.basic_auth.dto.request.InviteRequestDto;
import com.ga.basic_auth.model.Family;
import com.ga.basic_auth.model.Invitation;
import com.ga.basic_auth.model.InvitationStatus;
import com.ga.basic_auth.model.User;
import com.ga.basic_auth.multitenant.TenantContext;
import com.ga.basic_auth.repository.IFamilyRepository;
import com.ga.basic_auth.repository.IInvitationRepository;
import com.ga.basic_auth.repository.IResetTokenRepository;
import com.ga.basic_auth.repository.IUserRepository;
import com.ga.basic_auth.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class InvitationService implements BaseService {
  @Autowired
  private IInvitationRepository invitationRepository;

  @Autowired
  private IFamilyRepository familyRepository;

  @Autowired
  private FamilyService familyService;

  @Autowired
  private IUserRepository userRepository;
  @Autowired
  @Lazy
  private EmailUtil emailUtil;


  public ResponseEntity<?> sendInvitation(InviteRequestDto requestDto) {
    Optional<User> user= userRepository.findByEmail(requestDto.getEmail());

    if(user.isEmpty())
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no Registered user with the same email has been found");


    Long tenantId = TenantContext.getTenantId();
    Family loggedInfamily = familyRepository.findById(tenantId).get();

    if(!loggedInfamily.getFamilyName().equals(requestDto.getFamilyName()))
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body("family name does not match");

    Invitation invitation = new Invitation();
    invitation.setEmail(requestDto.getEmail());
    invitation.setUser(user.get());
    invitation.setFamily(familyRepository.findByFamilyName(requestDto.getFamilyName()).orElse(familyRepository.findByFamilyName("Unassigned").get()));
    invitation.setStatus(InvitationStatus.PENDING);
    invitation.setSentDate(LocalDateTime.now());
    invitation.setToken(UUID.randomUUID().toString());

    // Logic to send email (using JavaMailSender or similar)
    StringBuilder body = new StringBuilder();
    body.append("Please click on the following link to resetPassword your account:\n\n");
    body.append("http://localhost:5000/Invitation.html?token=" + invitation.getToken() + "\n\n");
    emailUtil.sendEmail(requestDto.getEmail(), "Invitation to " + invitation.getFamily().getFamilyName() , body.toString());

    invitationRepository.save(invitation);
    return ResponseEntity.ok("Invitation sent successfully");
  }

  public ResponseEntity<?> updateInvitationStatus(String token) {

    Invitation invitation = invitationRepository.findByToken(token).orElse(null);
    System.out.println(token);
    System.out.println(invitation);

    if (invitation != null) {
      invitation.setStatus(InvitationStatus.ACCEPTED);
      invitationRepository.save(invitation);
      familyService.addToFamily(invitation.getUser(), invitation.getFamily());
    }

    return ResponseEntity.ok("Invitation added to family successfully");
  }

}
