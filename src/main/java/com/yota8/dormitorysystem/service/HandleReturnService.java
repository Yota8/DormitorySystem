package com.yota8.dormitorysystem.service;

import com.yota8.dormitorysystem.bean.Result;

import java.util.ArrayList;

public interface HandleReturnService {

    Result getDormBuildStudents(Integer id);

    Result insertRecord(ArrayList<Integer> id);
}
