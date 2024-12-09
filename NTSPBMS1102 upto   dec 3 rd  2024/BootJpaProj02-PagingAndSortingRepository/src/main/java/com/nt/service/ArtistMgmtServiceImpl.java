package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Artist;
import com.nt.repository.IArtistRepository;
@Service("artistService")
public class ArtistMgmtServiceImpl implements IArtistMgmtService {
	@Autowired
	private  IArtistRepository  artistRepo;

	@Override
		public Iterable<Artist> showArtistsBySorting(boolean ascOrder, String... props) {
			//prepare the Sort object
		 Sort sort=Sort.by(ascOrder?Direction.ASC: Direction.DESC, props);
		 //  invoke the method
		 	return artistRepo.findAll(sort);
		}	
	
	@Override
	public Page<Artist> showArtistByPageNo(int pageNo, int pageSize) {
		//prepare  Pageable object having inputs
		Pageable pageable=PageRequest.of(pageNo, pageSize);
		//call the b,method
		Page<Artist> page=artistRepo.findAll(pageable);
		return page;
	}
	
	
	@Override
	public void showArtistsPageByPage(int pageSize, boolean ascOrder, String... props) {
		// get records count
		long count=artistRepo.count();
		// get no,of pages
		long pagesCount=count/pageSize;
		if(count%pageSize!=0)
			pagesCount=++pagesCount;
		//prepare Sort object
	   Sort sort=Sort.by(ascOrder?Direction.ASC:Direction.DESC, props);
		
		for(int i=0;i<pagesCount;++i) {
			//Prepare Pageable  obj for every Page
			Pageable  pageable=PageRequest.of(i, pageSize,sort);
			// get each page record
			Page<Artist> page=artistRepo.findAll(pageable);
			//display each page records
			page.forEach(System.out::println);
			System.out.println("--------------"+(page.getNumber()+1)+"/"+page.getTotalPages() +"---------------------");
		}//for
                   
				
	}//method
	

}//class
