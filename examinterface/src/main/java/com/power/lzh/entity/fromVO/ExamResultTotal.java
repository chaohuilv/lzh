package com.power.lzh.entity.fromVO;

import com.power.lzh.entity.ExamResult;
import lombok.Data;

import java.util.List;

/**
 * 考试结果统计
 */
@Data
public class ExamResultTotal {

    /**总行数*/
    private Integer total;

    /**页码*/
    private Integer current;

    /**每页条数*/
    private Integer rowCount;

    /**（结果）对象*/
    private List<ExamResult> rows;

}
