package com.apigateway.function.apigateway.function;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${functiontrigger.rabbitmq.exchange}")
    private String exchange;

    public boolean produceFunctionMessage(String functionName, String  functionRequestBody){
        String functionMessage ;

        functionMessage = "{ 'functionName : '" + functionName + "," +  " 'functionRequestBody : ' " + functionRequestBody + "}";
        try {
            amqpTemplate.convertAndSend(exchange, "", functionMessage);

            return true;

        }catch (Exception exp){
            //logging

            return false;
        }
    }

    public MessageService(){


    }
}
