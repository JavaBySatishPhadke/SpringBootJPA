package com.sp.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Table(name = "emp")
@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Employee {
	
	//@SequenceGenerator(name = "gen1", sequenceName = "emp_eno_seq", initialValue = 1000, allocationSize = 1)
	//@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empno;
	@NonNull
	@Column(length = 30)
	private String ename;
	@NonNull
	@Column(length = 30)
	private String job;
	@NonNull
	private Double sal;
	@Nonnull
	private Integer deptno=20;
}
