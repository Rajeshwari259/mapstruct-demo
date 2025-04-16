package com.raji.mapstruct.service;

import com.raji.mapstruct.dto.UserDTO;
import com.raji.mapstruct.mapper.UserMapper;
import com.raji.mapstruct.model.User;
import com.raji.mapstruct.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserDTO createUser(UserDTO dto) {
        User user = userMapper.toEntity(dto);
        User saved = userRepository.save(user);
        return userMapper.toDTO(saved);
    }

    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepository.findAll(); // Get all users from DB
        return userMapper.toDTOList(userList); // Convert to List<UserDTO> using MapStruct
    }
}
