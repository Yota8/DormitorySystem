package com.yota8.dormitorysystem.mapper;

import com.yota8.dormitorysystem.bean.Staff;
import com.yota8.dormitorysystem.bean.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

    Student studentLoginById(Long id, String password);

    Staff staffLoginById(Integer id, String password);
}
