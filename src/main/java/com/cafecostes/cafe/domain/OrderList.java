package com.cafecostes.cafe.domain;

import com.cafecostes.cafe.BaseTimeEntity;
import com.cafecostes.cafe.DB.Custom;
import com.cafecostes.cafe.DB.Menu;
import com.cafecostes.cafe.DB.Users;
import com.cafecostes.cafe.repository.MenuRepository;
import com.cafecostes.cafe.repository.UsersRepository;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;


import javax.persistence.*;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@Entity
public class OrderList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; // 주문 고유 식별 아이디

    @Column(columnDefinition = "TEXT", nullable = false)
    private String orderMesage; // 주문하면서 담길 메시지

    @Column(columnDefinition = "BOOLEAN", nullable = false)
    private boolean state = false;

    public OrderList(String orderMesage, boolean state) {
        this.orderMesage = orderMesage;
        this.state = state;
    }

}
