package com.UDNDcourse1.springbootcourse.Controller;

import com.UDNDcourse1.springbootcourse.POJO.MessageForm;
import com.UDNDcourse1.springbootcourse.Services.MessageServiceList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.time.Instant;

@Controller
public class HomeController {

    private MessageServiceList messageServiceList;


    public HomeController(MessageServiceList messageServiceList) {
        this.messageServiceList = messageServiceList;
    }


    @GetMapping("/home")
    public String getHomePage(@ModelAttribute("newMessage") MessageForm newMessage, Model model){
        model.addAttribute("greetings", this.messageServiceList.getMessages());

        return "home";
    }

    @PostMapping("/home")
    public String addMessage(@ModelAttribute("newMessage") MessageForm messageForm, Model model){
        messageServiceList.addMessage(messageForm.getText());
        model.addAttribute("greetings", messageServiceList.getMessages());
        messageForm.setText("");
        return "home";
    }

}
