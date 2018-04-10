package com.srk.auditapp.service;

import com.srk.auditapp.model.EmployeeModel;

import java.util.List;

public interface AuditService {

    EmployeeModel createEmployee(EmployeeModel employeeModel);

    List<EmployeeModel> getEmployees();

    EmployeeModel getEmployee(Integer id);
}
