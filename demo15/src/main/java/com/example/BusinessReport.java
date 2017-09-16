package com.example;


import java.util.ArrayList;
import java.util.List;

public class BusinessReport {

    List<Staff> mStaffList = new ArrayList<>();

    public BusinessReport() {
        mStaffList.add(new Manager("经理A"));
        mStaffList.add(new Engineer("工程师A"));
        mStaffList.add(new Engineer("工程师B"));
        mStaffList.add(new Engineer("工程师C"));
    }

    // 为访问者展示报表
    public void showReport(Visitor visitor) {
        for (Staff staff : mStaffList) {
            staff.accept(visitor);
        }
    }
}
