package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.entity.Membership;

public interface MembershipDAO {
    void addMembershipAccount(Membership membership, int id);
    void goToSleep();
}
