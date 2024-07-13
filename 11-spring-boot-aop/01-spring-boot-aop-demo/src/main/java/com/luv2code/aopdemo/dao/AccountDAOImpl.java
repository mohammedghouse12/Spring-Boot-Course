package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{
    public String getName() {
        System.out.println(getClass() + " : in the getter method");
        return "name";
    }

    public void setName(String name) {
        System.out.println(getClass() + " : in the setter method");
    }

    @Override
    public List<Account> findAccounts(Boolean flag) throws Exception{
        List<Account> res = new ArrayList<>();
        res.add(new Account("Ghouse", "Gold"));
        res.add(new Account("Ayush", "Platinum"));
        System.out.println("Inside findAccounts ");
        if(flag)
            throw new Exception("Exception is found");
        return res;
    }


    @Override
    public void addAccount(Account account, boolean flag) {
        System.out.println(getClass() +  " : Adding account DB operation");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + " : doing some work");
        return true;
    }
}
