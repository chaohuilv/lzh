package com.power.lzh.entity.fromVO;

import lombok.Data;

import java.util.List;

@Data
public class ResultFromVO {

    /**是否成功*/
    private Boolean success;

    /**返回错误码*/
    private Integer code;

    /**返回错误信息*/
    private String desc;

    /**返回错误信息*/
    private String englishDesc;

    private List<ExamResultTotal> bizContent;

}
