package com.yota8.dormitorysystem.service.Impl;


import com.yota8.dormitorysystem.bean.InfoRequest;
import com.yota8.dormitorysystem.bean.Result;
import com.yota8.dormitorysystem.mapper.StaffInfoMapper;
import com.yota8.dormitorysystem.service.StaffInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class StaffInfoServiceImpl implements StaffInfoService {

    @Autowired
    StaffInfoMapper staffInfoMapper;

    @Override
    public Result updateStaffInfo(InfoRequest infoRequest) {
        if (Objects.equals(infoRequest.getTelephone(), "")) {
            return new Result(0, "INFO_NO_MESSAGE", null);
        }

        int impactColumn = staffInfoMapper.updateStaffInfo(infoRequest.getTelephone(), infoRequest.getId());

        if (impactColumn >= 1) {
            return new Result(1, "INFO_SUBMITTED", null);
        } else {
            return new Result(0, "INFO_NOT_SUBMITTED", null);
        }
    }
}
