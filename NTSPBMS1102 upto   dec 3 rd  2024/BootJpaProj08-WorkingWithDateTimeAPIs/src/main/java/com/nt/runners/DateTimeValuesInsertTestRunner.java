package com.nt.runners;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.PersonInfo;
import com.nt.service.IPersonInfoMgmtService;

@Component
public class DateTimeValuesInsertTestRunner implements CommandLineRunner {
	@Autowired
	private  IPersonInfoMgmtService  personService;

	@Override
	public void run(String... args) throws Exception {
		/*	try {
				PersonInfo info=new PersonInfo("raja", "hyd",
						                                                         LocalDate.of(1991, 10, 21),
						                                                         LocalTime.of(2, 30),
						                                                         LocalDateTime.of(2013,10,22,10,50,30));
				String msg=personService.registerPerson(info);
				System.out.println(msg);
			}//try
			catch(Exception e) {
				e.printStackTrace();
			}*/


		  
	
	/*	try {
			personService.showAllPersons().forEach(System.out::println);
		}
		catch(Exception e) {
			 e.printStackTrace();
		}*/
		
		try {
            System.out.println("Person Age is ::"+personService.getAgeByPid(1));			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	} 
}
