package com.yota8.dormitorysystem.controller;

import com.yota8.dormitorysystem.bean.*;
import com.yota8.dormitorysystem.service.HandleReturnService;
import com.yota8.dormitorysystem.service.StaffInfoService;
import com.yota8.dormitorysystem.service.StaffPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class StaffPageController {

    @Autowired
    private StaffPageService staffPageService;

    @Autowired
    private HandleReturnService handleReturnService;

    @Autowired
    private StaffInfoService staffInfoService;


    @PostMapping("/StaffMainPage")
    public StaffResult getStaffInfoById(@RequestBody Id id) {
        StaffResult studentInfo = staffPageService.getStaffInfoById(id);
        try {
            log.info("staffinfo:" + studentInfo);
            return studentInfo;
        } catch (Exception e) {
            e.printStackTrace();
            log.info("返回staffInfo失败,检查后台");
        }
        return null;
    }


    @PostMapping("/StaffHandleReturn")
    public Result handleReturn(@RequestBody Id id) {
        return handleReturnService.insertRecord(id);
    }


    @PostMapping("/StaffHandleRepair")
    public Result finishRepair(@RequestBody InfoRequest infoRequest) {
        return staffInfoService.updateStaffInfo(infoRequest);
    }


    @PostMapping("/StaffInfo")
    public Result updateStaffInfo(@RequestBody InfoRequest infoRequest) {
        return staffInfoService.updateStaffInfo(infoRequest);
    }
}
