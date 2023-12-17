package com.yota8.dormitorysystem.service.Impl;

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
    public Student studentLogin(Student student) {
        log.info("登录:{}",student);
        Student loginingStudent = loginMapper.studentLoginById(student.getId(), student.getPassword());
        log.info("账号信息:{}",loginingStudent);
        return loginingStudent;
    }

    @Override
    public Staff staffLogin(Staff staff) {
        log.info("登录:{}",staff);
        Staff loginingStaff = loginMapper.staffLoginById(staff.getId(), staff.getPassword());
        log.info("账号信息:{}",loginingStaff);
        return loginingStaff;
    }

}
