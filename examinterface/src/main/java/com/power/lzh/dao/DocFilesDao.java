package com.power.lzh.dao;

import com.power.lzh.entity.DocFiles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DocFilesDao extends JpaRepository<DocFiles,String> {

    Optional<DocFiles> findById(String id);

}
