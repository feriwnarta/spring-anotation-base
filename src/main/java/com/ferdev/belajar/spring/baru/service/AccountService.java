package com.ferdev.belajar.spring.baru.service;

import com.ferdev.belajar.spring.baru.domain.Account;

import java.math.BigDecimal;

public interface AccountService {
    void transfer(Long source, Long target, BigDecimal balance);
    Account getById(Long id);
}
