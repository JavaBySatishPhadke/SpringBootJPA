package com.nt.runners;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Artist;
import com.nt.service.IArtistMgmtService;

@Component
public class JpaRepositoryTestRunner implements CommandLineRunner {
	@Autowired
	private IArtistMgmtService  artistService;

	@Override
	public void run(String... args) throws Exception {
		/*	try {
				List<Artist> list=artistService.searchArtitsByGivenData(null, 40000.0);
				list.forEach(System.out::println);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}*/
		
		try {
		  Optional<Artist> opt=	artistService.fetchArtistById(110);
		  if(opt.isEmpty()) {
			  System.out.println("Artist not found");
		  }
		  else {
			  System.out.println("Artist  found ");
		  }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("==============================");
		/*	try {
				Artist  proxy=artistService.loadArtistById(110);
				System.out.println("proxy object class name ::"+proxy.getClass()+"  super class "+ proxy.getClass().getSuperclass());
				
				System.out.println(proxy.getAid());
				System.out.println(proxy.getAname());
				System.out.println(proxy.getFee());
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		*/		
		
		
	} //run

}//class
