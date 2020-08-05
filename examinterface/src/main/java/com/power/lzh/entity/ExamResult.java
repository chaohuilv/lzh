package com.power.lzh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name="WLCB_Examresult")
public class ExamResult {

    @Id
    private String Id;

    private Integer examInfoId;

    private String examStyleName; //考试分类名

    private String examName;  //考试名称

    private Date examStartTime; //考试开始时间

    private Date examEndTime;  //考试结束时间

    private String examTimeRestrict;

    private Integer examTime; //考试时长限制（分钟）

    private Integer examResultsId;

    private Integer results;  //分数

    private Boolean isPass; //是否及格

    private String examLink;  //考试链接

    private String inquireLink; //考试结果查询链接

    private Integer practiceMode; //0考试；1作业

    private String status;

    private String statusExam;//考试状态

    private String reghumname; //录入人

    private String reghumid; //录入人

    private Date regdate; //录入人

    private String ownprojname; //项目名称

    private String ownprojid;

    private String epsprojid;

    private String userCode;

}
