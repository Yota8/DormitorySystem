//package com.yota8.dormitorysystem.controller;
//
//
//import com.yota8.dormitorysystem.bean.BindBean;
//import com.yota8.dormitorysystem.bean.Result;
//import com.yota8.dormitorysystem.service.BindService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class BindController {
//
//    @Autowired
//    private BindService bindService;
//
//    @PostMapping("/Bind")
//    public Result doBind(@RequestBody BindBean bindBean) {
//        return bindService.doBind(bindBean);
//    }
//
//}
