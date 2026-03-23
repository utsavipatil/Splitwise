package com.utsavi.splitwise.dto;

import com.utsavi.splitwise.model.Group;
import com.utsavi.splitwise.model.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SettleUpGroupRequestDto {
  private Long groupId;
}
