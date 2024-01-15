package com.example.mailbox.service;

import com.example.mailbox.dto.Item;
import com.example.mailbox.dto.MessageDto;
import com.example.mailbox.model.Account;
import com.example.mailbox.model.Message;
import com.example.mailbox.repo.MessageRepository;
import com.example.mailbox.response.MessageListResponse;
import com.example.mailbox.response.MessageResponse;
import com.example.mailbox.response.Meta;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    private final AccountService accountService;

    public MessageService(MessageRepository messageRepository, AccountService accountService, AccountService accountService1) {
        this.messageRepository = messageRepository;
        this.accountService = accountService1;
    }


    public MessageListResponse findAllByConsumer(Item item) {
        MessageListResponse messageListResponse = new MessageListResponse();
        messageListResponse.messageList = Message.toResourceList(messageRepository.findAllByConsumerContaining(item.mail));
        messageListResponse.meta = new Meta(200);
        return messageListResponse;
    }

    public MessageListResponse findPublisher(Item item) {
        MessageListResponse messageListResponse = new MessageListResponse();
        messageListResponse.messageList = Message.toResourceList(messageRepository.findAllByPublisherContaining(item.mail));
        messageListResponse.meta = new Meta(200);
        return messageListResponse;

    }

    public MessageResponse findMessage(int messageId) {
        MessageResponse messageResponse = new MessageResponse();
        Message message = messageRepository.findMessageByMessageId(messageId);
        message.setStatus(1);
        message = messageRepository.save(message);
        messageResponse.messageDto = Message.toResource(message);
        messageResponse.meta = new Meta(200);
        return messageResponse;
    }

    public MessageResponse sendMessage(MessageDto messageDto, int userId)  {
        MessageResponse messageResponse = new MessageResponse();
        Account account = accountService.findAccount(userId);
        Message message = Message.fromResource(messageDto, account);
        message = messageRepository.save(message);
        if (message == null)

        messageResponse.meta = new Meta(200);
        return messageResponse;
    }
}
