package com.yota8.dormitorysystem.service.Impl;

import com.yota8.dormitorysystem.bean.Result;
import com.yota8.dormitorysystem.bean.Student;
import com.yota8.dormitorysystem.mapper.StudentInfoMapper;
import com.yota8.dormitorysystem.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class StudentInfoServiceImpl implements StudentInfoService {

    @Autowired
    StudentInfoMapper studentInfoMapper;

    @Override
    public Result updateStudentInfo(Student student) {

        if (Objects.equals(student.getTelephone(), "")) {
            return new Result(0, "INFO_NO_MESSAGE", null);
        }

        int impactColumn = studentInfoMapper.updateStudentInfo(student.getTelephone(), student.getId());

        if (impactColumn >= 1) {
            return new Result(1, "INFO_SUBMITTED", null);
        } else {
            return new Result(0, "INFO_NOT_SUBMITTED", null);
        }
    }
}
