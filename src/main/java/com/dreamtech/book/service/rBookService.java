package com.dreamtech.book.service;

import com.dreamtech.book.entity.RbookInfo;
import com.dreamtech.book.mapper.rBookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class rBookService {
    @Autowired
    private rBookMapper RbookMapper;


    /**
     * 添加预约
     * @param RbookInfo
     */
    public void insertIntoBookInfo(RbookInfo RbookInfo){
        RbookMapper.insertIntoRbookInfo(RbookInfo);
    }

    /**
     * 获得我的预约信息
     * @param tid
     * @return
     */
    public List<RbookInfo> getMyBook(String tid){
        return  RbookMapper.getMyBook(tid);
    }

    /**
     * 撤销预约
     * @param id
     */
    public void deleteBook(String id){
        RbookMapper.deleteBook(id);
    }

    /**
     * 更新预约信息
     * @param RbookInfo
     */
    public void updateBook(RbookInfo RbookInfo){
        RbookMapper.updateMyBook(RbookInfo);
    }

    /**
     * 获得所有预约信息
     * @return
     */
    public List<RbookInfo> getAllInfo(){
        return RbookMapper.getAllInfo();
    }

    /**
     * 更新预约状态
     * @param bid
     * @param status
     */
    public void updateStattus(String bid,Integer status){
        RbookMapper.updateStatus(bid,status);
    }
}
