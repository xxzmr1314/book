package com.dreamtech.book.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * 会议室预约信息
 */
@Data
@Entity
public class RbookInfo {
    @Id
    @GeneratedValue
    private String id;

    @JsonProperty(value = "room_name")
    @Transient
    private String name;//预约的会议室名称

    @JsonProperty(value = "room_id")
    private String room_id;//会议室id

    @JsonProperty(value = "teacher_id")
    private String teacher_id;//申请老师id

    @JsonProperty(value = "number")
    private int number;//预约数量

    @JsonProperty(value = "remark")
    private String remark;//备注信息

    @JsonProperty(value = "time")
    private String time;//预约的课时

    @JsonProperty(value = "book_time")
    private String book_time;//申请预约的时间

    @JsonProperty(value = "status")
    private Integer status;//预约的状态  0预约中  1已通过  -1未通过
}
