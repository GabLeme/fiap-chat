package com.fiap.chat.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.chat.entity.UserConversation;
@Repository
public interface UserConversationRepository extends JpaRepository<UserConversation, Long>{
	public Set<UserConversation> findByUserId(Long id);
}
