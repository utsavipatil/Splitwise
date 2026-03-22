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
@Entity(name = "groups")
public class Group extends BaseModel{
  private String name;
  private String description;

  @ManyToMany
  private List<User> users;
  
  @OneToMany(mappedBy = "group")
  private List<Expense> expenses;

  @ManyToOne
//  @JoinColumn(name = "group_id")
  private User admin;
}
