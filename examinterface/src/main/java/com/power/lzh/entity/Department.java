package com.power.lzh.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="PB_Department")
@NoArgsConstructor
@Data
@ApiModel(value="Department对象",description="部门对象")
public class Department {
    /**主键*/
    @Id
    @ApiModelProperty(value="主键")
    private String id;

    /**父键*/
    @ApiModelProperty(value="父键")
    private String parentid;

    /**编号*/
    @ApiModelProperty(value="编号")
    private String code;

    /**名称*/
    @ApiModelProperty(value="名称")
    private String name;

    /**长代码*/
    @ApiModelProperty(value="长代码")
    private String longcode;

    /**序号*/
    @ApiModelProperty(value="序号")
    private String sequ;

    /**更新时间*/
    @ApiModelProperty(value="更新时间")
    private String upddate;

    /**项目Id*/
    @ApiModelProperty(value="项目Id")
    private String epsprojid;

    /**公司名称*/
    @ApiModelProperty(value="公司名称")
    private String ownprojname;

}
