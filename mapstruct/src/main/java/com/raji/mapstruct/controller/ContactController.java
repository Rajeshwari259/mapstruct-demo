package com.raji.mapstruct.controller;

import com.raji.mapstruct.dto.ContactDTO;
import com.raji.mapstruct.model.Contact;
import com.raji.mapstruct.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController
{
    @Autowired
    private ContactService contactService;

    @PostMapping("/contact")
    public ResponseEntity<Contact> saveContact(@RequestBody ContactDTO contactDTO) {
        Contact contact = contactService.saveContact(contactDTO);
        return ResponseEntity.ok(contact);
    }

    @GetMapping("/contact/{id}")
    public ResponseEntity<ContactDTO> getContactById(@PathVariable Long id) {
        ContactDTO contactDTO = contactService.getContactById(id);
        if (contactDTO != null) {
            return ResponseEntity.ok(contactDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/contacts")
    public ResponseEntity<List<ContactDTO>> getAllContacts() {
        List<ContactDTO> contactList = contactService.getAllContactList();
        return ResponseEntity.ok(contactList);
    }

}
