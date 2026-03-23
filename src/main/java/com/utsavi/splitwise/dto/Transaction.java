package com.utsavi.splitwise.dto;

import com.utsavi.splitwise.model.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Transaction {
  private User fromUser;
  private User toUser;
  private Integer totalAmount;
}
