package com.power.lzh.dao;

import com.power.lzh.entity.ExamResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamResultDao extends JpaRepository<ExamResult,String> {

    ExamResult findAllByExamInfoId(Integer examInfoId);

    ExamResult findAllByExamResultsId(Integer examResultsId);
}
