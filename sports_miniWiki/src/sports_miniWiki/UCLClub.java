package sports_miniWiki;

import java.util.ArrayList;

public class UCLClub {
	private String name;
	private String alias;
	private String teamCountry;
	private String managerFN;
	private String managerLN;
	private String managerCountry;
	private String managerBirthDate;
	private ArrayList<UCLPlayer> roster;
	

	public UCLClub(String teamName) {
		this.name = teamName;
		roster = new ArrayList<UCLPlayer>();
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAlias() {
		return alias;
	}


	public void setAlias(String alias) {
		this.alias = alias;
	}


	public String getTeamCountry() {
		return teamCountry;
	}


	public void setTeamCountry(String teamCountry) {
		this.teamCountry = teamCountry;
	}


	public String getManagerFN() {
		return managerFN;
	}


	public void setManagerFN(String managerFN) {
		this.managerFN = managerFN;
	}


	public String getManagerLN() {
		return managerLN;
	}


	public void setManagerLN(String managerLN) {
		this.managerLN = managerLN;
	}


	public String getManagerCountry() {
		return managerCountry;
	}


	public void setManagerCountry(String managerCountry) {
		this.managerCountry = managerCountry;
	}


	public String getManagerBirthDate() {
		return managerBirthDate;
	}


	public void setManagerBirthDate(String managerBirthDate) {
		this.managerBirthDate = managerBirthDate;
	}


	public ArrayList<UCLPlayer> getRoster() {
		return roster;
	}


	public void setRoster(ArrayList<UCLPlayer> roster) {
		this.roster = roster;
	}
	
	

}
