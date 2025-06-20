package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name="emp")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee {
	@Id
	//@SequenceGenerator(name="gen1",sequenceName="EMPNO_SEQ",initialValue=1000,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer empno;
	@NonNull
	private String ename;
	@NonNull
	private Double sal;
	@NonNull
	private Integer deptno;
	@NonNull
	private String job;
	
}
