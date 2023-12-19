package com.yota8.dormitorysystem.service;

import com.yota8.dormitorysystem.bean.Result;

import java.util.List;

public interface HandleReturnService {

    Result getDormBuildStudents(Long id);

    Result insertRecord(List<Long> id);
}
