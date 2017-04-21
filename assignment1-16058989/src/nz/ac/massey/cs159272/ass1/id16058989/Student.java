package nz.ac.massey.cs159272.ass1.id16058989;

import java.util.Date;

public class Student {
	private String lastname;
	private String firstname;
	private String id;
	private Date dob;
	private Course course = new Course();
	private Address address = new Address();


	public Student() {}
	public Student( String id, String lastname, String firstname, Date dob ) {
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.dob = dob;
	}
	
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}


	/**
	 * @param lname the lastname to set
	 */
	public void setLastname(String lname) {
		this.lastname = lname;
	}


	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}


	/**
	 * @param fname the firstname to set
	 */
	public void setFirstname(String fname) {
		this.firstname = fname;
	}


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}


	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}


	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}


	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}


	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}


	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	//===[ Overrides ]===
	//Contract: Student ID

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
	
	//===
	
	//====[ Methods ]===
	
	/**
	 * @return a clone that's an instance of Student (shallow: course, deep: address).
	 */
	public Student clone() {
		Student clone = new Student();
		clone.setFirstname( this.getFirstname() );
		clone.setLastname( this.getLastname() );
		clone.setDob( this.getDob() );
		clone.setId( this.getId() );
		
		clone.setCourse( this.getCourse() );
		clone.setAddress( this.getAddress().clone() );
		return clone;
	}
	//===
	
	
}
