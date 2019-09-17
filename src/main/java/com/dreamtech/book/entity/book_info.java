package com.dreamtech.book.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Data
@Entity
public class book_info {
    @Id
    @GeneratedValue
    private Integer id;
    private String course_name;//课程名称
    private String teacher_id;//申请老师id
    private String office; //教研室
    private String equip_need;//所需设备数量
    private String stu_num;//上课学生数量
    private String exp_type;//实验类型
    private String class_info;//上课班级
    private String remark;//备注信息
    private String week;//预约的周数
    private String time;//预约的课时
    private Integer status;//预约的状态  0预约中  1已通过  -1未通过
}
