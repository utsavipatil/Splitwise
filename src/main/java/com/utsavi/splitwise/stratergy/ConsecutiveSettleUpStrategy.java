package com.utsavi.splitwise.stratergy;

import com.utsavi.splitwise.dto.Transaction;
import com.utsavi.splitwise.model.Expense;

import java.util.ArrayList;
import java.util.List;

public class ConsecutiveSettleUpStrategy implements SettleUpStrategy{
  @Override
  public List<Transaction> settle(List<Expense> expenses) {
    return new ArrayList<>();
  }
}
