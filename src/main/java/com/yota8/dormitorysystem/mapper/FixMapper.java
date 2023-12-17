package com.yota8.dormitorysystem.mapper;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FixMapper {
    int insertFixApplication(String dormId, String dormBuild, String detail);
}
