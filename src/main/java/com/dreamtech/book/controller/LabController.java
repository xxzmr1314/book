package com.dreamtech.book.controller;

import com.dreamtech.book.entity.labInfo;
import com.dreamtech.book.service.LabService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/lab")
@RestController
public class LabController {

    @Autowired
    private LabService labService;


    /**
     * 获取实验室列表
     * @return
     */
    @ApiOperation(value="获取实验室列表", notes="获取实验室列表的字符串数组")
    @GetMapping
    public List<labInfo> getLabList()  {
        return labService.getLabList();
    }
}
