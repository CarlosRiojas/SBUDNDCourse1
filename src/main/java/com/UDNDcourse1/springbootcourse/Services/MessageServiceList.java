package com.UDNDcourse1.springbootcourse.Services;

import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceList {

    private List<String> messages;


    @PostConstruct
    public void postConstruct(){
        this.messages = new ArrayList<>();
    }


    public void addMessage(String message){
        messages.add(message);
    }

    public List<String> getMessages(){
        return new ArrayList<>(this.messages);
    }
}
