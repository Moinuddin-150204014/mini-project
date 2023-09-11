package com.example.Online.Book.Library.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRequest {
    private String mail;
    private  String password;
}
