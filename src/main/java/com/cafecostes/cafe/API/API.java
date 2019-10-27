package com.cafecostes.cafe.API;

import com.cafecostes.cafe.email.EmailServiceImpl;
import com.cafecostes.cafe.repository.UsersRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Log
@Controller
@RequestMapping(value="/API")
public class API {
    @Autowired
    UsersRepository usersrepository;

    @Autowired
    JavaMailSender javaMailSender;


    @RequestMapping(value = "/email", method = {RequestMethod.GET, RequestMethod.POST})
    public String email(@RequestParam String to,
                      @RequestParam String subject,
                      @RequestParam String text,
                         @RequestParam String redirect_url){
        EmailServiceImpl es=new EmailServiceImpl();
        es.setJavaMailSender(javaMailSender);
        es.sendSimpleMessage(to,subject + "님 이메일 인증 코드입니다.", text);
        return "redirect:" + redirect_url;
    }
}
