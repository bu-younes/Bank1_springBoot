package com.codeline.sampleProject.Service;

import com.codeline.sampleProject.Models.Account;
import com.codeline.sampleProject.Models.Employee;
import com.codeline.sampleProject.Repository.EmployeeRepository;
import com.codeline.sampleProject.RequestObjects.GetEmployeeProject.GetEmployeeRequestObject;
import com.codeline.sampleProject.ResponseObjects.GetAccountResponse;
import com.codeline.sampleProject.ResponseObjects.GetEmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public GetEmployeeResponse getEmployeeById(Long employeeId) {
        Optional<Employee> optionalEmployee =  employeeRepository.findById(employeeId);
        if(!optionalEmployee.isEmpty())
        {
            Employee employee =  optionalEmployee.get();
            GetEmployeeResponse employeeResponse = new GetEmployeeResponse(employee.getName(), employee.getGender(), employee.getDepartment(), employee.getSalary());
            return employeeResponse;
        }

        return null;

    }


    public void deleteEmployeeById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }



//update
/*
    public GetEmployeeResponse updateEmployee(Long employeeId, Employee updatedEmployee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setName(updatedEmployee.getName());
            employee.setGender(updatedEmployee.getGender());
            employee.setDepartment(updatedEmployee.getDepartment());
            employee.setSalary(updatedEmployee.getSalary());
            employeeRepository.save(employee);
            GetEmployeeResponse employeeResponse = new GetEmployeeResponse(employee.getName(), employee.getGender(), employee.getDepartment(), employee.getSalary());
            return employeeResponse;
        }

        return null;
    }*/



/*
    @GetMapping("employee/quer")
    @ResponseBody
    public String getemployeeQueryString(@RequestParam String a,@RequestParam String b,@RequestParam String c,@RequestParam Double d) throws JsonProcessingException {


*/


}