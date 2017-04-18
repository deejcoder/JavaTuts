package nz.ac.massey.cs159272.ass1.id16058989;

public class Address {
	private String town;
	private String street;
	private int postcode;
	private int houseno;
	
	public Address() {}
	
	//====[ Getters ]===
	public String getTown() {
		return this.town;
	}
	public String getStreet() {
		return this.street;
	}
	public int getPost() {
		return this.postcode;
	}
	public int getNumber() {
		
		return this.houseno;
	}
	//===
	//====[ Setters ]
	public void setTown( String town ) {
		
		this.town = town;
	}
	public void setStreet( String street ) {
		
		this.street = street;
	}
	public void setPost( int post ) {
		this.postcode = post;
	}
	public void setNumber( int number ) {
		this.houseno = number;
	}
	//===
}
