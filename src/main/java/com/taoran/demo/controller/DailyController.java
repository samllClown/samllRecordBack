package com.taoran.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taoran.demo.entity.DailyRecord;
import com.taoran.demo.service.IDailyService;
import com.taoran.demo.serviceImpl.DailyService;
import com.taoran.demo.utils.ListUtils;
import com.taoran.demo.utils.PrinWriterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/PhoneDaily")
public class DailyController {

    @Autowired
    private PrinWriterUtils prinWriterUtils;

    @Autowired
    private IDailyService dailyService;

    @PostMapping("/phoneDailyTest")
    @ResponseBody
    public void test(HttpServletRequest request, HttpServletResponse response , @RequestParam("dailyRecord") String dailyRecordJson){

        DailyRecord dailyRecord = new DailyRecord(dailyRecordJson);

        prinWriterUtils.outUserInfo(response,"");

    }

}
