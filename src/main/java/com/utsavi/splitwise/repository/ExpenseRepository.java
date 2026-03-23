package com.utsavi.splitwise.repository;

import com.utsavi.splitwise.model.Expense;
import com.utsavi.splitwise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
  @Query("SELECT DISTINCT e FROM Expense e " +
          "LEFT JOIN e.paidByUsers pbu " +
          "LEFT JOIN e.paidForUsers pfu " +
          "WHERE pbu.user = :user OR pfu.user = :user")
  List<Expense> findAllByPaidByUsersOrPaidForUsers(User user);
}
