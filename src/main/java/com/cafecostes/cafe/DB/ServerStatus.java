package com.cafecostes.cafe.DB;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;

//@AllArgsConstructor
@Getter
@Setter
@Service
@Data
@Entity // This tells Hibernate to make a table out of this class
public class ServerStatus {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int number; // 유저의 고유 번호이자 수

    // null 값은 회원가입 안되게

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String serverStatus; // 유저 로그인 시 아이디




}