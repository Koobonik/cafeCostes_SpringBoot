package com.cafecostes.cafe.repository;

import com.cafecostes.cafe.DB.EmailAuth;
import com.cafecostes.cafe.DB.Users;
import org.springframework.data.jpa.repository.JpaRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface EmailAuthRepository extends JpaRepository<EmailAuth, Integer> {
    EmailAuth findByCode(String code);
}