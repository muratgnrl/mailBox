package com.example.mailbox.repo;

import com.example.mailbox.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Integer> {
    public List<Message> findAllByConsumerContaining(String mail);

    public List<Message> findAllByPublisherContaining(String mail);

    Message findMessageByMessageId(int messageId);
}
