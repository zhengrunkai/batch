package com.example.batch.dao;

import com.example.batch.bean.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PersonDao {

    /**
     * 批量新增
     */
    int insertPersonByBatch(List<Person> list);

    /**
     * 批量删除
     */
    int deletePersonByBatch(List<Integer> list);

    /**
     * 批量修改
     */
    int updatePersonByBatch(List<Person> list);

    /**
     * 批量新增
     */
    List<Person> selectPersonList();
}
