package com.utsavi.splitwise.stratergy;

import com.utsavi.splitwise.dto.Transaction;
import com.utsavi.splitwise.model.Expense;
import com.utsavi.splitwise.model.User;
import com.utsavi.splitwise.model.UserExpense;
import org.springframework.stereotype.Component;

import java.util.*;

@Component("HeapSettleUpStrategy") //Spring, please create an object of this class and manage it.
public class HeapSettleUpStrategy implements SettleUpStrategy{
  @Override
  public List<Transaction> settle(List<Expense> expenses) {
    HashMap<User, Integer> balanceMap = calculateBalances(expenses);
    return settleBalances(balanceMap);
  }

  private HashMap<User, Integer> calculateBalances(List<Expense> expenses) {
    HashMap<User, Integer> balanceMap = new HashMap<>();

    for (Expense expense : expenses) {
      for (UserExpense userExpense : expense.getPaidByUsers()) {
        User user = userExpense.getUser();
        balanceMap.put(user, balanceMap.getOrDefault(user, 0) + userExpense.getAmount());
      }

      for (UserExpense userExpense : expense.getPaidForUsers()) {
        User user = userExpense.getUser();
        balanceMap.put(user, balanceMap.getOrDefault(user, 0) - userExpense.getAmount());
      }
    }

    return balanceMap;
  }

  private List<Transaction> settleBalances(HashMap<User, Integer> balanceMap) {
    PriorityQueue<Map.Entry<User, Integer>> creditors = new PriorityQueue<>(
        (a, b) -> b.getValue().compareTo(a.getValue())
    );

    PriorityQueue<Map.Entry<User, Integer>> debtors = new PriorityQueue<>(
        (a, b) -> a.getValue().compareTo(b.getValue())
    );

    for (Map.Entry<User, Integer> entry : balanceMap.entrySet()) {
      if (entry.getValue() > 0) {
        creditors.offer(entry);
      } else if (entry.getValue() < 0) {
        debtors.offer(entry);
      }
    }

    List<Transaction> transactions = new ArrayList<>();
    while (!creditors.isEmpty() && !debtors.isEmpty()) {
      Map.Entry<User, Integer> creditor = creditors.poll();
      Map.Entry<User, Integer> debtor = debtors.poll();

      int settlementAmount = Math.min(creditor.getValue(), -debtor.getValue());
      transactions.add(Transaction.builder()
          .fromUser(debtor.getKey())
          .toUser(creditor.getKey())
          .totalAmount(settlementAmount)
          .build());

      creditor.setValue(creditor.getValue() - settlementAmount);
      debtor.setValue(debtor.getValue() + settlementAmount);

      if (creditor.getValue() > 0) {
        creditors.offer(creditor);
      }
      if (debtor.getValue() < 0) {
        debtors.offer(debtor);
      }
    }

    return transactions;
  }
}
