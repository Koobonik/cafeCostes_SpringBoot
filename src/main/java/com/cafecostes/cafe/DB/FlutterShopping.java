package com.cafecostes.cafe.DB;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 자동 추가 // 기본 생성자의 접근 권한을 protected로 제한
@Data
@Setter
@Getter
public class FlutterShopping {
    private int id;
    private String userName;
    private String list;
    private String num;
    private String sum_cost;
    private String userRequestion;
}
