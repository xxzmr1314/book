package com.dreamtech.book.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class office_list {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;//教研室名称
}
