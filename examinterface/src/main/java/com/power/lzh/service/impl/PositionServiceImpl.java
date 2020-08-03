package com.power.lzh.service.impl;

import com.power.lzh.dao.PositionDao;
import com.power.lzh.entity.Position;
import com.power.lzh.service.PositionService;
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
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionDao positionDao;

    @Override
    public Page<Position> fiandAll(String epsprojid, String update, Pageable pageable) {

        Specification specification = new Specification(){
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                predicate.getExpressions().add(criteriaBuilder.equal(root.get("epsprojid"), epsprojid));
                predicate.getExpressions().add(criteriaBuilder.greaterThanOrEqualTo(root.get("upddate").as(String.class), update));
                return predicate;
            }
        };
        Page<Position> positionPage = positionDao.findAll(specification,pageable);
        return positionPage;
    }
}
