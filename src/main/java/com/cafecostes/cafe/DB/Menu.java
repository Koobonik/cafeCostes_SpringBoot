package com.cafecostes.cafe.DB;

import com.cafecostes.cafe.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.net.URL;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 자동 추가 // 기본 생성자의 접근 권한을 protected로 제한
@Getter // 클래스내 모든 필드의 Getter 메소드를 자동생성
@Setter
@Entity // 테이블과 링크될 클래스 + 언더스코어 네이밍으로 이름 매칭 ex ) SalesManager -> sales_manager table
public class Menu {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String category;
    @Column(columnDefinition = "TEXT", nullable = false, unique = true)
    private String menuName;
    private int menuCost;

    @Column(columnDefinition = "TEXT")
    private String url;

//    @OneToMany
//    @JoinColumn(name="custom_id", referencedColumnName="id")
//    private List<Custom> customList;

    @Builder
    public Menu(int id, String category, String menuName, int menuCost){
        this.id = id;
        this.category = category;
        this.menuName = menuName;
        this.menuCost = menuCost;

    }
    @Builder
    public Menu(int id, String category, String menuName, int menuCost, String url){
        this.id = id;
        this.category = category;
        this.menuName = menuName;
        this.menuCost = menuCost;
        this.url = url;

    }

}
