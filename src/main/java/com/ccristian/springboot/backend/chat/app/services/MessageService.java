package com.ccristian.springboot.backend.chat.app.services;

import com.ccristian.springboot.backend.chat.app.models.Message;

import java.util.List;

public interface MessageService {
    List<Message> findAll();
    void save(Message message);
}
