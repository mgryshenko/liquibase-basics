package com.mgryshenko.liquibasetest.repo;

import com.mgryshenko.liquibasetest.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
