package com.codeline.sampleProject.Service;

import com.codeline.sampleProject.Models.Account;
import com.codeline.sampleProject.Repository.AccountRepository;
import com.codeline.sampleProject.ResponseObjects.GetAccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    public List<Account> getAccount() {
        return accountRepository.findAll();
    }
    @Autowired
    AccountRepository accountRepository;

    public void saveAccount(Account account) {
        accountRepository.save(account);
    }


    public GetAccountResponse getAccountById(Long accountId) {
        Optional<Account> optionalAccount = accountRepository.findById(accountId);
        if (!optionalAccount.isEmpty()) {
            Account account = optionalAccount.get();
            GetAccountResponse accountResponse = new GetAccountResponse(account.getBankName(), account.getAccountNumber(), account.getBankBranch());
            return accountResponse;
        } else {

            return null;

        }
    }
    public Account getAccountByNumber(String accountNumber){
        return accountRepository.getAccountByAccountNumber(accountNumber);
    }
    public Account getBankByName(String BankName){
        return accountRepository.getBankByName(BankName);
    }

    public List<Account> getBankBranch(String BankBranch){
        return accountRepository.getBankByBranch(BankBranch);
    }
    public void deleteAccountById(Long accountId) {
        accountRepository.deleteById(accountId);
    }



    public void test(){

    }
}
