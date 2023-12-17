package com.yota8.dormitorysystem.service.Impl;

import com.yota8.dormitorysystem.bean.BindBean;
import com.yota8.dormitorysystem.bean.Result;
import com.yota8.dormitorysystem.mapper.BindMapper;
import com.yota8.dormitorysystem.service.BindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BindServiceImpl implements BindService {

    @Autowired
    BindMapper bindMapper;

    @Override
    public Result doBind(BindBean bindBean) {
        if (Objects.equals(bindBean.getTelephone(), "")) {
            return new Result(0, "BIND_NO_MESSAGE", null);
        }

        int impactColumn = bindMapper.doBind(bindBean.getId(), bindBean.getPassword(), bindBean.getTelephone());

        if (impactColumn >= 1) {
            return new Result(1, "BIND_SUBMITTED", null);
        } else {
            return new Result(0, "BIND_NOT_SUBMITTED", null);
        }
    }
}
