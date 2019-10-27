package com.cafecostes.cafe.dto;

import com.cafecostes.cafe.DB.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UsersSaveRequestDto {
    private Long userNum;
    private String userLoginId; // 유저 로그인 시 아이디
    private String userLoginPassword; // 유저 로그인 시 패스워드
    private String userName; // 유저 이름
    private String userEmail; // 유저 이메일
    private String userPhoneNumber; // 유저 폰번
    private String modifiedDate;

    @Builder
    public UsersSaveRequestDto(Long userNum, String userLoginId, String userLoginPassword, String userName, String userEmail, String userPhoneNumber) {
        this.userNum = userNum;
        this.userLoginId = userLoginId;
        this.userLoginPassword = userLoginPassword;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;
    }

    public Users toEntity(){
        return Users.builder()
                //.userNum(userNum)
                .userLoginId(userLoginId)
                .userLoginPassword(userLoginPassword)
                .userName(userName)
                .userEmail(userEmail)
                .userPhoneNumber(userPhoneNumber)
                .build();
    }
}
