package com.power.lzh.service.impl;

import com.power.lzh.dao.DocFilesDao;
import com.power.lzh.entity.Department;
import com.power.lzh.entity.DocFiles;
import com.power.lzh.service.DocFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocFilesServiceImpl implements DocFilesService {

    @Autowired
    private DocFilesDao docFilesDao;

    @Override
    public DocFiles findById(String id) {
        Optional<DocFiles> docFilesDaoById = docFilesDao.findById(id);
        return docFilesDaoById.get();
    }
}
