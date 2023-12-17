package com.yota8.dormitorysystem.controller;


import com.yota8.dormitorysystem.bean.Result;
import com.yota8.dormitorysystem.bean.Staff;
import com.yota8.dormitorysystem.bean.Student;
import com.yota8.dormitorysystem.service.LoginService;
import com.yota8.dormitorysystem.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/StudentLogin")
    public Result studentLogin(@RequestBody Student student) {
        Student loginResult = loginService.studentLogin(student);

        // 登录成功,生成并下发令牌
        if (loginResult != null) {
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",loginResult.getId());
            claims.put("name",loginResult.getName());
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }

        return Result.error("用户名或密码错误");
    }

    @PostMapping("/StaffLogin")
    public Result staffLogin(@RequestBody Staff staff) {
        Staff loginResult = loginService.staffLogin(staff);

        // 登录成功,生成并下发令牌
        if (loginResult != null) {
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",loginResult.getId());
            claims.put("name",loginResult.getName());
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }

        return Result.error("用户名或密码错误");
    }
}
