package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Artist;
import com.nt.service.IArtistMgmtService;

@Component
public class CrurdRepositoryTestRunner implements CommandLineRunner {
	@Autowired
	private IArtistMgmtService  artistService;

	@Override
	public void run(String... args) throws Exception {
	/*	Artist  artist=new  Artist("raja","hero",9900000.0);
		//invoke the b.method
		try {
		 String msg=artistService.registerArtist(artist);
		 System.out.println(msg);
		}//try
		catch(Exception e) {
			e.printStackTrace();
		} */
		
		
	/*	try {
			System.out.println(" 15  Id Artist available or not ?"+artistService.checkArtistAvailability(15));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	*/	
		
		try {
			System.out.println("Artits Count ::"+artistService.showArtistsCount());
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
