package com.utsavi.splitwise.service;

import com.utsavi.splitwise.dto.Transaction;
import com.utsavi.splitwise.dto.SettleUpGroupResponseDto;
import com.utsavi.splitwise.enums.ResponseStatus;
import com.utsavi.splitwise.model.Expense;
import com.utsavi.splitwise.model.Group;
import com.utsavi.splitwise.model.User;
import com.utsavi.splitwise.repository.ExpenseRepository;
import com.utsavi.splitwise.repository.GroupRepository;
import com.utsavi.splitwise.repository.UserRepository;
import com.utsavi.splitwise.stratergy.SettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettleUpGroup {

  private SettleUpStrategy settleUpStrategy;
  private UserRepository userRepository;
  private GroupRepository groupRepository;
  private ExpenseRepository expenseRepository;

  @Autowired
  public SettleUpGroup(SettleUpStrategy settleUpStrategy, UserRepository userRepository, GroupRepository groupRepository, ExpenseRepository expenseRepository){
    this.settleUpStrategy = settleUpStrategy;
    this.userRepository = userRepository;
    this.groupRepository = groupRepository;
    this.expenseRepository = expenseRepository;
  }

  public SettleUpGroupResponseDto settleUpGroup(Long groupId){
    if(groupId == null){
      throw new RuntimeException("Group Invalid !!!");
    }

    try{

      Group group = groupRepository.findById(groupId).orElseThrow(() -> new RuntimeException("Group not found"));
      List<Expense> groupExpenses = group.getExpenses();

      List<Transaction> transactions = settleUpStrategy.settle(groupExpenses);

      return SettleUpGroupResponseDto.builder()
          .transactions(transactions)
          .responseStatus(ResponseStatus.SUCCESS)
          .build();
    }catch (Exception e){
      return SettleUpGroupResponseDto.builder()
          .responseStatus(ResponseStatus.FAILURE)
          .build();
    }
  }

  public SettleUpGroupResponseDto settleUpUser(Long userId){
    if(userId == null){
      throw new RuntimeException("User Invalid !!!");
    }

    try{
      User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
      List<Expense> userExpenses = expenseRepository.findAllByPaidByUsersOrPaidForUsers(user);
      List<Transaction> transactions = settleUpStrategy.settle(userExpenses);

      return SettleUpGroupResponseDto.builder()
          .transactions(transactions)
          .responseStatus(ResponseStatus.SUCCESS)
          .build();
    }catch (Exception e){
      return SettleUpGroupResponseDto.builder()
          .responseStatus(ResponseStatus.FAILURE)
          .build();
    }
  }
}
