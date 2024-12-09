package com.nt.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SalesReportService {
	
	public SalesReportService() {
		System.out.println("SalesReportService:: 0-param consstructor");
	}
	
	//@Scheduled(initialDelay = 5000 , fixedDelay = 3000)
	//@Scheduled(fixedDelayString = "3000")
	
	@Scheduled(fixedRate = 3000)
	public  void  showReport() {
		System.out.println("SalesReportService.showReport() :::"+new Date()+"....."+Thread.currentThread().getName());
		/*	try {
				Thread.sleep(10000);
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
	}

}
