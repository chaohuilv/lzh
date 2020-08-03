package com.power.lzh.service.impl;

import com.power.lzh.dao.HumanDao;
import com.power.lzh.entity.Human;
import com.power.lzh.service.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class HumanServiceImpl implements HumanService {

    @Autowired
    private HumanDao humanDao;
    @Override
    public Page<Human> fiandAll(String update, Pageable pageable) {
        Specification specification = new Specification(){
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                predicate.getExpressions().add(criteriaBuilder.greaterThanOrEqualTo(root.get("upddate").as(String.class), update));
                return predicate;
            }
        };
        Page<Human> positionPage = humanDao.findAll(specification,pageable);
        return positionPage;
    }

    /**
     * 根据人员编号查询数据
     * @param code
     * @return
     */
    public Human findAllUserCode(String code){
        Human human = humanDao.findAllByCode(code);
        return human;
    }

    /**
     * 查询所有的人员信息
     * @return
     */
    public List<Human> findAll(){
        List<Human> humanList = humanDao.findAll();
        return humanList;
    }
}
