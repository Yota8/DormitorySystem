package com.yota8.dormitorysystem.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffResult {
    int population;     // 楼栋学生人数
    int livePopulation; // 住宿学生人数
    int pieces;         // 报修件数
    Staff staffInfo;    // 宿管个人信息
}
