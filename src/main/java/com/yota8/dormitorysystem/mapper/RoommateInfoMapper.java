package com.yota8.dormitorysystem.mapper;


import com.yota8.dormitorysystem.bean.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoommateInfoMapper {

    List<Student> getRoommateInfo(Long id);
}
