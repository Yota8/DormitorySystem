package com.yota8.dormitorysystem.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepairBean {
    Long dormId;
    String detail;
    Integer complete;
    Integer repairId;
}
