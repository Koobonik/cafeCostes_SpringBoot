package com.cafecostes.cafe.DB;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

//@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 자동 추가 // 기본 생성자의 접근 권한을 protected로 제한
//@Getter // 클래스내 모든 필드의 Getter 메소드를 자동생성
//@Setter
////@Entity // 테이블과 링크될 클래스 + 언더스코어 네이밍으로 이름 매칭 ex ) SalesManager -> sales_manager table
//@RestController
//@RequestMapping("/order")
//public class OrderController {
//    @Autowired
//    private MenuRepository menuRepository;
//
//    @RequestMapping("{menuid}")
//    public Optional<Menu> getMenu(@PathVariable Long menuId){
//        Optional<Menu> menu = menuRepository.findById(menuId);
//        return menu;
//    }
//}
