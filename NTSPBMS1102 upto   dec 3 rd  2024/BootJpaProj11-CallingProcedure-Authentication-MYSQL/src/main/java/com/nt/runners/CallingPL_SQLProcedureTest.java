package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.ILoginMgmtService;

@Component
public class CallingPL_SQLProcedureTest implements CommandLineRunner {
	@Autowired
	private  ILoginMgmtService  loginService;

	@Override
	public void run(String... args) throws Exception {
		try {
			//invoke the method
			String result=loginService.doLogin("raja", "rani");
			System.out.println(result);
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}
