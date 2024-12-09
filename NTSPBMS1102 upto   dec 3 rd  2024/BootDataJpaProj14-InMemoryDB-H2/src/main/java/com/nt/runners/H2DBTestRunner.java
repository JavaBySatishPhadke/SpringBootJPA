package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Artist;
import com.nt.repository.IArtistRepository;

@Component
public class H2DBTestRunner implements CommandLineRunner {
	@Autowired
	private IArtistRepository  artistRepo;

	@Override
	public void run(String... args) throws Exception {
            Artist artist=new Artist();
            artist.setAname("raja");
            artist.setCategory("HERO"); artist.setFee(90000.0);
            try {
            	artistRepo.save(artist);
            }
            catch(Exception e) {
            	e.printStackTrace();
            }

	}

}
