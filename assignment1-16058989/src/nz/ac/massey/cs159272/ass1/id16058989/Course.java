package nz.ac.massey.cs159272.ass1.id16058989;

public class Course {
	private int number;
	private String name;
	
	//====[ Course initialization]===
	public Course() {}
	public Course( int number ) {
		
		this.number = number;
	}
	
	public Course( int number, String name ) {
		
		this.number = number;
		this.name = name;
	}
	//====

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	//====[ Overrides ]===
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
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
		if (!(obj instanceof Course)) {
			return false;
		}
		Course other = (Course) obj;
		if (number != other.number) {
			return false;
		}
		return true;
	}
	//===
	
	//====[ Methods ]===
	/*
	/**
	 * @return a clone that's an instance of course.
	 /
	public Course clone() {
		Course clone = new Course();
		clone.setName( this.getName() );
		clone.setNumber( this.getNumber() );;
		return clone;
	}*/
	//===


	
}
