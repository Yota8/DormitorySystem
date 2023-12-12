package com.yota8.dormitorysystem.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String job;         // 职位
    private Integer id;         // 学号
    private String password;    // 密码
    private String name;        // 姓名
    private String telephone;   // 手机号
    private String sex;         // 性别
    private Integer dormId;      // 寝室号
    private String dormBuild;   // 寝室楼
}
