package com.nt.runners;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IEmployeeRepository;

@Component
public class QueryMethodsTestRunner implements CommandLineRunner {
	@Autowired
	private  IEmployeeRepository empRepo;

	@Override
	public void run(String... args) throws Exception {
		
	//empRepo.showAllEmployees().forEach(System.out::println);
   	 //empRepo.showEmpsBySalaryRange(3000.0, 12000.0).forEach(System.out::println);
   	 
   	 //empRepo.fetchEmpsBySalaryRange(3000.0, 12000.0).forEach(System.out::println);
	   //empRepo.loadEmpsBySalaryRange(3000.0, 12000.0).forEach(System.out::println);
		
		/*empRepo.showEmpsByDesgs("CLERK", "MANAGER", "SALESMAN").forEach(System.out::println);
		
		System.out.println("------------------");
		
		empRepo.showEmpsDataByDesg("CLERK", "MANAGER", "SALESMAN").forEach(row->{
			
			for(Object val:row) 
				System.out.print(val+"     ");
			
			System.out.println();
		});
		
		System.out.println("-------------------------");
		
		empRepo.showEmpNamesByNameChars("S%").forEach(System.out::println);
		*/		
		
		/*	System.out.println("Single record ::"+empRepo.fetchEmpByName("ALLEN"));
			System.out.println("-----------------");
			Object  data=empRepo.fetchEmpDataByName("ALLEN");
			Object row[]=(Object[])data;
			System.out.println("Single record multiple values::"+Arrays.toString(row));
			System.out.println("-----------------");
			System.out.println("Single record  Single value::"+empRepo.fetchEmpSalaryByName("ALLEN"));*/
		
		
		/*	System.out.println(" unique emp names count ::"+empRepo.showEmpsUniqueCount());
			Object row[]=(Object[]) empRepo.showArrgregateData();
			System.out.println("aggregate data ::"+Arrays.toString(row));*/
		
		/*   int count=empRepo.hikeSalaryByDesg("CLERK", 5.0f);
		   System.out.println("no.of records that are effected ::"+count);
		*/
		
		/*	int  count=empRepo.removeEmpsBySalaryRange(10000.0, 15000.0);
			System.out.println("no.of records that are removed::"+count);*/
		
		  LocalDateTime  ldt=empRepo.showSystemDate();
		  System.out.println("Date and time ::"+ldt);
		
		

	}

}
