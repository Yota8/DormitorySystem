package com.yota8.dormitorysystem.service.Impl;

import com.yota8.dormitorysystem.bean.Id;
import com.yota8.dormitorysystem.bean.Result;
import com.yota8.dormitorysystem.mapper.HandleReturnMapper;
import com.yota8.dormitorysystem.service.HandleReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HandleReturnServiceImpl implements HandleReturnService {

    @Autowired
    private HandleReturnMapper handleReturnMapper;

    // 名为insert,实为update,xml文件里就是让student表里对应id的学生未归记录+1(简易实现)
    @Override
    public Result insertRecord(Id id) {

        int impactColumn = handleReturnMapper.insertRecord(id);

        if (impactColumn >= 1) {
            return new Result(1, "RETURN_HANDLED", null);
        } else {
            return new Result(0, "RETURN_NOT_HANDLED", null);
        }
    }
}
