package com.JPA.dataModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String Name, RollNo, Department, Result;
	private Float Pointer;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getRollNo() {
		return RollNo;
	}

	public void setRollNo(String rollNo) {
		RollNo = rollNo;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getResult() {
		return Result;
	}

	public void setResult(String result) {
		Result = result;
	}

	public Float getPointer() {
		return Pointer;
	}

	public void setPointer(Float pointer) {
		Pointer = pointer;
	}

	@Override
	public String toString() {
		return "Student [Name=" + Name + ", RollNo=" + RollNo + ", Department=" + Department + ", Result=" + Result
				+ ", Pointer=" + Pointer + "]";
	}

//	public Student(String name, String rollNo, String department, String result, String pointer) {
//		super();
//		Name = name;
//		RollNo = rollNo;
//		Department = department;
//		Result = result;
//		Pointer = pointer;
//	}

}