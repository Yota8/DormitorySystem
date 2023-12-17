package com.yota8.dormitorysystem.mapper;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentInfoMapper {

    int updateStudentInfo(String telephone, Long id);
}
