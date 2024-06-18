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
import java.util.List;


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
            return studentInfo;
        } catch (Exception e) {
            log.info("返回staffInfo失败,检查后台");
        }
        return null;
    }


    @PostMapping("/StaffHandleReturn")
    public Result handleReturn(@RequestBody IdList ids) {
        // 判断是否为宿管Id
        if (ids.getId().size() == 1 && 10000 <= ids.getId().get(0) && ids.getId().get(0) <= 99999) {
            return handleReturnService.getDormBuildStudents(ids.getId().get(0));
        } else {
            // 非宿管Id即为待上传的未归学生Id
            return handleReturnService.insertRecord(ids.getId());
        }
    }


    @PostMapping("/StaffHandleRepair")
    public Result finishRepair(@RequestBody IdList ids) {
        // 通过获取宿管Id,得到相应楼栋的报修信息
        if (ids.getId().size() == 1 && ids.getId().get(0) >= 10000){
            return handleRepairService.getRepairInfo(ids.getId().get(0));
        } else {
            return handleRepairService.finishRepair(ids.getId());
        }
    }


    @PostMapping("/StaffInfo")
    public Result updateStaffInfo(@RequestBody InfoRequest infoRequest) {
        return staffInfoService.updateStaffInfo(infoRequest);
    }
}
