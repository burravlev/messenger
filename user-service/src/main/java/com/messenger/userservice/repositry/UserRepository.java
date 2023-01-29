package com.messenger.userservice.repositry;

import com.messenger.userservice.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("from User u where u.username like concat('%', :username, '%') ")
    Page<User> findByUsername(String username, Pageable pageable);
}
