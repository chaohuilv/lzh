package com.power.lzh.service.impl;

import com.power.lzh.entity.Human;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HumanServiceImplTest {

    @Autowired
    private HumanServiceImpl humanService;

    @Test
    void fiandAll() {
        Pageable pageable = PageRequest.of(1,10);
        Page<Human> page = humanService.fiandAll("2019-01-01",pageable);
    }

    @Test
    void fiandByAll(){
        List<Human> humanList = humanService.findAll();
        System.out.println(humanList);
    }
}