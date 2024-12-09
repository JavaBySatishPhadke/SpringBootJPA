package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.PersonInfo;

public interface IPersonInfoRepository extends JpaRepository<PersonInfo, Integer> {

	   @Query(value="select  (sysdate-dob)/365.25  from JPA_JODA_DATE_TIME WHERE PID=:id", nativeQuery = true)
	  public   float    calculateAgeByPid(int id);
}
