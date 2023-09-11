package com.example.Online.Book.Library.service.serviceImpl;

import com.example.Online.Book.Library.constants.AppConstants;
import com.example.Online.Book.Library.dto.UserDto;
import com.example.Online.Book.Library.entity.User;
import com.example.Online.Book.Library.repository.UserRepository;
import com.example.Online.Book.Library.service.UserService;
import com.example.Online.Book.Library.utils.JWTUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.naming.NameNotFoundException;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) throws Exception {
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new Exception("User exists");
        }

        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAddress(user.getAddress());
        user.setRole(userDto.getRole());
        User userDetails = userRepository.save(user);

        ModelMapper modelMapper = new ModelMapper();

        UserDto userDtoObj = modelMapper.map(userDetails,UserDto.class);
        String token = JWTUtils.generateToken(user.getEmail());
        userDtoObj.setAccessToken(AppConstants.TOKEN_PREFIX + token);
        return userDtoObj;
    }

    @Override
    public UserDto getUser(String email) {
        User userEntity = userRepository.findByEmail(email).get();
        if (userEntity == null) {
            throw new UsernameNotFoundException("No record found belonging to this email");
        }
        return null;
    }

    @Override
    public UserDto getUserByUserId(Long id) throws Exception {
        return null;
    }
}
