package com.javatar.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javatar.demo.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
