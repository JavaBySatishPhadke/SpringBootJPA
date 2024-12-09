package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.Artist;

public interface IArtistMgmtService {

	public   String    removeArtistsByIdsInBatch(List<Integer> ids);
	public   List<Artist>   searchArtitsByGivenData(String name, double income);
	public   Optional<Artist>   fetchArtistById(int id);
	public   Artist    loadArtistById(int id);
   
}
