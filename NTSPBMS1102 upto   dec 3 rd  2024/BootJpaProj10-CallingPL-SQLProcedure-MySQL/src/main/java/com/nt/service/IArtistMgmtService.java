package com.nt.service;

import java.util.List;

import com.nt.entity.Artist;

public interface IArtistMgmtService {
  public   List<Artist>  showArtitsByFeeRange(double start,double end)throws Exception;
}
