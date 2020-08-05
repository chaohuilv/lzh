package com.power.lzh.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.power.lzh.config.ExamConfig;
import com.power.lzh.config.PowerEpsProjConfig;
import com.power.lzh.dao.ExamResultDao;
import com.power.lzh.entity.ExamResult;
import com.power.lzh.entity.Login;
import com.power.lzh.entity.fromVO.ExamResultTotal;
import com.power.lzh.entity.fromVO.ResultFromVO;
import com.power.lzh.utils.ExamJWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class ExamService {

    @Autowired
    private ExamJWTUtil examJWTUtil;

    @Autowired
    private ExamConfig examConfig;

    @Autowired
    private ExamResultDao examResultDao;

    @Autowired
    private PowerEpsProjConfig powerEpsProjConfig;

    /**
     * 生成单点登录地址
     * @param body 请求信息
     * @return
     */
    public String getLogin(String body){
        String jwtInfo = examJWTUtil.getJWTInfo(examConfig.getLonginCode());
        String postUrl = String.format("%s/api/company/data/%s/?jwt=%s", examConfig.getDomainUrl(),
                examConfig.getAppId(), jwtInfo);
        String result = examJWTUtil.sendPost(postUrl,body);
        List<Login> list = new ArrayList<Login>(JSONArray.parseArray("["+result+"]", Login.class));
        String url = "";
        for (Login loginRow : list) {
            url = loginRow.getUrl();
        }
        return url;
    }

    /**
     * 获取考试成绩信息
     * @param body 请求内容
     * @return
     */
    public void getList(String body,String userCode){
        String jwtInfo = examJWTUtil.getJWTInfo(examConfig.getAchievementCode());
        String postUrl = String.format("%s/api/company/data/%s/?jwt=%s", examConfig.getDomainUrl(),
                examConfig.getAppId(), jwtInfo);
        String result = examJWTUtil.sendPost(postUrl,body);
        List<ResultFromVO> list = new ArrayList<ResultFromVO>(JSONArray.parseArray("["+result+"]", ResultFromVO.class));
        if(list != null){
            for (ResultFromVO result1:list) {
                //返回有数据执行add赋值
                if(result1.getSuccess() == true){
                    log.info("【获取考试结果】userCode={},result={}",userCode,result1);
                    List<ExamResultTotal> examResultTotals = result1.getBizContent();
                    for (ExamResultTotal examResultTotal :examResultTotals) {
                        List<ExamResult> examResults = examResultTotal.getRows();
                        for (ExamResult examResult : examResults) {
                            ExamResult exam = examResultDao.findAllByExamInfoId(examResult.getExamInfoId());
                            if (exam == null) {
                                examResult.setStatusExam(examResult.getStatus());
                                examResult.setId(UUID.randomUUID().toString());
                                examResult.setReghumid(powerEpsProjConfig.getRegHumId());
                                examResult.setReghumname(powerEpsProjConfig.getRegHumName());
                                examResult.setRegdate(new Date());
                                examResult.setOwnprojid(powerEpsProjConfig.getOwnProjId());
                                examResult.setOwnprojname(powerEpsProjConfig.getOwnProjName());
                                examResult.setEpsprojid(powerEpsProjConfig.getEpsProjId());
                                examResult.setUserCode(userCode);
                                examResult.setStatus("0");
                                examResultDao.save(examResult);
                            }
                        }
                    }
                }else{
                    log.error("【获取考试结果异常信息】userCode={},result={}",userCode,result);
                }
            }
        }
    }
}
