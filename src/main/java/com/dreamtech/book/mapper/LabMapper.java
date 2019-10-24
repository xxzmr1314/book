package com.dreamtech.book.mapper;

import com.dreamtech.book.entity.labInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface LabMapper {
    /**
     * 获取实验室列表
     * @return
     */
    @Select("SELECT * FROM lab_info")
    List<labInfo> getLabList();

    /**
     * 获取某个实验室的试验总人数
     * @param id
     * @return
     */
    @Select("SELECT stu_num FROM lab_info WHERE id = #{id} ")
    int getStuNum(@Param("id")String id);

    /**
     * 增加实验室
     * @param labInfo
     */
    @Insert("INSERT INTO lab_info (name,place,stu_num,equip_name,equip_num,rule) values(#{name},#{place},#{stu_num},#{equip_name},#{equip_num},#{rule})")
    void insertLab(labInfo labInfo);

    /**
     * 删除实验室
     * @param lid
     */
    @Delete("DELETE FROM lab_info WHERE id = #{lid}")
    void deleteLab(@Param("lid")String lid);

    /**
     * 获取实验室信息
     * @param lid
     * @return
     */
    @Select("SELECT * FROM lab_info WHERE id = #{lid}")
    labInfo getLabInfo(@Param("lid")String lid);

    /**
     * 更新实验室信息
     * @param labInfo
     */
    @Update("update lab_info set name = #{name},place = #{place},stu_num = #{stu_num},equip_name = #{equip_name},equip_num = #{equip_num},rule = #{rule} where id = #{id}")
    void updateLab(labInfo labInfo);

}
