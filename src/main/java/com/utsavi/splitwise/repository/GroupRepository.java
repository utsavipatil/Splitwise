package com.utsavi.splitwise.repository;

import com.utsavi.splitwise.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
