package com.yota8.dormitorysystem.service;

import com.yota8.dormitorysystem.bean.Id;
import com.yota8.dormitorysystem.bean.Student;

public interface StudentPageService {
    Student getStudentInfoById(Id id);
}
