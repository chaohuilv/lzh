package com.power.lzh.dao;

import com.power.lzh.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Date;


public interface DepartmentDao extends JpaRepository<Department,String> {

    /**根据项目id和更新时间查询部门信息*/
    Page<Department> findByAndEpsprojidAndUpddateLessThanEqual(String epsprojid, Date update, Pageable pageable);

    Page<Department> findAll(Specification specification, Pageable pageable);
}
