package com.utsavi.splitwise.dto;

import com.utsavi.splitwise.enums.ResponseStatus;

import java.util.List;

public class SettleUpUserResponseDto {
  private List<Transaction> transactions;
  private String failureMessage;
  private ResponseStatus responseStatus;
}
