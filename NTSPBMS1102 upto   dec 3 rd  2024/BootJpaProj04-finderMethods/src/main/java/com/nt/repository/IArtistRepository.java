package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Artist;

public interface IArtistRepository extends JpaRepository<Artist, Integer> {
	
	public  List<Artist>   findByCategoryEqualsIgnoreCase(String category);
	public   List<Artist>   readByCategoryIs(String category);
	public  List<Artist>    getByCategory(String category);
	public  List<Artist>   findByAnameStartingWith(String initChars);
	public  List<Artist>   findByAnameEndingWith(String lastChars);
	public  List<Artist>   findByAnameContaining(String chars);
	public  List<Artist>   findByAnameContainingIgnoreCase(String chars);
	
	public   Iterable<Artist>  findByAnameLike(String chars);
	public   Iterable<Artist>  findByFeeBetween(double start,double end);
	
	public   Iterable<Artist>  findByCategoryIn(List<String> categories);
	public   Iterable<Artist>  readByCategoryInOrderByAnameDesc(String ...categories);
	
	
 	
	
	

}
