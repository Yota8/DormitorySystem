package com.yota8.dormitorysystem.controller;


import com.yota8.dormitorysystem.bean.Result;
import com.yota8.dormitorysystem.bean.Staff;
import com.yota8.dormitorysystem.bean.Student;
import com.yota8.dormitorysystem.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/StudentLogin")
    public Result studentLogin(@RequestBody Student student) {
        Result loginResult = loginService.studentLogin(student);
        return loginResult;
    }

    @PostMapping("/StaffLogin")
    public Result staffLogin(@RequestBody Staff staff) {
        Result loginResult = loginService.staffLogin(staff);
        return loginResult;
    }
}
