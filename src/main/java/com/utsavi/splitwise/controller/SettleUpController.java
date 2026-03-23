package com.utsavi.splitwise.controller;

import com.utsavi.splitwise.dto.SettleUpGroupResponseDto;
import com.utsavi.splitwise.service.SettleUpGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SettleUpController {

  private SettleUpGroup settleUpGroup;

  @Autowired
  public SettleUpController(SettleUpGroup settleUpGroup){
    this.settleUpGroup = settleUpGroup;
  }

  public SettleUpGroupResponseDto settleUpGroup(Long groupId){
    return settleUpGroup.settleUpGroup(groupId);
  }

  public SettleUpGroupResponseDto settleUpUser(Long userId){
    return settleUpGroup.settleUpUser(userId);
  }
}
