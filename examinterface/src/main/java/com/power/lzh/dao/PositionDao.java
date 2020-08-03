package com.power.lzh.dao;

import com.power.lzh.entity.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionDao extends JpaRepository<Position,String> {

    Page<Position> findAll(Specification specification, Pageable pageable);

}
