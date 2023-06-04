package com.codeline.sampleProject.Repository;

import com.codeline.sampleProject.Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT m FROM Account m WHERE m.accountNumber=:accountNumber")
    Account getAccountByAccountNumber(@Param("accountNumber") String accountNumber);

    @Query("SELECT mm FROM Account mm WHERE mm.accountHolderName=:accountHolder")
    Account getAccountByAccountHolderName(@Param("accountHolder") String accountHolderName);

    @Query("SELECT mmm FROM Account mmm WHERE mmm.bankName=:BankName")
    Account getBankByName(@Param("BankName") String BankName);


    @Query("SELECT mmmm FROM Account mmmm WHERE mmmm.bankBranch=:BankBranch")
    List<Account> getBankByBranch(@Param("BankBranch") String BankName);
}
