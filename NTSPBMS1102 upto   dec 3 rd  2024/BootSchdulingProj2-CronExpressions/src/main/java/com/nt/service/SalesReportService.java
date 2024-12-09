package com.nt.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SalesReportService {
	
	public SalesReportService() {
		System.out.println("SalesReportService:: 0-param consstructor");
	}
	
	//@Scheduled(cron="20 * * * * * ")
	//@Scheduled(cron="0 56 18 * * * ")
	//@Scheduled(cron="* * * * * * ")
	//@Scheduled(cron="* 2 19 * * * ")
	//@Scheduled(cron="0 * 19 * * * ")
	//@Scheduled(cron="0 14 19,20 * * * ")
	//@Scheduled(cron="0  20-25  19 * * * ")
	//@Scheduled(cron="0-10  24-27  19 * * * ")
	
	//@Scheduled(cron="0/20  *  *  *  *  * ")
	//@Scheduled(cron="0/20  43/2  *  *  *  * ")
	//@Scheduled(cron="0 56 19  L-20   *  * ")
	@Scheduled(cron="0 7 20  10W   *  * ")
	public  void  showReport() {
		System.out.println("SalesReportService.showReport() :::"+new Date());
	}

}
