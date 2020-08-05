package com.power.lzh.entity;

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
public class Position {

    /**主键*/
    @Id
    private String Id;

    /**父键*/
    private String parentid;

    /**编号*/
    private String code;

    /**岗位名称*/
    private String name;

    /**长代码*/
    private String longcode;

    /**部门id*/
    private String deptid;

    /**更新时间*/
    private String upddate;

    /**项目id*/
    private String epsprojid;

    /**公司名称*/
    private String ownprojname;


}
