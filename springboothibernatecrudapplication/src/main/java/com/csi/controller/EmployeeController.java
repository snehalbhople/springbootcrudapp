package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeServiceImpl;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Employee employee){
        employeeServiceImpl.save(employee);
        return  ResponseEntity.ok("Data Saved Successfully !");
    }

    @PostMapping("/saveall")
    public ResponseEntity<String> saveAll(@RequestBody List<Employee> employeeList){
        employeeServiceImpl.saveAll(employeeList);
        return  ResponseEntity.ok("All Data Saved Successfully");
    }

    @GetMapping("/findbyid/{empId}")
    public ResponseEntity<Employee> findById(@PathVariable int empId){
        return  ResponseEntity.ok(employeeServiceImpl.findById(empId));
    }

    @GetMapping("/sortbyname")
    public ResponseEntity<List<Employee>> sortbyname(){
        return  ResponseEntity.ok(employeeServiceImpl.findAll().stream().sorted(Comparator.comparing(e->e.getEmpName())).toList());
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Employee>> findAll(){
        return  ResponseEntity.ok(employeeServiceImpl.findAll());
    }
    @PutMapping("/update/{empId}")
    public ResponseEntity<String> update(@PathVariable int empId ,@RequestBody  Employee employee){
        employeeServiceImpl.update(empId , employee);
        return  ResponseEntity.ok("Data Updated Successfully !");
    }

    @DeleteMapping("/deletebyid/{empId}")
    public ResponseEntity<String> deleteById(@PathVariable int empId){
        employeeServiceImpl.deleteById(empId);
        return ResponseEntity.ok("Data deletes Successfully");

    }
    @DeleteMapping("/deleteall")
    public ResponseEntity<String> deleteAll(){
        employeeServiceImpl.deleteAll();
        return ResponseEntity.ok("All data deleted Successfully");
    }
}
