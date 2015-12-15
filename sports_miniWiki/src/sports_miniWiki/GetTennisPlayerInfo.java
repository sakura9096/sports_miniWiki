package sports_miniWiki;

/**
 * This class call the API for the top10 ATP and top10 WTA player information
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

public class GetTennisPlayerInfo {
	
	/**
	 * instance variables: top10 ATP players and top10 WTA players
	 */
	private ArrayList<TennisPlayer> ATP_top10 = new ArrayList<TennisPlayer> ();
	private ArrayList<TennisPlayer> WTA_top10 = new ArrayList<TennisPlayer> ();
	
	/**
	 * top10 ATP & WTA players' id on sportradar
	 */
	private static final String[] ATP_ID = {"5751bac3-3661-4ae6-8257-481e032fd33b","ecea93ca-ac1d-41a0-ac84-95d09077e343","f469a52f-df2a-40f2-9923-627232fa18e2",
											"28449696-4d2b-45eb-9779-c7f6eef38423","10633607-c6d1-40de-ac39-cc254baf9276","9eeb7f6f-8717-4ca6-afb0-a6b6ad1e2408",
											"c8bde16f-5197-4273-9d6e-7f1d906c2b53","1c27f899-e32f-4430-874f-4bef0a5d4a7c","c7ca8d70-cb43-4ba1-8b32-2f61dca0fd67",
											"b65d1cfe-b3c1-4a7d-b7b9-70cd21f3f140"};
	
	private static final String[] WTA_ID = {"e7560249-17eb-4400-aa23-6004551d60d8","371ccf74-01e4-4e69-86a6-ab43d800c9e7","166d303a-7144-49c5-bb56-4c93614aad04",
											"74ab8026-7b1e-40fc-8b2a-55980f8b544f","e840b962-6333-4940-b83d-d385546eee6e","b150e3cd-539c-4994-846e-1a651fde6300",
											"0b7132dd-1311-4cff-816c-e524e1f9f849","f816edde-f993-4a27-bd45-8f6b16bb9ef7","7d3457c5-0389-46a6-8f5d-bac82e9edf18",
											"575f9ef0-06d0-4f10-951b-ad51abd835d4"};
	
	/**
	 * constructor
	 * get the information of each player and store in an arraylist
	 * @throws Exception 
	 */
	
	public GetTennisPlayerInfo() throws Exception {
		ATP_top10 = getTop10(ATP_ID);
		TimeUnit.SECONDS.sleep(1);
		WTA_top10 = getTop10(WTA_ID);
		TimeUnit.SECONDS.sleep(1);	
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
	private ArrayList<TennisPlayer> getTop10(String[] id) throws Exception {
		
		ArrayList<TennisPlayer> player = new ArrayList<TennisPlayer> ();
		
		for(String element: id) {
			String link = "http://api.sportradar.us/tennis-t1/competitor/" + element + "/summary.xml?api_key=dkkz6m4y76spfj2c99vh5dvm";
			String name = "unknown";
			String ranking = "0";
			String ranking_points = "0";
			
			URL url = new URL(link);
			URLConnection connection = url.openConnection();
			
			Document doc = parseXML(connection.getInputStream());
			
			NodeList competitor = doc.getElementsByTagName("competitor");
			NodeList tournament = doc.getElementsByTagName("tournament");
		
			name = competitor.item(0).getAttributes().getNamedItem("name").getTextContent();
			
			try {
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
			
			TimeUnit.SECONDS.sleep(1);
		}
		
		return player;
	}
		
	/**
	 * parse XML file
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
