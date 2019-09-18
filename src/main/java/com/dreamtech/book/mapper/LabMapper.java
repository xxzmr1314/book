package com.dreamtech.book.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface LabMapper {
    /**
     * 获取实验室列表
     * @return
     */
    @Select("SELECT name FROM lab_info")
    List<String> getLabList();

    /**
     * 获取某个实验室的试验总人数
     * @param id
     * @return
     */
    @Select("SELECT stu_num FROM lab_info WHERE id = #{id} ")
    String getStuNum(@Param("id")String id);


}
