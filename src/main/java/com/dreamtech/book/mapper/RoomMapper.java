package com.dreamtech.book.mapper;

import com.dreamtech.book.entity.labInfo;
import com.dreamtech.book.entity.roomInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoomMapper {
    /**
     * 获取会议室列表
     * @return
     */
    @Select("SELECT * FROM room_info")
    List<roomInfo> getRoomList();

    /**
     * 增加会议室
     * @param roomInfo
     */
    @Insert("INSERT INTO room_info (name,number,place,rule) values(#{name},#{number},#{place},#{rule})")
    void insertRoom(roomInfo roomInfo);

    /**
     * 删除会议室
     * @param rid
     */
    @Delete("DELETE FROM room_info WHERE id = #{rid}")
    void deleteRoom(@Param("rid")String rid);

    /**
     * 获取会议室信息
     * @param rid
     * @return
     */
    @Select("SELECT * FROM room_info WHERE id = #{rid}")
    roomInfo getRoomInfo(@Param("rid")String rid);

    /**
     * 更新实验室信息
     * @param roomInfo
     */
    @Update("update lab_info set name = #{name},number = #{number},place = #{place},rule = #{rule} where id = #{id}")
    void updateRoom(roomInfo roomInfo);
}
