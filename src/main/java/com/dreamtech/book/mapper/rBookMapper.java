package com.dreamtech.book.mapper;

import com.dreamtech.book.entity.RbookInfo;
import com.dreamtech.book.entity.bookInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface rBookMapper {

    /**
     * 预约实验
     * @param RbookInfo
     */
    @Insert("INSERT INTO rbook_info (book_time,number,remark,room_id,status,teacher_id,time)values(#{book_time},#{number},#{remark},#{room_id},#{status},#{teacher_id},#{time})")
    void insertIntoRbookInfo(RbookInfo RbookInfo);

    /**
     * 获取我的预约
     * @param tid
     * @return
     */
    @Select("select a.*,b.name from rbook_info as a,room_info as b where a.teacher_id = #{teacher_id} AND b.id = a.room_id ")
    List<RbookInfo> getMyBook(@Param("teacher_id")String tid);

    /**
     * 更新预约信息
     * @param RbookInfo
     */
    @Update("update rbook_info set number = #{number},remark = #{remark},teacher_id = #{teacher_id},time = #{time},book_time = #{book_time},room_id = #{room_id}  where id = #{id}")
    void updateMyBook(RbookInfo RbookInfo);


    /**
     * 撤销某个预约
     * @param id
     */
    @Delete("DELETE FROM rbook_info WHERE id = #{id} ")
    void deleteBook(@Param("id")String id);




    /**
     * 获取所有预约信息
     * @return
     */
    @Select("select * from rbook_info")
    List<RbookInfo> getAllInfo();


    /**
     * 更新预约状态
     * @param bid
     * @param status
     */
    @Update("UPDATE rbook_info SET status = #{status} WHERE id = #{bid}")
    void updateStatus(@Param("bid")String bid,@Param("status")Integer status);

}
