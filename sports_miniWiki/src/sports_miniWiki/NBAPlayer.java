package sports_miniWiki;

public class NBAPlayer {
	
	private String player;
	private String position;
	private String number;
	private int height;
	private int weight;
	private String experience;
	
	public NBAPlayer(String player, String position, String number, int height, int weight, String experience) {
		this.player = player;
		this.position = position;
		this.number = number;
		this.height = height;
		this.weight = weight;
		this.experience = experience;
		
	}
	public String toString() {
		String res = number + " -- " + player + ": " + position + "  height: " 
					+ height + "  weight: " + weight + "  experience: " + experience + "years" + "\n";
		return res;
	}

}
