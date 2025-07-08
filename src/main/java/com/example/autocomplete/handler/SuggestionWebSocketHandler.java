package com.example.autocomplete.handler;

import com.example.autocomplete.model.SuggestionResponse;
import com.example.autocomplete.service.AutoCompleteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class SuggestionWebSocketHandler extends TextWebSocketHandler {

    @Autowired
    private AutoCompleteService service;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String prefix = message.getPayload().trim();

        // Get suggestions from service
        SuggestionResponse response = service.getSuggestions(prefix);

        // Convert to JSON and send
        ObjectMapper mapper = new ObjectMapper();
        session.sendMessage(new TextMessage(mapper.writeValueAsString(response)));
    }
}