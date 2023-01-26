package com.nova.messegeservice.repository;

import com.nova.messegeservice.model.Chat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    @Transactional
    @Modifying
    @Query("update Chat c set c.updatedAt = :date where c.id = :chatId")
    void updateDate(@Param("date")LocalDateTime date, Long chatId);

    @Query("from Chat c where c.sender = :username or c.receiver = :username order by c.updatedAt desc")
    Page<Chat> findAll(String username, Pageable pageable);
}
