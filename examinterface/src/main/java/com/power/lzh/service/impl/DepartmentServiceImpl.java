package com.power.lzh.service.impl;

import com.power.lzh.dao.DepartmentDao;
import com.power.lzh.entity.Department;
import com.power.lzh.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    public Page<Department> findByEpsprojidAndUpdate(String epsprojid, String update, Pageable pageable) {
        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                predicate.getExpressions().add(criteriaBuilder.equal(root.get("epsprojid"), epsprojid));
                predicate.getExpressions().add(criteriaBuilder.greaterThanOrEqualTo(root.get("upddate").as(String.class), update));
                //predicate.getExpressions().add(criteriaBuilder.lessThanOrEqualTo(root.get("createTime").as(String.class), date));

                return predicate;
            }
        };
        Page<Department> departmentPage = departmentDao.findAll(specification,pageable);
        return departmentPage;
    }

}
