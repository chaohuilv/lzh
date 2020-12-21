package com.power.lzh.controller;

import com.power.lzh.config.PowerEpsProjConfig;
import com.power.lzh.entity.Department;
import com.power.lzh.service.impl.DepartmentServiceImpl;
import com.power.lzh.utils.ResultVOUtil;
import com.power.lzh.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dept")
@Api("部门信息API")
public class DepartmentController {

    @Autowired
    private DepartmentServiceImpl departmentService;


    @GetMapping("/list")
    @ApiOperation(value = "部门查询(分页)", notes = "根据更新时间模糊查询部门信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="页码",paramType="query",dataType="Integer",defaultValue="1"),
            @ApiImplicitParam(name="size",value="行数",paramType="query",dataType="Integer",defaultValue="10"),
            @ApiImplicitParam(name="update",value="时间",required=true,paramType="query",dataType="String")
    })
    public ResultVO list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                         @RequestParam(value = "size", defaultValue = "10") Integer size,
                         @Param(value = "update") String update){

        Pageable pageable = PageRequest.of(page-1,size);
        Page<Department> departments = departmentService.findByEpsprojidAndUpdate(update,pageable);
        int total = (int) departments.getTotalElements();
        return ResultVOUtil.success(departments.getContent(),total);
    }
}
