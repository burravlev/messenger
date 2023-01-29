package com.messenger.fileservice.repository;

import com.messenger.fileservice.model.Audio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudioRepository extends JpaRepository<Audio, Long> {

}
