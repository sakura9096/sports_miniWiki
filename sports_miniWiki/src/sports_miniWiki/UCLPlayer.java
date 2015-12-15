package sports_miniWiki;

public class UCLPlayer {
	private String firstName;
	private String lastName;
	private String country;
	private String dateOfBirth;
	private String preferredFoot;
	private String height_cm;
	private String weight_kg;
	private String jerseyNumber;
	private String position;

	public UCLPlayer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPreferredFoot() {
		return preferredFoot;
	}

	public void setPreferredFoot(String preferredFoot) {
		this.preferredFoot = preferredFoot;
	}

	public String getHeight_cm() {
		return height_cm;
	}

	public void setHeight_cm(String height_cm) {
		this.height_cm = height_cm;
	}

	public String getWeight_kg() {
		return weight_kg;
	}

	public void setWeight_kg(String weight_kg) {
		this.weight_kg = weight_kg;
	}

	public String getJerseyNumber() {
		return jerseyNumber;
	}

	public void setJerseyNumber(String jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	

}
