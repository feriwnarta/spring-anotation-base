package com.ferdev.belajar.spring.baru.repository;

import com.ferdev.belajar.spring.baru.domain.Account;

public interface AccountRepository {
    void update(Account account);
    Account find(Long id);
}
