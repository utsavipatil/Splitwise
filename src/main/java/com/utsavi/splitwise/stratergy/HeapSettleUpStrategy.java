package com.utsavi.splitwise.stratergy;

import com.utsavi.splitwise.dto.Transaction;
import com.utsavi.splitwise.model.Expense;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("HeapSettleUpStrategy") //Spring, please create an object of this class and manage it.
public class HeapSettleUpStrategy implements SettleUpStrategy{
  @Override
  public List<Transaction> settle(List<Expense> expenses) {

    return new ArrayList<>();
  }
}
