package com.ga.basic_auth.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "invitation")
public class Invitation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String email;

  @Column
  @Enumerated(EnumType.STRING)
  private InvitationStatus status;

  @Column
  private String token;

  @Column
  private LocalDateTime sentDate;

  @JsonIgnore
  @ManyToOne()
  @JoinColumn(name = "user_id",nullable = false)
  private User user;

  @ManyToOne
  @JoinColumn(name = "familyid", nullable = false)
  private Family family;
}
