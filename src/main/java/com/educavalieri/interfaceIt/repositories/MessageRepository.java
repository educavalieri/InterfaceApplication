package com.educavalieri.interfaceIt.repositories;

import com.educavalieri.interfaceIt.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
