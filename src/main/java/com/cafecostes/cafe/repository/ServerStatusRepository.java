package com.cafecostes.cafe.repository;

import com.cafecostes.cafe.DB.OneSay;
import com.cafecostes.cafe.DB.ServerStatus;
import org.springframework.data.jpa.repository.JpaRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ServerStatusRepository extends JpaRepository<ServerStatus, Integer> {
    ServerStatus findByNumber(int i);
}