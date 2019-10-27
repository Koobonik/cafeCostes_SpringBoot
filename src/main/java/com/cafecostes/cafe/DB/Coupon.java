package com.cafecostes.cafe.DB;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 자동 추가 // 기본 생성자의 접근 권한을 protected로 제한
@Getter // 클래스내 모든 필드의 Getter 메소드를 자동생성
@Setter
@Entity // 테이블과 링크될 클래스 + 언더스코어 네이밍으로 이름 매칭 ex ) SalesManager -> sales_manager table
public class Coupon {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String couponName;

    @Column(columnDefinition = "TEXT")
    private String createdDate;

    @Column(columnDefinition = "TEXT")
    private String untilDate;

    // 발급자
    @Column(columnDefinition = "TEXT", nullable = false)
    private String issuer;
    @Column(nullable = false)
    private int cost;

    // 쿠폰을 단독적으로 사용 가능한 것인지 판별해주는 코드임
    @Column(columnDefinition = "BOOLEAN", nullable = false)
    private boolean usingOne = false;

//    @ManyToOne
//    @JoinColumn(name="users", referencedColumnName="userName")
    @Column(columnDefinition = "TEXT", nullable = false)
    private String userName;

    @Column(columnDefinition = "BOOLEAN", nullable = false)
    private boolean status;

    @Builder
    public Coupon(String couponName, String issuer, String userName){
        this.couponName = couponName;
        this.issuer = issuer;
        this.userName = userName;
    }

    @Builder
    public Coupon(String couponName, String createdDate, String issuer, String userName, int cost){
        this.couponName = couponName;
        this.createdDate = createdDate;
        this.issuer = issuer;
        this.userName = userName;
        this.status = true;
        this.cost = cost;
    }

}
