package sports_miniWiki;
/**
 * store tournament information
 * @author MHu
 *
 */
public class TennisLeagueSchedule {
	/**
	 * instance variables
	 */
	private String name;
	private String start;
	private String end;
	private String type;
	private String ground;
	private String prize;
	private String currency;

	/**
	 * constructor
	 * @param name tournament's name
	 * @param start tournament's start date
	 * @param end tournament's end date
	 * @param type tournament's type
	 * @param ground tournament's ground
	 * @param prize tournament's prize
	 * @param currency tournament's currency
	 */
	public TennisLeagueSchedule(String name, String start, String end, String type, String ground, String prize, String currency) {
		this.name= name;
		this.start = start;
		this.end = end;
		this.type = type;
		this.ground = ground;
		this.prize = prize;
		this.currency = currency;

	}

	/**
	 * @return tournament's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return tournament's start date
	 */
	public String getStart() {
		return start;
	}

	/**
	 * @return tournament's end date
	 */
	public String getEnd() {
		return end;
	}

	/**
	 * @return tournament's type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return tournament's ground
	 */
	public String getGround() {
		return ground;
	}

	/**
	 * @return tournament's prize
	 */
	public String getPrize() {
		return prize;
	}

	/**
	 * @return tournament's currency
	 */
	public String getCurrency() {
		return currency;
	}

}
