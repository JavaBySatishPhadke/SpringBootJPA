package com.nt.runners;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IArtistRepository;

@Component
public class FinderMethodsTestRunner implements CommandLineRunner {
	@Autowired
	private IArtistRepository  artistRepo;

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(artistRepo.getClass()+"....." +artistRepo.getClass().getSuperclass()+"...."+Arrays.toString(artistRepo.getClass().getDeclaredMethods()));
		
		/*artistRepo.findByCategoryEqualsIgnoreCase("HERO").forEach(System.out::println);
		System.out.println("-----------------------");
		artistRepo.readByCategoryIs("HERO").forEach(System.out::println);
		System.out.println("-------------------------");
		artistRepo.getByCategory("HERO").forEach(System.out::println);
		*/
		
		/*artistRepo.findByAnameStartingWith("r").forEach(System.out::println);
		System.out.println("-----------------");
		artistRepo.findByAnameEndingWith("sh").forEach(System.out::println);
		System.out.println("-----------------");
		artistRepo.findByAnameContaining("m").forEach(System.out::println);
		System.out.println("-----------------");
		artistRepo.findByAnameContainingIgnoreCase("m").forEach(System.out::println);*/

		
		//artistRepo.findByAnameLike("r%").forEach(System.out::println);  //starting with
		//artistRepo.findByAnameLike("%sh").forEach(System.out::println);  // ending with
		//artistRepo.findByAnameLike("%m%").forEach(System.out::println);  // containing
		
		//artistRepo.findByFeeBetween(10000.0, 2000000.0).forEach(System.out::println);
		
		//artistRepo.findByCategoryIn(List.of("HERO","villian","comedian")).forEach(System.out::println);
		 artistRepo.readByCategoryInOrderByAnameDesc("HERO","comedian").forEach(System.out::println);
		
		
		
			
		
		
	} //run

}//class
