package com.power.lzh.task;

import com.power.lzh.entity.Human;
import com.power.lzh.service.impl.ExamService;
import com.power.lzh.service.impl.HumanServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 定时任务
 */
@Slf4j
@Component
@EnableScheduling   // 2.开启定时任务
public class ScheduledService {

    @Autowired
    private ExamService examService;

    @Autowired
    private HumanServiceImpl humanService;

    /**
     * 定时获取考试成绩
     */
    @Scheduled(cron = "0 0 1 ? * *")
    public void scheduled(){
        log.info(LocalDateTime.now()+" 【开始】同步考试成绩");
        JSONObject json = new JSONObject();
        //编号为空获取所有
        List<Human> humanList = humanService.findAll();
        for (Human row:humanList) {
            json.put("user_id", row.getCode());
            examService.getList(json.toString(),row.getCode());
        }
        log.info(LocalDateTime.now()+" 【结束】同步考试成绩");
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void configureTasks() {
        //System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
    }
}
