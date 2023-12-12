package com.yota8.dormitorysystem.mapper;

import com.yota8.dormitorysystem.bean.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

    Student studentLoginById(Integer id);

    Student staffLoginById(Integer id);
}
