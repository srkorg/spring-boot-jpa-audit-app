package com.srk.auditapp.controller;

import com.srk.auditapp.entity.Employee;
import com.srk.auditapp.model.EmployeeModel;
import com.srk.auditapp.repository.EmployeeRepository;
import com.srk.auditapp.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PutMapping("/{id}")
    public EmployeeModel updateEmployee(@RequestBody EmployeeModel employeeModel, @PathVariable Integer id) {
        EmployeeModel model = auditService.updateEmployee(employeeModel, id);
        if (model != null)
            return model;
        return null;
    }

    @DeleteMapping("/{id}")
    public EmployeeModel deleteEmployee(@PathVariable Integer id) {
        EmployeeModel model = auditService.deleteEmployee(id);
        if (model != null)
            return model;
        return null;
    }
}
