package com.power.lzh.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="PB_Department")
@Data
public class Department {
    /**主键*/
    @Id
    private String id;

    /**父键*/
    private String parentid;

    /**编号*/
    private String code;

    /**名称*/
    private String name;

    /**长代码*/
    private String longcode;

    /**序号*/
    private String sequ;

    /**更新时间*/
    private String upddate;

    /**项目Id*/
    private String epsprojid;

}
