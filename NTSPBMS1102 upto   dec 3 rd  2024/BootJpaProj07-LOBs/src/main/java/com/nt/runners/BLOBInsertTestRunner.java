package com.nt.runners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.JobSeeker;
import com.nt.service.IJobSeekerMgmtService;

//@Component
public class BLOBInsertTestRunner implements  CommandLineRunner {
	@Autowired
	private  IJobSeekerMgmtService  jsService;

	@Override
	public void run(String... args) throws Exception {
		Scanner  sc=new Scanner(System.in);
		System.out.println("Enter  JS name ::");
		String name=sc.next();
		System.out.println("Enter  JS address ::");
		 String addrs=sc.next();
		 System.out.println("Is JS   Indian ?");
		 boolean  indian=sc.nextBoolean();
		 System.out.println("Enter  JS Photo file path");
		 String  photoPath=sc.next();
		 System.out.println("Enter  JS Resume file path");
		 String  resumePath=sc.next();
		 
		  //Convert the  PhotoFile content  into  byte[]
		   FileInputStream  fis=new FileInputStream(photoPath);
		   byte[]  photoData=new byte[fis.available()];
		   photoData=fis.readAllBytes();
		   
		   //Convert  the  resume file content to char[]
		   File file=new File(resumePath);
		   FileReader   fr=new FileReader(resumePath);
		   int length=(int)file.length();
		   char[]  resumeData=new char[length];
		   fr.read(resumeData);
		  
		    //prepare Entity class obj
		   JobSeeker  js=new JobSeeker(name, addrs, photoData, resumeData, indian);
		   
		   try {
			   String msg=jsService.registerJobSeeker(js);
			   System.out.println(msg);
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }
		
	}

}
