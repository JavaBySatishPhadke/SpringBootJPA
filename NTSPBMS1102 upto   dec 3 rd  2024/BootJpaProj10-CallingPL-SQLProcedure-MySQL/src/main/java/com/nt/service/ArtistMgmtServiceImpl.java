package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Artist;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service("artistService")
public class ArtistMgmtServiceImpl implements IArtistMgmtService {
	@Autowired
	private  EntityManager  manager;
	
	
	/*CREATE DEFINER=`root`@`localhost` PROCEDURE `P_GET_ARTISTS_BY_FEE`(in start float,in end float)
			BEGIN
			    select  *  from   artist_info where fee>=start and fee<=end;
			END
	*/
	
	@Override
	public List<Artist> showArtitsByFeeRange(double start, double end) throws Exception{
		//create StoredProcedureQuery Object
		 StoredProcedureQuery  query=manager.createStoredProcedureQuery("P_GET_ARTISTS_BY_FEE", Artist.class);
		 //register  the params
		 query.registerStoredProcedureParameter(1, Float.class, ParameterMode.IN);
		 query.registerStoredProcedureParameter(2, Float.class, ParameterMode.IN);
		 //set the Values to IN params
		 query.setParameter(1, start);
		 query.setParameter(2, end);
		 //call the PL/SQL procedure
		 List<Artist> list=query.getResultList();
		 //return the list
		return list;
	}

}
