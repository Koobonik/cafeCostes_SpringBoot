package com.cafecostes.cafe.kakao;

import java.util.Date;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class KakaoPayReadyVO {

    //response
    private String tid, next_redirect_pc_url, next_redirect_app_url, next_redirect_mobile_url;
    private String android_app_scheme, ios_app_scheme;
    private Date created_at;

}