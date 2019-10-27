package com.cafecostes.cafe.kakao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.Setter;
import lombok.extern.java.Log;

@Log
@Controller
public class SampleController {

//    @Setter(onMethod_ = @Autowired)
//    private KakaoPay kakaopay;
//
//
//    @GetMapping("/kakaoPay")
//    public void kakaoPayGet() {
//        log.info("여긴아닐거야");
//    }
//
//    @PostMapping("/kakaoPay")
//    public String kakaoPay() {
//        log.info("kakaoPay post............................................");
//        System.out.println(kakaopay.kakaoPayReady().toString());
//        return "redirect:" + kakaopay.kakaoPayReady();
//
//    }
//
//    @GetMapping("/pay")
//    public String pay(){
//        log.info("whatthe");
//        return "kakaoPaySuccess.jsp";
//    }
//
//    @GetMapping("/kakaoPaySuccess")
//    public String kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model) {
//        log.info("kakaoPaySuccess get............................................");
//        log.info("kakaoPaySuccess pg_token : " + pg_token);
//        return "kakaoPaySuccess.jsp";
//    }

}