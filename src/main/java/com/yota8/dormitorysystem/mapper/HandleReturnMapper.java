package com.yota8.dormitorysystem.mapper;

import com.yota8.dormitorysystem.bean.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HandleReturnMapper {

    List<Student> getDormBuildStudents(Long id);

    int insertRecord(List<Long> id);
}
