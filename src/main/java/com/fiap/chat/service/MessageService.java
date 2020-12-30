package com.fiap.chat.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.chat.entity.Message;

public interface MessageService extends JpaRepository<Message, Long>{

}
