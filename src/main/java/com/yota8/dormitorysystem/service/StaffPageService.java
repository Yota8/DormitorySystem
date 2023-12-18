package com.yota8.dormitorysystem.service;

import com.yota8.dormitorysystem.bean.Id;
import com.yota8.dormitorysystem.bean.StaffResult;

public interface StaffPageService {

    StaffResult getStaffInfoById(Id id);
}
