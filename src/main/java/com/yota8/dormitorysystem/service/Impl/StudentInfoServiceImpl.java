package com.yota8.dormitorysystem.service.Impl;

import com.yota8.dormitorysystem.bean.InfoRequest;
import com.yota8.dormitorysystem.bean.Result;
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
    public Result updateStudentInfo(InfoRequest infoRequest) {

        if (Objects.equals(infoRequest.getTelephone(), "")) {
            return new Result(0, "INFO_NO_MESSAGE", null);
        }

        int impactColumn = studentInfoMapper.updateStudentInfo(infoRequest.getTelephone(), infoRequest.getId());

        if (impactColumn >= 1) {
            return new Result(1, "INFO_SUBMITTED", null);
        } else {
            return new Result(0, "INFO_NOT_SUBMITTED", null);
        }
    }
}
