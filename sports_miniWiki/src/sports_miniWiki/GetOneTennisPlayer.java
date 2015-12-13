package sports_miniWiki;
/**
 * This class will only call the API for only one player, by changing the API link
 */
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GetOneTennisPlayer {
	
	/**
	 * instance variables: top10 ATP players and top10 WTA players
	 */
	private ArrayList<TennisPlayer> ATP_top10 = new ArrayList<TennisPlayer> ();
	private ArrayList<TennisPlayer> WTA_top10 = new ArrayList<TennisPlayer> ();
	
	
	/**
	 * constructor
	 * get the information of each player and store in an arraylist
	 * @throws Exception 
	 */
	public GetOneTennisPlayer() throws Exception {
		ATP_top10 = getTop10();
		TimeUnit.SECONDS.sleep(1);
		//WTA_top10 = getTop10();	
	}
	

	/**
	 * @return an arraylist with ATP top 10 players' information
	 */
	public ArrayList<TennisPlayer> getTop10ATPplayers() {
		return ATP_top10;
	}
	
	/**
	 * @return an arraylist with WTA top 10 players' information
	 */
	public ArrayList<TennisPlayer> getTop10WTAplayers() {
		return WTA_top10;
	}
	
	/**
	 * get the player's information by calling the API
	 * @param id	competitor's id
	 * @param player	arraylist used to store competitor's information
	 * @throws Exception
	 */
	private ArrayList<TennisPlayer> getTop10() throws Exception {
		
		ArrayList<TennisPlayer> player = new ArrayList<TennisPlayer> ();
		
		String link = "http://api.sportradar.us/tennis-t1/competitor/f469a52f-df2a-40f2-9923-627232fa18e2/summary.xml?api_key=hbnefvjkssda5f3xa4tctnfd";
		String name = "unknown";
		String ranking = "0";
		String ranking_points = "0";
			
		URL url = new URL(link);
		URLConnection connection = url.openConnection();
		
		Document doc = parseXML(connection.getInputStream());
			
		NodeList competitor = doc.getElementsByTagName("competitor");
		NodeList tournament = doc.getElementsByTagName("tournament");
		
		try {
			name = competitor.item(0).getAttributes().getNamedItem("name").getTextContent();
			ranking = competitor.item(0).getAttributes().getNamedItem("ranking").getTextContent();
			ranking_points = competitor.item(0).getAttributes().getNamedItem("ranking_points").getTextContent();
		} catch (Exception e) {}
		
		HashMap<String, String> tour_round = new HashMap<String, String> ();
			
		for (int i = 0; i < tournament.getLength(); i++) {
			String tour = tournament.item(i).getAttributes().getNamedItem("name").getTextContent();
			Node node  = tournament.item(i).getLastChild();
			String round = "Qualification round";
			
			while (node != null && node.getNodeType() != Node.ELEMENT_NODE) {
		        node = node.getPreviousSibling();
		    }
				
			try{
				round = node.getAttributes().getNamedItem("round").getTextContent(); 
			} catch(Exception e) {}
				
			tour_round.put(tour, round);
		}
			
		TennisPlayer atp_player = new TennisPlayer(name, ranking, ranking_points, tour_round);
		player.add(atp_player);
		
		return player;
	}
		
	/**
	 * parse the XML file
	 * @param stream
	 * @return
	 * @throws Exception
	 */
	private Document parseXML(InputStream stream) throws Exception {
		DocumentBuilderFactory objDocumentBuilderFactory = null;
        DocumentBuilder objDocumentBuilder = null;
        Document doc = null;
        try
        {
            objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
            objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();

            doc = objDocumentBuilder.parse(stream);
        }
        catch(Exception ex)
        {
            throw ex;
        }       

        return doc;
		
	}
	
}
