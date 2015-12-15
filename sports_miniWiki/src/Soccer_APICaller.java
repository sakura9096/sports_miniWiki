import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Soccer_APICaller {
	
	public static void main(String[] args) {
		try {
			new Soccer_APICaller().start();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void start () throws Exception {
		URL url = new URL("http://api.sportradar.us/soccer-t2/eu/teams/8337a86d-8c89-4641-bc39-cd4a4dedfd61/profile.xml?api_key=s7rzcwtqss8bdry9fkmxp88d");
		URLConnection connection = url.openConnection();
		
		Document doc = parseXML(connection.getInputStream());
		NodeList descNodes = doc.getElementsByTagName("player");
		
		for (int i = 0; i < descNodes.getLength(); i++) {
			System.out.println(descNodes.item(i).getAttributes().getNamedItem("first_name"));
		}
	}
	
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
