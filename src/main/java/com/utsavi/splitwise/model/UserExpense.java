package com.utsavi.splitwise.model;

import com.utsavi.splitwise.enums.UserExpenseType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class UserExpense extends BaseModel{

  @ManyToOne
  private User user;
  
  @ManyToOne
  private Expense expense;
  private Integer amount;
  
  @Enumerated(EnumType.STRING )
  private UserExpenseType userExpenseType;
}
