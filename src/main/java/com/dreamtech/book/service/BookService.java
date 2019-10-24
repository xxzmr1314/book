package com.dreamtech.book.service;

import com.dreamtech.book.entity.bookInfo;
import com.dreamtech.book.mapper.BookMapper;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;

    /**
     * 根据星期获取预约信息
     * @param week
     * @return
     */
    public List<bookInfo> getBookInfo(int week){
        return bookMapper.getBookInfo(week);
    }

    /**
     * 添加预约
     * @param bookInfo
     */
    public void insertIntoBookInfo(bookInfo bookInfo){
        bookMapper.insertIntoBookInfo(bookInfo);
    }

    /**
     * 获得我的预约信息
     * @param tid
     * @return
     */
    public List<bookInfo> getMyBook(String tid){
        return  bookMapper.getMyBook(tid);
    }

    /**
     * 撤销预约
     * @param id
     */
    public void deleteBook(String id){
        bookMapper.deleteBook(id);
    }

    /**
     * 更新预约信息
     * @param bookInfo
     */
    public void updateBook(bookInfo bookInfo){
        bookMapper.updateMyBook(bookInfo);
    }

    /**
     * 获取实验室已经预约的人数
     * @param lab_id
     * @return
     */
    public int getBookLabNum(String id){
        return bookMapper.getBookLabNum(id);
    }

    /**
     * 获得所有预约信息
     * @return
     */
    public List<bookInfo> getAllInfo(){
        return bookMapper.getAllInfo();
    }

    /**
     * 更新预约状态
     * @param bid
     * @param status
     */
    public void updateStattus(String bid,Integer status){
        bookMapper.updateStatus(bid,status);
    }
}
