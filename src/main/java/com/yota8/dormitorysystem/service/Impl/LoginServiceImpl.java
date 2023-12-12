package com.yota8.dormitorysystem.service.Impl;

import com.yota8.dormitorysystem.bean.Result;
import com.yota8.dormitorysystem.bean.Staff;
import com.yota8.dormitorysystem.bean.Student;
import com.yota8.dormitorysystem.mapper.LoginMapper;
import com.yota8.dormitorysystem.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Result studentLogin(Student student) {
        log.info("登录:{}", student);
        Student loginingStudent = loginMapper.studentLoginById(student.getId());
        return loginingStudent != null ? Result.success() : Result.error("用户名或密码错误");
    }

    @Override
    public Result staffLogin(Staff staff) {
        log.info("登录:{}", staff);
        Student loginingStaff = loginMapper.staffLoginById(staff.getId());
        return loginingStaff != null ? Result.success() : Result.error("用户名或密码错误");
    }

}
