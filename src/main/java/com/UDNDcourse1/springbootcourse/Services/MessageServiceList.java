package com.UDNDcourse1.springbootcourse.Services;

import com.UDNDcourse1.springbootcourse.POJO.ChatForm;
import com.UDNDcourse1.springbootcourse.POJO.ChatMessage;
import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class MessageServiceList {

    private List<String> messages;

    private List<ChatMessage> chatMessages;


    @PostConstruct
    public void postConstruct(){
        this.messages = new ArrayList<>();
        this.chatMessages = new ArrayList<>();
    }


    public void addMessage(String message){
        messages.add(message);
    }

    public List<String> getMessages(){
        return new ArrayList<>(this.messages);
    }

    public List<ChatMessage> getChatMessages() {
     return chatMessages;
    }

    public void addChatMessages(ChatForm chatForm) {
        ChatMessage newMessage = new ChatMessage();
        newMessage.setUserName(chatForm.getUserName());
        switch (chatForm.getMsgType()) {
            case "Say":
                newMessage.setMessage(chatForm.getChatText());
                break;
            case "Shout":
                newMessage.setMessage(chatForm.getChatText().toUpperCase());
                break;
            case "Whisper":
                newMessage.setMessage(chatForm.getChatText().toLowerCase());
                break;
        }
        this.chatMessages.add(newMessage);
    }
}
