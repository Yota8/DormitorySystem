package com.yota8.dormitorysystem.service.Impl;

import com.yota8.dormitorysystem.bean.RepairBean;
import com.yota8.dormitorysystem.bean.Result;
import com.yota8.dormitorysystem.mapper.HandleRepairMapper;
import com.yota8.dormitorysystem.service.HandleRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HandleRepairServiceImpl implements HandleRepairService {

    @Autowired
    HandleRepairMapper handleRepairMapper;


    @Override
    public Result getRepairInfo(Long id) {
        List<RepairBean> repairInfo = handleRepairMapper.getRepairInfo(id);
        return new Result(1,"GET_REPAIRINFO_SUCCESS", repairInfo);
    }

    @Override
    public Result finishRepair(List<Long> repairId) {
        int impactColumn = handleRepairMapper.finishRepair(repairId);

        if (impactColumn >= 1) {
            return new Result(1, "REPAIR_HANDLED", null);
        } else {
            return new Result(0, "REPAIR_NOT_HANDLED", null);
        }
    }
}
