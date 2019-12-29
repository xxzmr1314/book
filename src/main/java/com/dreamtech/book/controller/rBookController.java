package com.dreamtech.book.controller;

import com.dreamtech.book.entity.RbookInfo;
import com.dreamtech.book.entity.Result;
import com.dreamtech.book.entity.bookInfo;
import com.dreamtech.book.service.RoomService;
import com.dreamtech.book.service.rBookService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(value = "/room")
@RestController
public class rBookController {
    @Autowired
    private rBookService rbookService;


    @ApiOperation(value="添加预约", notes="预约实验，把预约信息组成json对象传过来")
    @PostMapping
    public Result addBookInfo(@Valid @RequestBody RbookInfo RbookInfo){
        rbookService.insertIntoBookInfo(RbookInfo);
        return Result.successNoData();
    }

    @ApiOperation(value="获取我的预约信息", notes="根据教师id获取预约信息")
    @ApiImplicitParam(name = "tid", value = "教师的id", required = true, dataType = "String")
    @GetMapping("/{tid}")
    public List<RbookInfo> getMyBook(@PathVariable String tid){
        return rbookService.getMyBook(tid);
    }

    @ApiOperation(value="撤销预约", notes="根据预约id取消当前预约")
    @ApiImplicitParam(name = "bid", value = "预约信息的id", required = true, dataType = "Integer")
    @DeleteMapping("/{bid}")
    public Result DeleteBook(@PathVariable String bid){
        rbookService.deleteBook(bid);
        return Result.successNoData();
    }

    @ApiOperation(value="更新预约", notes="根据预约id更新当前预约信息，并把json对象传过来用于更新")
    @ApiImplicitParam(name = "bid", value = "预约信息的id", required = true, dataType = "Integer")
    @PutMapping("/{bid}")
    public Result UpdateBook(@Valid @RequestBody RbookInfo RbookInfo,@PathVariable Integer bid){
        rbookService.updateBook(RbookInfo);
        return Result.successNoData();
    }
}
