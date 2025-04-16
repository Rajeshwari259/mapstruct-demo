package com.raji.mapstruct.repository;

import com.raji.mapstruct.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
