package nz.ac.massey.cs159272.ass1.id16058989;

import java.util.Date;

public class Student {
	private String lname;
	private String fname;
	private String id;
	private Date dob;
	private Course course = new Course();
	private Address address = new Address();
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Student)) {
			return false;
		}
		Student other = (Student) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	//====[ Getters ]===
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
	//===
	//====[ Setters ]===
	public void setLastName( String lname ) {
		this.lname = lname;
	}
	
	public void setFirstName( String fname ) {
		
		this.fname = fname;
	}
	
	public void setID( String id ) {
		this.id = id;
	}
	
	public void setDOB( Date dob ) {
		this.dob = dob;
	}
	
}
