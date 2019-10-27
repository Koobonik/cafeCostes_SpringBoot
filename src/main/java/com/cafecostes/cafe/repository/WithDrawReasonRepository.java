package com.cafecostes.cafe.repository;

import com.cafecostes.cafe.DB.Users;
import com.cafecostes.cafe.DB.WithDrawReason;
import org.springframework.data.jpa.repository.JpaRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface WithDrawReasonRepository extends JpaRepository<WithDrawReason, Integer> {
//    @Query("SELECT p " +
//            "FROM Users p " +
//            "ORDER BY p.usernum DESC")
//    Stream<Users> findAllDesc();


//    @Query("SELECT Users.userLoginId " +
//            "FROM Users p " +
//            "WHERE p.userEmail = name AND p.userName = name")
//    Users findOne(@Param("name") String name, @Param("name") String email);
}