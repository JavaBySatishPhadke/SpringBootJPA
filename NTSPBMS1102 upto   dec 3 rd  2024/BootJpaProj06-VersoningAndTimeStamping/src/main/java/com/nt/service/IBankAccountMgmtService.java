package com.nt.service;

import com.nt.entity.BankAccount;

public interface IBankAccountMgmtService {
   public  String  openAccount(BankAccount  account);
   public   String  withrawAmount(long acno, double amt);
   public   BankAccount   showAccountByAcno(long acno);
}
