package com.yota8.dormitorysystem.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String job;         // 职位
    private Long id;            // 学号   这里应该用Long而不用Integer,原因:我们学校的学号比较长
    private String password;    // 密码
    private String name;        // 姓名
    private String telephone;   // 手机号
    private String sex;         // 性别
    private Integer dormId;     // 寝室号
    private String dormBuild;   // 寝室楼
    private String liveStatus;  // 住宿情况,0为校外居住,1为校内居住
    private String recordTimes; // 未归次数
}
