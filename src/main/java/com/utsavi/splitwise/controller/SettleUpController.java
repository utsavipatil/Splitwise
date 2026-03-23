package com.utsavi.splitwise.controller;

import com.utsavi.splitwise.dto.SettleUpGroupRequestDto;
import com.utsavi.splitwise.dto.SettleUpGroupResponseDto;
import com.utsavi.splitwise.dto.SettleUpUserRequestDto;
import com.utsavi.splitwise.service.SettleUpGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SettleUpController {

  private SettleUpGroupService settleUpGroupService;

  @Autowired
  public SettleUpController(SettleUpGroupService settleUpGroupService){
    this.settleUpGroupService = settleUpGroupService;
  }

  public SettleUpGroupResponseDto settleUpGroup(SettleUpGroupRequestDto settleUpGroupRequestDto){
    return settleUpGroupService.settleUpGroup(settleUpGroupRequestDto.getGroupId(), settleUpGroupRequestDto.getSettUpType());
  }

  public SettleUpGroupResponseDto settleUpUser(SettleUpUserRequestDto settleUpUserRequestDto){
    return settleUpGroupService.settleUpUser(settleUpUserRequestDto.getUserId(), settleUpUserRequestDto.getSettleUpType());
  }
}
