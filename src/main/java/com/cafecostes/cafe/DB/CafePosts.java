package com.cafecostes.cafe.DB;


import com.cafecostes.cafe.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class CafePosts {

    @Id
    @GeneratedValue
    private int id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String title; // 제목

    @Column(length = 1000, nullable = false)
    private String content; // 내용

    @Column(length = 1000, nullable = false)
    private String userName; // 작성자 이름

    @Column(columnDefinition = "INT", nullable = false)
    private int boardCount = 0; // 조회수

    @Column(columnDefinition = "INT", nullable = false)
    private int likes; // 추천

    @Column(columnDefinition = "TEXT", nullable = false)
    private String datetime; // 생성날짜

    @Column(columnDefinition = "TEXT")
    private String likes_users; // 생성날짜

    @Builder
    public CafePosts(String title, String content, String userName, String datetime){
        this.title = title;
        this.content = content;
        this.userName = userName;
        this.datetime = datetime;
        this.likes = 0;
        this.boardCount = 0;
        this.likes_users = "";
    }

}
