package com.dreamtech.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/book")
@RestController
public class BookingController {

    @RequestMapping("/index")
    public String index()  {
        return "index";
    }

    /**
     * 获取预约日历
     * @return
     */
    @RequestMapping("/getLabList")
    public String getBookingSchedule(String week)  {
        return "index";
    }
}
