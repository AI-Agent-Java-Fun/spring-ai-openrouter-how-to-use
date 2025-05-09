package org.example;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class Controller {

    ChatClient client;

    public Controller(ChatClient client) {
        this.client = client;
    }

    @PostMapping
    public String send(@RequestBody TextFromUser prompt) {
        return client.prompt().user(prompt.text).call().content();
    }
}
