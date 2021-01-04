package com.fiap.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.chat.entity.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
