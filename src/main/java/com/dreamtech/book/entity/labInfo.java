package com.dreamtech.book.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class labInfo {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;//实验室名称
    private String place;//实验室所在地
    private String stu_num; //可容纳学生量
    private String equip_num;//设备数量
    private String equip_name;//设备名称
    private String rule;//规章制度
}
