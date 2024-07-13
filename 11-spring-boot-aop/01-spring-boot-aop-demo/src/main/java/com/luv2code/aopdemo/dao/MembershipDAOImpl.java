package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.entity.Membership;
import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{

    @Override
    public void addMembershipAccount(Membership membership, int id) {
        System.out.println(getClass() + " : Adding membership DB operation");
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + " : Going to sleep now");
    }
}
