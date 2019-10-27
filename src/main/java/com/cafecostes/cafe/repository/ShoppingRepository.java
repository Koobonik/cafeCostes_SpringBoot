package com.cafecostes.cafe.repository;

import com.cafecostes.cafe.DB.Shopping;
import com.cafecostes.cafe.domain.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingRepository extends JpaRepository<Shopping, Integer> {
    Shopping findByUserName(String userName);
}
