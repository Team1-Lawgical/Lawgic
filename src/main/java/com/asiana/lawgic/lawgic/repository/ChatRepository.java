package com.asiana.lawgic.lawgic.repository;

import com.asiana.lawgic.lawgic.entity.Chat;
import com.asiana.lawgic.lawgic.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ChatRepository extends JpaRepository<Chat,Long> {
    @Query("SELECT chat from Chat chat INNER JOIN chat.messages m where chat.chatId=:chatId")
    public Chat getMessagesByChatId(Long chatId);

    @Query("SELECT chat.chatId FROM Chat chat where chat.lawyer.lawyerId=:lawyerId AND chat.client.clientId=:clientId")
    public Long getChatIdByLawyerAndClientId(Long lawyerId, Long clientId);
}