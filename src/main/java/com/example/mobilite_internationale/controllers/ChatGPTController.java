package com.example.mobilite_internationale.controllers;

import com.example.mobilite_internationale.services.ChatGPTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
public class ChatGPTController {
    @Autowired
    private ChatGPTService chatGPTService;

    @RequestMapping(value = "/ask", method = RequestMethod.POST)
    public ResponseEntity<String> askQuestion(@RequestBody Map<String, String> requestBody) throws IOException {
        String question = requestBody.get("question");
        String response = chatGPTService.askQuestion(question);
        return ResponseEntity.ok(response);
    }
}
