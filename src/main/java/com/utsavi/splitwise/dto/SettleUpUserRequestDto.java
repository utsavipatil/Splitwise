package com.utsavi.splitwise.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SettleUpUserRequestDto {
  private Long userId;
  private String settleUpType;
}
