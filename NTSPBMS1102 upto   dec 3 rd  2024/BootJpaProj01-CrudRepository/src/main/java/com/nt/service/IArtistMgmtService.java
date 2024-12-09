package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.Artist;

public interface IArtistMgmtService {
   public  String  registerArtist(Artist artist);
   public    boolean  checkArtistAvailability(int  id);
   public   long    showArtistsCount();
   public    String   registerArtistBatch(List<Artist>  list);
   public    Iterable<Artist>   showAllArtists();
   public    Iterable<Artist>   showArtitsByIds(Iterable<Integer> ids);
   public    Optional<Artist>  showArtistById(int id);
   public    String    getArtistById(int id); 
   public   Artist    fetchArtistById(int id);
   
   public  String  registerOrUpateArtist(Artist artist);
   public    String    hikeActorFeeByIdAndPercentage(int id ,  double percentage);
   
   public   String     removeArtistById(int id);
   public    String     removeAllArtists();
   public   String  removeArtistsByIds(Iterable<Integer> ids);
   
   
}
