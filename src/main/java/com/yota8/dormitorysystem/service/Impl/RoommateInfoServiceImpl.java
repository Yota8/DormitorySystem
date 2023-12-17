package com.yota8.dormitorysystem.service.Impl;

import com.yota8.dormitorysystem.bean.Id;
import com.yota8.dormitorysystem.bean.Student;
import com.yota8.dormitorysystem.mapper.RoommateInfoMapper;
import com.yota8.dormitorysystem.service.RoommateInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoommateInfoServiceImpl implements RoommateInfoService {

    @Autowired
    RoommateInfoMapper roommateInfoMapper;

    @Override
    public List<Student> getRoommateInfo(Id id) {
        return roommateInfoMapper.getRoommateInfo(id.getId());
    }
}
