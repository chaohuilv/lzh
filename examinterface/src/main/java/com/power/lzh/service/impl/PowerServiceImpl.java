package com.power.lzh.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.power.lzh.entity.Department;
import com.power.lzh.entity.Human;
import com.power.lzh.entity.Position;
import com.power.lzh.service.PowerService;
import com.power.lzh.utils.ResultVOUtil;
import com.power.lzh.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@WebService(serviceName = "powerService",//对外发布的服务名
targetNamespace = "http://service.lzh.power.com/",//指定你想要的名称空间，通常使用使用包名反转
endpointInterface = "com.power.lzh.service.PowerService")
@Service
@Slf4j
public class PowerServiceImpl implements PowerService {

    @Autowired
    private DepartmentServiceImpl departmentService;

    @Autowired
    private PositionServiceImpl positionService;

    @Autowired
    private HumanServiceImpl humanService;

    /**
     * 部门服务
     * @param update 时间
     * @param page 页
     * @param size 行数
     * @return
     */
    @Override
    public String GetDept(String update, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page-1,size);
        Page<Department> departmentPage = departmentService.findByEpsprojidAndUpdate(update,pageable);
        int total = (int) departmentPage.getTotalElements();
        log.info("【GetDept返回信息】result={}",JSONObject.toJSONString(ResultVOUtil.success(departmentPage.getContent(),total)));
        return  JSONObject.toJSONString(ResultVOUtil.success(departmentPage.getContent(),total));
    }

    /**
     * 岗位服务
     * @param update 时间
     * @param page 页
     * @param size 行数
     * @return
     */
    @Override
    public String GetPosition(String update, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page-1,size);
        Page<Position> positionPage = positionService.fiandAll(update, pageable);
        int total = (int) positionPage.getTotalElements();
        String postionJson = JSONObject.toJSONString(ResultVOUtil.success(positionPage.getContent(),total));
        log.info("【GetPosition返回信息】result={}",postionJson);
        return  postionJson;
    }

    /**
     * 人员服务
     * @param update 时间
     * @param page 页
     * @param size 行
     * @return
     */
    @Override
    public String GetUser(String update, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page-1,size);
        Page<Human> humanPage = humanService.fiandAll(update,pageable);
        int total = (int) humanPage.getTotalElements();
        String userJson = JSONObject.toJSONString(ResultVOUtil.success(humanPage.getContent(),total));
        log.info("【GetPosition返回信息】result={}",userJson);
        return  userJson;
    }
}
