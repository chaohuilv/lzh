package com.power.lzh.service.impl;

import com.power.lzh.config.PowerEpsProjConfig;
import com.power.lzh.entity.Position;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PositionServiceImplTest {

    @Autowired
    private PositionServiceImpl positionService;

    @Autowired
    private PowerEpsProjConfig powerEpsProjConfig;

    @Test
    void fiandAll() {
        Pageable pageable = PageRequest.of(0,10);
        Page<Position> positions = positionService.fiandAll("2020-03-18",pageable);
    }
}