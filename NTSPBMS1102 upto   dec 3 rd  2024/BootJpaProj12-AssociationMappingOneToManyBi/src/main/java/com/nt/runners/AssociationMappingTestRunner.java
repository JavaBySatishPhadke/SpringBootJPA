package com.nt.runners;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.ICustomerMgmtService;


@Component
public class AssociationMappingTestRunner implements CommandLineRunner {
	@Autowired
	private  ICustomerMgmtService  custService;

	@Override
	public void run(String... args) throws Exception {
		/* try {
		  String msg=custService.saveDataUsingParent();
		  System.out.println(msg);
		 }
		 catch(Exception e) {
		  e.printStackTrace();
		 }
		*/
		
		/*	try {
				String  msg=custService.saveDataUsingChilds();
				System.out.println(msg);
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		/*	try {
				custService.loadDataUsingParent();
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		/*try {
			custService.loadDataUsingChilds();
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*	try {
				custService.deleteDataUsingParent();
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		/*	try {
				custService.deleteAllChildsOfAParent();
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		/*	try {
				custService.addNewChildToExistingChildsOfAParent();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		*/	
		
		/*try {
			custService.deleteDataUsingChilds();
		}
		catch(Exception e) {
		  e.printStackTrace();		
		}*/
		try {
			custService.showParentsToChildsDataUsingJoins().forEach(row->{
				System.out.println(Arrays.toString(row));
			});
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}//main

}//class
