package com.cafecostes.cafe.Controller;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Log
@Controller
public class CssController {
    @GetMapping("style.css")
    public @ResponseBody String css(){
        return "/* table 부분 */\n" +
                "table {\n" +
                "    width: 80%;\n" +
                "\n" +
                "}\n" +
                "\n" +
                "td {\n" +
                "    padding: 11px;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "\n" +
                "/* container 부분 */\n" +
                ".container {\n" +
                "    display: inline-flex;\n" +
                "    width: 100%;\n" +
                "    max-height: 300%;\n" +
                "    flex-direction: column;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "/* header 부분 */\n" +
                ".header {\n" +
                "    display: inline-flex;\n" +
                "    flex: 0 1 10px;\n" +
                "    width: 100%;\n" +
                "    justify-content: flex-end;\n" +
                "    background-color: #FAFAFA;\n" +
                "    border: 0.5px solid #F2F2F2;\n" +
                "}\n" +
                "\n" +
                ".header_right {\n" +
                "    width: 80%;\n" +
                "    margin-left: auto;\n" +
                "    text-align: right;\n" +
                "}\n" +
                "\n" +
                ".header_left {\n" +
                "    width: 20%;\n" +
                "    cursor: pointer;\n" +
                "\n" +
                "}\n" +
                "\n" +
                ".header_nav {\n" +
                "    width: 100%;\n" +
                "    height: 50px;\n" +
                "}\n" +
                "\n" +
                ".header_nav ul {\n" +
                "    list-style-type: none;\n" +
                "}\n" +
                "\n" +
                ".header_nav ul li {\n" +
                "    display: inline;\n" +
                "    margin: 35px 10px 35px 10px;\n" +
                "    padding: 10px 35px 10px 35px;\n" +
                "    cursor: pointer;\n" +
                "    color: #848484;\n" +
                "}\n" +
                "\n" +
                "\n" +
                ".user_interface {\n" +
                "    font-size: 13px;\n" +
                "    margin: 30px 0px 30px 0px;\n" +
                "    padding: 0px 10px 0px 10px;\n" +
                "    color: #848484;\n" +
                "}\n" +
                "\n" +
                ".user_interface ul {\n" +
                "    list-style-type: none;\n" +
                "}\n" +
                "\n" +
                ".user_interface ul li {\n" +
                "    display: inline;\n" +
                "    margin: 40px 0px 40px 0px;\n" +
                "    padding: 0px 20px 0px 20px;\n" +
                "    cursor: pointer;\n" +
                "    border-left: 1px solid #c0c0c0;\n" +
                "}\n" +
                "\n" +
                ".user_interface ul li:first-child {\n" +
                "    border-left: none;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "/* content 부분 */\n" +
                ".content {\n" +
                "    display: inline-flex;\n" +
                "    justify-content: center;\n" +
                "    flex: 1 1 350px;\n" +
                "    /*\n" +
                "    border : 1px solid red;\n" +
                "    margin-left : 10%;\n" +
                "    margin-right : 10%;\n" +
                "    */\n" +
                "}\n" +
                "\n" +
                "\n" +
                "/* sidebar 부분 */\n" +
                ".sidebar_container {\n" +
                "    display: inline-flex;\n" +
                "    justify-content: space-evenly;\n" +
                "    flex: 0 1 70px;\n" +
                "    /*margin-top: 10px;*/\n" +
                "    background-color: black;\n" +
                "    color: whitesmoke;\n" +
                "}\n" +
                "\n" +
                ".sidebar_container_left {\n" +
                "    display: inline-flex;\n" +
                "    width: 50%;\n" +
                "\n" +
                "}\n" +
                "\n" +
                ".sidebar_container_left_content {\n" +
                "    display: inline-flex;\n" +
                "    width: 20%;\n" +
                "    justify-content: center;\n" +
                "    align-items: center;\n" +
                "}\n" +
                "\n" +
                "\n" +
                ".sidebar_container_left_text_box {\n" +
                "    display: inline-flex;\n" +
                "    width: 80%;\n" +
                "    justify-content: left;\n" +
                "    align-items: center;\n" +
                "}\n" +
                "\n" +
                "\n" +
                ".sidebar_container_right {\n" +
                "    display: inline-flex;\n" +
                "    width: 50%;\n" +
                "    justify-content: center;\n" +
                "    align-items: center;\n" +
                "    background-color: white;\n" +
                "    color: black;\n" +
                "}\n" +
                "\n" +
                ".sidebar_container_right_content {\n" +
                "    display: inline-flex;\n" +
                "    width: 80%;\n" +
                "    justify-content: left;\n" +
                "    align-items: center;\n" +
                "    font-weight: bold;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "/* footer 부분 */\n" +
                ".footer {\n" +
                "    font-size: 10pt;\n" +
                "    line-height: 1.7em;\n" +
                "    display: inline-flex;\n" +
                "    /*font-weight:bold;*/\n" +
                "    background-color: #2E2E2E;\n" +
                "    color: #848484;\n" +
                "    flex: 0 1 80px;\n" +
                "    justify-content: center;\n" +
                "    font-family: \"Arial\";\n" +
                "    color: #848484;\n" +
                "    font-size: 12px;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "/* Content 부분 */\n" +
                "\n" +
                ".content_container {\n" +
                "    display: inline-flex;\n" +
                "    flex-direction: column;\n" +
                "    flex: 1 0 100px;\n" +
                "    width: 100%;\n" +
                "}\n" +
                "\n" +
                ".content_header {\n" +
                "    display: inline-flex;\n" +
                "    flex: 0 1 100px;\n" +
                "    color: black;\n" +
                "    justify-content: left;\n" +
                "    align-items: center;\n" +
                "    margin-left: 30px;\n" +
                "\n" +
                "}\n" +
                "\n" +
                ".content_body {\n" +
                "    display: inline-flex;\n" +
                "    flex: 1 1 50px;\n" +
                "    width: 100%;\n" +
                "\n" +
                "    /*\n" +
                "    스크롤로 넘치지 않게\n" +
                "    overflow : auto;*/\n" +
                "    justify-content: center;\n" +
                "    margin: 0 auto;\n" +
                "\n" +
                "}\n" +
                "\n" +
                ".content_footer {\n" +
                "    display: inline-flex;\n" +
                "    flex: 0 1 50px;\n" +
                "    justify-content: center;\n" +
                "}\n" +
                "\n" +
                "\n" +
                ".sharing_container {\n" +
                "    background-color: whitesmoke;\n" +
                "    position: fixed;\n" +
                "    left: 80%;\n" +
                "    top: 40%;\n" +
                "    text-align: center;\n" +
                "    width: 200px;\n" +
                "    height: 400px;\n" +
                "    border : 5px solid red;\n" +
                "}\n" +
                "\n" +
                ".shaing_header {\n" +
                "    width : auto;\n" +
                "    height : 50px;\n" +
                "    border: 5px solid black;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "\n" +
                "/* intro 부분 */\n" +
                ".img {\n" +
                "    position: relative;\n" +
                "    background-image: url(https://wikidocs.net/images/page/37661/%E1%84%8B%E1%85%AC%E1%84%87%E1%85%AE%E1%84%8C%E1%85%A5%E1%86%AB%E1%84%80%E1%85%A7%E1%86%BC2.jpeg);\n" +
                "    height: 100vh;\n" +
                "    background-size: cover;\n" +
                "}\n" +
                "\n" +
                ".img-cover {\n" +
                "    position: absolute;\n" +
                "    height: 100%;\n" +
                "    width: 100%;\n" +
                "    background-color: rgba(0, 0, 0, 0.5);\n" +
                "    z-index: 1;\n" +
                "}\n" +
                "\n" +
                ".img .content {\n" +
                "    position: absolute;\n" +
                "    top: 50%;\n" +
                "    left: 50%;\n" +
                "    transform: translate(-10%, 120%);\n" +
                "    font-size: 1.3rem;\n" +
                "    color: white;\n" +
                "    z-index: 2;\n" +
                "    text-align: right;\n" +
                "}\n" +
                "\n" +
                "/* introduction 부분 */\n" +
                ".introduction_box {\n" +
                "    display: inline-flex;\n" +
                "    font-family: \"Arial\";\n" +
                "    color: #848484;\n" +
                "    font-size: 14px;\n" +
                "    justify-content: center;\n" +
                "    align-items: center;\n" +
                "    width: 100%;\n" +
                "    height: auto;\n" +
                "    letter-spacing: 3px;\n" +
                "    line-height: 180%;\n" +
                "}\n";
    }
    @GetMapping("request/style.css")
    public @ResponseBody String css2(){
        return "/* table 부분 */\n" +
                "table {\n" +
                "    width: 80%;\n" +
                "\n" +
                "}\n" +
                "\n" +
                "td {\n" +
                "    padding: 11px;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "\n" +
                "/* container 부분 */\n" +
                ".container {\n" +
                "    display: inline-flex;\n" +
                "    width: 100%;\n" +
                "    max-height: 300%;\n" +
                "    flex-direction: column;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "/* header 부분 */\n" +
                ".header {\n" +
                "    display: inline-flex;\n" +
                "    flex: 0 1 10px;\n" +
                "    width: 100%;\n" +
                "    justify-content: flex-end;\n" +
                "    background-color: #FAFAFA;\n" +
                "    border: 0.5px solid #F2F2F2;\n" +
                "}\n" +
                "\n" +
                ".header_right {\n" +
                "    width: 80%;\n" +
                "    margin-left: auto;\n" +
                "    text-align: right;\n" +
                "}\n" +
                "\n" +
                ".header_left {\n" +
                "    width: 20%;\n" +
                "    cursor: pointer;\n" +
                "\n" +
                "}\n" +
                "\n" +
                ".header_nav {\n" +
                "    width: 100%;\n" +
                "    height: 50px;\n" +
                "}\n" +
                "\n" +
                ".header_nav ul {\n" +
                "    list-style-type: none;\n" +
                "}\n" +
                "\n" +
                ".header_nav ul li {\n" +
                "    display: inline;\n" +
                "    margin: 35px 10px 35px 10px;\n" +
                "    padding: 10px 35px 10px 35px;\n" +
                "    cursor: pointer;\n" +
                "    color: #848484;\n" +
                "}\n" +
                "\n" +
                "\n" +
                ".user_interface {\n" +
                "    font-size: 13px;\n" +
                "    margin: 30px 0px 30px 0px;\n" +
                "    padding: 0px 10px 0px 10px;\n" +
                "    color: #848484;\n" +
                "}\n" +
                "\n" +
                ".user_interface ul {\n" +
                "    list-style-type: none;\n" +
                "}\n" +
                "\n" +
                ".user_interface ul li {\n" +
                "    display: inline;\n" +
                "    margin: 40px 0px 40px 0px;\n" +
                "    padding: 0px 20px 0px 20px;\n" +
                "    cursor: pointer;\n" +
                "    border-left: 1px solid #c0c0c0;\n" +
                "}\n" +
                "\n" +
                ".user_interface ul li:first-child {\n" +
                "    border-left: none;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "/* content 부분 */\n" +
                ".content {\n" +
                "    display: inline-flex;\n" +
                "    justify-content: center;\n" +
                "    flex: 1 1 350px;\n" +
                "    /*\n" +
                "    border : 1px solid red;\n" +
                "    margin-left : 10%;\n" +
                "    margin-right : 10%;\n" +
                "    */\n" +
                "}\n" +
                "\n" +
                "\n" +
                "/* sidebar 부분 */\n" +
                ".sidebar_container {\n" +
                "    display: inline-flex;\n" +
                "    justify-content: space-evenly;\n" +
                "    flex: 0 1 70px;\n" +
                "    /*margin-top: 10px;*/\n" +
                "    background-color: black;\n" +
                "    color: whitesmoke;\n" +
                "}\n" +
                "\n" +
                ".sidebar_container_left {\n" +
                "    display: inline-flex;\n" +
                "    width: 50%;\n" +
                "\n" +
                "}\n" +
                "\n" +
                ".sidebar_container_left_content {\n" +
                "    display: inline-flex;\n" +
                "    width: 20%;\n" +
                "    justify-content: center;\n" +
                "    align-items: center;\n" +
                "}\n" +
                "\n" +
                "\n" +
                ".sidebar_container_left_text_box {\n" +
                "    display: inline-flex;\n" +
                "    width: 80%;\n" +
                "    justify-content: left;\n" +
                "    align-items: center;\n" +
                "}\n" +
                "\n" +
                "\n" +
                ".sidebar_container_right {\n" +
                "    display: inline-flex;\n" +
                "    width: 50%;\n" +
                "    justify-content: center;\n" +
                "    align-items: center;\n" +
                "    background-color: white;\n" +
                "    color: black;\n" +
                "}\n" +
                "\n" +
                ".sidebar_container_right_content {\n" +
                "    display: inline-flex;\n" +
                "    width: 80%;\n" +
                "    justify-content: left;\n" +
                "    align-items: center;\n" +
                "    font-weight: bold;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "/* footer 부분 */\n" +
                ".footer {\n" +
                "    font-size: 10pt;\n" +
                "    line-height: 1.7em;\n" +
                "    display: inline-flex;\n" +
                "    /*font-weight:bold;*/\n" +
                "    background-color: #2E2E2E;\n" +
                "    color: #848484;\n" +
                "    flex: 0 1 80px;\n" +
                "    justify-content: center;\n" +
                "    font-family: \"Arial\";\n" +
                "    color: #848484;\n" +
                "    font-size: 12px;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "/* Content 부분 */\n" +
                "\n" +
                ".content_container {\n" +
                "    display: inline-flex;\n" +
                "    flex-direction: column;\n" +
                "    flex: 1 0 100px;\n" +
                "    width: 100%;\n" +
                "}\n" +
                "\n" +
                ".content_header {\n" +
                "    display: inline-flex;\n" +
                "    flex: 0 1 100px;\n" +
                "    color: black;\n" +
                "    justify-content: left;\n" +
                "    align-items: center;\n" +
                "    margin-left: 30px;\n" +
                "\n" +
                "}\n" +
                "\n" +
                ".content_body {\n" +
                "    display: inline-flex;\n" +
                "    flex: 1 1 50px;\n" +
                "    width: 100%;\n" +
                "\n" +
                "    /*\n" +
                "    스크롤로 넘치지 않게\n" +
                "    overflow : auto;*/\n" +
                "    justify-content: center;\n" +
                "    margin: 0 auto;\n" +
                "\n" +
                "}\n" +
                "\n" +
                ".content_footer {\n" +
                "    display: inline-flex;\n" +
                "    flex: 0 1 50px;\n" +
                "    justify-content: center;\n" +
                "}\n" +
                "\n" +
                "\n" +
                ".sharing_container {\n" +
                "    background-color: whitesmoke;\n" +
                "    position: fixed;\n" +
                "    left: 80%;\n" +
                "    top: 40%;\n" +
                "    text-align: center;\n" +
                "    width: 200px;\n" +
                "    height: 400px;\n" +
                "    border : 5px solid red;\n" +
                "}\n" +
                "\n" +
                ".shaing_header {\n" +
                "    width : auto;\n" +
                "    height : 50px;\n" +
                "    border: 5px solid black;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "\n" +
                "/* intro 부분 */\n" +
                ".img {\n" +
                "    position: relative;\n" +
                "    background-image: url(https://wikidocs.net/images/page/37661/%E1%84%8B%E1%85%AC%E1%84%87%E1%85%AE%E1%84%8C%E1%85%A5%E1%86%AB%E1%84%80%E1%85%A7%E1%86%BC2.jpeg);\n" +
                "    height: 100vh;\n" +
                "    background-size: cover;\n" +
                "}\n" +
                "\n" +
                ".img-cover {\n" +
                "    position: absolute;\n" +
                "    height: 100%;\n" +
                "    width: 100%;\n" +
                "    background-color: rgba(0, 0, 0, 0.5);\n" +
                "    z-index: 1;\n" +
                "}\n" +
                "\n" +
                ".img .content {\n" +
                "    position: absolute;\n" +
                "    top: 50%;\n" +
                "    left: 50%;\n" +
                "    transform: translate(-10%, 120%);\n" +
                "    font-size: 1.3rem;\n" +
                "    color: white;\n" +
                "    z-index: 2;\n" +
                "    text-align: right;\n" +
                "}\n" +
                "\n" +
                "/* introduction 부분 */\n" +
                ".introduction_box {\n" +
                "    display: inline-flex;\n" +
                "    font-family: \"Arial\";\n" +
                "    color: #848484;\n" +
                "    font-size: 14px;\n" +
                "    justify-content: center;\n" +
                "    align-items: center;\n" +
                "    width: 100%;\n" +
                "    height: auto;\n" +
                "    letter-spacing: 3px;\n" +
                "    line-height: 180%;\n" +
                "}\n";
    }
    @GetMapping("css/style.css")
    public @ResponseBody String css3() {
        return "/* table 부분 */\n" +
                "table {\n" +
                "    width: 80%;\n" +
                "\n" +
                "}\n" +
                "\n" +
                "td {\n" +
                "    padding: 11px;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "\n" +
                "/* container 부분 */\n" +
                ".container {\n" +
                "    display: inline-flex;\n" +
                "    width: 100%;\n" +
                "    max-height: 300%;\n" +
                "    flex-direction: column;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "/* header 부분 */\n" +
                ".header {\n" +
                "    display: inline-flex;\n" +
                "    flex: 0 1 10px;\n" +
                "    width: 100%;\n" +
                "    justify-content: flex-end;\n" +
                "    background-color: #FAFAFA;\n" +
                "    border: 0.5px solid #F2F2F2;\n" +
                "}\n" +
                "\n" +
                ".header_right {\n" +
                "    width: 80%;\n" +
                "    margin-left: auto;\n" +
                "    text-align: right;\n" +
                "}\n" +
                "\n" +
                ".header_left {\n" +
                "    width: 20%;\n" +
                "    cursor: pointer;\n" +
                "\n" +
                "}\n" +
                "\n" +
                ".header_nav {\n" +
                "    width: 100%;\n" +
                "    height: 50px;\n" +
                "}\n" +
                "\n" +
                ".header_nav ul {\n" +
                "    list-style-type: none;\n" +
                "}\n" +
                "\n" +
                ".header_nav ul li {\n" +
                "    display: inline;\n" +
                "    margin: 35px 10px 35px 10px;\n" +
                "    padding: 10px 35px 10px 35px;\n" +
                "    cursor: pointer;\n" +
                "    color: #848484;\n" +
                "}\n" +
                "\n" +
                "\n" +
                ".user_interface {\n" +
                "    font-size: 13px;\n" +
                "    margin: 30px 0px 30px 0px;\n" +
                "    padding: 0px 10px 0px 10px;\n" +
                "    color: #848484;\n" +
                "}\n" +
                "\n" +
                ".user_interface ul {\n" +
                "    list-style-type: none;\n" +
                "}\n" +
                "\n" +
                ".user_interface ul li {\n" +
                "    display: inline;\n" +
                "    margin: 40px 0px 40px 0px;\n" +
                "    padding: 0px 20px 0px 20px;\n" +
                "    cursor: pointer;\n" +
                "    border-left: 1px solid #c0c0c0;\n" +
                "}\n" +
                "\n" +
                ".user_interface ul li:first-child {\n" +
                "    border-left: none;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "/* content 부분 */\n" +
                ".content {\n" +
                "    display: inline-flex;\n" +
                "    justify-content: center;\n" +
                "    flex: 1 1 350px;\n" +
                "    /*\n" +
                "    border : 1px solid red;\n" +
                "    margin-left : 10%;\n" +
                "    margin-right : 10%;\n" +
                "    */\n" +
                "}\n" +
                "\n" +
                "\n" +
                "/* sidebar 부분 */\n" +
                ".sidebar_container {\n" +
                "    display: inline-flex;\n" +
                "    justify-content: space-evenly;\n" +
                "    flex: 0 1 70px;\n" +
                "    /*margin-top: 10px;*/\n" +
                "    background-color: black;\n" +
                "    color: whitesmoke;\n" +
                "}\n" +
                "\n" +
                ".sidebar_container_left {\n" +
                "    display: inline-flex;\n" +
                "    width: 50%;\n" +
                "\n" +
                "}\n" +
                "\n" +
                ".sidebar_container_left_content {\n" +
                "    display: inline-flex;\n" +
                "    width: 20%;\n" +
                "    justify-content: center;\n" +
                "    align-items: center;\n" +
                "}\n" +
                "\n" +
                "\n" +
                ".sidebar_container_left_text_box {\n" +
                "    display: inline-flex;\n" +
                "    width: 80%;\n" +
                "    justify-content: left;\n" +
                "    align-items: center;\n" +
                "}\n" +
                "\n" +
                "\n" +
                ".sidebar_container_right {\n" +
                "    display: inline-flex;\n" +
                "    width: 50%;\n" +
                "    justify-content: center;\n" +
                "    align-items: center;\n" +
                "    background-color: white;\n" +
                "    color: black;\n" +
                "}\n" +
                "\n" +
                ".sidebar_container_right_content {\n" +
                "    display: inline-flex;\n" +
                "    width: 80%;\n" +
                "    justify-content: left;\n" +
                "    align-items: center;\n" +
                "    font-weight: bold;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "/* footer 부분 */\n" +
                ".footer {\n" +
                "    font-size: 10pt;\n" +
                "    line-height: 1.7em;\n" +
                "    display: inline-flex;\n" +
                "    /*font-weight:bold;*/\n" +
                "    background-color: #2E2E2E;\n" +
                "    color: #848484;\n" +
                "    flex: 0 1 80px;\n" +
                "    justify-content: center;\n" +
                "    font-family: \"Arial\";\n" +
                "    color: #848484;\n" +
                "    font-size: 12px;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "/* Content 부분 */\n" +
                "\n" +
                ".content_container {\n" +
                "    display: inline-flex;\n" +
                "    flex-direction: column;\n" +
                "    flex: 1 0 100px;\n" +
                "    width: 100%;\n" +
                "}\n" +
                "\n" +
                ".content_header {\n" +
                "    display: inline-flex;\n" +
                "    flex: 0 1 100px;\n" +
                "    color: black;\n" +
                "    justify-content: left;\n" +
                "    align-items: center;\n" +
                "    margin-left: 30px;\n" +
                "\n" +
                "}\n" +
                "\n" +
                ".content_body {\n" +
                "    display: inline-flex;\n" +
                "    flex: 1 1 50px;\n" +
                "    width: 100%;\n" +
                "\n" +
                "    /*\n" +
                "    스크롤로 넘치지 않게\n" +
                "    overflow : auto;*/\n" +
                "    justify-content: center;\n" +
                "    margin: 0 auto;\n" +
                "\n" +
                "}\n" +
                "\n" +
                ".content_footer {\n" +
                "    display: inline-flex;\n" +
                "    flex: 0 1 50px;\n" +
                "    justify-content: center;\n" +
                "}\n" +
                "\n" +
                "\n" +
                ".sharing_container {\n" +
                "    background-color: whitesmoke;\n" +
                "    position: fixed;\n" +
                "    left: 80%;\n" +
                "    top: 40%;\n" +
                "    text-align: center;\n" +
                "    width: 200px;\n" +
                "    height: 400px;\n" +
                "    border : 5px solid red;\n" +
                "}\n" +
                "\n" +
                ".shaing_header {\n" +
                "    width : auto;\n" +
                "    height : 50px;\n" +
                "    border: 5px solid black;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "\n" +
                "/* intro 부분 */\n" +
                ".img {\n" +
                "    position: relative;\n" +
                "    background-image: url(https://wikidocs.net/images/page/37661/%E1%84%8B%E1%85%AC%E1%84%87%E1%85%AE%E1%84%8C%E1%85%A5%E1%86%AB%E1%84%80%E1%85%A7%E1%86%BC2.jpeg);\n" +
                "    height: 100vh;\n" +
                "    background-size: cover;\n" +
                "}\n" +
                "\n" +
                ".img-cover {\n" +
                "    position: absolute;\n" +
                "    height: 100%;\n" +
                "    width: 100%;\n" +
                "    background-color: rgba(0, 0, 0, 0.5);\n" +
                "    z-index: 1;\n" +
                "}\n" +
                "\n" +
                ".img .content {\n" +
                "    position: absolute;\n" +
                "    top: 50%;\n" +
                "    left: 50%;\n" +
                "    transform: translate(-10%, 120%);\n" +
                "    font-size: 1.3rem;\n" +
                "    color: white;\n" +
                "    z-index: 2;\n" +
                "    text-align: right;\n" +
                "}\n" +
                "\n" +
                "/* introduction 부분 */\n" +
                ".introduction_box {\n" +
                "    display: inline-flex;\n" +
                "    font-family: \"Arial\";\n" +
                "    color: #848484;\n" +
                "    font-size: 14px;\n" +
                "    justify-content: center;\n" +
                "    align-items: center;\n" +
                "    width: 100%;\n" +
                "    height: auto;\n" +
                "    letter-spacing: 3px;\n" +
                "    line-height: 180%;\n" +
                "}\n";
    }

