package com.raji.mapstruct.mapper;

import com.raji.mapstruct.dto.ContactDTO;
import com.raji.mapstruct.model.Contact;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-16T12:13:29+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class ContactMapperImpl implements ContactMapper {

    @Override
    public Contact toEntity(ContactDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Contact.ContactBuilder contact = Contact.builder();

        contact.id( dto.getId() );
        contact.firstName( dto.getFirstName() );
        contact.lastName( dto.getLastName() );
        contact.email( dto.getEmail() );
        contact.phone( dto.getPhone() );

        return contact.build();
    }

    @Override
    public ContactDTO toDTO(Contact contact) {
        if ( contact == null ) {
            return null;
        }

        ContactDTO.ContactDTOBuilder contactDTO = ContactDTO.builder();

        contactDTO.id( contact.getId() );
        contactDTO.firstName( contact.getFirstName() );
        contactDTO.lastName( contact.getLastName() );
        contactDTO.email( contact.getEmail() );
        contactDTO.phone( contact.getPhone() );

        return contactDTO.build();
    }

    @Override
    public List<ContactDTO> toDTOList(List<Contact> contactList) {
        if ( contactList == null ) {
            return null;
        }

        List<ContactDTO> list = new ArrayList<ContactDTO>( contactList.size() );
        for ( Contact contact : contactList ) {
            list.add( toDTO( contact ) );
        }

        return list;
    }
}
