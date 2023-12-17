package com.yota8.dormitorysystem.mapper;

import com.yota8.dormitorysystem.bean.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentPageMapper {

    Student getStudentInfoById(Long id);
}
