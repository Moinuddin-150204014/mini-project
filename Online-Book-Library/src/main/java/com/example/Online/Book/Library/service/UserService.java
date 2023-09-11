package com.example.Online.Book.Library.service;

import com.example.Online.Book.Library.dto.UserDto;
import com.example.Online.Book.Library.entity.User;

public interface UserService {
    UserDto createUser(UserDto userDto) throws Exception;
    UserDto getUser(String email);
    UserDto getUserByUserId(Long id) throws Exception;

}
