package com.power.lzh.service;

import com.power.lzh.entity.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PositionService {
    Page<Position> fiandAll(String epsprojid, String update, Pageable pageable);
}
