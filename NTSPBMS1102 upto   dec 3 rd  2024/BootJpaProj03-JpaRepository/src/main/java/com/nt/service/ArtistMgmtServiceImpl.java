package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.nt.entity.Artist;
import com.nt.repository.IArtistRepository;
@Service("artistService")
public class ArtistMgmtServiceImpl implements IArtistMgmtService {
	@Autowired
	private  IArtistRepository  artistRepo;

	@Override
	public String removeArtistsByIdsInBatch(List<Integer> ids) {
		//Load objects by ids
		List<Artist>  list=artistRepo.findAllById(ids);
		// delete objects  by Ids  in batch processing
		   artistRepo.deleteAllByIdInBatch(ids);
		   
		return list.size()+"   records deleted";
	}

	@Override
	public List<Artist> searchArtitsByGivenData(String name, double income) {
           //prepare Example object
		Artist artirst=new Artist();
		artirst.setAname(name); 
		artirst.setFee(income);
		//prpare Exaple ojbject
		Example<Artist> example=Example.of(artirst);
		//execute the logics
		List<Artist> list=artistRepo.findAll(example);
	return list;
	}

	@Override
	public Optional<Artist> fetchArtistById(int id) {
		return artistRepo.findById(id);
	}

	@Override
	public Artist loadArtistById(int id) {
		return  artistRepo.getReferenceById(id);
	}

	

}//class
