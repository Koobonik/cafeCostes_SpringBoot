package com.cafecostes.cafe.kakao;

import com.cafecostes.cafe.DB.FlutterOrder;
import com.cafecostes.cafe.DB.KakaoPayPayment;
import com.cafecostes.cafe.formatter.Encoder;
import com.cafecostes.cafe.repository.KakaoPayPaymentRepository;
import com.cafecostes.cafe.repository.OrderListRepository;
import com.cafecostes.cafe.repository.UsersRepository;
import lombok.Data;
import lombok.Getter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

@Getter
@Service
@Log
@Data
public class KakaoPay {

    private static final String HOST = "https://kapi.kakao.com";

    final private String kakaopay_api_key = "";

    private KakaoPayReadyVO kakaoPayReadyVO;

    private KakaoPayApprovalVO kakaoPayApprovalVO;

    @Autowired
    private KakaoPayPaymentRepository kakaoPayPaymentRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private OrderListRepository orderListRepository;

    private String cid = ""; // 코스테스 코드 : , 테스트 코드 : TC0ONETIME
    private String partner_order_id;
    private String partner_user_id;
    private String item_name;
    private String total_amount;


    // 파라미터로 받아야할게 있다면 가맹점 주문번호, 회원id, 상품이름, 금액, 비과세금액?까지?
    // 클래스자체를 객체로 받아서 넘겨줘도 좋을듯
    // 유저한테 이러이러한 정보로 결제를 진행해주세요~
    public String kakaoPayReady() {
        log.info("카카오페이 레디 진입");
        RestTemplate restTemplate = new RestTemplate();

        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Host", "kapi.kakao.com");
        headers.add("Authorization", "KakaoAK " + kakaopay_api_key);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
        log.info(headers.toString());
        // 서버로 요청할 Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", cid); // cid 코드 제휴 이후 발급 될 것
        params.add("partner_order_id", "1001"); // 가맹점 주문번호
        params.add("partner_user_id", "gorany"); // 가맹점 회원 id
        params.add("item_name", "아메리카노 외 2"); // 상품
        params.add("quantity", "1"); // 수량
        params.add("total_amount", "4500"); // 금액
        params.add("tax_free_amount", "100"); // 비과세 금액
        params.add("approval_url", "https://cafecostes.com/kakaoPaySuccess");
        params.add("cancel_url", "https://cafecostes.com/kakaoPayCancel");
        params.add("fail_url", "https://cafecostes.com/kakaoPaySuccessFail");
        log.info(params.toString());

        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        log.info(body.toString());

        try {
            kakaoPayReadyVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, KakaoPayReadyVO.class);
            log.info("카카오페이레디쪽" + kakaoPayReadyVO);


            return kakaoPayReadyVO.getNext_redirect_pc_url();

        } catch (RestClientException e) {
            // TODO Auto-generated catch block
            log.info("여긴가");
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            log.info("여긴가2");
            e.printStackTrace();
        }
        log.info("여긴가3");
        return "/pay";

    }

    public String kakaoPayReady( String partner_user_id, String item_name, String total_amount) {
        log.info("카카오페이 레디 진입 결제2");
        RestTemplate restTemplate = new RestTemplate();
        //this.cid = "TC0ONETIME";
        this.partner_order_id = "cafeCostes";
        this.partner_user_id = partner_user_id;
        this.item_name = item_name;
        this.total_amount = total_amount;

        // 인코딩해주기
        String [] charSet = {"utf-8","euc-kr","ksc5601","iso-8859-1","x-windows-949"};
//        for (int i=0; i<charSet.length; i++) {
//            for (int j=0; j<charSet.length; j++) {
//                try {
//                    System.out.println("[" + charSet[i] +"," + charSet[j] +"] = " + new String(originalStr.getBytes(charSet[i]), charSet[j]));
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        try {
            item_name = new String(item_name.getBytes(charSet[3]), charSet[0]);
            partner_order_id = new String(partner_order_id.getBytes(charSet[3]), charSet[0]);
            partner_user_id = new String(partner_user_id.getBytes(charSet[3]), charSet[0]);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        log.info("아이템 이름 " + item_name);
        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Host", "kapi.kakao.com");
        headers.add("Authorization", "KakaoAK " + kakaopay_api_key);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
        log.info("헤더 요청 : " + headers.toString());
        // 서버로 요청할 Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", cid); // cid 코드 제휴 이후 발급 될 것
        params.add("partner_order_id", partner_order_id); // 가맹점 주문번호
        params.add("partner_user_id", partner_user_id); // 가맹점 회원 id
        params.add("item_name", item_name); // 상품
        params.add("quantity", "1"); // 수량
        params.add("total_amount", total_amount); // 금액
        params.add("tax_free_amount", "100"); // 비과세 금액
        params.add("approval_url", "https://cafecostes.com/kakaoPaySuccess");
        params.add("cancel_url", "https://cafecostes.com/kakaoPayCancel");
        params.add("fail_url", "https://cafecostes.com/kakaoPaySuccessFail");
        log.info(params.toString());

        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        log.info(body.toString());

        try {
            kakaoPayReadyVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, KakaoPayReadyVO.class);
            log.info("카카오페이레디쪽2" + kakaoPayReadyVO);


            return kakaoPayReadyVO.getNext_redirect_pc_url();

        } catch (RestClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "/pay";

    }

    // 카카오페이 플루터 결제
    public KakaoPayReadyVO flutterkakaoPayReady(FlutterOrder flutterOrder) {
        log.info("플루터 진입 카카오페이 레디 진입 결제2");
        log.info(flutterOrder.getItem_name() + " <- 파라미터로 받은 아이템 이름");
        RestTemplate restTemplate = new RestTemplate();
        //this.cid = "TC0ONETIME";
        this.partner_order_id = "cafeCostes";
        this.partner_user_id = flutterOrder.getPartner_user_id();
        this.item_name = flutterOrder.getItem_name();
        this.total_amount = flutterOrder.getTotal_amount();

        // 인코딩해주기
        String [] charSet = {"utf-8","euc-kr","ksc5601","iso-8859-1","x-windows-949"};
//        for (int i=0; i<charSet.length; i++) {
//            for (int j=0; j<charSet.length; j++) {
//                try {
//                    System.out.println("[" + charSet[i] +"," + charSet[j] +"] = " + new String(item_name.getBytes(charSet[i]), charSet[j]));
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        try {
//            this.item_name = new String(item_name.getBytes(charSet[3]), charSet[0]);
//            this.partner_order_id = new String(partner_order_id.getBytes(charSet[3]), charSet[0]);
//            this.partner_user_id = new String(partner_user_id.getBytes(charSet[3]), charSet[0]);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        log.info("아이템 이름 " + item_name);
        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Host", "kapi.kakao.com");
        headers.add("Authorization", "KakaoAK " + kakaopay_api_key);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
        log.info("헤더 요청 : " + headers.toString());
        // 서버로 요청할 Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", cid); // cid 코드 제휴 이후 발급 될 것
        params.add("partner_order_id", partner_order_id); // 가맹점 주문번호
        params.add("partner_user_id", partner_user_id); // 가맹점 회원 id
        params.add("item_name", item_name); // 상품
        params.add("quantity", "1"); // 수량
        params.add("total_amount", total_amount); // 금액
        params.add("tax_free_amount", "100"); // 비과세 금액
        params.add("approval_url", "https://cafecostes.com/kakaoPaySuccess");
        params.add("cancel_url", "https://cafecostes.com/kakaoPayCancel");
        params.add("fail_url", "https://cafecostes.com/kakaoPaySuccessFail");
        log.info(params.toString());

        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        log.info(body.toString());

        try {
            kakaoPayReadyVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, KakaoPayReadyVO.class);
            log.info("카카오페이레디쪽2" + kakaoPayReadyVO);


            return kakaoPayReadyVO;

        } catch (RestClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

    // 얘는 결제가 완료되면 그 값을 사용자한테 보내주는 역할을 함
    public KakaoPayApprovalVO kakaoPayInfo(String pg_token) {

        log.info("KakaoPayInfoVO............................................");
        log.info("-----------------------------");

        RestTemplate restTemplate = new RestTemplate();

        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Host", "kapi.kakao.com");
        headers.add("Authorization", "KakaoAK " + kakaopay_api_key);
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");

        // 서버로 요청할 Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

        params.add("cid", cid);
        params.add("tid", kakaoPayReadyVO.getTid());
        params.add("partner_order_id", "1001");
        params.add("partner_user_id", "gorany");
        params.add("pg_token", pg_token);
        params.add("total_amount", "4500");

        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);

        try {
            kakaoPayApprovalVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/approve"), body, KakaoPayApprovalVO.class);
            log.info("사용자한테 보낸 인포메이션");
            log.info("" + kakaoPayApprovalVO);

            // 카카오페이 결제 내역을 인자로 넘겨준다.
            KakaoPayPayment kakaoPayPayment = new KakaoPayPayment(kakaoPayApprovalVO);
            kakaoPayPaymentRepository.save(kakaoPayPayment);
            return kakaoPayApprovalVO;

        } catch (RestClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    public KakaoPayApprovalVO kakaoPayInfo(String pg_token, String cid, String partner_order_id, String partner_user_id, String item_name, String total_amount) {
        log.info("파라미터로 받은 카카오페이 인포");
        log.info("KakaoPayInfoVO............................................");
        log.info("-----------------------------");
        log.info("pg토큰 : "+ pg_token + " / cid : " + cid + " / " +"파트너" +  partner_order_id + partner_user_id + item_name + total_amount);
        Encoder encoder = new Encoder();
        partner_user_id = encoder.encoding(partner_user_id);
        item_name = encoder.encoding(item_name);
        RestTemplate restTemplate = new RestTemplate();

        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Host", "kapi.kakao.com");
        headers.add("Authorization", "KakaoAK " + kakaopay_api_key);
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");

        // 서버로 요청할 Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

        params.add("cid", cid);
        params.add("tid", kakaoPayReadyVO.getTid());
        params.add("partner_order_id", partner_order_id);
        params.add("partner_user_id", partner_user_id);
        params.add("pg_token", pg_token);
        params.add("total_amount", total_amount);

        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        log.info("바디 수 스트링 : "+body.toString());
        try {
            log.info("사용자한테 보낸 인포메이션12");
            kakaoPayApprovalVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/approve"), body, KakaoPayApprovalVO.class);
            log.info("사용자한테 보낸 인포메이션");
            log.info("" + kakaoPayApprovalVO);



            // 카카오페이 결제내역 저장
            KakaoPayPayment kakaoPayPayment = new KakaoPayPayment(kakaoPayApprovalVO);
            kakaoPayPaymentRepository.save(kakaoPayPayment);

            //
//            OrderList orderList = new OrderList(kakaoPayPayment.getApproved_at().toString().substring(0, 10) + " " + kakaoPayPayment.getApproved_at().toString().substring(11, 13)+ "시 " + kakaoPayPayment.getApproved_at().toString().substring(14, 16) + "분 " + kakaoPayPayment.getItem_name() + " " + kakaoPayPayment.getMoney() + "원 - " + kakaoPayPayment.getPartner_user_id(), true);
//            orderListRepository.save(orderList);

            return kakaoPayApprovalVO;

        } catch (RestClientException e) {
            log.info("asdsad "+e.toString());
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        } catch (URISyntaxException e) {
            log.info("URI  systax" + e.toString());
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }

}

