package com.utsavi.splitwise.stratergy;

import com.utsavi.splitwise.dto.Transaction;
import com.utsavi.splitwise.model.Expense;
import com.utsavi.splitwise.model.User;
import com.utsavi.splitwise.model.UserExpense;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component("ConsecutiveSettleUpStrategy")
public class ConsecutiveSettleUpStrategy implements SettleUpStrategy{
  @Override
  public List<Transaction> settle(List<Expense> expenses) {
    HashMap<User , Integer> expenseMap = new HashMap<>();
    for(Expense expense : expenses){
      for(UserExpense userExpense: expense.getPaidByUsers()){

        User currentUser = userExpense.getUser();

        //Add All Paid By transaction Amount
        if(expenseMap.containsKey(currentUser)){
          expenseMap.put(currentUser, expenseMap.get(currentUser) + userExpense.getAmount());
        }else{
          expenseMap.put(currentUser, userExpense.getAmount());
        }
      }
    }

    for(Expense expense : expenses){
      for(UserExpense userExpense: expense.getPaidForUsers()){

        User currentUser = userExpense.getUser();

        //Subtrack All Paid For transaction Amount
        if(expenseMap.containsKey(currentUser)){
          expenseMap.put(currentUser, expenseMap.get(currentUser) - userExpense.getAmount());
        }else{
          expenseMap.put(currentUser, userExpense.getAmount());
        }
      }
    }

    List<Transaction> transactions = new ArrayList<>();

    for(User user: expenseMap.keySet()){
      System.out.println(user.getUsername() + " " + expenseMap.get(user));
    }

    List<User> userList = new ArrayList<>(expenseMap.keySet());

    for(int i = 0 ; i<userList.size() - 1 ; i++){
      Transaction transaction;
      if(expenseMap.get(userList.get(i)) < 0){
        transaction = Transaction.builder()
            .fromUser(userList.get(i))
            .toUser(userList.get(i + 1))
            .totalAmount(Math.abs(expenseMap.get(userList.get(i))))
            .build();

        transactions.add(transaction);

      }else if(expenseMap.get(userList.get(i)) > 0){
        transaction = Transaction.builder()
            .fromUser(userList.get(i + 1))
            .toUser(userList.get(i))
            .totalAmount(Math.abs(expenseMap.get(userList.get(i))))
            .build();

        transactions.add(transaction);
      }

      expenseMap.put(userList.get(i + 1), expenseMap.get(userList.get(i + 1)) - expenseMap.get(userList.get(i)));
    }

    return transactions;
  }
}
