package com.example.batch.controller;

import com.example.batch.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatchController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/insertBatsh")
    private String insertBatsh(){
        int ins = personService.insertPersonByBatch();
        if (ins > 0){
            return "批量插入成功";
        } else {
            return "批量插入失败功";
        }
    }

    @RequestMapping("/deleteBatsh")
    private String deleteBatsh(){
        int ins = personService.deletePersonByBatch();
        if (ins > 0){
            return "批量删除成功";
        } else {
            return "批量删除失败";
        }
    }

    @RequestMapping("/updateBatsh")
    private String updateBatsh(){
        int ins = personService.updatePersonByBatch();
        if (ins > 0){
            return "批量修改成功";
        } else {
            return "批量修改失败";
        }
    }


}
