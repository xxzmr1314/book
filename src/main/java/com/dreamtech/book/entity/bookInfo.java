package com.dreamtech.book.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Data
@Entity
public class bookInfo {
    @Id
    @GeneratedValue
    private String id;
    private String name;//预约的实验室名称
    @JsonProperty(value = "lab_id")
    private String lab_id;//实验室id
    @JsonProperty(value = "course_name")
    private String course_name;//课程名称
    @JsonProperty(value = "teacher_id")
    private String teacher_id;//申请老师id
    @JsonProperty(value = "office")
    private String office; //教研室
    @JsonProperty(value = "equip_need")
    private int equip_need;//所需设备数量
    @JsonProperty(value = "stu_num")
    private int stu_num;//上课学生数量
    @JsonProperty(value = "exp_type")
    private String exp_type;//实验类型
    @JsonProperty(value = "class_info")
    private String class_info;//上课班级
    @JsonProperty(value = "remark")
    private String remark;//备注信息
    @JsonProperty(value = "week")
    private int week;//预约的周数
    @JsonProperty(value = "time")
    private String time;//预约的课时
    @JsonProperty(value = "book_time")
    private String book_time;//申请预约的时间

    private int remainNum;//剩余实验学生数量
    private Integer status;//预约的状态  0预约中  1已通过  -1未通过
}
