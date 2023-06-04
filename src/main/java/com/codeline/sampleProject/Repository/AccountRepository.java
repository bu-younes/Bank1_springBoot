package com.codeline.sampleProject.Repository;

import com.codeline.sampleProject.Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT e FROM Account e WHERE e.accountNumber=:accountNumber")
    Account getAccountByAccountNumber(@Param("accountNumber") Integer accountNumber);

    @Query("SELECT e FROM Account e WHERE e.accountHolderName=:accountHolder")
    Account getAccountByAccountHolderName(@Param("accountHolder") String accountHolderName);
}
