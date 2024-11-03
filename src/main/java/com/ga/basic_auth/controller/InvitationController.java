package com.ga.basic_auth.controller;

import com.ga.basic_auth.dto.request.ChangePasswordRequestDto;
import com.ga.basic_auth.dto.request.InviteAcceptDto;
import com.ga.basic_auth.dto.request.InviteRequestDto;
import com.ga.basic_auth.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/invitations")
public class InvitationController {

  @Autowired
  private InvitationService invitationService;

  @PostMapping("/send")
  public ResponseEntity<?> sendInvite(@RequestBody InviteRequestDto inviteRequestDto) {
    return invitationService.sendInvitation(inviteRequestDto);
  }

    @PostMapping("/accept")
  public ResponseEntity<?> acceptInvitation(@RequestBody InviteAcceptDto acceptRequestDto) {
    return invitationService.updateInvitationStatus(acceptRequestDto.getToken());
  }

}
