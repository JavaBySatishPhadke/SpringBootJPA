package com.nt.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name="JPA_JODA_DATE_TIME")
@RequiredArgsConstructor
@NoArgsConstructor
public class PersonInfo {
	@Id
	@GeneratedValue
	private Integer pid;
	@NonNull
	@Column(length = 30)
	private  String  pname;
	@NonNull
	@Column(length = 30)
	private  String  paddrs;
	@NonNull
	private  LocalDate  dob;
	@NonNull
	private  LocalTime  tob;
	@NonNull
	private  LocalDateTime doj;
	
	

}
