package com.cafecostes.cafe.DB;


import com.cafecostes.cafe.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 자동 추가 // 기본 생성자의 접근 권한을 protected로 제한
@Getter // 클래스내 모든 필드의 Getter 메소드를 자동생성
@Setter
@Entity
public class EmailAuth{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "users_userNum"))
    private Users users;

    @Column(columnDefinition = "BOOLEAN")
    private boolean status = false;

    @Column(columnDefinition = "VARCHAR(8)")
    private String code;

    private long createdDate;
    private long untilDate;

    @Builder
    public EmailAuth(Users users, boolean status, String code, long createdDate, long untilDate){
        this.users = users;
        this.status = status;
        this.code = code;
        this.createdDate = createdDate;
        this.untilDate = untilDate;
    }

//    @Builder
//    public EmailAuth(Users users){
//        this.users = users;
//    }

}

