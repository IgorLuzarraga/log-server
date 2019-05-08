package com.example.logserver.services;

import com.example.logserver.domain.LogMessage;

import java.util.List;

public interface LogMsgService {
    public List<LogMessage> findAll();
    public LogMessage save(LogMessage logMsg);
    public void deleteAll();
}
