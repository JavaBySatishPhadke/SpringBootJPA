package com.nt.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="JPA_OTM_CUSTOMER")
@Setter
@Getter
@RequiredArgsConstructor
//@NoArgsConstructor
public class Customer {
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "CNO_SEQ",initialValue = 1000 ,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private  Integer  cno;
	
	
	public  Customer() {
		System.out.println("Customer:: 0-param constuctor:::"+this.getClass());
	}
	
	@NonNull
	@Column(length = 20)
	private  String  cname;
	@NonNull
	@Column(length = 20)
	private   String  caddrs;
	
	//for building One To Many Association
	@OneToMany(targetEntity = PhoneNumber.class , 
			                      orphanRemoval = true,fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "cust")
	private Set<PhoneNumber>  phonesInfo;
	
	
	//toString()
	@Override
	public String toString() {
		return "Customer [cno=" + cno + ", cname=" + cname + ", caddrs=" + caddrs + "]";
	} 

}
