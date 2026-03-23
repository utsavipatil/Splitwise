package com.utsavi.splitwise.dto;

import com.utsavi.splitwise.enums.ResponseStatus;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Builder
public class SettleUpGroupResponseDto {
  private String failureMessage;
  private List<Transaction> transactions;
  private ResponseStatus responseStatus;
}
