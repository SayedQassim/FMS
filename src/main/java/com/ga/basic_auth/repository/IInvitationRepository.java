package com.ga.basic_auth.repository;

import com.ga.basic_auth.model.Invitation;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IInvitationRepository extends JpaRepository<Invitation, Long>, JpaSpecificationExecutor<Invitation> {
  public Optional<Invitation> findByToken(String token);
}
