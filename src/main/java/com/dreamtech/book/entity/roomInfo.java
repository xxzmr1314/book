package com.dreamtech.book.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 会议室信息
 */
@Data
@Entity
public class roomInfo {
    @Id
    @GeneratedValue
    private String id;
    @JsonProperty(value = "name")
    private String name;//会议室名称
    @JsonProperty(value = "place")
    private String place;//会议室所在地
    @JsonProperty(value = "rule")
    private String rule;//规章制度
    @JsonProperty(value = "number")
    private int number;//实验室可容纳人数
}
