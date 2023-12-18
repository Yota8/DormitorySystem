package com.yota8.dormitorysystem.mapper;


import com.yota8.dormitorysystem.bean.Staff;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StaffPageMapper {

    Integer getPopulationById(Long id);

    Integer getLivePopulationById(Long id);

    Integer getPiecesById(Long id);

    Staff getStaffInfoById(Long id);
}
