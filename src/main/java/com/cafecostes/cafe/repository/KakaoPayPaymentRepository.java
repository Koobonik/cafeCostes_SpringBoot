package com.cafecostes.cafe.repository;

import com.cafecostes.cafe.DB.KakaoPayPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface KakaoPayPaymentRepository extends JpaRepository<KakaoPayPayment, Integer> {
    @Query("SELECT p " +
            "FROM KakaoPayPayment p " +
            "ORDER BY p.id DESC")
    Iterable<KakaoPayPayment> findAllDesc();

    //Iterable<KakaoPayPayment> findByPartner_user_id(String name);

}