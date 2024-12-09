package com.nt.runners;

import java.util.Arrays;
import java.util.Optional;

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
		
	/*	try {
			System.out.println("Artits Count ::"+artistService.showArtistsCount());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	*/
		
		
	/*	Artist artist1=new Artist("mahesh1","HERO", 4000000.0);
		Artist artist2=new Artist("SRK1","HERO", 5000000.0);
		Artist artist3=new Artist("Prabhas1","HERO", 3000000.0);
		
		List<Artist>  list=List.of(artist1,artist2,artist3);
		try {
			String msg=artistService.registerArtistBatch(list);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	*/	
		
	/*try {
		Iterable<Artist>  list=artistService.showAllArtists();
		list.forEach(art->{
			System.out.println(art);
		});
		System.out.println("------------------");
		list.forEach(art-> System.out.println(art));
		System.out.println("------------------");
		list.forEach(System.out::println);
		System.out.println("------------------------");
		for(Artist art:list) {
			System.out.println(art);
		}
		System.out.println("------------------------");
		Stream.of(list).forEach(System.out::println);
		System.out.println("------------------------");
		Stream.of(list).forEachOrdered(System.out::println);	
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}*/
		
		
	/*	try {
			//artistService.showArtitsByIds(List.of(1,2,3,50,76)).forEach(System.out::println);
			  List<Integer> ids=new ArrayList();  ids.add(1); ids.add(2); ids.add(56); ids.add(null);
			  artistService.showArtitsByIds(ids).forEach(System.out::println);
		}
		catch(Exception  e) {
			e.printStackTrace();
		}*/

		
	/*	 try {
			 Optional<Artist> opt=artistService.showArtistById(111);
			 if(opt.isPresent()) {
				 Artist artits=opt.get();
				 System.out.println("Artist Info is ::"+artits);
			 }
			 else {
				 System.out.println("Artist not found");
			 }
		 }//try
		 catch(Exception e) {
			 e.printStackTrace();
		 }*/
		
		
	/*	try {
			System.out.println(artistService.getArtistById(111));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
	/*try {
		Artist  artist=artistService.fetchArtistById(1);
		System.out.println(artist);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	*/
		
	/*		try {
				Artist artist=new Artist(456, "NTR", "hero", 81000.0);
				String msg=artistService.registerOrUpateArtist(artist);
				System.out.println(msg);
			}//try
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
	/*	try {
			String  msg=artistService.hikeActorFeeByIdAndPercentage(1512, 20.0);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
	/*	try {
			System.out.println(artistService.removeArtistById(2));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
	/*	try {
			System.out.println(artistService.removeAllArtists());
		}
		catch(Exception  e) {
			e.printStackTrace();
		}
	*/		
		try {
			System.out.println("artits count::"+artistService.removeArtistsByIds(Arrays.asList(50,88,99)));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}//main

}//class
