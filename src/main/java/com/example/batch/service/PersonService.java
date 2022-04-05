package com.example.batch.service;

import com.example.batch.bean.Person;

import java.util.List;
import java.util.Map;

public interface PersonService {

    /**
     * 批量新增
     */
    int insertPersonByBatch();

    /**
     * 批量删除
     */
    int deletePersonByBatch();

    /**
     * 批量修改
     */
    int updatePersonByBatch();

}
