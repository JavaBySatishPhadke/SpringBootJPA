//LoginMgmtServiceImpl.java
package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service("loginSErvice")
public class LoginMgmtServiceImpl implements ILoginMgmtService {
	@Autowired
	private   EntityManager  manager;
	
	/*CREATE DEFINER=`root`@`localhost` PROCEDURE `p_authentication`(in uname varchar(20),
	        in pwd  varchar(20),
	        out result varchar(20))
	BEGIN
	declare  cnt  int(2);
	
	select count(*)  into cnt from login_info where username=uname  and password=pwd;
	
	if(cnt<>0) then
	set result="Valid  credentials";
	else
	set result="InValid Credentials";
	end if;
	END
	*/
	
	@Override
	public String doLogin(String user, String pwd) {
		//  create SToredPRocedureQuery object
		 StoredProcedureQuery  query=manager.createStoredProcedureQuery("p_authentication");
		//register the params
		 query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
		 query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
		 query.registerStoredProcedureParameter(3,String.class,ParameterMode.OUT);
		 //set Param values
		 query.setParameter(1, user);
		 query.setParameter(2, pwd);
		 //Call the PL/SQL procedure
		 String result=(String) query.getOutputParameterValue(3);
		return result;
	}

}
