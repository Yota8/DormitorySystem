package com.yota8.dormitorysystem.mapper;

import com.yota8.dormitorysystem.bean.RepairBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HandleRepairMapper {

    List<RepairBean> getRepairInfo(Long id);

    int finishRepair(List<Long> repairId);
}
