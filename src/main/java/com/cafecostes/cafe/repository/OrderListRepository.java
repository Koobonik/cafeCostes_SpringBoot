package com.cafecostes.cafe.repository;

import com.cafecostes.cafe.DB.KakaoPayPayment;
import com.cafecostes.cafe.domain.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderListRepository extends JpaRepository<OrderList, Integer> {
    @Query("SELECT p " +
            "FROM OrderList p " +
            "ORDER BY p.id DESC")
    Iterable<OrderList> findAllDesc();

}
