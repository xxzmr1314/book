package com.dreamtech.book.service;

import com.dreamtech.book.mapper.LabMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LabService {
    @Autowired
    private LabMapper labMapper;

    /**
     * 获取实验室列表
     * @return
     */
    public List<String> getLabList(){
        return labMapper.getLabList();
    }

    /**
     * 获取某个实验室的学生总人数
     * @param id
     * @return
     */
    public Integer getStuNum(String id){
        return Integer.valueOf(labMapper.getStuNum(id));
    }
}
