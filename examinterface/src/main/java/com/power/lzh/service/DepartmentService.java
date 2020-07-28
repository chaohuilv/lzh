package com.power.lzh.service;

import com.power.lzh.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DepartmentService {
    /**根据项目id和更新时间查询部门信息*/
    Page<Department> findByEpsprojidAndUpdate(String epsprojid, String update, Pageable pageable);
}
