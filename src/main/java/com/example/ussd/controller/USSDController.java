package com.example.ussd.controller;

import com.example.ussd.request.MessagesRequest;
import com.example.ussd.service.USSDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * ussd
 *
 * @author longtcs
 * @created_at 09/06/2020 - 15:05
 * @created_by longtcs
 * @since 09/06/2020
 */
@RestController
@RequestMapping("/ussd")
public class USSDController {
    @Autowired
    private USSDService ussdService;

    @PostMapping("/start")
    public ResponseEntity<?> handleUSSD(@ModelAttribute MessagesRequest messagesRequest){
         return ResponseEntity.ok(ussdService.handleUSSDService(messagesRequest));
    }

}
