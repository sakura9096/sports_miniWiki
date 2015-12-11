package sports_miniWiki;

import java.util.ArrayList;

public class NBATeam {
	
	private String name; 
	private String market;
	public ArrayList<NBAPlayer> members;
	
	public NBATeam(String name, String market) {
		
		this.name = name; 
		this.market = market;
		members = new ArrayList<NBAPlayer>();
	}
	
	public String toString() {
		StringBuilder res = new StringBuilder(market + " " + name + "\n" + "\n");
		for (NBAPlayer p: members) {
			String player = p.toString();
			res.append(player + "\n");
		}
		String resStr = res.toString();
		return resStr;
	}

}
