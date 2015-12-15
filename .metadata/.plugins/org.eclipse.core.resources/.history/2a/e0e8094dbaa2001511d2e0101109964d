import java.net.*;
import java.io.*;
import org.json.*;

public class APICaller {
	
    public static void main(String[] args) throws Exception {
        URL myUrl = new URL("http://api.sportradar.us/nba-t3/teams/583ec825-fb46-11e1-82cb-f4ce4684ea4c/profile.json?api_key=79jjegg7pncfakwtjkta25y2");
        URLConnection myConnection = myUrl.openConnection();
        
        JSONObject js;
        
        String results;

        BufferedReader in = new BufferedReader(
                            	new InputStreamReader(
                                myConnection.getInputStream()));
        
        while ((results = in.readLine()) != null) {
        	//System.out.println(results);
        	js = new JSONObject(results);
        	JSONArray players = js.getJSONArray("players");
        	for (int i = 0; i < players.length(); i++) {
        		String name = players.getJSONObject(i).getString("full_name");
        		System.out.println(name);
        	}
        } 
    }
}
