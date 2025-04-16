package com.raji.mapstruct.service;

import com.raji.mapstruct.dto.ContactDTO;
import com.raji.mapstruct.mapper.ContactMapper;
import com.raji.mapstruct.model.Contact;
import com.raji.mapstruct.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ContactMapper contactMapper;
    public Contact saveContact(ContactDTO contactDTO) {
        // Use MapStruct to convert DTO → Entity
        Contact contact = contactMapper.toEntity(contactDTO);

        // Optional: log to confirm mapping (good during development)
        System.out.println("Mapped Contact: " + contact);

        // Save to DB
        return contactRepository.save(contact);
    }

//    public Contact saveContact(ContactDTO contactDTO) {
//        // ✅ Confirm values are received
//        System.out.println("DTO first name: " + contactDTO.getFirstName());
//        System.out.println("DTO last name: " + contactDTO.getLastName());
//        System.out.println("DTO email: " + contactDTO.getEmail());
//        System.out.println("DTO phone: " + contactDTO.getPhone());
//
//        // ✅ Build the Contact object manually (bypassing MapStruct for now)
//        Contact contact = Contact.builder()
//                .firstName(contactDTO.getFirstName())
//                .lastName(contactDTO.getLastName())
//                .email(contactDTO.getEmail())
//                .phone(contactDTO.getPhone())
//                .build();
//
//        // ✅ Save to DB
//        return contactRepository.save(contact);
//    }


    public ContactDTO getContactById(Long id) {

        // Find the Contact entity by ID
        Optional<Contact> contactOptional = contactRepository.findById(id);
        // If found, convert it to ContactDTO using the mapper
        if (contactOptional.isPresent()) {
            return contactMapper.toDTO(contactOptional.get());
        } else {
            return null;
        }
//      Optional<Contact> contact = contactRepository.findById(id);
//        if (contact.isPresent()) {
//            return ContactDTO.builder()
//                    .id(contact.get().getId())
//                    .firstName(contact.get().getFirstName())
//                    .lastName(contact.get().getLastName())
//                    .email(contact.get().getEmail())
//                    .phone(contact.get().getPhone())
//                    .build();
//        } else {
//            return null;
//        }
    }

    public List<ContactDTO> getAllContactList() {

        List<Contact> contactList = contactRepository.findAll();
        return contactMapper.toDTOList(contactList);

//        List<Contact> contactList = contactRepository.findAll();
//        return contactList.stream()
//                .map(contact -> ContactDTO.builder()
//                        .id(contact.getId())
//                        .firstName(contact.getFirstName())
//                        .lastName(contact.getLastName())
//                        .email(contact.getEmail())
//                        .phone(contact.getPhone())
//                        .build())
//                .toList();
    }

}
