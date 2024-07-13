package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.entity.Account;

import java.util.List;

public interface AccountDAO {
    void addAccount(Account account, boolean flag);
    boolean doWork();
    String getName();
    void setName(String name);
    List<Account> findAccounts(Boolean flag) throws Exception;
}
