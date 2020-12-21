package com.power.lzh.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 岗位信息
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="PB_Position")
@ApiModel(value="Position对象",description="部门对象")
public class Position {

    /**主键*/
    @Id
    @ApiModelProperty(value="主键")
    private String Id;

    /**父键*/
    @ApiModelProperty(value="父键")
    private String parentid;

    /**编号*/
    @ApiModelProperty(value="编号")
    private String code;

    /**岗位名称*/
    @ApiModelProperty(value="岗位名称")
    private String name;

    /**长代码*/
    @ApiModelProperty(value="长代码")
    private String longcode;

    /**部门id*/
    @ApiModelProperty(value="部门id")
    private String deptid;

    /**更新时间*/
    @ApiModelProperty(value="更新时间")
    private String upddate;

    /**项目id*/
    @ApiModelProperty(value="项目id")
    private String epsprojid;

    /**公司名称*/
    @ApiModelProperty(value="公司名称")
    private String ownprojname;


}
