package com.power.lzh.service.impl;

import com.power.lzh.entity.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceImplTest {

    @Autowired
    private DepartmentServiceImpl departmentService;

    @Test
    void findByEpsprojidAndUpdate() {

        Pageable pageable = PageRequest.of(1,10);
        Page<Department> departments = departmentService.findByEpsprojidAndUpdate("00000000-0000-0000-0000-0000000000a4","2020-05-11",pageable);
        System.out.println(departments);
    }
}