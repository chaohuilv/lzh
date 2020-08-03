package com.power.lzh.service.impl;

import com.power.lzh.entity.fromVO.ResultFromVO;
import net.sf.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ExamServiceTest {

    @Autowired
    private ExamService examService;

    @Test
    void getLogin() {
        JSONObject json = new JSONObject();
        json.put("user_id", "zhangsan");
        json.put("user_name", "张三");
        //json.put("password", "");
        json.put("department", "IT部");
        String result = examService.getLogin(json.toString());
        System.out.println(result);
    }

    @Test
    void getList(){
        JSONObject json = new JSONObject();
        json.put("user_id", "zhangsan");
        //json.put("page", 1);
        examService.getList(json.toString(),"zhangsan");
    }
}