package com.yota8.dormitorysystem.controller;


import com.yota8.dormitorysystem.bean.Dorm;
import com.yota8.dormitorysystem.bean.Id;
import com.yota8.dormitorysystem.bean.Result;
import com.yota8.dormitorysystem.bean.Student;
import com.yota8.dormitorysystem.service.FixService;
import com.yota8.dormitorysystem.service.RoommateInfoService;
import com.yota8.dormitorysystem.service.StudentPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
public class StudentPageController {

    // 首页
    @Autowired
    StudentPageService studentPageService;

    // 我的宿舍(室友信息)
    @Autowired
    RoommateInfoService roommateInfoService;

    // 报修申请
    @Autowired
    FixService fixService;

    // 个人信息修改(有时间就做修改,没时间就直接查询,和第一个合并了)


    // 接收一个id参数,已经进行登录校验后,并且有jwt令牌,直接根据id去查找学生信息
    @PostMapping("/StudentMainPage")
    public Student getStudentInfoById(@RequestBody Id id) {
        Student studentInfo = studentPageService.getStudentInfoById(id);
        try {
            return studentInfo;
        } catch (Exception e) {
            e.printStackTrace();
            log.info("返回studentInfo失败,检查后台");
        }
        return null;
    }


    @PostMapping("/StudentMyDormitory")
    public List<Student> getRoommateInfo(@RequestBody Id id) {
        List<Student> roommateInfo = roommateInfoService.getRoommateInfo(id);
        try {
            log.info(roommateInfo.toString());
            return roommateInfo;
        } catch (Exception e) {
            e.printStackTrace();
            log.info("返回roommateInfo失败,检查后台");
        }
        return null;
    }


    @PostMapping("/StudentFixApplication")
    public Result insertFixApplication(@RequestBody Dorm dorm) {
        return fixService.insertFixApplication(dorm);
    }

}
