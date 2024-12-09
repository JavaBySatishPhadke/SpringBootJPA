package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Artist;
import com.nt.service.IArtistMgmtService;

@Component
public class PagingAndSortingRepositoryTestRunner implements CommandLineRunner {
	@Autowired
	private IArtistMgmtService  artistService;

	@Override
	public void run(String... args) throws Exception {
		
		/*	try {
				//artistService.showArtistsBySorting(false, "aname","aid").forEach(System.out::println);
				artistService.showArtistsBySorting(true,"fee").forEach(System.out::println);
			}
			catch(Exception  e) {
				e.printStackTrace();
			}*/
		
	/*	try {
		  Page<Artist> page=artistService.showArtistByPageNo(4, 3);
		 //get content of the page
		  List<Artist> list=page.getContent();
		  list.forEach(System.out::println);
		  System.out.println("------------------------");
		  System.out.println("current page no:"+ (page.getNumber()+1));
		  System.out.println("page size ::"+page.getSize());
		  System.out.println("total no.of pages::"+page.getTotalPages());
		  System.out.println("total no,of records on the current page::"+page.getNumberOfElements());
		  System.out.println("Is the current page is first page :::"+page.isFirst());
		  System.out.println("Is the current page is last page :::"+page.isLast());
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		  
		  try {
			  artistService.showArtistsPageByPage(3, true, "aname");
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		
	}//main

}//class
