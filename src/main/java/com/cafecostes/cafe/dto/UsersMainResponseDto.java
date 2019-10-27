package com.cafecostes.cafe.dto;

import com.cafecostes.cafe.DB.Users;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class UsersMainResponseDto {
    private int userNum;
    private String userLoginId; // 유저 로그인 시 아이디
    private String userLoginPassword; // 유저 로그인 시 패스워드
    private String userName; // 유저 이름
    private String userEmail; // 유저 이메일
    private String userPhoneNumber; // 유저 폰번
    private String modifiedDate;

    public UsersMainResponseDto(Users entity) {
        userNum = entity.getUserNum();
        userLoginId = entity.getUserLoginId();
        userLoginPassword = entity.getUserLoginPassword();
        userName = entity.getUserName();
        userEmail = entity.getUserEmail();
        userPhoneNumber = entity.getUserPhoneNumber();
    }

    /**
     * Java 8 버전
     */
    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }

    /**
     * Java 7 버전
     */
    private String toStringDateTimeByJava7(LocalDateTime localDateTime){
        if(localDateTime == null){
            return "";
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return formatter.format(localDateTime);
    }
}
