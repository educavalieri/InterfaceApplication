package com.educavalieri.interfaceIt.repositories;

import com.educavalieri.interfaceIt.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
