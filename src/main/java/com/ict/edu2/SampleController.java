package com.ict.edu2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class SampleController {

    // 반환형이 String => 브라우저에 String 자체가 출력됨
    @GetMapping("/hello")
    public String getHello() {
        return "Hello, World";
    }

    // 반환형이 String[] => 자동으로 json 형식을 가지고 출력
    @GetMapping("/hello2")
    public String[] getHello2() {
        return new String[]{"Hello" , "World"};
    }
    
    // 반환형이 객체일 때
    @GetMapping("/hello3")
    public SampleVO getHello3() {
        SampleVO svo = new SampleVO();
        svo.setName("고길동");
        svo.setAge("24");
        
        return svo;
    }

    // 반환형이 객체일 때 => 자동으로 json 형식을 가지고 출력
    @GetMapping("/hello4")
    public List<SampleVO> getHello4() {
        List<SampleVO> list = new ArrayList<>();

        SampleVO svo = new SampleVO();
        svo.setName("고길동");
        svo.setAge("24");
        list.add(svo);

        SampleVO svo2 = new SampleVO();
        svo2.setName("희동이");
        svo2.setAge("3");
        list.add(svo2);

        SampleVO svo3 = new SampleVO();
        svo3.setName("도우너");
        svo3.setAge("17");
        list.add(svo3);
        return list;
    }


    // 반환형이 객체일 때 => 자동으로 json 형식을 가지고 출력
    @GetMapping("/hello5")
    public DataVO getHello5(String number) {
        DataVO dataVO = new DataVO<>();

        List<SampleVO> list = new ArrayList<>();

        SampleVO svo = new SampleVO("고길동", "24");
        SampleVO svo2 = new SampleVO("희동이", "3");
        SampleVO svo3 = new SampleVO("도우너", "17");

        list.add(svo);
        list.add(svo2);
        list.add(svo3);

        if (number.equals("1")) {
            // datavo.setResultCode(1);
            // datavo.setMessage("성공");
            // datavo.setData(list);
            
            return DataVO.success("list", "성공");

        } else {
            // datavo.setResultCode(0);
            // datavo.setMessage("실패");
            // datavo.setData(null);

            return DataVO.fail(0, "실패");

        }
    }

}
