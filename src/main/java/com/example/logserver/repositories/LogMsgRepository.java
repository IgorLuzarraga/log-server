package com.example.logserver.repositories;

import com.example.logserver.domain.LogMessage;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LogMsgRepository  extends JpaRepository<LogMessage, Long> {
}
