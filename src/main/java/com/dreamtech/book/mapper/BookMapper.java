package com.dreamtech.book.mapper;

import com.dreamtech.book.entity.bookInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface BookMapper {
    /**
     * 获取某个星期内的预约情况
     * @param week
     * @return
     */
    @Select("SELECT a.*,b.name FROM book_info as a,lab_info as b where a.week = #{week} AND a.STATUS = 1 AND b.id = a.lab_id")
    List<bookInfo> getBookInfo(@Param("week")int week);

    /**
     * 预约实验
     * @param bookInfo
     */
    @Insert("INSERT INTO book_info (lab_id,class_info,course_name,equip_need,exp_type,office,remark,stu_num,teacher_id,time,week,book_time)values(#{lab_id},#{class_info}, #{course_name}, #{equip_need},#{exp_type}, #{office}, #{remark}, #{stu_num}, #{teacher_id},#{time}, #{week}, #{book_time})")
    void insertIntoBookInfo(bookInfo bookInfo);

    /**
     * 获取我的预约
     * @param tid
     * @return
     */
    @Select("select a.*,b.name from book_info as a,lab_info as b where a.teacher_id = #{teacher_id} AND b.id = a.lab_id ")
    List<bookInfo> getMyBook(@Param("teacher_id")String tid);

    /**
     * 更新预约信息
     * @param bookInfo
     */
    @Update("update book_info set name = #{name},lab_id = #{lab_id},class_info = #{class_info},course_name = #{course_name},equip_need = #{equip_need},exp_type = #{exp_type},office = #{office},remark = #{remark},stu_num = #{stu_num},teacher_id = #{teacher_id},time = #{time},week = #{week},book_time = #{book_time}  where id = #{id}")
    void updateMyBook(bookInfo bookInfo);


    /**
     * 撤销某个预约
     * @param id
     */
    @Delete("DELETE FROM book_info WHERE id = #{id} ")
    void deleteBook(@Param("id")String id);

    /**
     * 获取某个实验室已经预约的人数
     * @param id
     * @return
     */
    @Select("SELECT sum(stu_num) FROM  book_info WHERE id =#{id} and status = 1 ")
    Integer getBookLabNum(@Param("lab_id")String id);


    /**
     * 获取所有预约信息
     * @return
     */
    @Select("SELECT a.*,b.name,(SELECT b.stu_num-COALESCE(SUM(c.stu_num),0) from book_info as c  where c.status=1 and c.lab_id = b.id and c.book_time = a.book_time ) as remainStuNum FROM book_info as a,lab_info as b where b.id = a.lab_id ")
    List<bookInfo> getAllInfo();


    /**
     * 更新预约状态
     * @param bid
     * @param status
     */
    @Update("UPDATE book_info SET status = #{status} WHERE id = #{bid}")
    void updateStatus(@Param("bid")String bid,@Param("status")Integer status);









}
