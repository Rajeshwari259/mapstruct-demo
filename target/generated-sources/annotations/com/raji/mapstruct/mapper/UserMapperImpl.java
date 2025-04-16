package com.raji.mapstruct.mapper;

import com.raji.mapstruct.dto.UserDTO;
import com.raji.mapstruct.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-16T12:13:28+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO.UserDTOBuilder userDTO = UserDTO.builder();

        userDTO.userId( user.getId() );
        userDTO.name( user.getUsername() );
        userDTO.emailAddress( user.getEmail() );
        userDTO.mobile( user.getPhoneNumber() );

        return userDTO.build();
    }

    @Override
    public User toEntity(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( dto.getUserId() );
        user.username( dto.getName() );
        user.email( dto.getEmailAddress() );
        user.phoneNumber( dto.getMobile() );

        return user.build();
    }

    @Override
    public List<UserDTO> toDTOList(List<User> userList) {
        if ( userList == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( userList.size() );
        for ( User user : userList ) {
            list.add( toDTO( user ) );
        }

        return list;
    }
}
