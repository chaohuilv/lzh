package com.power.lzh.service.impl;

import com.power.lzh.config.PowerEpsProjConfig;
import com.power.lzh.dao.DepartmentDao;
import com.power.lzh.entity.Department;
import com.power.lzh.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private PowerEpsProjConfig powerEpsProjConfig;

    public Page<Department> findByEpsprojidAndUpdate(String update, Pageable pageable) {
        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                predicate.getExpressions().add(criteriaBuilder.equal(root.get("epsprojid"), powerEpsProjConfig.getEpsProjId()));
                predicate.getExpressions().add(criteriaBuilder.greaterThanOrEqualTo(root.get("upddate").as(String.class), update));
                //predicate.getExpressions().add(criteriaBuilder.lessThanOrEqualTo(root.get("createTime").as(String.class), date));

                return predicate;
            }
        };
        Page<Department> departmentPage = departmentDao.findAll(specification,pageable);
        log.info("【获取部门信息】deptPage={}",departmentPage);
        return departmentPage;
    }

}
