package com.power.lzh.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 人员
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="PB_Human")
@ApiModel(value="Human对象",description="人员对象")
public class Human {
    /**主键*/
    @Id
    @ApiModelProperty(value="主键")
    private String id;

    /**人员编号*/
    @ApiModelProperty(value="人员编号")
    private String code;

    /**人员名称*/
    @ApiModelProperty(value="人员名称")
    private String name;

    /**部门id*/
    @ApiModelProperty(value="部门id")
    private String deptid;

    /**部门名称*/
    @ApiModelProperty(value="部门名称")
    private String deptname;

    /**岗位id*/
    @ApiModelProperty(value="岗位id")
    private String posiid;

    /**岗位名称*/
    @ApiModelProperty(value="岗位名称")
    private String posiname;

    /**更新时间*/
    @ApiModelProperty(value="更新时间")
    private String upddate;

    /**手机号码*/
    @ApiModelProperty(value="手机号码")
    private String mobile;

    /**单位*/
    @ApiModelProperty(value="单位")
    private String unit;
    /**单位id*/
    @ApiModelProperty(value="单位id")
    private String unitid;

    /**管理类型 */
    @ApiModelProperty(value="管理类型")
    private String wlcbWorktype;

    /**是否管理员*/
    @ApiModelProperty(value="是否管理员")
    private Boolean isadmin;

    /**工区*/
    @ApiModelProperty(value="工区")
    private String jdShouquanjinru;

    /**工种*/
    @ApiModelProperty(value="工种")
    private String wlcbBusinesstype;

    /**报验状态*/
    @ApiModelProperty(value="报验状态")
    private String wlcbRcbyStatus;

    /**专业*/
    @ApiModelProperty(value="专业")
    private String majorname;
}
