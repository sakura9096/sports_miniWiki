package sports_miniWiki;

/**
 * store player's information
 * 
 */

import java.util.HashMap;

public class TennisPlayer {
	
	/**
	 * instance variables
	 */
	private String name;
	private String ranking;
	private String ranking_points;
	private HashMap<String, String> tournament_round;
	
	/**
	 * constructor
	 * @param name player's name
	 * @param ranking player's ranking
	 * @param ranking_points player's ranking points
	 * @param tournament_round player's tournament and final round
	 */
	public TennisPlayer(String name, String ranking, String ranking_points, HashMap<String, String> tournament_round) {
		this.name = name;
		this.ranking = ranking;
		this.ranking_points = ranking_points;
		this.tournament_round = tournament_round;
	}

	/**
	 * @return player's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return player's ranking
	 */
	public String getRanking() {
		return ranking;
	}

	/**
	 * @return player's ranking_points
	 */
	public String getRanking_points() {
		return ranking_points;
	}

	/**
	 * @return tournaments player has participated in 2015
	 */
	public HashMap<String, String> getTournament_round() {
		return tournament_round;
	}
	
}
