package com.power.lzh.service.impl;

import com.power.lzh.config.PowerEpsProjConfig;
import com.power.lzh.dao.PositionDao;
import com.power.lzh.entity.Position;
import com.power.lzh.service.PositionService;
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
import java.time.LocalDateTime;

@Service
@Slf4j
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionDao positionDao;

    @Autowired
    private PowerEpsProjConfig powerEpsProjConfig;

    @Override
    public Page<Position> fiandAll(String update, Pageable pageable) {

        Specification specification = new Specification(){
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                predicate.getExpressions().add(criteriaBuilder.equal(root.get("epsprojid"), powerEpsProjConfig.getEpsProjId()));
                predicate.getExpressions().add(criteriaBuilder.greaterThanOrEqualTo(root.get("upddate").as(String.class), update));
                return predicate;
            }
        };
        Page<Position> positionPage = positionDao.findAll(specification,pageable);
        log.info(LocalDateTime.now()+" 【获取岗位信息】positionPage={}",positionPage);
        return positionPage;
    }
}
