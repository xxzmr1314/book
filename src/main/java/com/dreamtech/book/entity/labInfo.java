package com.dreamtech.book.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class labInfo {
    @Id
    @GeneratedValue
    private Integer id;
    @JsonProperty(value = "name")
    private String name;//实验室名称
    @JsonProperty(value = "place")
    private String place;//实验室所在地
    @JsonProperty(value = "stu_num")
    private String stu_num; //可容纳学生量
    @JsonProperty(value = "equip_num")
    private String equip_num;//设备数量
    @JsonProperty(value = "equip_name")
    private String equip_name;//设备名称
    @JsonProperty(value = "rule")
    private String rule;//规章制度
}
