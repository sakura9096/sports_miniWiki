package sports_miniWiki;

public class TennisLeagueSchedule {
	private String name;
	private String start;
	private String end;
	private String type;
	private String ground;
	private String prize;
	private String currency;

	
	public TennisLeagueSchedule(String name, String start, String end, String type, String ground, String prize, String currency) {
		this.name= name;
		this.start = start;
		this.end = end;
		this.type = type;
		this.ground = ground;
		this.prize = prize;
		this.currency = currency;

	}


	public String getName() {
		return name;
	}


	public String getStart() {
		return start;
	}


	public String getEnd() {
		return end;
	}


	public String getType() {
		return type;
	}


	public String getGround() {
		return ground;
	}


	public String getPrize() {
		return prize;
	}


	public String getCurrency() {
		return currency;
	}

}
