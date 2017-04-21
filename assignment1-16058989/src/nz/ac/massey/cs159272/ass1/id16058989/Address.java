package nz.ac.massey.cs159272.ass1.id16058989;

public class Address {
	
	private String town;
	private String street;
	private int postcode;
	private int houseno;
	
	public Address() {}
	public Address( int houseno, String street, String town, int postcode ) {
		this.houseno = houseno;
		this.street = street;
		this.town = town;
		this.postcode = postcode;
	}

	/**
	 * @return the town
	 */
	public String getTown() {
		return town;
	}

	/**
	 * @param town the town to set
	 */
	public void setTown(String town) {
		this.town = town;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the postcode
	 */
	public int getPostcode() {
		return postcode;
	}

	/**
	 * @param postcode the postcode to set
	 */
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	/**
	 * @return the houseno
	 */
	public int getHouseno() {
		return houseno;
	}

	/**
	 * @param houseno the houseno to set
	 */
	public void setHouseno(int houseno) {
		this.houseno = houseno;
	}
	
	//====[ Overrides ]===
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + houseno;
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((town == null) ? 0 : town.hashCode());
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
		if (!(obj instanceof Address)) {
			return false;
		}
		Address other = (Address) obj;
		if (houseno != other.houseno) {
			return false;
		}
		if (street == null) {
			if (other.street != null) {
				return false;
			}
		} else if (!street.equals(other.street)) {
			return false;
		}
		if (town == null) {
			if (other.town != null) {
				return false;
			}
		} else if (!town.equals(other.town)) {
			return false;
		}
		return true;
	}
	
	//===
	//====[ Methods ]===
	/**
	 * @return a clone that's an instance of Address.
	 */
	public Address clone() {
		Address address = new Address();
		address.setTown( this.getTown() );
		address.setStreet( this.getStreet() );
		address.setPostcode( this.getPostcode() );
		address.setHouseno( this.getHouseno() );
		return address;
	}
	//===


}
