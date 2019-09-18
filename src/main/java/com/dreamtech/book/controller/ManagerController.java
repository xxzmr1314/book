package com.dreamtech.book.controller;

import com.dreamtech.book.entity.Result;
import com.dreamtech.book.entity.bookInfo;
import com.dreamtech.book.entity.labInfo;
import com.dreamtech.book.service.BookService;
import com.dreamtech.book.service.LabService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 管理员专用
 */
@RequestMapping(value = "/manager")
@RestController
public class ManagerController {
    @Autowired
    private BookService bookService;
    @Autowired
    private LabService labService;


    @ApiOperation(value="获取所有预约信息", notes="获取预约信息")
    @GetMapping("/book/all")
    public List<bookInfo> getAllInfo(){
        return bookService.getAllInfo();
    }


    @ApiOperation(value="更新预约的状态", notes="更新预约状态，分别为通过，不通过，待定")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bid", value = "预约的id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "status", value = "需要变更成的状态", required = true, dataType = "Integer")
    })
    @PostMapping("/book/{bid}/{status}")
    public Result UpdateStatus(@PathVariable Integer bid,@PathVariable Integer status){
        bookService.updateStattus(bid, status);
        return Result.successNoData();
    }

    @ApiOperation(value="撤销预约", notes="根据预约id取消当前预约")
    @ApiImplicitParam(name = "bid", value = "预约信息的id", required = true, dataType = "Integer")
    @DeleteMapping("/book/{bid}")
    public Result DeleteBook(@PathVariable Integer bid){
        bookService.deleteBook(bid);
        return Result.successNoData();
    }


    @ApiOperation(value="添加实验室", notes="根据传过来的json字符串添加实验室")
    @PostMapping("/lab")
    public Result InsertLab(@Valid @RequestBody labInfo labInfo){
        labService.insertLab(labInfo);
        return Result.successNoData();
    }

    @ApiOperation(value="删除实验室", notes="根据传过来的实验室id删除实验室")
    @DeleteMapping("/lab/{lid}")
    public Result DeleteLab(@PathVariable Integer lid){
        labService.deleteLab(lid);
        return Result.successNoData();
    }

    @ApiOperation(value="获取实验室信息", notes="获取实验室的详细信息")
    @GetMapping("/lab/{lid}")
    public labInfo GetLabInfo(@PathVariable Integer lid){
        return labService.getLabInfo(lid);
    }


    @ApiOperation(value="更新实验室", notes="根据传过来的json字符串更新实验室信息")
    @PutMapping("/lab")
    public Result UpdateLab(@Valid @RequestBody labInfo labInfo){
        labService.updateLab(labInfo);
        return Result.successNoData();

    }









}
