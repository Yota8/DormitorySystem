package com.yota8.dormitorysystem.service;

import com.yota8.dormitorysystem.bean.InfoRequest;
import com.yota8.dormitorysystem.bean.Result;

public interface StudentInfoService {
    Result updateStudentInfo(InfoRequest infoRequest);
}
