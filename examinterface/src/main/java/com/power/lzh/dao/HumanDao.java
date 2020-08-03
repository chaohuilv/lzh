package com.power.lzh.dao;

import com.power.lzh.entity.Human;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumanDao extends JpaRepository<Human,String> {

    Page<Human> findAll(Specification specification, Pageable pageable);

    Human findAllByCode(String Code);

}
