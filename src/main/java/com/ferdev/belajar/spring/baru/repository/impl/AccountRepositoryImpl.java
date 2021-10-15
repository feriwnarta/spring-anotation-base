package com.ferdev.belajar.spring.baru.repository.impl;

import com.ferdev.belajar.spring.baru.domain.Account;
import com.ferdev.belajar.spring.baru.repository.AccountRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

// jatohnya dao, data akses objek, berisi tentang query ke database
@Repository(value = "accountRepository")
public class AccountRepositoryImpl implements AccountRepository {
    private Map<Long, Account> demoDb = new HashMap<>();
    // class static method
    {
        Account account1 = new Account();
        account1.setId(1l);
        account1.setAccountNumber("001");
        account1.setNama("feri");
        account1.setBalance(new BigDecimal(100000));

        Account account2 = new Account();
        account2.setId(2l);
        account2.setAccountNumber("002");
        account2.setNama("jaka");
        account2.setBalance(new BigDecimal(100000));

        demoDb.put(account1.getId(), account1);
        demoDb.put(account2.getId(), account2);
    }

    @Override
    public void update(Account account) { // anggap ini isi kedatabase
        demoDb.put(account.getId(), account);
    }

    @Override
    public Account find(Long id) {
        return demoDb.get(id);
    }


}
