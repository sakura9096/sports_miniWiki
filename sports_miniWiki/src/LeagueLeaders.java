import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class LeagueLeaders {
	
	public static void main(String[] args) throws Exception {
        
		URL myUrl = new URL("http://api.sportradar.us/nba-t3/seasontd/2015/REG/leaders.json?api_key=79jjegg7pncfakwtjkta25y2");
        URLConnection myConnection = myUrl.openConnection();
        
        JSONObject js;
        
        String results;

        BufferedReader in = new BufferedReader(
                            	new InputStreamReader(
                                myConnection.getInputStream()));
        
        while ((results = in.readLine()) != null) {
        	//System.out.println(results);
        	js = new JSONObject(results);
        	JSONArray categories = js.getJSONArray("categories");
        	for (int i = 0; i < categories.length(); i++) {
        		String name = categories.getJSONObject(i).getString("name");
        		//System.out.println(name); 
        		
        		switch (name) {
        		
        			case "points":
        				System.out.println(name);
        				JSONArray pts_leaders = categories.getJSONObject(i).getJSONArray("ranks");
        				for (int j = 0; j < pts_leaders.length(); j++) {
        					int leader_rank = pts_leaders.getJSONObject(j).getInt("rank");
        					String leaders = pts_leaders.getJSONObject(j).getJSONObject("player").getString("full_name");
        					
        					JSONArray leader_team = pts_leaders.getJSONObject(j).getJSONArray("teams");
        					String market = leader_team.getJSONObject(0).getString("market");
        					String team = leader_team.getJSONObject(0).getString("name");
        					
        					double stats = pts_leaders.getJSONObject(j).getJSONObject("average").getDouble(name);
        					
        					System.out.println(leader_rank + " " + leaders + " " + stats +" (" + market + " " + team + ")");        					
        				}
        				System.out.println();
        				break;
        				
        			case "assists":
        				System.out.println(name);
        				JSONArray assist_leaders = categories.getJSONObject(i).getJSONArray("ranks");
        				for (int j = 0; j < assist_leaders.length(); j++) {
        					int leader_rank = assist_leaders.getJSONObject(j).getInt("rank");
        					String leaders = assist_leaders.getJSONObject(j).getJSONObject("player").getString("full_name");
        					
        					JSONArray leader_team = assist_leaders.getJSONObject(j).getJSONArray("teams");
        					String market = leader_team.getJSONObject(0).getString("market");
        					String team = leader_team.getJSONObject(0).getString("name");
        					
        					double stats = assist_leaders.getJSONObject(j).getJSONObject("average").getDouble(name);
        					
        					System.out.println(leader_rank + " " + leaders + " " + stats +" (" + market + " " + team + ")");      					
        				}
        				System.out.println();
        				break;       				
        			
        			case "three_points_made":
        				System.out.println(name);
        				JSONArray three_pt_leaders = categories.getJSONObject(i).getJSONArray("ranks");
        				for (int j = 0; j < three_pt_leaders.length(); j++) {
        					int leader_rank = three_pt_leaders.getJSONObject(j).getInt("rank");
        					String leaders = three_pt_leaders.getJSONObject(j).getJSONObject("player").getString("full_name");
        					
        					JSONArray leader_team = three_pt_leaders.getJSONObject(j).getJSONArray("teams");
        					String market = leader_team.getJSONObject(0).getString("market");
        					String team = leader_team.getJSONObject(0).getString("name");
        					
        					double stats = three_pt_leaders.getJSONObject(j).getJSONObject("average").getDouble(name);
        					
        					System.out.println(leader_rank + " " + leaders + " " + stats +" (" + market + " " + team + ")");      					    					
        				}
        				System.out.println();
        				break;
        			
        			case "rebounds":
        				System.out.println(name);
        				JSONArray reb_leaders = categories.getJSONObject(i).getJSONArray("ranks");
        				for (int j = 0; j < reb_leaders.length(); j++) {
        					int leader_rank = reb_leaders.getJSONObject(j).getInt("rank");
        					String leaders = reb_leaders.getJSONObject(j).getJSONObject("player").getString("full_name");
        					
        					JSONArray leader_team = reb_leaders.getJSONObject(j).getJSONArray("teams");
        					String market = leader_team.getJSONObject(0).getString("market");
        					String team = leader_team.getJSONObject(0).getString("name");
        					
        					double stats = reb_leaders.getJSONObject(j).getJSONObject("average").getDouble(name);
        					
        					System.out.println(leader_rank + " " + leaders + " " + stats +" (" + market + " " + team + ")");        					
        				}
        				System.out.println();
        				break;
        				
        			case "free_throws_made":
        				System.out.println(name);
        				JSONArray free_thr_leaders = categories.getJSONObject(i).getJSONArray("ranks");
        				for (int j = 0; j < free_thr_leaders.length(); j++) {
        					int leader_rank = free_thr_leaders.getJSONObject(j).getInt("rank");
        					String leaders = free_thr_leaders.getJSONObject(j).getJSONObject("player").getString("full_name");
        					
        					JSONArray leader_team = free_thr_leaders.getJSONObject(j).getJSONArray("teams");
        					String market = leader_team.getJSONObject(0).getString("market");
        					String team = leader_team.getJSONObject(0).getString("name");
        					
        					double stats = free_thr_leaders.getJSONObject(j).getJSONObject("average").getDouble(name);
        					
        					System.out.println(leader_rank + " " + leaders + " " + stats +" (" + market + " " + team + ")");  					      					
        				}
        				System.out.println();
        				break;
        				
        			case "blocks":
        				System.out.println(name);
        				JSONArray blocks_leaders = categories.getJSONObject(i).getJSONArray("ranks");
        				for (int j = 0; j < blocks_leaders.length(); j++) {
        					int leader_rank = blocks_leaders.getJSONObject(j).getInt("rank");
        					String leaders = blocks_leaders.getJSONObject(j).getJSONObject("player").getString("full_name");
        					
        					JSONArray leader_team = blocks_leaders.getJSONObject(j).getJSONArray("teams");
        					String market = leader_team.getJSONObject(0).getString("market");
        					String team = leader_team.getJSONObject(0).getString("name");
        					
        					double stats = blocks_leaders.getJSONObject(j).getJSONObject("average").getDouble(name);
        					
        					System.out.println(leader_rank + " " + leaders + " " + stats +" (" + market + " " + team + ")");       					
        				}
        				System.out.println();
        				break;
        			
        			case "steals":
        				System.out.println(name);
        				JSONArray steal_leaders = categories.getJSONObject(i).getJSONArray("ranks");
        				for (int j = 0; j < steal_leaders.length(); j++) {
        					int leader_rank = steal_leaders.getJSONObject(j).getInt("rank");
        					String leaders = steal_leaders.getJSONObject(j).getJSONObject("player").getString("full_name");
        					
        					JSONArray leader_team = steal_leaders.getJSONObject(j).getJSONArray("teams");
        					String market = leader_team.getJSONObject(0).getString("market");
        					String team = leader_team.getJSONObject(0).getString("name");
        					
        					double stats = steal_leaders.getJSONObject(j).getJSONObject("average").getDouble(name);
        					
        					System.out.println(leader_rank + " " + leaders + " " + stats +" (" + market + " " + team + ")");       					    					
        				}
        				System.out.println();
        				break;
        		}
        	}
        } 
    }
}
