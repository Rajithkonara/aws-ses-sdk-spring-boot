package com.rkdevblog.ses.dto;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
public class EmailRequestDto {

    @Email(message = "Invalid Email address")
    private String email;
    @NotEmpty(message = "Email body cannot be Null")
    private String body;
}
