package com.UDNDcourse1.springbootcourse.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String getHomePage(Model model){
        model.addAttribute("greetings", new String[]{"Hi","Hello","goodbye"});
        return "home";
    }

}
