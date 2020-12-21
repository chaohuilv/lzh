package com.power.lzh.controller;


import com.power.lzh.entity.Human;
import com.power.lzh.service.impl.ExamService;
import com.power.lzh.service.impl.HumanServiceImpl;
import com.power.lzh.utils.ResultVOUtil;
import com.power.lzh.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/exam")
@Api("考试星信息API")
public class ExamController {

    @Autowired
    private ExamService examService;

    @Autowired
    private HumanServiceImpl humanService;



    @GetMapping("/login")
    @ResponseBody
    @ApiOperation(value = "登录", notes = "根据人员编号登录系统,不重定向登录后的地址。")
    @ApiImplicitParam(name = "code", value = "人员编号",  paramType = "path", required = true, dataType =  "String")
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
    @ApiOperation(value = "登录", notes = "根据人员编号登录系统,重定向登录后的地址。")
    @ApiImplicitParam(name = "code", value = "人员编号",  paramType = "query", required = true, dataType =  "String")
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
    @ApiOperation(value = "考试信息", notes = "根据人员编号获取考试信息。")
    public ResultVO getAchievement(@RequestParam(value = "code", defaultValue= "") String code){
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
