package sports_miniWiki;

/**
 * This class constructs a single NBA leader profile.
 * @author yuezhang
 *
 */
public class NBALeaders_Individual {
	
	private int rank;
	private String name;
	private String market;
	private String team;
	private double stats;
	private String category;
	
	/**
	 * The constructor
	 * @param rank the rank of the player in a specific category
	 * @param name the name of the player
	 * @param market the market of the player's team
	 * @param team the player's team
	 * @param stats the player's statistics in the specified category
	 * @param category the category in which the player is a leader
	 */
	public NBALeaders_Individual(int rank, String name, String market, String team, double stats, String category) {
		this.rank = rank;
		this.name = name;
		this.market = market;
		this.team = team;
		this.stats = stats;
		this.category = category;
	}
	
	@Override
	public String toString() {
		String res = rank + ": " + name + " -- " + stats + " " + category + " ( " + market + " " + team + " ) ";
		return res;
	}

}
