package com.nt.runners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.JobSeeker;
import com.nt.service.IJobSeekerMgmtService;

@Component
public class BLOBRetriveTestRunner implements  CommandLineRunner {
	@Autowired
	private  IJobSeekerMgmtService  jsService;

	@Override
	public void run(String... args) throws Exception {
		Scanner  sc=new Scanner(System.in);
		System.out.println("Enter  JS Id ::");
		  int  id=sc.nextInt();
		  
		  try {
			  Optional<JobSeeker> opt=jsService.showJobSeekerInfoById(id);
			  if(opt.isPresent()) {
				  JobSeeker js=opt.get();
				  int jsId=js.getJsId();
				  String name=js.getJsName();
				  String addrs=js.getJsAddrs();
				  byte[] photoContent=js.getPhoto();
				  char[]  resumeContent=js.getResume();
				  boolean  indian=js.getIndian();
				  System.out.println(id+"  "+name+"   "+addrs+"   "+indian);
				  
				  try(FileOutputStream  fos=new FileOutputStream("photo_retrieved.jfif");
						  FileWriter  fw=new FileWriter("resume_retrieved.txt");
						  ){
					    //write  byte[]  to dest file 
					  fos.write(photoContent);
					  fos.flush();
					  //write char[]  to dest file
					  fw.write(resumeContent);
					  fw.flush();
					  System.out.println("LOB files are retrieved from the DB s/w");
				  }//try
			  }//if
			  else {
				  System.out.println("JobSeeker  Not found");
			  }

			  }//try
		      catch(Exception e) {
					  e.printStackTrace();
				  }
				  
		  	}//run(-)

}//class
