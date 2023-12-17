package com.yota8.dormitorysystem.service.Impl;


import com.yota8.dormitorysystem.bean.Dorm;
import com.yota8.dormitorysystem.bean.Result;
import com.yota8.dormitorysystem.mapper.FixMapper;
import com.yota8.dormitorysystem.service.FixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class FixServiceImpl implements FixService {

    @Autowired
    FixMapper fixMapper;

    @Override
    public Result insertFixApplication(Dorm dorm) {
        int returnColumn = fixMapper.insertFixApplication(dorm.getDormId(), dorm.getDormBuild(), dorm.getDetail());
        if (Objects.equals(dorm.getDetail(), "")) {
            return new Result(0, "FIX_NO_MESSAGE", null);
        }
        // 返回结果行数大于等于1 说明插入成功
        if (returnColumn >= 1) {
            return new Result(1, "FIX_SUBMITTED", null);
        } else {
            return new Result(0, "FIX_NOT_SUBMITTED", null);
        }
    }
}