    @GetMapping("style2.css")
    public @ResponseBody String style2(){
        return "html {\n" +
                "        width: 100%;\n" +
                "        height: 100%;\n" +
                "    }\n" +
                "\n" +
                "    body {\n" +
                "        color: rgba(0, 0, 0, 0.6);\n" +
                "        -webkit-font-smoothing: antialiased;\n" +
                "        -moz-osx-font-smoothing: grayscale;\n" +
                "    }\n" +
                "\n" +
                "    .form-toggle {\n" +
                "        z-index: 10;\n" +
                "        position: absolute;\n" +
                "        top: 60px;\n" +
                "        right: 60px;\n" +
                "        background: #FFFFFF;\n" +
                "        width: 60px;\n" +
                "        height: 60px;\n" +
                "        border-radius: 100%;\n" +
                "        -webkit-transform-origin: center;\n" +
                "        -ms-transform-origin: center;\n" +
                "        transform-origin: center;\n" +
                "        -webkit-transform: translate(0, -25%) scale(0);\n" +
                "        -ms-transform: translate(0, -25%) scale(0);\n" +
                "        transform: translate(0, -25%) scale(0);\n" +
                "        opacity: 0;\n" +
                "        cursor: pointer;\n" +
                "        -webkit-transition: all 0.3s ease;\n" +
                "        transition: all 0.3s ease;\n" +
                "    }\n" +
                "\n" +
                "    .form-group {\n" +
                "        display: -webkit-box;\n" +
                "        display: -webkit-flex;\n" +
                "        display: -ms-flexbox;\n" +
                "        display: flex;\n" +
                "        -webkit-flex-wrap: wrap;\n" +
                "        -ms-flex-wrap: wrap;\n" +
                "        flex-wrap: wrap;\n" +
                "        -webkit-box-pack: justify;\n" +
                "        -webkit-justify-content: space-between;\n" +
                "        -ms-flex-pack: justify;\n" +
                "        justify-content: space-between;\n" +
                "        margin: 0 0 20px;\n" +
                "    }\n" +
                "\n" +
                "    .form-group:last-child {\n" +
                "        margin: 0;\n" +
                "    }\n" +
                "\n" +
                "    .form-group label {\n" +
                "        display: block;\n" +
                "        margin: 0 0 10px;\n" +
                "        color: rgba(0, 0, 0, 0.6);\n" +
                "        font-size: 12px;\n" +
                "        font-weight: 500;\n" +
                "        line-height: 1;\n" +
                "        text-transform: uppercase;\n" +
                "        letter-spacing: .2em;\n" +
                "    }\n" +
                "\n" +
                "    .form-group input {\n" +
                "        outline: none;\n" +
                "        display: block;\n" +
                "        background: rgba(0, 0, 0, 0.1);\n" +
                "        width: 100%;\n" +
                "        border: 0;\n" +
                "        border-radius: 4px;\n" +
                "        box-sizing: border-box;\n" +
                "        padding: 12px 20px;\n" +
                "        color: rgba(0, 0, 0, 0.6);\n" +
                "        font-family: inherit;\n" +
                "        font-size: inherit;\n" +
                "        font-weight: 500;\n" +
                "        line-height: inherit;\n" +
                "        -webkit-transition: 0.3s ease;\n" +
                "        transition: 0.3s ease;\n" +
                "    }\n" +
                "\n" +
                "    .form-group input:focus {\n" +
                "        color: rgba(0, 0, 0, 0.8);\n" +
                "    }\n" +
                "\n" +
                "    .form-group button {\n" +
                "        outline: none;\n" +
                "        background: black;\n" +
                "        width: 100%;\n" +
                "        border: 0;\n" +
                "        border-radius: 4px;\n" +
                "        padding: 12px 20px;\n" +
                "        color: white;\n" +
                "        font-family: inherit;\n" +
                "        font-size: inherit;\n" +
                "        font-weight: 500;\n" +
                "        line-height: inherit;\n" +
                "        text-transform: uppercase;\n" +
                "        cursor: pointer;\n" +
                "        font-weight: 700;\n" +
                "    }\n" +
                "\n" +
                "    .form-group .form-remember {\n" +
                "        font-size: 12px;\n" +
                "        font-weight: 400;\n" +
                "        letter-spacing: 0;\n" +
                "        text-transform: none;\n" +
                "    }\n" +
                "\n" +
                "    .form-group .form-remember input[type='checkbox'] {\n" +
                "        display: inline-block;\n" +
                "        width: auto;\n" +
                "        margin: 0 10px 0 0;\n" +
                "    }\n" +
                "\n" +
                "    .form-group .form-recovery {\n" +
                "        color: #4285F4;\n" +
                "        font-size: 12px;\n" +
                "        text-decoration: none;\n" +
                "    }\n" +
                "\n" +
                "    .form-panel {\n" +
                "        padding: 60px calc(5% + 60px) 60px 60px;\n" +
                "        box-sizing: border-box;\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "    .form-header h1 {\n" +
                "        padding: 4px 0;\n" +
                "        color: black;\n" +
                "        font-size: 24px;\n" +
                "        font-weight: 700;\n" +
                "        text-transform: uppercase;\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "    .pen-footer a {\n" +
                "        color: #FFFFFF;\n" +
                "        font-size: 12px;\n" +
                "        text-decoration: none;\n" +
                "        text-shadow: 1px 2px 0 rgba(0, 0, 0, 0.1);\n" +
                "    }";
    }
}
