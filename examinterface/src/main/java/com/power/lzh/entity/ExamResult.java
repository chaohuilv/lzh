package com.power.lzh.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value="ExamResult对象",description="考试成绩对象")
public class ExamResult {

    @Id
    @ApiModelProperty(value="主键")
    private String Id;

    @ApiModelProperty(value="考试主键")
    private Integer examInfoId;
    @ApiModelProperty(value="考试分类名")
    private String examStyleName; //考试分类名
    @ApiModelProperty(value="考试名称")
    private String examName;  //考试名称
    @ApiModelProperty(value="考试开始时间")
    private Date examStartTime; //考试开始时间
    @ApiModelProperty(value="考试结束时间")
    private Date examEndTime;  //考试结束时间

    private String examTimeRestrict;
    @ApiModelProperty(value="考试时长限制（分钟）")
    private Integer examTime; //考试时长限制（分钟）

    private Integer examResultsId;
    @ApiModelProperty(value="分数")
    private Integer results;  //分数
    @ApiModelProperty(value="是否及格")
    private Boolean isPass; //是否及格
    @ApiModelProperty(value="考试链接")
    private String examLink;  //考试链接
    @ApiModelProperty(value="考试结果查询链接")
    private String inquireLink; //考试结果查询链接
    @ApiModelProperty(value="0考试；1作业")
    private Integer practiceMode; //0考试；1作业

    private String status;
    @ApiModelProperty(value="考试状态")
    private String statusExam;//考试状态
    @ApiModelProperty(value="录入人")
    private String reghumname; //录入人
    @ApiModelProperty(value="录入人id")
    private String reghumid; //录入人
    @ApiModelProperty(value="录入人")
    private Date regdate; //录入人
    @ApiModelProperty(value="项目名称")
    private String ownprojname; //项目名称
    @ApiModelProperty(value="项目id")
    private String ownprojid;
    @ApiModelProperty(value="所属项目id")
    private String epsprojid;
    @ApiModelProperty(value="人员code")
    private String userCode;

}
