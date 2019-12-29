package com.dreamtech.book.controller;

import com.dreamtech.book.entity.labInfo;
import com.dreamtech.book.entity.roomInfo;
import com.dreamtech.book.service.RoomService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/Rbook")
@RestController
public class RoomController {
    @Autowired
    private RoomService RoomService;
    /**
     * 获取会议室列表
     * @return
     */
    @ApiOperation(value="获取会议室列表", notes="获取会议室列表的字符串数组")
    @GetMapping
    public List<roomInfo> getRoomList()  {
        return RoomService.getRoomList();
    }
}
