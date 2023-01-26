package com.nova.messegeservice.repository;

import com.nova.messegeservice.model.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MessageRepository extends JpaRepository<Message, Long> {
    @Query("from Message m where m.chatId = :chatId order by m.sent asc ")
    Page<Message> findByChatId(String chatId, Pageable pageable);
}
