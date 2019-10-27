package com.cafecostes.cafe.repository;

import com.cafecostes.cafe.DB.Coupon;
import com.cafecostes.cafe.DB.Menu;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CouponRepository extends CrudRepository<Coupon, Integer> {


    Iterable<Coupon> findAllById(int i);
    Coupon findByUserName(String i);
    Iterable<Coupon> findAllByCouponName(String i);
    Iterable<Coupon> findAllByUserName(String i);
}