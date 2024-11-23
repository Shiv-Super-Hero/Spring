package com.shivaji.dto;

import java.io.File;

public class Employee {
	private int eno;
	private String ename;
	private File emp_Image;
	private File emp_Resume;
	
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public File getEmp_Image() {
		return emp_Image;
	}
	public void setEmp_Image(File emp_Image) {
		this.emp_Image = emp_Image;
	}
	public File getEmp_Resume() {
		return emp_Resume;
	}
	public void setEmp_Resume(File emp_Resume) {
		this.emp_Resume = emp_Resume;
	}
}
