package com.dreamtech.book.service;

import com.dreamtech.book.entity.labInfo;
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

    /**
     * 添加实验室
     * @param labInfo
     */
    public void insertLab(labInfo labInfo){
        labMapper.insertLab(labInfo);
    }

    /**
     * 删除实验室
     * @param lid
     */
    public void deleteLab(Integer lid){
        labMapper.deleteLab(lid);
    }

    /**
     * 获取实验室信息
     * @param lid
     * @return
     */
    public labInfo getLabInfo(Integer lid){
        return labMapper.getLabInfo(lid);
    }

    /**
     * 更新实验室信息
     * @param labInfo
     */
    public void updateLab(labInfo labInfo){
        labMapper.updateLab(labInfo);
    }
}
