package com.utsavi.splitwise.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@MappedSuperclass //Map all these attributes to subclasses
public class BaseModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) //counter - 1,2,3,4...
  private Long id;
  private Date createdAt;
  private Date updatedAt;
}
