package com.yota8.dormitorysystem.service;

import com.yota8.dormitorysystem.bean.Result;
import com.yota8.dormitorysystem.bean.Staff;
import com.yota8.dormitorysystem.bean.Student;

public interface LoginService {

    Result studentLogin(Student student);

    Result staffLogin(Staff staff);
}
