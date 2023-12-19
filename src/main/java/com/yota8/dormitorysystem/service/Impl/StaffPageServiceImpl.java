package com.yota8.dormitorysystem.service.Impl;

import com.yota8.dormitorysystem.bean.Id;
import com.yota8.dormitorysystem.bean.Result;
import com.yota8.dormitorysystem.bean.Staff;
import com.yota8.dormitorysystem.bean.StaffResult;
import com.yota8.dormitorysystem.mapper.StaffPageMapper;
import com.yota8.dormitorysystem.service.StaffPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StaffPageServiceImpl implements StaffPageService {

    @Autowired
    private StaffPageMapper staffPageMapper;

    @Override
    public Result getStaffInfoById(Id id) {
        Integer population = staffPageMapper.getPopulationById(id.getId());
        Integer livePopulation = staffPageMapper.getLivePopulationById(id.getId());
        Integer pieces = staffPageMapper.getPiecesById(id.getId());
        Staff staffInfo = staffPageMapper.getStaffInfoById(id.getId());
        StaffResult staffResult = new StaffResult(population, livePopulation, pieces, staffInfo);
        return new Result(1, "GET_STAFFINFO_SUCCESS", staffResult);
    }
}
