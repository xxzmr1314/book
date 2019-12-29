package com.dreamtech.book.controller;

import com.dreamtech.book.entity.Result;
import com.dreamtech.book.entity.bookInfo;
import com.dreamtech.book.service.BookService;
import com.dreamtech.book.service.LabService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RequestMapping(value = "/book")
@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private LabService labService;

    @ApiOperation(value="获取预约信息", notes="根据周数获取预约信息")
    @ApiImplicitParam(name = "week", value = "周数", required = true, dataType = "int")
    @GetMapping("/common/{week}")
    public List<bookInfo> getBookInfo(@PathVariable int week){
        List<bookInfo> bookInfos = bookService.getBookInfo(week);
        return bookInfos;
    }



    @ApiOperation(value="添加预约", notes="预约实验，把预约信息组成json对象传过来")
    @PostMapping
    public Result addBookInfo(@Valid @RequestBody bookInfo bookInfo){
            bookService.insertIntoBookInfo(bookInfo);
            return Result.successNoData();
    }

    @ApiOperation(value="获取我的预约信息", notes="根据教师id获取预约信息")
    @ApiImplicitParam(name = "tid", value = "教师的id", required = true, dataType = "String")
    @GetMapping("/{tid}")
    public List<bookInfo> getMyBook(@PathVariable String tid){
        return bookService.getMyBook(tid);
    }

    @ApiOperation(value="撤销预约", notes="根据预约id取消当前预约")
    @ApiImplicitParam(name = "bid", value = "预约信息的id", required = true, dataType = "Integer")
    @DeleteMapping("/{bid}")
    public Result DeleteBook(@PathVariable String bid){
        bookService.deleteBook(bid);
        return Result.successNoData();
    }

    @ApiOperation(value="更新预约", notes="根据预约id更新当前预约信息，并把json对象传过来用于更新")
    @ApiImplicitParam(name = "bid", value = "预约信息的id", required = true, dataType = "Integer")
    @PutMapping("/{bid}")
    public Result UpdateBook(@Valid @RequestBody bookInfo bookInfo,@PathVariable Integer bid){
        int bookedNum=bookService.getBookLabNum(bookInfo.getLab_id());//已经预约的人数
        int needNum=Integer.valueOf(bookInfo.getStu_num());//需要预约的人数
        if (bookInfo.getId().equals(bid)&&bookedNum+needNum<=labService.getStuNum(bookInfo.getLab_id())){
            bookService.updateBook(bookInfo);
            return Result.successNoData();
        }else{
            return Result.error(0,"人数超过啦");
        }
    }
















}
