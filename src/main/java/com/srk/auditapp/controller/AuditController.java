package com.srk.auditapp.controller;

import com.srk.auditapp.model.EmployeeModel;
import com.srk.auditapp.repository.EmployeeRepository;
import com.srk.auditapp.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class AuditController {

    @Autowired
    AuditService auditService;

    @PostMapping
    public EmployeeModel createEmployee(@RequestBody EmployeeModel employeeModel) {
        EmployeeModel model = auditService.createEmployee(employeeModel);
        return model;
    }

    @GetMapping
    public List<EmployeeModel> getEmployees() {
        List<EmployeeModel> model = auditService.getEmployees();
        return model;
    }

    @GetMapping("/{id}")
    public EmployeeModel getEmployeeById(@PathVariable Integer id) {
        return auditService.getEmployee(id);
    }
}
