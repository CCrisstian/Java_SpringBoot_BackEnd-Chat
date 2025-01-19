package com.ccristian.springboot.backend.chat.app.controllers;

import com.ccristian.springboot.backend.chat.app.models.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.Random;

@Controller
public class ChatController {

    private String[] colors = {
            "red", "blue", "green", "magenta", "orange", "purple", "yellow",
            "cyan", "pink", "brown", "black", "gray", "teal", "lime", "gold", "silver"
    };

    @MessageMapping("/message") /*Para publicar un mensaje*/
    @SendTo("/chat/message")    /*Para recibir mensajes de los Usuarios*/
    public Message receiveMessage(Message message){
        message.setDate(new Date().getTime());

        if (message.getType().equals("NEW_USER")){
            message.setColor(this.colors[new Random().nextInt(colors.length)]);
            message.setText("Nuevo usuario");
        }

        return message;
    }
}
