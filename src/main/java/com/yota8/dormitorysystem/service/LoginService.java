package com.yota8.dormitorysystem.service;

import com.yota8.dormitorysystem.bean.Staff;
import com.yota8.dormitorysystem.bean.Student;

public interface LoginService {

    Student studentLogin(Student student);
    Staff staffLogin(Staff staff);
}
