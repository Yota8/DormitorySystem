package com.yota8.dormitorysystem.service.Impl;

import com.yota8.dormitorysystem.bean.Id;
import com.yota8.dormitorysystem.bean.Result;
import com.yota8.dormitorysystem.mapper.HandleRepairMapper;
import com.yota8.dormitorysystem.service.HandleRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HandleRepairServiceImpl implements HandleRepairService {

    @Autowired
    HandleRepairMapper handleRepairMapper;

    @Override
    public Result finishRepair(Id id) {
        int impactColumn = handleRepairMapper.finishRepair(id);

        if (impactColumn >= 1) {
            return new Result(1, "REPAIR_HANDLED", null);
        } else {
            return new Result(0, "REPAIR_NOT_HANDLED", null);
        }
    }
}
