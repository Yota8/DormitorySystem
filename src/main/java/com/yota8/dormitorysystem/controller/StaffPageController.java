package com.yota8.dormitorysystem.controller;

import com.yota8.dormitorysystem.bean.*;
import com.yota8.dormitorysystem.service.HandleRepairService;
import com.yota8.dormitorysystem.service.HandleReturnService;
import com.yota8.dormitorysystem.service.StaffInfoService;
import com.yota8.dormitorysystem.service.StaffPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@Slf4j
@RestController
public class StaffPageController {

    @Autowired
    private StaffPageService staffPageService;

    @Autowired
    private HandleReturnService handleReturnService;

    @Autowired
    private HandleRepairService handleRepairService;

    @Autowired
    private StaffInfoService staffInfoService;


    @PostMapping("/StaffMainPage")
    public Result getStaffInfoById(@RequestBody Id id) {
        Result studentInfo = staffPageService.getStaffInfoById(id);
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
    public Result handleReturn(@RequestBody ArrayList<Integer> id) {
        if (id.size() == 1 && 10000 <= id.get(0) && id.get(0) <= 99999) {
            return handleReturnService.getDormBuildStudents(id.get(0));
        } else {
            return handleReturnService.insertRecord(id);
        }
    }


    @PostMapping("/StaffHandleRepair")
    public Result finishRepair(@RequestBody Id id) {
        return handleRepairService.finishRepair(id);
    }


    @PostMapping("/StaffInfo")
    public Result updateStaffInfo(@RequestBody InfoRequest infoRequest) {
        return staffInfoService.updateStaffInfo(infoRequest);
    }
}
