package com.power.lzh.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(value="考试星Login对象",description="考试星登录对象")
public class Login {
    @ApiModelProperty(value="错误码")
    private String code;
    @ApiModelProperty(value="错误信息")
    private String msg;
    @ApiModelProperty(value="地址")
    private String url;

}
