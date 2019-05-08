package com.example.logserver.configuration;

import com.example.logserver.domain.LogMessage;
import com.example.logserver.receiver.LogReceiver;
import com.example.logserver.services.LogMsgService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class AppConfiguration {

    private final String LOG_WELCOME_MSG = "Welcome to the Log Server";

    @Bean
    public CommandLineRunner loadData(LogMsgService logMsgService,
                                      LogReceiver logReceiver) {

        return (args) -> {
            logMsgService.deleteAll();

            // send the welcome log
            logMsgService.save(new LogMessage(LOG_WELCOME_MSG));
        };
    }
}

