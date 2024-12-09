//PhoneNumber.java
package com.nt.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="JPA_OTM_PHONES")
@Setter
@Getter
//@NoArgsConstructor
@RequiredArgsConstructor
public class PhoneNumber {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Integer  regNo;
	@NonNull
	private  Long mobileNo;
	@NonNull
	@Column(length = 30)
	private  String provider;
	@Column(length = 30)
	@NonNull
	private  String  numberType;
	
	public PhoneNumber() {
		System.out.println("PhoneNumber:: 0-param constructor :::"+this.getClass());
	}
	
	
	//For Building Many To One Association
	@ManyToOne(targetEntity = Customer.class,fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
	@JoinColumn(name = "CUSTOMER_ID",referencedColumnName = "CNO")
	private  Customer  cust;

	
	//toString()  (alt+shift+s,s)
	@Override
	public String toString() {
		return "PhoneNumber [regNo=" + regNo + ", mobileNo=" + mobileNo + ", provider=" + provider + ", numberType="
				+ numberType + "]";
	}
	
}
