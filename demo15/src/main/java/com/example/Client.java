package com.example;

public class Client {

    public static void main(String[] args) {
        BusinessReport report = new BusinessReport();

        System.out.println("CEO 可见");
        report.showReport(new CEOVisitor());

        System.out.println("CTO 可见");
        report.showReport(new CTOVisitor());

        // 输出:
        // CEO 可见
        // 经理A kpi = 0
        // 工程师A kpi = 6
        // 工程师B kpi = 2
        // 工程师C kpi = 4
        // CTO 可见
        // 经理A products = 7
        // 工程师A codes = 695
        // 工程师B codes = 537
        // 工程师C codes = 461
    }
}
