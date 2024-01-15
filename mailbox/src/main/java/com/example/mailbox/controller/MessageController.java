package com.example.mailbox.controller;

import com.example.mailbox.dto.Item;
import com.example.mailbox.dto.MessageDto;
import com.example.mailbox.dto.UserDto;
import com.example.mailbox.response.MessageListResponse;
import com.example.mailbox.response.MessageResponse;
import com.example.mailbox.service.MessageService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/consumer")
    public MessageListResponse findConsumer(@RequestBody Item item ){
        return messageService.findAllByConsumer(item);
    }

    @PostMapping("/publisher")
    public MessageListResponse findPublisher(@RequestBody Item item){
        return messageService.findPublisher(item);
    }
    @GetMapping("/find/{messageId}")
    public MessageResponse findMessage(@PathVariable (value = "messageId") int messageId){
        return messageService.findMessage(messageId);
    }

    @PostMapping("/send/{userId}")
    public MessageResponse sendMessage(@RequestBody MessageDto messageDto,@PathVariable (value = "userId")int userId){
        return messageService.sendMessage(messageDto,userId);
    }
}
