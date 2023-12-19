package com.yota8.dormitorysystem.service;

import com.yota8.dormitorysystem.bean.Result;

import java.util.List;

public interface HandleRepairService {

    Result getRepairInfo(Long id);
    Result finishRepair(List<Long> id);
}
