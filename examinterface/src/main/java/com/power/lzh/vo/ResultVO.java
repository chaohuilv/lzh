package com.power.lzh.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@ApiModel(value="ResultVO对象",description="返回响应对象")
public class ResultVO<T> {

    @ApiModelProperty(value = "错误码")
    /** 错误码. */
    private Integer code;

    @ApiModelProperty(value = "提示信息")
    /** 提示信息. */
    private String msg;

    @ApiModelProperty(value = "具体内容")
    /** 具体内容. */
    private T data;

    @ApiModelProperty(value = "总页数")
    /** 总页数*/
    private Integer total;


}
