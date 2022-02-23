package com.asiana.lawgic.lawgic.repository;

import com.asiana.lawgic.lawgic.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ChatRepository extends JpaRepository<Chat,Long> {
}
