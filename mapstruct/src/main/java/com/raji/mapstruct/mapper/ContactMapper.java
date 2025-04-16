package com.raji.mapstruct.mapper;

import com.raji.mapstruct.dto.ContactDTO;
import com.raji.mapstruct.model.Contact;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ContactMapper {
    Contact toEntity(ContactDTO dto);

    ContactDTO toDTO(Contact contact);

    List<ContactDTO> toDTOList(List<Contact> contactList);
}
