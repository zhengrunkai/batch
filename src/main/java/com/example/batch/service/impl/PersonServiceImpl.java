package com.example.batch.service.impl;

import com.example.batch.bean.Person;
import com.example.batch.service.PersonService;
import com.example.batch.dao.PersonDao;
import com.sun.org.apache.xalan.internal.lib.ExsltSets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public int insertPersonByBatch() {
        List<Person> list = new ArrayList<>();
        Person person1 = new Person();
        person1.setId(1);
        person1.setName("老大");
        person1.setMoney(10000L);
        list.add(person1);
        Person person2 = new Person();
        person2.setId(2);
        person2.setName("老二");
        person2.setMoney(20000L);
        list.add(person2);
        Person person3 = new Person();
        person3.setId(3);
        person3.setName("老三");
        person3.setMoney(30000L);
        list.add(person3);
        return personDao.insertPersonByBatch(list);
    }

    @Override
    public int deletePersonByBatch() {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        return personDao.deletePersonByBatch(ids);
    }

    /**
     * 测试数据
     * id   name    money
     * 1    老大     10000
     * 2    老二     20000
     * 3    老三     30000
     */

    /**
     * 这是简单的对比，取 id 主键作为唯一标识，只修改存在的 id，不符合实际
     */
//    @Override
//    public int updatePersonByBatch() {
//        newPersonList();
//        return personDao.updatePersonByBatch(list);
//    }


    /**
     * 通取 id 主键作为唯一标识，筛选出增加、修改、删除的数据
     */
//    @Transactional
//    @Override
//    public int updatePersonByBatch() {
//
//        // 用来存放增删改数据
//        List<Person> addList = new ArrayList<>();
//        List<Person> updateList = new ArrayList<>();
//        List<Integer> deleteList = new ArrayList<>();
//
//        // 数据库旧数据
//        List<Person> oldList = personDao.selectPersonList();
//        Map<Integer, Person> oldPersonMap = new HashMap<>();
//        for (Person person : oldList){
//            oldPersonMap.put(person.getId(), person);
//        }
//        新数据
//        List<Person> newList = newPersonList();
//        for (Person person : newList){
//            // 存在则修改
//            if (oldPersonMap.containsKey(person.getId())){
//                updateList.add(person);
//                oldPersonMap.remove(person.getId());
//                // 不存在则新增
//            } else {
//                addList.add(person);
//            }
//        }
//        // 剩余的则删除
//        if (oldPersonMap != null){
//            for (Map.Entry<Integer, Person> entry : oldPersonMap.entrySet()) {
//                deleteList.add(entry.getKey());
//            }
//        }
//        personDao.insertPersonByBatch(addList);
//        personDao.updatePersonByBatch(updateList);
//        personDao.deletePersonByBatch(deleteList);
//        return 1;
//    }
    @Transactional
    @Override
    public int updatePersonByBatch() {
        // 用来存放增删改数据
        List<Person> addList = new ArrayList<>();
        List<Person> updateList = new ArrayList<>();
        List<Integer> deleteList = new ArrayList<>();
        // 数据库旧数据
        List<Person> oldList = personDao.selectPersonList();
        Set<Person> oldSet = new HashSet<>(oldList);
        // 新数据
        List<Person> newList = newPersonList();
        // 取交集
        Set<Person> intersectionSet = new HashSet<>(newList);
        intersectionSet.retainAll(oldSet);
        // 在新不在旧
        Set<Person> newIntersectionSet = new HashSet<>(newList);
        newIntersectionSet.removeAll(intersectionSet);
        // 在旧不在新
        Set<Person> oldIntersectionSet = new HashSet<>(oldList);
        oldIntersectionSet.removeAll(intersectionSet);
List<Person> oldIntersectionList = new ArrayList<>(oldIntersectionSet);
HashSet<Person> updateSet = new HashSet<>();
for (Person newPerson : newIntersectionSet){
    oldIntersectionSet.removeAll(intersectionSet);
    for (Person oldPerson : oldIntersectionSet){
        // 重新 equal 方法，比较 name 和 money 属性
        if (newPerson.getId().equals(oldPerson.getId()) && !newPerson.equals(oldPerson)){
            updateList.add(newPerson);
            updateSet.add(newPerson);
            oldIntersectionList.remove(oldPerson);
        }
    }
}
Set<Person> addSet = new HashSet<>(newIntersectionSet);
addSet.removeAll(updateSet);
addList.addAll(addSet);
for (Person person : oldIntersectionList){
    deleteList.add(person.getId());
}
        personDao.insertPersonByBatch(addList);
        personDao.updatePersonByBatch(updateList);
        personDao.deletePersonByBatch(deleteList);
        return 1;
    }


    /**
     * 作为新增的假数据
     */
    private List<Person> newPersonList(){
        List<Person> list = new ArrayList<>();
        Person person1 = new Person();
        person1.setId(1);
        person1.setName("老大");
        person1.setMoney(10000L);
        list.add(person1);
        Person person2 = new Person();
        person2.setId(2);
        person2.setName("老二");
        person2.setMoney(22222L);
        list.add(person2);
        Person person3 = new Person();
        person3.setId(4);
        person3.setName("老四");
        person3.setMoney(40000L);
        list.add(person3);
        return list;
    }
}
