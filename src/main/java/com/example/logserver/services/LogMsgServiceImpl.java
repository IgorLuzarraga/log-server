package com.example.logserver.services;

import com.example.logserver.domain.LogMessage;
import com.example.logserver.repositories.LogMsgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class LogMsgServiceImpl implements LogMsgService {
    private LogMsgRepository logMsgRepository;

    @Autowired
    public LogMsgServiceImpl(LogMsgRepository logMsgRepository){
        this.logMsgRepository = logMsgRepository;
    }

    @Override
    public List<LogMessage> findAll(){
        return logMsgRepository.findAll();
    }

    @Override
    public LogMessage save(LogMessage logMsg){
       return logMsgRepository.save(logMsg);
    }

    @Override
    public void deleteAll(){
        logMsgRepository.deleteAll();
    }
}
