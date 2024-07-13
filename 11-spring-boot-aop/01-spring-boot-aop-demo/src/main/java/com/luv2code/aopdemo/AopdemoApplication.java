package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.entity.Account;
import com.luv2code.aopdemo.entity.Membership;
import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO, TrafficFortuneService trafficFortuneService){
		return runner->{
//            demoBeforeAdvice(accountDAO, membershipDAO);
			  callFortune(trafficFortuneService);
		};
	}

	private void callFortune(TrafficFortuneService trafficFortuneService) {
		System.out.println("Calling getFortune");
		String ans = null;
        try {
            System.out.println(trafficFortuneService.getFortune());
        } catch (Throwable e) {
			System.out.println("Exception handled");
        }
        System.out.println("Done!");
	}

	private void demoBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
//        accountDAO.addAccount(new Account("Ghouse", "12"), true);
		List<Account> result = null;

		try{
			Boolean flag = true;
			result = accountDAO.findAccounts(flag);
			System.out.println(result);
		}
		catch (Exception e){
			System.out.println("Reached");
		}

    }
}
