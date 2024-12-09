package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.BankAccount;
import com.nt.service.IBankAccountMgmtService;


@Component
public class VersionAndTimeStampTestRunner implements CommandLineRunner {
	@Autowired
	private  IBankAccountMgmtService  bankService;

	@Override
	public void run(String... args) throws Exception {
		
		BankAccount  account=new BankAccount();
		account.setHolderName("pavan  -the bhandar"); account.setBalance(80000.0);
		
		/*try {
			String msg=bankService.openAccount(account);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		
		try {
			String msg=bankService.withrawAmount(10000020, 2000.0);
			System.out.println(msg);
			BankAccount  acc=bankService.showAccountByAcno(10000020);
			System.out.println("accoint is modified for "+acc.getModificationCount()+" ....opened on"+acc.getOpeningDate()+" .... lastly operated on "+acc.getLastlyOperatedOn());
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
