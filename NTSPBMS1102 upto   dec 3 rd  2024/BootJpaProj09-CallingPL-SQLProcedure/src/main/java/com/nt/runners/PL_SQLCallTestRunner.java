package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Artist;
import com.nt.service.IArtistMgmtService;

@Component
public class PL_SQLCallTestRunner implements CommandLineRunner {
	@Autowired
	private IArtistMgmtService  artistService;

	@Override
	public void run(String... args) throws Exception {
		try {
			List<Artist> list=artistService.showArtitsByFeeRange(20000.0, 200000.0);
			list.forEach(ar->{
				System.out.println(ar);
			});
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
