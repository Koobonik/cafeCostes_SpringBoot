package com.cafecostes.cafe.repository;

import com.cafecostes.cafe.DB.SignupEmailAuth;
import org.springframework.data.jpa.repository.JpaRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface SignupEmailAuthRepository extends JpaRepository<SignupEmailAuth, Integer> {
    SignupEmailAuth findByCode(String code);
}