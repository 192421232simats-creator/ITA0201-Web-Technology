package com.support;

public class SupportTicket {

    private String employeeCode;
    private String employeeName;
    private String department;
    private String problemType;
    private String problemDetails;
    private String priorityLevel;

    public SupportTicket(String employeeCode,
                         String employeeName,
                         String department,
                         String problemType,
                         String problemDetails,
                         String priorityLevel) {

        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.department = department;
        this.problemType = problemType;
        this.problemDetails = problemDetails;
        this.priorityLevel = priorityLevel;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getProblemType() {
        return problemType;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }

    public String getProblemDetails() {
        return problemDetails;
    }

    public void setProblemDetails(String problemDetails) {
        this.problemDetails = problemDetails;
    }

    public String getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(String priorityLevel) {
        this.priorityLevel = priorityLevel;
    }
}