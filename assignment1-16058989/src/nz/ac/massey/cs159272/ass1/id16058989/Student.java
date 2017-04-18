package nz.ac.massey.cs159272.ass1.id16058989;

import java.util.Date;

public class Student {
	private String lname;
	private String fname;
	private String id;
	private Date dob;
	private Course course;
	private Address address;
	
	public String getLastName() {
		
		return this.lname;
	}
	public String getFirstName() {
		
		return this.fname;
	}
	public String getID() {
		
		return this.id;
	}
	
	public Date getDOB() {
		
		return this.dob;
	}
}
