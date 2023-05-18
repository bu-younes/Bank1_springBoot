package com.codeline.sampleProject.Controller;

import com.codeline.sampleProject.Models.Employee;
import com.codeline.sampleProject.RequestObjects.GetEmployeeProject.GetEmployeeRequestObject;
import com.codeline.sampleProject.ResponseObjects.GetEmployeeResponse;
import com.codeline.sampleProject.Service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("employee/create")
    public void saveEmployee (@RequestBody GetEmployeeRequestObject employeeRequestObject) {
        createEmployee(employeeRequestObject);
    }

    //@RequestMapping("employee/get")
    //public List<Employee> getEmployees () {
        //return employeeService.getEmployees();
   // }

    @RequestMapping("employee/get")
    public List<Employee> getEmployees () {
        return employeeService.getEmployees();
    }

    //Path Variable
    @RequestMapping("employee/get/{employeeId}")
    public GetEmployeeResponse createEmployee (@PathVariable Long employeeId) {
        return employeeService.getEmployeeById(employeeId);

      }

    @RequestMapping("employee/delete/{Id}")
    public void deleteeemployee (@PathVariable Long Id) {
        employeeService.deleteEmployeeById(Id);
    }







//update
/*
   @RequestMapping(value = "employee/update/{Id}", method = RequestMethod.PUT)
   public GetEmployeeResponse updateEmployee(@PathVariable Long employeeId, @RequestBody Employee updatedEmployee) {
       return employeeService.updateEmployee(employeeId, updatedEmployee);
    }

*/








    @GetMapping("employee/quer")
    @ResponseBody
    public String getemployeeQueryString(@RequestParam String a,@RequestParam String b,@RequestParam String c,@RequestParam Double d) throws JsonProcessingException {
        Employee employee = new Employee();
        employee.setName(a);
        employee.setGender(b);
        employee.setDepartment(c);
        employee.setSalary(d);
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(employeeService.getEmployeeAsString(employee));
        System.out.print(s);
        return s;
    }

    public void createEmployee(GetEmployeeRequestObject employeeRequestObject) {

        Employee employee = new Employee();

        employee.setName(employeeRequestObject.getName());
        employee.setGender(employeeRequestObject.getGender());
        employee.setSalary(650.0);
        employee.setDepartment(employeeRequestObject.getDepartment());
        employee.setCompanyName("TechM");


        employee.setCreatedDate(new Date());
        employee.setIsActive(true);
        employeeService.saveEmployee(employee);
    }
}
