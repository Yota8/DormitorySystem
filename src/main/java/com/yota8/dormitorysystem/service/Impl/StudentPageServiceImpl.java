package com.yota8.dormitorysystem.service.Impl;

import com.yota8.dormitorysystem.bean.Id;
import com.yota8.dormitorysystem.bean.Student;
import com.yota8.dormitorysystem.mapper.StudentPageMapper;
import com.yota8.dormitorysystem.service.StudentPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StudentPageServiceImpl implements StudentPageService {

    @Autowired
    StudentPageMapper studentPageMapper;

    @Override
    public Student getStudentInfoById(Id id) {
        Student studentInfo = studentPageMapper.getStudentInfoById(id.getId());
        log.info("studentInfo:{}",studentInfo);
        return studentInfo;
    }
}
