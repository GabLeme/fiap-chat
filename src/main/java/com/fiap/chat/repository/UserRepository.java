package com.fiap.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.chat.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByLoginEmailAndLoginPassword(String email, String password);
}
