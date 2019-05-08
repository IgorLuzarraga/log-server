package com.example.logserver.receiver;

import com.example.logserver.frontend.IAddLogsToGrid;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class LogReceiver {
    private final String QUEUE_NAME = "LOG_MESSAGES_QUEUE";
    private IAddLogsToGrid addLogsToGrid;

    public LogReceiver(){
    }

    @Bean
    Queue queue(){
        return new Queue(QUEUE_NAME, false);
    }

    @RabbitListener(queues = QUEUE_NAME)
    public void receiveLogMessage(String log){
        if (log != null) {
            System.out.println(log);
            addLogsToGrid.onReceive(log);
        }
    }

    public void setAddLogsToGrid(IAddLogsToGrid e) {
        addLogsToGrid = e;
    }
}

