package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.BankAccount;
import com.nt.repository.IBankAccountRepository;


@Service("bankService")
public class BankAccountMgmtServiceImpl implements IBankAccountMgmtService {
	@Autowired
	private  IBankAccountRepository   accountRepo;

	@Override
	public String openAccount(BankAccount account) {
		long  idVal=accountRepo.save(account).getAcno();
		return "Bank Account is opened with the account number :"+idVal;
	}
	
	@Override
	public String withrawAmount(long acno, double amt) {
		// Load the object
		BankAccount  account=accountRepo.findById(acno).orElseThrow(()-> new IllegalArgumentException("account not found"));
		if(account!=null) {
			//with amount
			account.setBalance(account.getBalance()-amt);
			accountRepo.save(account);
			return "Money is withdrawn";
		}
	return  " Account  not found";
	}
	
	@Override
	public BankAccount showAccountByAcno(long acno) {
	  return   accountRepo.findById(acno).orElseThrow(()-> new IllegalArgumentException("invalid Accno"));
	}

}
