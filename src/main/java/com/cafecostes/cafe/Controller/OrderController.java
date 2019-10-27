package com.cafecostes.cafe.Controller;


import com.cafecostes.cafe.domain.Hello;
import com.cafecostes.cafe.domain.OrderList;
import com.cafecostes.cafe.domain.Param;
import com.cafecostes.cafe.repository.OrderListRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@RestController
@RequestMapping
@Controller
@AllArgsConstructor

//
// 주문이 들어왔을때 그에 맞게 iOS, Android, Manager에 뿌려줄 것
public class OrderController {
    String json_All_Menu;
    // http://localhost:8080/order?americano=1&cafelate=2
    // 결과값
    // {"code":0,"msg":"m1, msg2Default"}
    // 디폴트 값을 설정해줄 수 있음

    public OrderController(){

    }
    @RequestMapping(value = "order",method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json")
    public Hello getArgsDefault(
            @RequestParam(value = "americano", required = false, defaultValue = "샷추가없음")String msg,
            @RequestParam(value = "cafelate", required = false, defaultValue = "샷추가없음")String msg2) {
        Hello hello = new Hello(0, msg);
        hello.setMsg(hello.getMsg() + ", " + msg2);
        try {
            this.getList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hello;
    }

    // DB에 있는 메뉴 다 가져오기
    public void getList() throws IOException {
        URL url = new URL("https://cafecostes.com/request/getAllMenu");

        // 문자열로 URL 표현
        System.out.println("URL :" + url.toExternalForm());

        // HTTP Connection 구하기
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        // 요청 방식 설정 ( GET or POST or .. 별도로 설정하지않으면 GET 방식 )
        conn.setRequestMethod("GET");

        // 연결 타임아웃 설정
        conn.setConnectTimeout(3000); // 3초
        // 읽기 타임아웃 설정
        conn.setReadTimeout(3000); // 3초

//        // 요청 방식 구하기
//        System.out.println("getRequestMethod():" + conn.getRequestMethod());
//        // 응답 콘텐츠 유형 구하기
//        System.out.println("getContentType():" + conn.getContentType());
//        // 응답 코드 구하기
//        System.out.println("getResponseCode():"    + conn.getResponseCode());
//        // 응답 메시지 구하기
//        System.out.println("getResponseMessage():" + conn.getResponseMessage());

        // 응답 내용(BODY) 구하기
        try (InputStream in = conn.getInputStream();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            byte[] buf = new byte[1024 * 8];
            int length = 0;
            while ((length = in.read(buf)) != -1) {
                out.write(buf, 0, length);
            }
            System.out.println(new String(out.toByteArray(), "UTF-8"));
            json_All_Menu = new String(out.toByteArray(), "UTF-8");
            System.out.println(json_All_Menu);
        }

        // 접속 해제
        conn.disconnect();




    }



    // http://localhost:8080/orderPost
//    post 문구
//    {
//        "data1" : 100,
//            "data2" : "paramData2"
//    }
//
//    응답
//    {
//        "code": 0,
//            "msg": "Data1 : 100, Data2 : paramData2"
//    }


//    @PostMapping("orderPost")
//    public OrderList orderPost(@RequestBody Param param) {
//        String msg = "Data1 : " + param.getData1() + ", Data2 : " + param.getData2();
//        OrderList orderList = new OrderList("order2", msg);
//        System.out.println("orderList 출력 "+ orderList.toString());
//        return orderList;
//    }

}
