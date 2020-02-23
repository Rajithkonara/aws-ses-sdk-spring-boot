package com.rkdevblog.ses.controller;

import com.rkdevblog.ses.dto.EmailRequestDto;
import com.rkdevblog.ses.exception.AwsSesClientException;
import com.rkdevblog.ses.service.AwsSesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/email")
public class EmailController {

    private final AwsSesService awsSesService;

    @Autowired
    public EmailController(AwsSesService awsSesService) {
        this.awsSesService = awsSesService;
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> sendEmail(@Valid @RequestBody EmailRequestDto emailRequestDto) {
        try {
            awsSesService.sendEmail(emailRequestDto.getEmail(), emailRequestDto.getBody());
            return ResponseEntity.ok("Successfully Sent Email");
        } catch (AwsSesClientException e) {
            return ResponseEntity.status(500).body("Error occurred while sending email " + e);
        }
    }
}
