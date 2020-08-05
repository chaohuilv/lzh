package com.power.lzh.controller;


import com.power.lzh.entity.Human;
import com.power.lzh.service.impl.ExamService;
import com.power.lzh.service.impl.HumanServiceImpl;
import com.power.lzh.utils.ResultVOUtil;
import com.power.lzh.vo.ResultVO;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    private ExamService examService;

    @Autowired
    private HumanServiceImpl humanService;



    @GetMapping("/login")
    @ResponseBody
    public ResultVO getPostUrl(@RequestParam(value = "code") String code) {
        Human human = humanService.findAllUserCode(code);
        JSONObject json = new JSONObject();
        json.put("user_id", code);
        json.put("user_name", human.getName());
        //json.put("password", password);
        json.put("department", human.getDeptname());
        String url = examService.getLogin(json.toString());
        return ResultVOUtil.success(url);
    }

    @GetMapping("/authorize")
    public String getLogin(@RequestParam(value = "code") String code) {
        Human human = humanService.findAllUserCode(code);
        JSONObject json = new JSONObject();
        json.put("user_id", code);
        json.put("user_name", human.getName());
        //json.put("password", password);
        json.put("department", human.getDeptname());
        String url = examService.getLogin(json.toString());
        return "redirect:" + url;
    }

    /**
     * 获取考试信息
     * @param code 人员唯一id
     * @return
     */
    @GetMapping("/achievement")
    @ResponseBody
    public ResultVO getAchievement(@RequestParam(value = "code",defaultValue = "") String code){
        JSONObject json = new JSONObject();
        //编号为空获取所有
        if(code.equals("")){
            List<Human> humanList = humanService.findAll();
            for (Human row:humanList) {
                json.put("user_id", row.getCode());
                examService.getList(json.toString(),row.getCode());
            }
        }else {
            json.put("user_id", code);
            //json.put("page", 1);
            examService.getList(json.toString(),code);
        }
        return ResultVOUtil.success();
    }

}
