package com.codeline.sampleProject.Controller;

import com.codeline.sampleProject.Models.Salary;
import com.codeline.sampleProject.RequestObjects.GetEmployeeProject.GetSalaryRequestObject;
import com.codeline.sampleProject.ResponseObjects.GetEmployeeResponse;
import com.codeline.sampleProject.ResponseObjects.GetSalaryResponse;
import com.codeline.sampleProject.Service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class SalaryController {

    @Autowired
    SalaryService salaryService;

    @RequestMapping("salary/create")
    public void saveSalary (@RequestBody GetSalaryRequestObject salaryRequestObject) {
        createSalary(salaryRequestObject);
    }


    @RequestMapping("salary/get")
    public List<Salary> getSalary () { return salaryService.getSalary();}

    //Path Variable
    @RequestMapping("salary/get/{salaryId}")
    public GetSalaryResponse createSalary (@PathVariable Long salaryId) {
        return salaryService.getSalaryById(salaryId);

    }
    public void createSalary(GetSalaryRequestObject salaryRequestObject) {



        Salary salary = new Salary();

        salary.setAmount(54.8);
        salary.setCurrency("gdygtdg");
        salary.setOverTimeAmount(58.6);
        salary.setDeductions(78.2);
        salary.setHealthCareContribution(salaryRequestObject.getHealthCareContribution());
        salary.setAllowances(salaryRequestObject.getAllowances());
        salary.setBonus(salaryRequestObject.getBonus());
        salary.setPerDiem(salaryRequestObject.getPerDiem());



        salary.setCreatedDate(new Date());
        salary.setIsActive(true);
        salaryService.saveSalary(salary);
    }

}




