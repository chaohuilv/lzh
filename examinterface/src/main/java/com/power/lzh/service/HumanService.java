package com.power.lzh.service;

import com.power.lzh.entity.Human;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HumanService {
    Page<Human> fiandAll(String update, Pageable pageable);
}
