package com.yota8.dormitorysystem.service;

import com.yota8.dormitorysystem.bean.Id;
import com.yota8.dormitorysystem.bean.Student;

import java.util.List;

public interface RoommateInfoService {
    List<Student> getRoommateInfo(Id id);
}
