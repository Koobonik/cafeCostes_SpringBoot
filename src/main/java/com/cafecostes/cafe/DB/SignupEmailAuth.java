package com.cafecostes.cafe.DB;


import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 자동 추가 // 기본 생성자의 접근 권한을 protected로 제한
@Getter // 클래스내 모든 필드의 Getter 메소드를 자동생성
@Setter
@Entity
public class SignupEmailAuth {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(columnDefinition = "BOOLEAN", nullable = false)
    private boolean status = false;

    @Column(columnDefinition = "VARCHAR(8)", nullable = false)
    private String code;

    private String email;
    private long createdDate;
    private long untilDate;

    @Builder
    public SignupEmailAuth(boolean status, String code, long createdDate, long untilDate){
        this.status = status;
        this.code = code;
        this.createdDate = createdDate;
        this.untilDate = untilDate;
    }

    @Builder
    public SignupEmailAuth(boolean status, String code, long createdDate, long untilDate, String email){
        this.status = status;
        this.code = code;
        this.createdDate = createdDate;
        this.untilDate = untilDate;
        this.email = email;
    }

}

