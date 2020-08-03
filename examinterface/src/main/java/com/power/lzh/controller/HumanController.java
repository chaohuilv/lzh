package com.power.lzh.controller;


import com.power.lzh.entity.Human;
import com.power.lzh.service.impl.HumanServiceImpl;
import com.power.lzh.utils.ResultVOUtil;
import com.power.lzh.vo.ResultVO;
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
@RequestMapping("/user")
public class HumanController {

    @Autowired
    private HumanServiceImpl humanService;

    @GetMapping("/list")
    public ResultVO list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                         @RequestParam(value = "size", defaultValue = "10") Integer size,
                         @Param(value = "update") String update){

        Pageable pageable = PageRequest.of(page-1,size);
        Page<Human> humanPage =  humanService.fiandAll(update,pageable);
        int total = (int) humanPage.getTotalElements();
        return ResultVOUtil.success(humanPage.getContent(),total);
    }

}
