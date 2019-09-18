package com.dreamtech.book.controller;

import com.dreamtech.book.entity.Result;
import com.dreamtech.book.entity.bookInfo;
import com.dreamtech.book.service.BookService;
import com.dreamtech.book.service.LabService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
    @ApiImplicitParam(name = "week", value = "周数", required = true, dataType = "String")
    @GetMapping("/common/{week}")
    public List<bookInfo> getBookInfo(@PathVariable String week){
        return bookService.getBookInfo(week);
    }



    @ApiOperation(value="添加预约", notes="预约实验，把预约信息组成json对象传过来")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "lab_id", value = "实验室的id", required = true, dataType = "String"),
            @ApiImplicitParam(name = "stu_num", value = "当前时段实验室已经预约的人数", required = true, dataType = "String")
    })
    @PostMapping("/{lab_id}/{stu_num}")
    public Result addBookInfo(@PathVariable String lab_id,@PathVariable String stu_num,@Valid @RequestBody bookInfo bookInfo){
        Integer lab_stu_num=labService.getStuNum(lab_id);
        if(Integer.valueOf(bookInfo.getStu_num())+Integer.valueOf(stu_num)>lab_stu_num){
            return Result.error(0,"超过实验室可容纳人数啦");
        }
        else {
            bookService.insertIntoBookInfo(bookInfo);
            return Result.successNoData();
        }
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
    public Result DeleteBook(@PathVariable Integer bid){
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
