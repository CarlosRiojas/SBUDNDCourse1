package com.UDNDcourse1.springbootcourse.Controller;

import com.UDNDcourse1.springbootcourse.POJO.ChatForm;
import com.UDNDcourse1.springbootcourse.POJO.ChatMessage;
import com.UDNDcourse1.springbootcourse.POJO.MessageForm;
import com.UDNDcourse1.springbootcourse.Services.MessageServiceList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChatController {
    private MessageServiceList messageServiceList;

    public ChatController(MessageServiceList messageServiceList){
        this.messageServiceList = messageServiceList;
    }

    @GetMapping("/chat")
    public String getChatPage(@ModelAttribute("chatForm") ChatForm chatForm, Model model){
        model.addAttribute("chatMessages", this.messageServiceList.getChatMessages());

        return "chat";
    }

    @PostMapping("/chat")
    public String addChatMessage(@ModelAttribute("chatForm") ChatForm chatForm, Model model){
        this.messageServiceList.addChatMessages(chatForm);
        chatForm.setChatText("");
        model.addAttribute("chatMessages",messageServiceList.getChatMessages());

        return "chat";
    }

    @ModelAttribute("allMessageTypes")
    public String[] allMessageTypes () {
        return new String[] { "Say", "Shout", "Whisper" };
    }
}
