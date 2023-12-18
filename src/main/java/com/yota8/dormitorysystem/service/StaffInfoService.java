package com.yota8.dormitorysystem.service;

import com.yota8.dormitorysystem.bean.InfoRequest;
import com.yota8.dormitorysystem.bean.Result;
import com.yota8.dormitorysystem.bean.Staff;

public interface StaffInfoService {

    Result updateStaffInfo(InfoRequest infoRequest);
}
