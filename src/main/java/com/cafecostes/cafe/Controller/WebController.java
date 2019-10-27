package com.cafecostes.cafe.Controller;

import com.cafecostes.cafe.DB.*;
import com.cafecostes.cafe.Firebase.FirebaseMessagingSnippets;
import com.cafecostes.cafe.domain.OrderList;
import com.cafecostes.cafe.kakao.KakaoPay;
import com.cafecostes.cafe.repository.*;
import com.cafecostes.cafe.service.PushNotificationService;
import com.cafecostes.cafe.service.PushPeriodicNotifications;
import com.google.firebase.messaging.FirebaseMessagingException;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CompletableFuture;


@Log
@Controller
public class WebController {

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    ShoppingRepository shoppingRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    CafePostsRepository cafePostsRepository;

    @Autowired
    private OrderListRepository orderListRepository;

    @Autowired
    private OneSayRepository oneSayRepository;

    @Autowired
    private CouponRepository couponRepository;
    /*
    *
    *
    * REST에서는 보통 4가지 통신방식을 주로 사용하는데요.
    * Get은 조회, Post는 수정, Put은 추가, Delete는 삭제
    * 이게 표준이긴 한데 개발하다 보면 딱 이게 조회다, 수정이다 라고 한정되는 경우는 많지 않다.
    *
    * */
    @RequestMapping(value="/", method = {RequestMethod.GET, RequestMethod.POST})
    public String main() {
        log.info("index진입");
        //model.addAttribute("posts", postsService.findAllDesc());
        return "index.jsp";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting.jsp";
    }

    // kakaoPay 클래스 실행
    @RequestMapping(value="/kakaoPayTest", method = {RequestMethod.GET, RequestMethod.POST})
    public String kakaoPayTest() {
        //model.addAttribute("posts", postsService.findAllDesc());
        return "kakaoPayTest.jsp";
    }

    @Setter(onMethod_ = @Autowired)
    private KakaoPay kakaopay;


    @GetMapping("/kakaoPay")
    public void kakaoPayGet() {
        log.info("여긴아닐거야");
    }

    // @RequestBody로 KakaoPayApproval 가져와야함
    @PostMapping("/kakaoPay")
    public String kakaoPay() {
        log.info("kakaoPay post............................................");
        return "redirect:" + kakaopay.kakaoPayReady();

    }
    @PostMapping("/kakaoPay2")
    public String kakaoPay2(@RequestParam String partner_user_id,
                            @RequestParam String item_name,
                            @RequestParam String total_amount) {
        log.info("kakaoPay2 post............................................");
        //log.info(model.toString());
        //model.addAttribute("info");
        log.info("@@@@@@@@@@");
        log.info("@@@@@@@@@@");
        log.info(total_amount);
        return "redirect:" + kakaopay.kakaoPayReady(partner_user_id, item_name, total_amount);

    }

    @GetMapping("/pay")
    public String pay(){
        log.info("whatthe");
        return "kakaoPaySuccess.jsp";
    }


    @Autowired
    PushNotificationService pushNotificationService;

    @Autowired
    PushNotificationService pushNotificationService2;

