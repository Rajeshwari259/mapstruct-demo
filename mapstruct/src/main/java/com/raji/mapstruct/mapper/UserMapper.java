package com.raji.mapstruct.mapper;

import com.raji.mapstruct.dto.UserDTO;
import com.raji.mapstruct.model.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "username", target = "name")
    @Mapping(source = "email", target = "emailAddress")
    @Mapping(source = "phoneNumber", target = "mobile")
    UserDTO toDTO(User user);

    @Mapping(source = "userId", target = "id")
    @Mapping(source = "name", target = "username")
    @Mapping(source = "emailAddress", target = "email")
    @Mapping(source = "mobile", target = "phoneNumber")
    User toEntity(UserDTO dto);
    List<UserDTO> toDTOList(List<User> userList);

}

