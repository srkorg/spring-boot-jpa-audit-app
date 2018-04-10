package com.srk.auditapp.service.impl;

import com.srk.auditapp.entity.Employee;
import com.srk.auditapp.model.EmployeeModel;
import com.srk.auditapp.repository.EmployeeRepository;
import com.srk.auditapp.service.AuditService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuditServiceImpl implements AuditService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public EmployeeModel createEmployee(EmployeeModel employeeModel) {
        Employee empMap = modelMapper.map(employeeModel, Employee.class);
        Employee emp = employeeRepository.save(empMap);
        return modelMapper.map(emp, EmployeeModel.class);
    }

    @Override
    public List<EmployeeModel> getEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeModel> employeeModels = employeeList.stream()
                .map(employee -> modelMapper.map(employee, EmployeeModel.class))
                .collect(Collectors.toList());
        return employeeModels;
    }

    @Override
    public EmployeeModel getEmployee(Integer id) {
        return modelMapper.map(employeeRepository.getOne(id), EmployeeModel.class);
    }
}