    // 성공했을경우 kakaoPayInfo 불러줌
    @GetMapping("/kakaoPaySuccess")
    public String kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model) throws ParseException {
        log.info("kakaoPaySuccess get............................................");
        log.info("kakaoPaySuccess pg_token : " + pg_token);
        if (kakaopay.getCid() != null && pg_token != null){
            Users users = usersRepository.findByUserName(kakaopay.getPartner_user_id());
            log.info("카카오페이 결제 성공 모델에 값 넣기");

            log.info("왜 null값이야? " + kakaopay.getCid() + kakaopay.getTotal_amount());
            log.info(kakaopay.toString());


            log.info(users.getFirebaseToken());


            model.addAttribute("info", kakaopay.kakaoPayInfo(pg_token, kakaopay.getCid(), kakaopay.getPartner_order_id(), kakaopay.getPartner_user_id(), kakaopay.getItem_name(), kakaopay.getTotal_amount()));
            model.addAttribute("users", users.getUserName());
            model.addAttribute("token", users.getFirebaseToken());
            log.info(model.asMap().toString());
            Map map = model.asMap();
            if(map.get("info") != null){

                // 쿠폰 스플릿 해주기
                String coupon[] = kakaopay.getItem_name().split("쿠폰 번호 : ");

                log.info(coupon[0]);
                if(coupon.length >= 2){
                    log.info("에러가 날까?");
                    String coupon2[] = coupon[1].split("  쿠폰 이름");
                    Integer iInteger = Integer.parseInt(coupon2[0]);
                    Optional<Coupon> userCoupon = couponRepository.findById(iInteger);
                    userCoupon.get().setStatus(false);
                    couponRepository.save(userCoupon.get());
                }
               // 결제되면 푸시 보냄
                log.info("사용자한테 보낸 푸시");
                String notifications = PushPeriodicNotifications.SuccessOrder(kakaopay.getPartner_user_id(), "Thank you!", "Please wait 5 miniute", users.getFirebaseToken());
                log.info(notifications);
                HttpEntity<String> request = new HttpEntity<>(notifications);

                CompletableFuture<String> pushNotification = pushNotificationService.send(request);
                CompletableFuture.allOf(pushNotification).join();


                Iterable<Users> users3 = usersRepository.findAll();
                Iterator<Users> usersIterator = users3.iterator();
                Iterator<Users> usersIterator1 = users3.iterator();
                int j = 0; // 현재 유저의 수
                while(usersIterator.hasNext()){
                    usersIterator.next();
                    j++;
                }



                // 유저 수 만큼 반복
                for(int i = 0; i< j; i++){
                    Users users4 = usersIterator1.next();
                    // 유저의 권한이 6이상이면
                    if(users4.getUserPermission() >= 6){
                        log.info("권한이 있음 6 이상이야!");
                        String notifications1 = PushPeriodicNotifications.SuccessOrder(users4.getUserName(), "Order!", "Please confirm in app", users4.getFirebaseToken());
                        log.info(notifications1);
                        HttpEntity<String> request1 = new HttpEntity<>(notifications1);

                        CompletableFuture<String> pushNotification1 = pushNotificationService2.send(request1);
                        CompletableFuture.allOf(pushNotification1).join();
                    }
                }

                // 사장님한테도 푸시보냄
//                log.info("사장님한테 보낸 푸시");
//                Users users1 = usersRepository.findByUserName("master");
//                log.info(users1.toString());
//                String notifications1 = PushPeriodicNotifications.SuccessOrder(users1.getUserName(), "Order!", "Please confirm in app", users1.getFirebaseToken());
//                log.info(notifications1);
//                HttpEntity<String> request1 = new HttpEntity<>(notifications1);
//
//                CompletableFuture<String> pushNotification1 = pushNotificationService2.send(request1);
//                CompletableFuture.allOf(pushNotification1).join();
//
//
//                // 내 개발자 계정으로 푸시 보내자
//                // 사장님한테도 푸시보냄
//                log.info("개발자한테 보낸 푸시");
//                Users users2 = usersRepository.findByUserName("devHi");
//                log.info(users2.toString());
//                String notifications2 = PushPeriodicNotifications.SuccessOrder(users2.getUserName(), "Order!", "Please confirm in app", users2.getFirebaseToken());
//                log.info(notifications2);
//                HttpEntity<String> request2 = new HttpEntity<>(notifications2);
//
//                CompletableFuture<String> pushNotification2 = pushNotificationService2.send(request2);
//                CompletableFuture.allOf(pushNotification2).join();


                // 시간 설정

                Date datetime2 = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM월 dd일 HH시 mm분", Locale.KOREA);
                String createdDate1 = simpleDateFormat.format(datetime2);

                // 요일 설정
                Calendar cal = Calendar.getInstance();
                //현재 일자의 요일
                String dTime = simpleDateFormat.format(datetime2);
                cal.setTime(simpleDateFormat.parse(dTime));
                int dayNum = cal.get(Calendar.DAY_OF_WEEK);

                String day = "";
                switch(dayNum){
                    case 1:
                        day = "금";
                        break ;
                    case 2:
                        day = "토";
                        break ;
                    case 3:
                        day = "일";
                        break ;
                    case 4:
                        day = "월";
                        break ;
                    case 5:
                        day = "화";
                        break ;
                    case 6:
                        day = "수";
                        break ;
                    case 7:
                        day = "목";
                        break ;
                }

                // 오더리스트에 저장도 해줘야지..?
                OrderList orderList = new OrderList();
                orderList.setOrderMesage(createdDate1+ " " + day + "요일" + " - " + kakaopay.getItem_name() + " - " + kakaopay.getTotal_amount()+ "원 - " + kakaopay.getPartner_user_id());
                orderList.setState(true);
                orderListRepository.save(orderList);
            }

        }
        else {
            // test 구역
            model.addAttribute("info", kakaopay.kakaoPayInfo(pg_token));
        }
        System.out.println(model); // 각종 key, value 값들 보여주는 것
        //return "home.jsp?pageName=kakaoPaySuccess.jsp";
        return "kakaoPaySuccess.jsp";
    }

    @GetMapping("/kakaoPaySuccessFlutter")
    public String kakaoPaySuccessFlutter(@RequestParam("pg_token") String pg_token, Model model) {
        log.info("kakaoPaySuccess get............................................");
        log.info("kakaoPaySuccess pg_token : " + pg_token);
        if (kakaopay.getCid() != null){
            log.info("카카오페이 결제 성공 모델에 값 넣기");
            model.addAttribute("info", kakaopay.kakaoPayInfo(pg_token, kakaopay.getCid(), kakaopay.getPartner_order_id(), kakaopay.getPartner_user_id(), kakaopay.getItem_name(), kakaopay.getTotal_amount()));
        }
        else {
            // test 구역
            model.addAttribute("info", kakaopay.kakaoPayInfo(pg_token));
        }
        System.out.println(model); // 각종 key, value 값들 보여주는 것
        return "home.jsp?pageName=kakaoPaySuccess.jsp";
    }

    @GetMapping("/kakaoPaySuccessView")
    public String kakaoPaySuccessView(@RequestParam String name){

        return "gn";
    }

    @GetMapping("/hello") // 웹에서 /hello 라는 요청이 있을경우
    public String hello() {
        return "hello.jsp";
    }

    // 아이디 찾기
    @GetMapping("/findID")
    public String findID(){
        return "find_id_page.jsp";
    }

    // 아이디 찾기 결과
    @GetMapping("/findIDResult")
    public String findIDResult(@RequestParam String userLoginID, String userName, Model model){
        //model.addAttribute("id", userLoginID);
        //model.addAttribute("name", userName);

        //return "find_id_page_result.jsp?userLoginID=" + userLoginID + "&userName=" + userName;
        return "find_id_page_result.jsp";
    }

    // 비밀번호 찾기
    @GetMapping("/findPassword")
    public String findPassword(@RequestParam (required = false) String fail){
        if (fail == null){
            return "find_password_page.jsp";
        }
        else{
            return "find_password_page.jsp?fail=" + fail;
        }

    }

    // 사용자가 진짜 사용자인지 재확인 하는 페이지
    @GetMapping("/checkUser")
    public String checkUser(@RequestParam String redirect_url){
        return "checkUser.jsp?redirect_url" + redirect_url;
    }

    // JSP DB 커넥션 테스트
    @GetMapping("/test")
    public String test(){
        return "test.jsp";
    }

    // 마이페이지
    @GetMapping("/myPage")
    public String myPage(){
        return "myPage.jsp";
    }

    // 회원 정보 수정 페이지
    @RequestMapping(value = "/updateUserInfo", method = {RequestMethod.GET, RequestMethod.POST})
    public String updateUserInfo(HttpSession httpSession){
        return "update_user_information.jsp";
    }

    // 쿠폰 내역 페이지
    @GetMapping("/myCoupon")
    public String myCoupon(){
        return "myCoupon.jsp";
    }

    // 회원탈퇴 페이지
    @GetMapping("withDraw")
    public String withDraw(){
        return "withDraw.jsp";
    }

    // 물품 구매 페이지 이동
    @GetMapping("buy")
    public String buy(){
        return "buy.jsp";
    }

    // 이메일 체크
    @GetMapping("emailcheck")
    public String emailcheck(){
        return "emailcheck.jsp";
    }

    // 로그인 시도
    @GetMapping("/login")
    public String tryLogin(@RequestParam String redirect_url){

        return "login.jsp?redirect_url="+redirect_url;
    }

    // 로그인 시도
    @GetMapping("/signup")
    public String signup(){

        return "signup.jsp";
    }

    // 로그아웃 해주는 url
    @RequestMapping(value="/logout", method = {RequestMethod.GET, RequestMethod.POST})
    public String logout(@RequestParam String redirect_url,
                         HttpSession httpSession){
        httpSession.removeAttribute("name");
        httpSession.removeAttribute("coupon");
        httpSession.removeAttribute("userid");
        httpSession.removeAttribute("shopping_name");
        httpSession.removeAttribute("shopping_list");
        httpSession.removeAttribute("shopping_num");
        httpSession.removeAttribute("shopping_sum_cost");
        log.info("로그아웃");

        return "redirect:" + redirect_url;
    }

    // 탈퇴성공
    @GetMapping("withDrawSuccess")
    public String withDrawSuccess(){
        return "withDrawSuccess.jsp";
    }

    @GetMapping("Introduction/menu")
    public String menu(Model model, HttpSession httpSession){
        log.info("메뉴 페이지 진입");

        if (httpSession.getAttribute("name") != null){
            log.info(httpSession.getAttribute("name").toString());
            String name = httpSession.getAttribute("name").toString();
            Shopping shopping = shoppingRepository.findByUserName(name);
            httpSession.setAttribute("shopping_name", shopping.getUserName());
            httpSession.setAttribute("shopping_list", shopping.getList());
            httpSession.setAttribute("shopping_num", shopping.getNum());
            httpSession.setAttribute("shopping_sum_cost", shopping.getSum_cost());
        }



        return "Introduction/menu.jsp";
    }

    // 민철이가 작업한 부분 ---------------------------------------------------------------
    @GetMapping("/Introduction/terms_and_conditions")
    public String terms_and_conditions(){
        return "Introduction/terms_and_conditions.jsp";
    }
    // @RequestParam(value = "americano", required = false, defaultValue = "샷추가없음")String msg,
    @GetMapping("/Introduction/directions")
    public String directions(){
        return "Introduction/directions.jsp";
    }

    @GetMapping("/home")
    public String home(@RequestParam (required = false) String pageName, HttpSession httpSession, Model model, @RequestParam (required = false) String boardView,
                       @RequestParam (required = false) String already){
        log.info("home 진입");
        log.info(pageName);
        if(pageName != null){
            if (!pageName.equals("")){
                // 단순한 게시판 조회일 경우
                if(pageName.equals("board.jsp")){
                    log.info("게시판 조회");
                    Iterable<CafePosts> board = cafePostsRepository.findAllDesc();
                    model.addAttribute("board", board);
                    log.info(board.toString());
                    return "home.jsp?pageName="+pageName;
                }
                // 제목 링크 눌러서 들어온 페이지 일 경우
                else if(pageName.equals("board_view.jsp")){
                    log.info("게시판 상세 조회");
                    log.info(boardView);
                    // 실존하는 글이 있을경우
                    if (cafePostsRepository.findById(Integer.parseInt(boardView)) != null){
                        CafePosts cafePosts = cafePostsRepository.findById(Integer.parseInt(boardView));
                        cafePosts.setBoardCount(cafePosts.getBoardCount() + 1);
                        cafePostsRepository.save(cafePosts);
                        model.addAttribute("board", cafePosts);
                        log.info(cafePosts.toString());
                        return "home.jsp?pageName="+pageName;
                    }
                    else {
                        return "home.jsp?pageName=board.jsp&board=fail";
                    }
                }
                // 게시판 쓰기일 경우
                else if(pageName.equals("board_write.jsp")){
                    // 비어있지 않은경우에만 쓸 수 있음
                    if (httpSession.getAttribute("name") != null){

                    }
                }
                return "home.jsp?pageName="+pageName;
            }
        }

        return "home.jsp";
    }

    // 게시판 업데이트
    @RequestMapping(value = "/boardUpdate", method = {RequestMethod.GET, RequestMethod.POST})
    public String boardUpdate(HttpSession httpSession, Model model, @RequestParam String id, String title, String content, String userName){
        log.info("게시판 업데이트");
        CafePosts cafePosts = cafePostsRepository.findById(Integer.parseInt(id));
        // 게시판이 잘 있으며 어트리뷰트로 벨류들 다 뿌려줘서 수정하기 쉽게 해줘야함
        if(cafePosts != null && httpSession.getAttribute("name").equals(cafePosts.getUserName())){
            model.addAttribute("board", cafePosts);
        }
        log.info(cafePosts.toString());
        return "home.jsp?pageName=board_update.jsp";

    }

    @GetMapping("policy")
    public String policy(){
        return "policy.jsp";
    }

    // 경호 도와주는중
    @GetMapping("map")
    public String map(){
        FirebaseMessagingSnippets firebaseMessagingSnippets = new FirebaseMessagingSnippets();
        try {
            firebaseMessagingSnippets.sendToToken();
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
        }
        return "map.jsp";
    }


    // 사장님의 한마디
    @PostMapping("onesay")
    public @ResponseBody String onesay(){
        // 나중엔 DB 연동해서 해주자
        OneSay oneSay = oneSayRepository.findByNumber(0);

        return oneSay.getOneSay();
    }

    @GetMapping("pushtest")
    public @ResponseBody String pushtest(@RequestParam String param){
        Users users = usersRepository.findByUserName("koo");
        log.info(param);
        String notifications = PushPeriodicNotifications.SuccessOrder(kakaopay.getPartner_user_id(), param, param, users.getFirebaseToken());
        log.info(notifications);
        HttpEntity<String> request = new HttpEntity<>(notifications);

        CompletableFuture<String> pushNotification = pushNotificationService.send(request);
        CompletableFuture.allOf(pushNotification).join();
        return "ghi";
    }

}
