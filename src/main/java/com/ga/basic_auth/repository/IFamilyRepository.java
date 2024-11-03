package com.ga.basic_auth.repository;

import com.ga.basic_auth.model.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFamilyRepository extends JpaRepository<Family, Long> {

  public Family findByFamilyName(String familyName);
  public boolean existsByFamilyName(String familyName);
}
