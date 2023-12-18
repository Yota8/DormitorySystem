package com.yota8.dormitorysystem.mapper;

import com.yota8.dormitorysystem.bean.Id;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HandleRepairMapper {

    int finishRepair(Id id);
}
