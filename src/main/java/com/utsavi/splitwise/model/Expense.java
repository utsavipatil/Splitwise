package com.utsavi.splitwise.model;

import com.utsavi.splitwise.enums.ExpenseType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Expense extends BaseModel{
  private Integer amount;
  private String description;
  private Date expenseDate;

  @OneToMany(mappedBy = "expense")
  private List<UserExpense> paidByUsers;

  @OneToMany(mappedBy = "expense")
  private List<UserExpense> paidForUsers;

  @Enumerated(EnumType.STRING )
  private ExpenseType expenseType;

  @ManyToOne
  @JoinColumn(name = "group_id")
  private Group group;
}
