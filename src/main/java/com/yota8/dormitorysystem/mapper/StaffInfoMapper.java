package com.yota8.dormitorysystem.mapper;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StaffInfoMapper {
    int updateStaffInfo(String telephone, Long id);
}
