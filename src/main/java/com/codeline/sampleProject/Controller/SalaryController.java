package com.codeline.sampleProject.Controller;

import com.codeline.sampleProject.Models.Salary;
import com.codeline.sampleProject.RequestObjects.GetEmployeeProject.GetSalaryRequestObject;
import com.codeline.sampleProject.ResponseObjects.GetSalaryResponse;
import com.codeline.sampleProject.Service.SalaryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("salary/delete/{Id}")
    public void deletesalary (@PathVariable Long Id) {
        salaryService.deleteSalaryById(Id);
    }



    @GetMapping("salary/quer")
    @ResponseBody
    public String getsalaryQueryString(@RequestParam Double a, @RequestParam Double b, @RequestParam Double c, @RequestParam Double d) throws JsonProcessingException {
        Salary salary = new Salary();
        salary.setHealthCareContribution(a);
        salary.setAllowances(b);
        salary.setBonus(c);
        salary.setPerDiem(d);
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(salaryService.getSalaryAsString(salary));
        System.out.print(s);
        return s;
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




