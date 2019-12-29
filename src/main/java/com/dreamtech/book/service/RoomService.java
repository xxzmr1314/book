package com.dreamtech.book.service;
import com.dreamtech.book.entity.roomInfo;
import com.dreamtech.book.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomMapper RoomMapper;

    /**
     * 获取会议室列表
     * @return
     */
    public List<roomInfo> getRoomList(){
        return RoomMapper.getRoomList();
    }

    /**
     * 获取某个实验室的学生总人数
     * @param id
     * @return
     *//*
    public int getStuNum(String id){
        return roomMapper.getStuNum(id);
    }*/

    /**
     * 添加会议室
     * @param roomInfo
     */
    public void insertroom(roomInfo roomInfo){
        RoomMapper.insertRoom(roomInfo);
    }

    /**
     * 删除会议室
     * @param rid
     */
    public void deleteroom(String rid){
        RoomMapper.deleteRoom(rid);
    }

    /**
     * 获取会议室信息
     * @param rid
     * @return
     */
    public roomInfo getroomInfo(String rid){
        return RoomMapper.getRoomInfo(rid);
    }

    /**
     * 更新会议室信息
     * @param roomInfo
     */
    public void updateRoom(roomInfo roomInfo){
        RoomMapper.updateRoom(roomInfo);
    }
}
