package com.codeline.sampleProject.Controller;

import com.codeline.sampleProject.Models.Account;
import com.codeline.sampleProject.Models.Employee;
import com.codeline.sampleProject.RequestObjects.GetEmployeeProject.GetAccountRequestObject;
import com.codeline.sampleProject.RequestObjects.GetEmployeeProject.GetEmployeeRequestObject;
import com.codeline.sampleProject.ResponseObjects.GetAccountResponse;
import com.codeline.sampleProject.ResponseObjects.GetEmployeeResponse;
import com.codeline.sampleProject.Service.AccountService;
import com.codeline.sampleProject.Service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping("create")
    public void saveAccount(@RequestBody GetAccountRequestObject accountRequestObject) {
        createAccount(accountRequestObject);
    }


    @RequestMapping("get")
    public List<Account> getAccount() {

        return accountService.getAccount();
    }

    //Path Variable


        @RequestMapping("get/{accountId}")
        public GetAccountResponse createAccount(@PathVariable Long accountId) {
        return accountService.getAccountById(accountId);

    }

    @RequestMapping("account/delete/{Id}")
    public void deleteaccount(@PathVariable Long Id) {
        accountService.deleteAccountById(Id);
    }






    public void createAccount(GetAccountRequestObject accountRequestObject) {

        Account account = new Account();

        account.setBankName(accountRequestObject.getBankName());
        account.setAccountNumber("645654654");
        account.setBankBranch("gfuyftuyf");
        account.setSwiftCode("lihyuytg");
        account.setAccountHolderName("ugvjhg");
        account.setAccountType("uyfrufr");
        account.setBranchCode(2569);

        account.setCreatedDate(new Date());
        account.setIsActive(true);
        accountService.saveAccount(account);

    }

    @RequestMapping(value = "getByAccountNumber")
    public Account getAccountByNumber(@RequestParam String accountNumber) {
        return accountService.getAccountByNumber(accountNumber);
    }
}
