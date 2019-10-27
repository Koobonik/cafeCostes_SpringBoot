package com.cafecostes.cafe.DB;

import com.cafecostes.cafe.domain.Hello;
import com.cafecostes.cafe.domain.Param;
import com.cafecostes.cafe.response.JSONResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
@AllArgsConstructor
public class WebRestController {
    @RequestMapping(value="/car", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Car> get() {

        Car car = new Car();
        car.setColor("yellow");
        car.setName("taxi");

        return new ResponseEntity<Car>(car, HttpStatus.OK);
    }

    @RequestMapping(value="/car2", method= RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Car> post(@RequestBody Car _car) {

        Car car = new Car();
        car.setColor(_car.getColor().toUpperCase());
        car.setName(_car.getName().toUpperCase());

        return new ResponseEntity<Car>(car, HttpStatus.OK);
    }

    @RequestMapping(value="/cars", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<List<Car>> list(@RequestBody List<Car> _cars) {

        Iterator<Car> iter = _cars.iterator();

        while (iter.hasNext()) {
            Car curCar = iter.next();
            curCar.setColor(curCar.getColor().toUpperCase());
            curCar.setName(curCar.getName().toUpperCase());
        }

        return new ResponseEntity<List<Car>>(_cars, HttpStatus.OK);
    }

//    @RequestMapping(value="/hello", method = {RequestMethod.GET, RequestMethod.POST})
//    public Hello get2() {
//        return new Hello(0, "Hello Spring Boot!");
//    }

    /*  GetMapping 대한것들  */

    // 요청 URL
    // http://localhost:8080/args?msg=m1&msg2=m2
    // {"code":0,"msg":"m1, m2"}
    @GetMapping("args")
    public Hello getArgs(@RequestParam(value = "msg")String msg, @RequestParam(value = "msg2")String msg2) {
        Hello hello = new Hello(0, msg);
        hello.setMsg(hello.getMsg() + ", " + msg2);

        return hello;
    }



    // http://localhost:8080/argsDefault?msg=m1
    // 결과값
    // {"code":0,"msg":"m1, msg2Default"}
    // 디폴트 값을 설정해줄 수 있음
    @GetMapping("argsDefault")
    public Hello getArgsDefault(
            @RequestParam(value = "msg")String msg,
            @RequestParam(value = "msg2", required = false, defaultValue = "msg2Default")String msg2) {
        Hello hello = new Hello(0, msg);
        hello.setMsg(hello.getMsg() + ", " + msg2);

        return hello;
    }

    // http://localhost:8080/jsonResponse?msg=m1
    @GetMapping("jsonResponse")
    public JSONResponse<Hello> getJsonResponse(
            @RequestParam(value = "msg")String msg) {
        Hello hello = new Hello(0, msg);

        JSONResponse<Hello> response = new JSONResponse<Hello>();
        response.setCode(1);
        response.setMsg("응답코드가 1이네요.");
        response.setData(hello);

        return response;
    }

    /*  GetMapping 대한것들  */



    /*  GetPosting 대한것들  */



    /*
    // http://localhost:8080/post
    post 문구
    {
	    "data1" : 100,
	    "data2" : "paramData2"
    }

    응답
    {
        "code": 0,
        "msg": "Data1 : 100, Data2 : paramData2"
    }

    */
    @PostMapping("post")
    public Hello post(@RequestBody Param param) {
        String msg = "Data1 : " + param.getData1() + ", Data2 : " + param.getData2();
        Hello hello = new Hello(0, msg);
        return hello;
    }

    /*  GetPosting 대한것들  */



    /*  Put 대한것들  */

    @PutMapping()
    public Hello put(@RequestParam(value = "param1")String param1) {
        Hello hello = new Hello(0, "Put Request : " + param1);
        return hello;
    }

    /*  Put 대한것들  */





}
