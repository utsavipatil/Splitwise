package com.utsavi.splitwise.stratergy;

import com.utsavi.splitwise.dto.Transaction;
import com.utsavi.splitwise.model.Expense;

import java.util.List;

public interface SettleUpStrategy {
  List<Transaction> settle(List<Expense> expenses);
}
