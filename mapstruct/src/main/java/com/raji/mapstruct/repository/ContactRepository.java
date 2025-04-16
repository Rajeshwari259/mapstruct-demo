package com.raji.mapstruct.repository;

import com.raji.mapstruct.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    // This interface will automatically provide CRUD operations for the Contact entity
    // No need to define any methods here, JpaRepository provides all the necessary methods
}
