package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    private String welcomeMessage;


    public WelcomeController(@Value(value = "${WELCOME_MESSAGE}") String message) {
        this.welcomeMessage = message;
    }

    @GetMapping("/")
    public String sayHello(){
        return this.welcomeMessage;
    }
}