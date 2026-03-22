package com.utsavi.splitwise.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseModel {
  private String username;
  private String phoneNo;
  private String password;

  @ManyToMany
  @JoinTable(
      name = "group_members",
      joinColumns = @JoinColumn(name = "user_id"), //Refers to the current entity’s foreign key column
      inverseJoinColumns = @JoinColumn(name = "group_id") //Refers to the other entity’s foreign key column
  )
  private List<Group> groups;

  @ManyToMany
  private List<Expense> expenses; //All Expenses with and without group
}
