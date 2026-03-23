package com.utsavi.splitwise.repository;

import com.utsavi.splitwise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
