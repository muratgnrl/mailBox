package com.example.mailbox.dto;

import com.example.mailbox.model.Account;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

public class MessageDto implements Serializable {

    public int messageId;
    public String consumer;
    public String publisher;
    public String mailDesc;
    public String mailTitle;
    public int status;
    public String mail;
    public boolean readed;
    public Account account;
}
