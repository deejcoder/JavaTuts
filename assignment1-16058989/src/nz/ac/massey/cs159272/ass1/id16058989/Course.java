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
	//====[ Getter & Setter for number ]===
	public int getNumber() {
		return this.number;
	}
	
	public void setNumber( int number ) {
		
		this.number = number;
	}
	//====
	//====[ Getter & Setter for name ]===
	public String getName() {
		
		return this.name;
	}
	public void setName( String name ) {
		this.name = name;
	}
	//===
	
}
