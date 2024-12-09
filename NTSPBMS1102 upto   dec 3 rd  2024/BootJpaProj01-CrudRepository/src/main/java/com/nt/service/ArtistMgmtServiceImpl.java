package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Artist;
import com.nt.repository.IArtistRepository;
@Service("artistService")
public class ArtistMgmtServiceImpl implements IArtistMgmtService {
	@Autowired
	private  IArtistRepository  artistRepo;

	@Override
	public String registerArtist(Artist artist) {
		System.out.println("InMemory Proxy obj class name::"+artistRepo.getClass());
		//use repo
		Artist  artist1=artistRepo.save(artist);
		return  artist1.getAid()==null? "Artist is not saved (record not inserted)":"Artist is saved (Record inserted)";
	}
	
	@Override
	public boolean checkArtistAvailability(int id) {
		boolean flag=artistRepo.existsById(id);
		return flag;
	}
	
	@Override
	public long showArtistsCount() {
		//USE REPO
				return artistRepo.count();
	}
	
	
	@Override
	public String registerArtistBatch(List<Artist> list) {
		//save  the objs
				Iterable<Artist>  savedList=artistRepo.saveAll(list);
		  List<Integer> ids=StreamSupport.stream(savedList.spliterator(),false).map(Artist::getAid).collect(Collectors.toList());
		  return   ids.size()+"  no.of  artits are registered having the idValues "+ids;
	}
	
	/*@Override
	public String registerArtistBatch(List<Artist> list) {
		//save  the objs
		List<Artist>  savedList=(List<Artist>)artistRepo.saveAll(list);
		
		List<Integer> ids=savedList.stream().map(art->art.getAid()).collect(Collectors.toList());
		
		return  ids.size()+"  no.of Artists are saved with the id values ::"+ids;
	}*/
	
/*	@Override
	public String registerArtistBatch(List<Artist> list) {
		//save  the objs
		Iterable<Artist>  savedList=artistRepo.saveAll(list);
		List<Integer> idsList=new ArrayList();
		savedList.forEach(artist->{
			idsList.add(artist.getAid());
		});
		return   idsList.size()+"  no.of  artits are registered having the idValues "+idsList.toString();
	}*/
	
	@Override
	public Iterable<Artist> showAllArtists() {
		Iterable<Artist>  list=artistRepo.findAll();
		return list;
	}
	
	@Override
	public Iterable<Artist> showArtitsByIds(Iterable<Integer> ids) {
		Iterable<Artist> list=artistRepo.findAllById(ids);
		return list;
	}
	
	@Override
	public Optional<Artist> showArtistById(int id) {
		Optional<Artist> opt=artistRepo.findById(id);
		return opt;
	}
	
	@Override
	public String getArtistById(int id) {
		Optional<Artist> opt=artistRepo.findById(id);
		 if(opt.isEmpty())
			 return " Artist not found";
		 else
			 return "Artist details  are :"+opt.get();
	}
	
	
	@Override
	public Artist fetchArtistById(int id) {
		/*	Optional<Artist> opt=artistRepo.findById(id);
			  if(opt.isPresent())
				  return opt.get();
			  else
				  throw new IllegalArgumentException("Invalid Id");*/
		   return  artistRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Id"));
		}
	
	@Override
	public String registerOrUpateArtist(Artist artist) {
		//save or update  object
		artistRepo.save(artist);
		if(artistRepo.existsById(artist.getAid()))
		          return artist.getAname()+"  Artist is   updated";
		else
			return  artist.getAname()+"  Artist is registered";
	}
	
	
	@Override
	public String hikeActorFeeByIdAndPercentage(int id, double percentage) {
		//Load  the Artist
		Optional<Artist>  opt=artistRepo.findById(id);
		if(opt.isPresent()) {
			//get Entity object
			Artist artist=opt.get();
			//hike the fee by given percentage
			artist.setFee(artist.getFee()+ ( artist.getFee()* percentage/100.0f));
			artistRepo.save(artist);
			return "Artist is found and the Fee is Modified";
		}
		else {
		  return "Artist is not found for Modification";	
		}
		
	}
	
	
	@Override
	public String removeArtistById(int id) {
		// Load  the   Object
		Optional<Artist> opt= artistRepo.findById(id);
		if(opt.isPresent()) {
			//delete object
			artistRepo.deleteById(id);
			return "Artist found and deleted";
		}
		return "Artist not found for deletion";
	}
	
	
	@Override
	public String removeAllArtists() {
		long count=artistRepo.count();
		artistRepo.deleteAll();
		
		return count+"  no.of  records  are  deleted";
	}
	
	@Override
	public String removeArtistsByIds(Iterable<Integer> ids) {
		//Load the objs by ids
		Iterable<Artist> list=artistRepo.findAllById(ids);
		long count= StreamSupport.stream(list.spliterator(), false).count();
		
		//delete objs by  ids
		artistRepo.deleteAllById(ids);
		return   count+"  no.of Artits are  deleted ";
	}
	
	
	

}
