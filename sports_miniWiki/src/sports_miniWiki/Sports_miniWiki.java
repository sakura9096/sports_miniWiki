package sports_miniWiki;

/**
 * This is the main script for this project
 */

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.CardLayout;

import javax.swing.JComboBox;

import java.awt.Color;
import javax.swing.SwingConstants;

public class Sports_miniWiki {

	private JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					Sports_miniWiki window = new Sports_miniWiki();
					window.frame.setVisible(true);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public Sports_miniWiki() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		frame = new JFrame("Sports miniWiki");
		frame.setBounds(100, 100, 1280, 740);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		final JPanel Main_window = new JPanel();
		frame.getContentPane().add(Main_window, "name_75543461813159");
		Main_window.setLayout(null);
		Main_window.setVisible(true);
		
		
		/*
		 * This is the UCL page.
		 */
		JPanel UCLLast16Draw = new JPanel();
		frame.getContentPane().add(UCLLast16Draw, "name_2115637513029884");
		UCLLast16Draw.setLayout(null);
		
		UCLClubAPICaller clubProfile = new UCLClubAPICaller();
		
		JPanel UCLTeamProfile = new JPanel();
		frame.getContentPane().add(UCLTeamProfile, "name_2115637513029884");
		UCLTeamProfile.setLayout(null);
		
		JTextArea textAreaTeamInfo = new JTextArea();
		textAreaTeamInfo.setVisible(true);
		textAreaTeamInfo.setEditable(false);
		textAreaTeamInfo.setFont(new Font("Serif", Font.PLAIN, 25));
		JScrollPane UCLPlayerInfo_scroll = new JScrollPane(textAreaTeamInfo);
		UCLPlayerInfo_scroll.setBounds(600, 66, 600, 612);
		UCLTeamProfile.add(UCLPlayerInfo_scroll);
		
		/**
		 * FC Barcelona
		 */
		JLabel lblBarcelona = new JLabel("Barcelona");
		lblBarcelona.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/UCLTeam/Barcelona.jpg")));
		lblBarcelona.setBounds(80, 80, 80, 80);
		UCLTeamProfile.add(lblBarcelona);
		
		JLabel lblPSG = new JLabel("PSG");
		lblPSG.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/UCLTeam/PSG.jpg")));
		lblPSG.setBounds(300, 80, 80, 80);
		UCLTeamProfile.add(lblPSG);
		
		JLabel lblBMunich = new JLabel("BMunich");
		lblBMunich.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/UCLTeam/BayernMunich.jpg")));
		lblBMunich.setBounds(80, 240, 80, 80);
		UCLTeamProfile.add(lblBMunich);
		
		JLabel lblJuventus = new JLabel("Juventus");
		lblJuventus.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/UCLTeam/Juventus.jpg")));
		lblJuventus.setBounds(300, 240, 80, 80);
		UCLTeamProfile.add(lblJuventus);
		
		JLabel lblRealMadrid = new JLabel("RealMadrid");
		lblRealMadrid.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/UCLTeam/RealMadrid.jpg")));
		lblRealMadrid.setBounds(80, 400, 80, 80);
		UCLTeamProfile.add(lblRealMadrid);
		
		JLabel lblChelsea = new JLabel("Chelsea");
		lblChelsea.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/UCLTeam/Chelsea.jpg")));
		lblChelsea.setBounds(300, 400, 80, 80);
		UCLTeamProfile.add(lblChelsea);
		
		JLabel lblArsenal = new JLabel("Arsenal");
		lblArsenal.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/UCLTeam/Arsenal.jpg")));
		lblArsenal.setBounds(80, 560, 80, 80);
		UCLTeamProfile.add(lblArsenal);
		
		JLabel lblManCity = new JLabel("ManCity");
		lblManCity.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/UCLTeam/ManCity.jpg")));
		lblManCity.setBounds(300, 560, 80, 80);
		UCLTeamProfile.add(lblManCity);
		
		JButton btnFcBarcelona = new JButton("FC Barcelona");
		btnFcBarcelona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UCLClub club = clubProfile.getClubs().get("FCBarcelona");
				String name = club.getName();
				String alias = club.getAlias();
				String country = club.getTeamCountry();
				String managerFN = club.getManagerFN();
				String managerLN = club.getManagerLN();
				String managerCountry = club.getManagerCountry();
				String managerBirthdate = club.getManagerBirthDate();
				ArrayList<UCLPlayer> playerInfo = club.getRoster();
				
				textAreaTeamInfo.setText("Name: " + name + " Alias: " + alias + " Country: " + country + "\n\n" + "Manager:\n" + "Name: " + managerFN + " " + managerLN + "\n" + "Country: " + managerCountry + "\n" + "Date of Birth: " + managerBirthdate + "\n\n" + "Roster:\n");
				
				for (UCLPlayer player : playerInfo) {
					String firstName = player.getFirstName();
					String lastName = player.getLastName();
					String playerCountry = player.getCountry();
					String dateOfBirth = player.getDateOfBirth();
					String preferredFoot = player.getPreferredFoot();
					String height_cm = player.getHeight_cm();
					String weight_kg = player.getWeight_kg();
					String jerseyNumber = player.getJerseyNumber();
					String position = player.getPosition();
					textAreaTeamInfo.append("Name: " + firstName + " " + lastName + "\n");
					textAreaTeamInfo.append("Country: " + playerCountry + "\n");
					textAreaTeamInfo.append("DOB: " + dateOfBirth + "\n");
					textAreaTeamInfo.append("Preferred Foot: " + preferredFoot + "\n");
					textAreaTeamInfo.append("height(cm): " + height_cm + "\n");
					textAreaTeamInfo.append("weight(kg): " + weight_kg + "\n");
					textAreaTeamInfo.append("Jersey Number: " + jerseyNumber + "\n");
					textAreaTeamInfo.append("Position: " + position + "\n\n");
				}
			}
		});
		btnFcBarcelona.setBounds(64, 172, 117, 29);
		UCLTeamProfile.add(btnFcBarcelona);
		
		JButton btnParisSaintgermen = new JButton("Paris Saint-German");
		btnParisSaintgermen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UCLClub club = clubProfile.getClubs().get("Paris Saint-German");
				String name = club.getName();
				String alias = club.getAlias();
				String country = club.getTeamCountry();
				String managerFN = club.getManagerFN();
				String managerLN = club.getManagerLN();
				String managerCountry = club.getManagerCountry();
				String managerBirthdate = club.getManagerBirthDate();
				ArrayList<UCLPlayer> playerInfo = club.getRoster();
				
				textAreaTeamInfo.setText("Name: " + name + " Alias: " + alias + " Country: " + country + "\n\n" + "Manager:\n" + "Name: " + managerFN + " " + managerLN + "\n" + "Country: " + managerCountry + "\n" + "Date of Birth: " + managerBirthdate + "\n\n" + "Roster:\n");
				
				for (UCLPlayer player : playerInfo) {
					String firstName = player.getFirstName();
					String lastName = player.getLastName();
					String playerCountry = player.getCountry();
					String dateOfBirth = player.getDateOfBirth();
					String preferredFoot = player.getPreferredFoot();
					String height_cm = player.getHeight_cm();
					String weight_kg = player.getWeight_kg();
					String jerseyNumber = player.getJerseyNumber();
					String position = player.getPosition();
					textAreaTeamInfo.append("Name: " + firstName + " " + lastName + "\n");
					textAreaTeamInfo.append("Country: " + playerCountry + "\n");
					textAreaTeamInfo.append("DOB: " + dateOfBirth + "\n");
					textAreaTeamInfo.append("Preferred Foot: " + preferredFoot + "\n");
					textAreaTeamInfo.append("height(cm): " + height_cm + "\n");
					textAreaTeamInfo.append("weight(kg): " + weight_kg + "\n");
					textAreaTeamInfo.append("Jersey Number: " + jerseyNumber + "\n");
					textAreaTeamInfo.append("Position: " + position + "\n\n");
				}
			}
		});
		btnParisSaintgermen.setBounds(268, 172, 150, 30);
		UCLTeamProfile.add(btnParisSaintgermen);
		
		JButton btnBayernMunich = new JButton("Bayern Munich");
		btnBayernMunich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UCLClub club = clubProfile.getClubs().get("Bayern Munich");
				String name = club.getName();
				String alias = club.getAlias();
				String country = club.getTeamCountry();
				String managerFN = club.getManagerFN();
				String managerLN = club.getManagerLN();
				String managerCountry = club.getManagerCountry();
				String managerBirthdate = club.getManagerBirthDate();
				ArrayList<UCLPlayer> playerInfo = club.getRoster();
				
				textAreaTeamInfo.setText("Name: " + name + " Alias: " + alias + " Country: " + country + "\n\n" + "Manager:\n" + "Name: " + managerFN + " " + managerLN + "\n" + "Country: " + managerCountry + "\n" + "Date of Birth: " + managerBirthdate + "\n\n" + "Roster:\n");
				
				for (UCLPlayer player : playerInfo) {
					String firstName = player.getFirstName();
					String lastName = player.getLastName();
					String playerCountry = player.getCountry();
					String dateOfBirth = player.getDateOfBirth();
					String preferredFoot = player.getPreferredFoot();
					String height_cm = player.getHeight_cm();
					String weight_kg = player.getWeight_kg();
					String jerseyNumber = player.getJerseyNumber();
					String position = player.getPosition();
					textAreaTeamInfo.append("Name: " + firstName + " " + lastName + "\n");
					textAreaTeamInfo.append("Country: " + playerCountry + "\n");
					textAreaTeamInfo.append("DOB: " + dateOfBirth + "\n");
					textAreaTeamInfo.append("Preferred Foot: " + preferredFoot + "\n");
					textAreaTeamInfo.append("height(cm): " + height_cm + "\n");
					textAreaTeamInfo.append("weight(kg): " + weight_kg + "\n");
					textAreaTeamInfo.append("Jersey Number: " + jerseyNumber + "\n");
					textAreaTeamInfo.append("Position: " + position + "\n\n");
				}
			}
		});
		btnBayernMunich.setBounds(64, 332, 117, 29);
		UCLTeamProfile.add(btnBayernMunich);
		
		JButton btnJuventus = new JButton("Juventus");
		btnJuventus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UCLClub club = clubProfile.getClubs().get("Juventus");
				String name = club.getName();
				String alias = club.getAlias();
				String country = club.getTeamCountry();
				String managerFN = club.getManagerFN();
				String managerLN = club.getManagerLN();
				String managerCountry = club.getManagerCountry();
				String managerBirthdate = club.getManagerBirthDate();
				ArrayList<UCLPlayer> playerInfo = club.getRoster();
				
				textAreaTeamInfo.setText("Name: " + name + " Alias: " + alias + " Country: " + country + "\n\n" + "Manager:\n" + "Name: " + managerFN + " " + managerLN + "\n" + "Country: " + managerCountry + "\n" + "Date of Birth: " + managerBirthdate + "\n\n" + "Roster:\n");
				
				for (UCLPlayer player : playerInfo) {
					String firstName = player.getFirstName();
					String lastName = player.getLastName();
					String playerCountry = player.getCountry();
					String dateOfBirth = player.getDateOfBirth();
					String preferredFoot = player.getPreferredFoot();
					String height_cm = player.getHeight_cm();
					String weight_kg = player.getWeight_kg();
					String jerseyNumber = player.getJerseyNumber();
					String position = player.getPosition();
					textAreaTeamInfo.append("Name: " + firstName + " " + lastName + "\n");
					textAreaTeamInfo.append("Country: " + playerCountry + "\n");
					textAreaTeamInfo.append("DOB: " + dateOfBirth + "\n");
					textAreaTeamInfo.append("Preferred Foot: " + preferredFoot + "\n");
					textAreaTeamInfo.append("height(cm): " + height_cm + "\n");
					textAreaTeamInfo.append("weight(kg): " + weight_kg + "\n");
					textAreaTeamInfo.append("Jersey Number: " + jerseyNumber + "\n");
					textAreaTeamInfo.append("Position: " + position + "\n\n");
				}
			}
		});
		btnJuventus.setBounds(288, 332, 117, 29);
		UCLTeamProfile.add(btnJuventus);
		
		JButton btnRealMadrid = new JButton("Real Madrid");
		btnRealMadrid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UCLClub club = clubProfile.getClubs().get("Real Madrid");
				String name = club.getName();
				String alias = club.getAlias();
				String country = club.getTeamCountry();
				String managerFN = club.getManagerFN();
				String managerLN = club.getManagerLN();
				String managerCountry = club.getManagerCountry();
				String managerBirthdate = club.getManagerBirthDate();
				ArrayList<UCLPlayer> playerInfo = club.getRoster();
				
				textAreaTeamInfo.setText("Name: " + name + " Alias: " + alias + " Country: " + country + "\n\n" + "Manager:\n" + "Name: " + managerFN + " " + managerLN + "\n" + "Country: " + managerCountry + "\n" + "Date of Birth: " + managerBirthdate + "\n\n" + "Roster:\n");
				
				for (UCLPlayer player : playerInfo) {
					String firstName = player.getFirstName();
					String lastName = player.getLastName();
					String playerCountry = player.getCountry();
					String dateOfBirth = player.getDateOfBirth();
					String preferredFoot = player.getPreferredFoot();
					String height_cm = player.getHeight_cm();
					String weight_kg = player.getWeight_kg();
					String jerseyNumber = player.getJerseyNumber();
					String position = player.getPosition();
					textAreaTeamInfo.append("Name: " + firstName + " " + lastName + "\n");
					textAreaTeamInfo.append("Country: " + playerCountry + "\n");
					textAreaTeamInfo.append("DOB: " + dateOfBirth + "\n");
					textAreaTeamInfo.append("Preferred Foot: " + preferredFoot + "\n");
					textAreaTeamInfo.append("height(cm): " + height_cm + "\n");
					textAreaTeamInfo.append("weight(kg): " + weight_kg + "\n");
					textAreaTeamInfo.append("Jersey Number: " + jerseyNumber + "\n");
					textAreaTeamInfo.append("Position: " + position + "\n\n");
				}
			}
		});
		btnRealMadrid.setBounds(64, 492, 117, 29);
		UCLTeamProfile.add(btnRealMadrid);
		
		JButton btnChelsea = new JButton("Chelsea");
		btnChelsea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UCLClub club = clubProfile.getClubs().get("Chelsea");
				String name = club.getName();
				String alias = club.getAlias();
				String country = club.getTeamCountry();
				String managerFN = club.getManagerFN();
				String managerLN = club.getManagerLN();
				String managerCountry = club.getManagerCountry();
				String managerBirthdate = club.getManagerBirthDate();
				ArrayList<UCLPlayer> playerInfo = club.getRoster();
				
				textAreaTeamInfo.setText("Name: " + name + " Alias: " + alias + " Country: " + country + "\n\n" + "Manager:\n" + "Name: " + managerFN + " " + managerLN + "\n" + "Country: " + managerCountry + "\n" + "Date of Birth: " + managerBirthdate + "\n\n" + "Roster:\n");
				
				for (UCLPlayer player : playerInfo) {
					String firstName = player.getFirstName();
					String lastName = player.getLastName();
					String playerCountry = player.getCountry();
					String dateOfBirth = player.getDateOfBirth();
					String preferredFoot = player.getPreferredFoot();
					String height_cm = player.getHeight_cm();
					String weight_kg = player.getWeight_kg();
					String jerseyNumber = player.getJerseyNumber();
					String position = player.getPosition();
					textAreaTeamInfo.append("Name: " + firstName + " " + lastName + "\n");
					textAreaTeamInfo.append("Country: " + playerCountry + "\n");
					textAreaTeamInfo.append("DOB: " + dateOfBirth + "\n");
					textAreaTeamInfo.append("Preferred Foot: " + preferredFoot + "\n");
					textAreaTeamInfo.append("height(cm): " + height_cm + "\n");
					textAreaTeamInfo.append("weight(kg): " + weight_kg + "\n");
					textAreaTeamInfo.append("Jersey Number: " + jerseyNumber + "\n");
					textAreaTeamInfo.append("Position: " + position + "\n\n");
				}
			}
		});
		btnChelsea.setBounds(288, 492, 117, 29);
		UCLTeamProfile.add(btnChelsea);
		
		JButton btnArsenal = new JButton("Arsenal");
		btnArsenal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UCLClub club = clubProfile.getClubs().get("Arsenal");
				String name = club.getName();
				String alias = club.getAlias();
				String country = club.getTeamCountry();
				String managerFN = club.getManagerFN();
				String managerLN = club.getManagerLN();
				String managerCountry = club.getManagerCountry();
				String managerBirthdate = club.getManagerBirthDate();
				ArrayList<UCLPlayer> playerInfo = club.getRoster();
				
				textAreaTeamInfo.setText("Name: " + name + " Alias: " + alias + " Country: " + country + "\n\n" + "Manager:\n" + "Name: " + managerFN + " " + managerLN + "\n" + "Country: " + managerCountry + "\n" + "Date of Birth: " + managerBirthdate + "\n\n" + "Roster:\n");
				
				for (UCLPlayer player : playerInfo) {
					String firstName = player.getFirstName();
					String lastName = player.getLastName();
					String playerCountry = player.getCountry();
					String dateOfBirth = player.getDateOfBirth();
					String preferredFoot = player.getPreferredFoot();
					String height_cm = player.getHeight_cm();
					String weight_kg = player.getWeight_kg();
					String jerseyNumber = player.getJerseyNumber();
					String position = player.getPosition();
					textAreaTeamInfo.append("Name: " + firstName + " " + lastName + "\n");
					textAreaTeamInfo.append("Country: " + playerCountry + "\n");
					textAreaTeamInfo.append("DOB: " + dateOfBirth + "\n");
					textAreaTeamInfo.append("Preferred Foot: " + preferredFoot + "\n");
					textAreaTeamInfo.append("height(cm): " + height_cm + "\n");
					textAreaTeamInfo.append("weight(kg): " + weight_kg + "\n");
					textAreaTeamInfo.append("Jersey Number: " + jerseyNumber + "\n");
					textAreaTeamInfo.append("Position: " + position + "\n\n");
				}
			}
		});
		btnArsenal.setBounds(64, 649, 117, 29);
		UCLTeamProfile.add(btnArsenal);
		
		JButton btnManchesterCity = new JButton("Manchester City");
		btnManchesterCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UCLClub club = clubProfile.getClubs().get("Man City");
				String name = club.getName();
				String alias = club.getAlias();
				String country = club.getTeamCountry();
				String managerFN = club.getManagerFN();
				String managerLN = club.getManagerLN();
				String managerCountry = club.getManagerCountry();
				String managerBirthdate = club.getManagerBirthDate();
				ArrayList<UCLPlayer> playerInfo = club.getRoster();
				
				textAreaTeamInfo.setText("Name: " + name + " Alias: " + alias + " Country: " + country + "\n\n" + "Manager:\n" + "Name: " + managerFN + " " + managerLN + "\n" + "Country: " + managerCountry + "\n" + "Date of Birth: " + managerBirthdate + "\n\n" + "Roster:\n");
				
				for (UCLPlayer player : playerInfo) {
					String firstName = player.getFirstName();
					String lastName = player.getLastName();
					String playerCountry = player.getCountry();
					String dateOfBirth = player.getDateOfBirth();
					String preferredFoot = player.getPreferredFoot();
					String height_cm = player.getHeight_cm();
					String weight_kg = player.getWeight_kg();
					String jerseyNumber = player.getJerseyNumber();
					String position = player.getPosition();
					textAreaTeamInfo.append("Name: " + firstName + " " + lastName + "\n");
					textAreaTeamInfo.append("Country: " + playerCountry + "\n");
					textAreaTeamInfo.append("DOB: " + dateOfBirth + "\n");
					textAreaTeamInfo.append("Preferred Foot: " + preferredFoot + "\n");
					textAreaTeamInfo.append("height(cm): " + height_cm + "\n");
					textAreaTeamInfo.append("weight(kg): " + weight_kg + "\n");
					textAreaTeamInfo.append("Jersey Number: " + jerseyNumber + "\n");
					textAreaTeamInfo.append("Position: " + position + "\n\n");
				}
			}
		});
		btnManchesterCity.setBounds(278, 649, 150, 29);
		UCLTeamProfile.add(btnManchesterCity);
		
		/**
		 * UEFA Champions League Main Page
		 */
		
		final JPanel UCL = new JPanel();
		frame.getContentPane().add(UCL, "name_75551392776245");
		UCL.setLayout(null);
		
		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UCL.setVisible(false);
				Main_window.setVisible(true);
			}
		});
		btnHome.setBounds(25, 25, 120, 40);
		UCL.add(btnHome);
		
		JButton btnFTeamProfile = new JButton("Team Profile");
		btnFTeamProfile.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnFTeamProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UCL.setVisible(false);
				Main_window.setVisible(false);
				UCLTeamProfile.setVisible(true);
			}
		});
		btnFTeamProfile.setBounds(567, 429, 150, 70);
		UCL.add(btnFTeamProfile);
		
		JButton btnFDraw = new JButton("Last 16 Draw");
		btnFDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UCL.setVisible(false);
				Main_window.setVisible(false);
				UCLLast16Draw.setVisible(true);
			}
		});
		btnFDraw.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnFDraw.setBounds(567, 543, 150, 70);
		UCL.add(btnFDraw);
		
		JLabel lblUCL_background1 = new JLabel("UCL_background");
		lblUCL_background1.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/UCL_logo.jpg")));
		lblUCL_background1.setBounds(0, 0, 1280, 720);
		UCL.add(lblUCL_background1);
	
		JButton btnBack_4 = new JButton("Back");
		btnBack_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UCL.setVisible(true);
				UCLTeamProfile.setVisible(false);
				UCLLast16Draw.setVisible(false);
			}
		});
		btnBack_4.setBounds(31, 21, 111, 29);
		UCLTeamProfile.add(btnBack_4);
		
		JLabel lblStadium = new JLabel("Stadium");
		lblStadium.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/UCL_Stadium.jpg")));
		lblStadium.setBounds(0, 0, 1280, 720);
		UCLTeamProfile.add(lblStadium);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UCL.setVisible(true);
				UCLLast16Draw.setVisible(false);
				UCLTeamProfile.setVisible(false);
			}
		});
		btnBack_1.setBounds(21, 42, 142, 43);
		UCLLast16Draw.add(btnBack_1);
		
		JLabel lblUCLDrawResult = new JLabel("Result");
		lblUCLDrawResult.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblUCLDrawResult.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/UCLLast16Draw.jpg")));
		lblUCLDrawResult.setBounds(0, 0, 1280, 720);
		UCLLast16Draw.add(lblUCLDrawResult);
		

		/*
		 * This is the NBA page. It contains one main page and three sub-pages.
		 */

		// NBA panel is the main panel of this part.
		final JPanel NBA = new JPanel();
		frame.getContentPane().add(NBA, "name_75555177344305");
		NBA.setLayout(null);
		
		JButton btnHome_1 = new JButton("Home");
		btnHome_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnHome_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NBA.setVisible(false);
				Main_window.setVisible(true);
			}
		});
		btnHome_1.setBounds(25, 25, 120, 40);
		NBA.add(btnHome_1);
		
		// A sub-page in NBA. It contains the NBA leaders information.
		NBALeagueLeaders nbaLeaders = new NBALeagueLeaders();
		
		JPanel NBA_leaders = new JPanel();
		frame.getContentPane().add(NBA_leaders, "name_111499636225905");
		NBA_leaders.setLayout(null);
		
		JComboBox<String> comboBoxLeaders = new JComboBox<String>();
		comboBoxLeaders.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		comboBoxLeaders.setBounds(700, 90, 200, 30);
		NBA_leaders.add(comboBoxLeaders);
		
		String[] categories = {"points", "assists", "threePoints", "rebounds", "freeThrow", "blocks", "steals"};
		for (String category: categories) {
			comboBoxLeaders.addItem(category);
		}
		
		JTextArea text = new JTextArea(10, 45);
		text.setVisible(true);
		text.setEditable(false);
		text.setFont(new Font("Serif", Font.BOLD, 26));
		JScrollPane sp = new JScrollPane(text);
		
		sp.setBounds(240, 130, 800, 500);
		NBA_leaders.add(sp);
		
		comboBoxLeaders.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == comboBoxLeaders) {
					JComboBox<String> cb = (JComboBox<String>) e.getSource();
			        String selected = (String)cb.getSelectedItem();
			        
			        switch (selected) {
			        	case "points": 
			        		text.setText(null);
			        		for (NBALeaders_Individual lead: nbaLeaders.getPointsLeaders()) {					        	
				        		text.append(" " + lead.toString() + "\n");
								text.append("\n");
				        	}	
			        		break;
			        	case "assists":
			        		text.setText(null);
			        		for (NBALeaders_Individual lead: nbaLeaders.getAssistsLeaders()) {					        	
				        		text.append(" " + lead.toString() + "\n");
								text.append("\n");
				        	}	
			        		break;
			        	case "threePoints": 
			        		text.setText(null);
			        		for (NBALeaders_Individual lead: nbaLeaders.getThreePointsLeaders()) {					        	
				        		text.append(" " + lead.toString() + "\n");
								text.append("\n");
				        	}	
			        		break;
			        	case "rebounds":
			        		text.setText(null);
			        		for (NBALeaders_Individual lead: nbaLeaders.getReboundsLeaders()) {					        	
				        		text.append(" " + lead.toString() + "\n");
								text.append("\n");
				        	}	
			        		break;
			        	case "freeThrow":
			        		text.setText(null);
			        		for (NBALeaders_Individual lead: nbaLeaders.getFreeThrowLeaders()) {					        	
				        		text.append(" " + lead.toString() + "\n");
								text.append("\n");
				        	}	
			        		break;
			        	case "blocks":
			        		text.setText(null);
			        		for (NBALeaders_Individual lead: nbaLeaders.getBlocksLeaders()) {					        	
				        		text.append(" " + lead.toString() + "\n");
								text.append("\n");
				        	}	
			        		break;
			        	case "steals":
			        		text.setText(null);
			        		for (NBALeaders_Individual lead: nbaLeaders.getStealsLeaders()) {					        	
				        		text.append(" " + lead.toString() + "\n");
								text.append("\n");
				        	}	
			        		break;
					}			        	
				}			        
			}						
		}); 

		
		JButton btnBack_3 = new JButton("Back");
		btnBack_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NBA.setVisible(true);
				Main_window.setVisible(false);
				NBA_leaders.setVisible(false);
			}
		});
		btnBack_3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnBack_3.setBounds(25, 25, 120, 40);
		NBA_leaders.add(btnBack_3);
		
		JLabel lblSelectTheItem = new JLabel("Select item from the list:");
		lblSelectTheItem.setForeground(Color.WHITE);
		lblSelectTheItem.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		lblSelectTheItem.setBounds(300, 90, 400, 30);
		NBA_leaders.add(lblSelectTheItem);
		
		JLabel lblNbaleadersbackground = new JLabel("NBA_leaders_background");
		lblNbaleadersbackground.setIcon(new ImageIcon(this.getClass().getResource("/resources/NBA_players_trophy.jpg")));
		lblNbaleadersbackground.setBounds(0, 0, 1280, 720);
		NBA_leaders.add(lblNbaleadersbackground);
		
		
		// A sub-page in NBA which displays NBA schedule in 2015-2016 season.
		TimeUnit.SECONDS.sleep(1);
		NBA_Schedule scheduleOfNBA = new NBA_Schedule();
		
		JPanel NBA_schedule = new JPanel();
		frame.getContentPane().add(NBA_schedule, "name_111337211737580");
		NBA_schedule.setLayout(null);
		
		JComboBox<String> comboBoxDate = new JComboBox<String>();
		comboBoxDate.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		comboBoxDate.setBounds(850, 90, 200, 30);
		NBA_schedule.add(comboBoxDate);
		
		for (int i = 0; i < scheduleOfNBA.getStoredDate().size(); i++) {
			comboBoxDate.addItem(scheduleOfNBA.getStoredDate().get(i));
		}
		
		JTextArea textArea = new JTextArea(10, 38);
		textArea.setVisible(true);
		textArea.setEditable(false);
		textArea.setFont(new Font("Serif", Font.BOLD, 26));
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		scrollPane.setBounds(215, 130, 850, 500);
		NBA_schedule.add(scrollPane);
				
		comboBoxDate.addActionListener(new ActionListener() {		
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == comboBoxDate) {
					textArea.setText(null);
					JComboBox<String> cb = (JComboBox<String>) e.getSource();
			        String selectedDate = (String)cb.getSelectedItem();
			        			        
			        for (NBASchedule_Individual game: scheduleOfNBA.getStoredSchedule()) {
			        	if (game.getDate().equals(selectedDate)) {			        		
			        		textArea.append(" " + game.toString() + "\n");
							textArea.append("\n");
			        	}				
					}		        
				}
			}			
		}); 
			
		JButton btnBack_2 = new JButton("Back");
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NBA.setVisible(true);
				Main_window.setVisible(false);
				NBA_schedule.setVisible(false);
			}
		});
		btnBack_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnBack_2.setBounds(25, 25, 120, 40);
		NBA_schedule.add(btnBack_2);
		
		JLabel lblInstruction = new JLabel("View 2015-16 schedule by selecting the date:");
		lblInstruction.setForeground(Color.CYAN);		
		lblInstruction.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		lblInstruction.setBounds(250, 90, 600, 30);
		NBA_schedule.add(lblInstruction);
		
		JLabel lblNbaschedulebackground = new JLabel("NBA_schedule_background");
		lblNbaschedulebackground.setIcon(new ImageIcon(this.getClass().getResource("/resources/NBA_schedulebg.jpg")));
		lblNbaschedulebackground.setBounds(0, 0, 1280, 720);
		NBA_schedule.add(lblNbaschedulebackground);
		
		
		// A sub-page in NBA that displays NBA team and player information.
		TimeUnit.SECONDS.sleep(1);
		NBATeamProfile nbaTeamProfiles = new NBATeamProfile();
		
		JPanel NBA_teams = new JPanel();
		frame.getContentPane().add(NBA_teams, "name_110655200741455");
		NBA_teams.setLayout(null);
		
		JComboBox<String> comboBoxTeams = new JComboBox<String>();
		comboBoxTeams.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		comboBoxTeams.setBounds(700, 90, 300, 30);
		NBA_teams.add(comboBoxTeams);
		
		for (String t: nbaTeamProfiles.getTeam().keySet()) {
			comboBoxTeams.addItem(t);
		}
		
		JTextArea textForTeam = new JTextArea(10, 39);
		textForTeam.setVisible(true);
		textForTeam.setEditable(false);
		textForTeam.setFont(new Font("Serif", Font.BOLD, 26));
		JScrollPane sp2 = new JScrollPane(textForTeam);
		
		sp2.setBounds(240, 130, 800, 500);
		NBA_teams.add(sp2);
		
		comboBoxTeams.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == comboBoxTeams) {
					JComboBox<String> cb = (JComboBox<String>) e.getSource();
			        String selected = (String)cb.getSelectedItem();
			        
			        switch (selected) {
			        	case "Chicago Bulls": 
			        		textForTeam.setText(null);			        			        	
			        		textForTeam.append(" " + nbaTeamProfiles.getStoredTeams().get(0).toString() + "\n");
			        		textForTeam.append("\n");				        	
			        		break;
			        				        
			        	case "Cleveland Cavaliers": 
			        		textForTeam.setText(null);			        						        	
			        		textForTeam.append(" " + nbaTeamProfiles.getStoredTeams().get(1).toString() + "\n");
			        		textForTeam.append("\n");				        		
			        		break;
			        		
			        	case "Golden State Warriors":
			        		textForTeam.setText(null);			        						        	
				        	textForTeam.append(" " + nbaTeamProfiles.getStoredTeams().get(2).toString() + "\n");
							textForTeam.append("\n");				        	
			        		break;
			        		
			        	case "Indiana Pacers":
			        		textForTeam.setText(null);			        						        	
				        	textForTeam.append(" " + nbaTeamProfiles.getStoredTeams().get(3).toString() + "\n");
							textForTeam.append("\n");				        	
			        		break;
			        	
			        	case "Los Angeles Clippers":
			        		textForTeam.setText(null);			        						        	
				        	textForTeam.append(" " + nbaTeamProfiles.getStoredTeams().get(4).toString() + "\n");
							textForTeam.append("\n");				        	
			        		break;
			        		
			        	case "Oklahoma City Thunder":
			        		textForTeam.setText(null);			        						        	
				        	textForTeam.append(" " + nbaTeamProfiles.getStoredTeams().get(5).toString() + "\n");
							textForTeam.append("\n");				        	
			        		break;
			        	
			        	case "San Antonio Spurs": 
			        		textForTeam.setText(null);			        			        	
				        	textForTeam.append(" " + nbaTeamProfiles.getStoredTeams().get(6).toString() + "\n");
							textForTeam.append("\n");				        	
			        		break;
			        	case "Toronto Raptors":
			        		textForTeam.setText(null);			        		     			        	
				        	textForTeam.append(" " + nbaTeamProfiles.getStoredTeams().get(7).toString() + "\n");
							textForTeam.append("\n");	
			        		break;			        	
					}			        	
				}			        
			}						
		}); 
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NBA.setVisible(true);
				Main_window.setVisible(false);
				NBA_teams.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnBack.setBounds(25, 25, 120, 40);
		NBA_teams.add(btnBack);
		
		JLabel label = new JLabel("Select team from the list:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		label.setBounds(300, 90, 400, 30);
		NBA_teams.add(label);
		
		JLabel lblNbateambackground = new JLabel("NBATeamBackground");
		lblNbateambackground.setIcon(new ImageIcon(this.getClass().getResource("/resources/NBA_teambackground.jpg")));
		lblNbateambackground.setBounds(0, 0, 1280, 720);
		NBA_teams.add(lblNbateambackground);
		
		
		// The followings are the JButton on the main NBA page.
		JButton btnTeamProfile = new JButton("Team Rosters");
		btnTeamProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NBA.setVisible(false);
				Main_window.setVisible(false);
				NBA_teams.setVisible(true);
			}
		});
		btnTeamProfile.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		btnTeamProfile.setBounds(150, 510, 200, 80);
		NBA.add(btnTeamProfile);
		
		JButton btnSchedule = new JButton("Schedule");
		btnSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NBA.setVisible(false);
				Main_window.setVisible(false);
				NBA_schedule.setVisible(true);
			}
		});
		btnSchedule.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		btnSchedule.setBounds(150, 345, 200, 80);
		NBA.add(btnSchedule);
		
		JButton buttonLeaders = new JButton("Leaders");
		buttonLeaders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NBA.setVisible(false);
				Main_window.setVisible(false);
				NBA_leaders.setVisible(true);
			}
		});
		buttonLeaders.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		buttonLeaders.setBounds(150, 180, 200, 80);
		NBA.add(buttonLeaders);
		
		// This is the background of the NBA main page.
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(this.getClass().getResource("/resources/NBA_trophy.jpg")));
		lblNewLabel_1.setBounds(0, 0, 1280, 720);
		NBA.add(lblNewLabel_1);
		NBA.setVisible(false);
		
		/**
		 * ATP_WTA panel, created by Man Hu
		 */
		//call Tennis API
		GetTennisPlayerInfo tennisInfo = new GetTennisPlayerInfo();
		TimeUnit.SECONDS.sleep(1);
		GetTennisSchedule tennisSchedule = new GetTennisSchedule();
		TimeUnit.SECONDS.sleep(1);
		
		// ATP_WTA panel
		final JPanel ATP_WTA = new JPanel();
		frame.getContentPane().add(ATP_WTA, "ATP_WTA");
		ATP_WTA.setLayout(null);
		
		// "Home" Button
		JButton TennisHomepage = new JButton("Home");
		TennisHomepage.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		TennisHomepage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ATP_WTA.setVisible(false);
				Main_window.setVisible(true);
			}
		});
		TennisHomepage.setBounds(25, 25, 120, 40);
		ATP_WTA.add(TennisHomepage);
		
		// ATP_WTA background
		JLabel Tennis_Symbol = new JLabel("");
		Tennis_Symbol.setHorizontalAlignment(SwingConstants.CENTER);
		Tennis_Symbol.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/atp-wta.jpg")));
		Tennis_Symbol.setBounds(198, 78, 912, 490);
		ATP_WTA.add(Tennis_Symbol);

		/**
		 * ATP_Player panel
		 */
		JPanel ATP_Player = new JPanel();
		frame.getContentPane().add(ATP_Player, "ATP_Player");
		ATP_Player.setLayout(null);
			
		JTextArea ATP_Player_Info  = new JTextArea(10, 20);
		ATP_Player_Info.setVisible(true);
		ATP_Player_Info.setEditable(false);
		ATP_Player_Info.setFont(new Font("Serif", Font.PLAIN, 25));
		JScrollPane ATPPlayerInfo_scroll = new JScrollPane(ATP_Player_Info);
		
		ATPPlayerInfo_scroll.setBounds(600, 100, 640, 550);
		ATP_Player.add(ATPPlayerInfo_scroll);

		/* Djokvic */
		JLabel Djokovic = new JLabel("");
		Djokovic.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/atp_player/djokovic.jpg")));
		Djokovic.setBounds(64, 153, 80, 80);
		ATP_Player.add(Djokovic);
		
		JButton btnDjo = new JButton("Djokovic");
		btnDjo.setBounds(158, 180, 110, 30);
		ATP_Player.add(btnDjo);
		
		btnDjo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TennisPlayer player = tennisInfo.getTop10ATPplayers().get(0);
				String name = player.getName();
				String ranking = player.getRanking();
				String ranking_points = player.getRanking_points();
				HashMap<String, String> tournament_round = player.getTournament_round();
				
				ATP_Player_Info.setText("Name: " + name + "\n\n" + "Ranking: " + ranking + "\n\n" + "Ranking points: " + ranking_points + "points\n\nTournaments in 2015:\n" );
				
				for (String element : tournament_round.keySet()) {
					ATP_Player_Info.append("     " + element + " - " + tournament_round.get(element) + "\n" );
				}
			} 
		});
		
		/* Federer */
		JLabel Federer = new JLabel("Federer");
		Federer.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/atp_player/federer.jpg")));
		Federer.setBounds(64, 258, 80, 80);
		ATP_Player.add(Federer);
		
		JButton btnFed = new JButton("Federer");
		btnFed.setBounds(158, 284, 110, 30);
		ATP_Player.add(btnFed);
		
		btnFed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TennisPlayer player = tennisInfo.getTop10ATPplayers().get(1);
				String name = player.getName();
				String ranking = player.getRanking();
				String ranking_points = player.getRanking_points();
				HashMap<String, String> tournament_round = player.getTournament_round();
				
				ATP_Player_Info.setText("Name: " + name + "\n\n" + "Ranking: " + ranking + "\n\n" + "Ranking points: " + ranking_points + "points\n\nTournaments in 2015:\n" );
				
				for (String element : tournament_round.keySet()) {
					ATP_Player_Info.append("     " + element + " - " + tournament_round.get(element) + "\n" );
				}
			} 
		});

		/* Murray */
		JLabel Murray = new JLabel("Murray");
		Murray.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/atp_player/murray.jpg")));
		Murray.setBounds(64, 363, 80, 80);
		ATP_Player.add(Murray);
		
		JButton btnMur = new JButton("Murray");
		btnMur.setBounds(158, 389, 110, 30);
		ATP_Player.add(btnMur);
		
		btnMur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TennisPlayer player = tennisInfo.getTop10ATPplayers().get(2);
				String name = player.getName();
				String ranking = player.getRanking();
				String ranking_points = player.getRanking_points();
				HashMap<String, String> tournament_round = player.getTournament_round();
				
				ATP_Player_Info.setText("Name: " + name + "\n\n" + "Ranking: " + ranking + "\n\n" + "Ranking points: " + ranking_points + "points\n\nTournaments in 2015:\n" );
				
				for (String element : tournament_round.keySet()) {
					ATP_Player_Info.append("     " + element + " - " + tournament_round.get(element) + "\n" );
				}
			} 
		});
		
		/* Wawrinka */
		JLabel Wawrinka = new JLabel("Wawrinka");
		Wawrinka.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/atp_player/wawrinka.jpg")));
		Wawrinka.setBounds(64, 468, 80, 80);
		ATP_Player.add(Wawrinka);
		
		JButton btnWaw = new JButton("Wawrinka");
		btnWaw.setBounds(158, 494, 110, 30);
		ATP_Player.add(btnWaw);
		
		btnWaw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TennisPlayer player = tennisInfo.getTop10ATPplayers().get(3);
				String name = player.getName();
				String ranking = player.getRanking();
				String ranking_points = player.getRanking_points();
				HashMap<String, String> tournament_round = player.getTournament_round();
				
				ATP_Player_Info.setText("Name: " + name + "\n\n" + "Ranking: " + ranking + "\n\n" + "Ranking points: " + ranking_points + "points\n\nTournaments in 2015:\n" );
				
				for (String element : tournament_round.keySet()) {
					ATP_Player_Info.append("     " + element + " - " + tournament_round.get(element) + "\n" );
				}
			} 
		});
		
		/* Nishikori */
		JLabel Nishikori = new JLabel("Nishikori");
		Nishikori.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/atp_player/nishikori.jpg")));
		Nishikori.setBounds(64, 575, 80, 80);
		ATP_Player.add(Nishikori);
		
		JButton btnNis = new JButton("Nishikori");
		btnNis.setBounds(158, 601, 110, 30);
		ATP_Player.add(btnNis);
		
		btnNis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TennisPlayer player = tennisInfo.getTop10ATPplayers().get(4);
				String name = player.getName();
				String ranking = player.getRanking();
				String ranking_points = player.getRanking_points();
				HashMap<String, String> tournament_round = player.getTournament_round();
				
				ATP_Player_Info.setText("Name: " + name + "\n\n" + "Ranking: " + ranking + "\n\n" + "Ranking points: " + ranking_points + "points\n\nTournaments in 2015:\n" );
				
				for (String element : tournament_round.keySet()) {
					ATP_Player_Info.append("     " + element + " - " + tournament_round.get(element) + "\n" );
				}
			} 
		});
		
		
		/* Berdych */
		JLabel Berdych = new JLabel("Berdych");
		Berdych.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/atp_player/berdych.jpg")));
		Berdych.setBounds(338, 153, 80, 80);
		ATP_Player.add(Berdych);
		
		JButton btnBer = new JButton("Berdych");
		btnBer.setBounds(430, 180, 110, 30);
		ATP_Player.add(btnBer);
		
		btnBer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TennisPlayer player = tennisInfo.getTop10ATPplayers().get(5);
				String name = player.getName();
				String ranking = player.getRanking();
				String ranking_points = player.getRanking_points();
				HashMap<String, String> tournament_round = player.getTournament_round();
				
				ATP_Player_Info.setText("Name: " + name + "\n\n" + "Ranking: " + ranking + "\n\n" + "Ranking points: " + ranking_points + "points\n\nTournaments in 2015:\n" );
				
				for (String element : tournament_round.keySet()) {
					ATP_Player_Info.append("     " + element + " - " + tournament_round.get(element) + "\n" );
				}
			} 
		});
		
		/* Nadal */
		JLabel Nadal = new JLabel("Nadal");
		Nadal.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/atp_player/nadal.jpg")));
		Nadal.setBounds(338, 258, 80, 80);
		ATP_Player.add(Nadal);
		
		JButton btnNad = new JButton("Nadal");
		btnNad.setBounds(430, 284, 110, 30);
		ATP_Player.add(btnNad);
		
		btnNad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TennisPlayer player = tennisInfo.getTop10ATPplayers().get(6);
				String name = player.getName();
				String ranking = player.getRanking();
				String ranking_points = player.getRanking_points();
				HashMap<String, String> tournament_round = player.getTournament_round();
				
				ATP_Player_Info.setText("Name: " + name + "\n\n" + "Ranking: " + ranking + "\n\n" + "Ranking points: " + ranking_points + "points\n\nTournaments in 2015:\n" );
				
				for (String element : tournament_round.keySet()) {
					ATP_Player_Info.append("     " + element + " - " + tournament_round.get(element) + "\n" );
				}
			} 
		});
		
		/* Ferrer */
		JLabel Ferrer = new JLabel("Ferrer");
		Ferrer.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/atp_player/ferrer.jpg")));
		Ferrer.setBounds(338, 363, 80, 80);
		ATP_Player.add(Ferrer);
		
		JButton btnFer = new JButton("Ferrer");
		btnFer.setBounds(430, 389, 110, 30);
		ATP_Player.add(btnFer);
		
		btnFer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TennisPlayer player = tennisInfo.getTop10ATPplayers().get(7);
				String name = player.getName();
				String ranking = player.getRanking();
				String ranking_points = player.getRanking_points();
				HashMap<String, String> tournament_round = player.getTournament_round();
				
				ATP_Player_Info.setText("Name: " + name + "\n\n" + "Ranking: " + ranking + "\n\n" + "Ranking points: " + ranking_points + "points\n\nTournaments in 2015:\n" );
				
				for (String element : tournament_round.keySet()) {
					ATP_Player_Info.append("     " + element + " - " + tournament_round.get(element) + "\n" );
				}
			} 
		});
		
		/* Gasquet */
		JLabel Gasquet = new JLabel("Gasquet");
		Gasquet.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/atp_player/gasquet.jpg")));
		Gasquet.setBounds(338, 468, 80, 80);
		ATP_Player.add(Gasquet);
		
		JButton btnGas = new JButton("Gasquet");
		btnGas.setBounds(430, 494, 110, 30);
		ATP_Player.add(btnGas);
		
		btnGas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TennisPlayer player = tennisInfo.getTop10ATPplayers().get(8);
				String name = player.getName();
				String ranking = player.getRanking();
				String ranking_points = player.getRanking_points();
				HashMap<String, String> tournament_round = player.getTournament_round();
				
				ATP_Player_Info.setText("Name: " + name + "\n\n" + "Ranking: " + ranking + "\n\n" + "Ranking points: " + ranking_points + "points\n\nTournaments in 2015:\n" );
				
				for (String element : tournament_round.keySet()) {
					ATP_Player_Info.append("     " + element + " - " + tournament_round.get(element) + "\n" );
				}
			} 
		});
		
		/* Tsonga */
		JLabel Tsonga = new JLabel("Tsonga");
		Tsonga.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/atp_player/tsonga.jpg")));
		Tsonga.setBounds(338, 575, 80, 80);
		ATP_Player.add(Tsonga);
		
		JButton btnTso = new JButton("Tsonga");
		btnTso.setBounds(430, 601, 110, 30);
		ATP_Player.add(btnTso);
		
		btnTso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TennisPlayer player = tennisInfo.getTop10ATPplayers().get(9);
				String name = player.getName();
				String ranking = player.getRanking();
				String ranking_points = player.getRanking_points();
				HashMap<String, String> tournament_round = player.getTournament_round();
				
				ATP_Player_Info.setText("Name: " + name + "\n\n" + "Ranking: " + ranking + "\n\n" + "Ranking points: " + ranking_points + "points\n\nTournaments in 2015:\n" );
				
				for (String element : tournament_round.keySet()) {
					ATP_Player_Info.append("     " + element + " - " + tournament_round.get(element) + "\n" );
				}
			} 
		});
		
		// go back to tennis homepage
		JButton btnGoToTennisHomepage1 = new JButton("Go Back");
		btnGoToTennisHomepage1.setBounds(42, 24, 117, 41);
		ATP_Player.add(btnGoToTennisHomepage1);
		
		btnGoToTennisHomepage1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ATP_WTA.setVisible(true);
				ATP_Player.setVisible(false);
				Main_window.setVisible(false);
			} 
		});
		
		// ATP player panel background
		JLabel ATP_final = new JLabel("");
		ATP_final.setBounds(0, 0, 1280, 693);
		ATP_final.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/atp_player/atp-world-tour-finals.jpg")));
		ATP_Player.add(ATP_final);
		
		/**
		 * ATP_Schedule panel
		 */
		JPanel ATP_Schedule = new JPanel();
		ATP_Schedule.setBackground(Color.WHITE);
		frame.getContentPane().add(ATP_Schedule, "ATP_Schedule");
		ATP_Schedule.setLayout(null);
		
		// go back to tennis homepage
		JButton btnGoToTennisHomepage2 = new JButton("Go Back");
		btnGoToTennisHomepage2.setBounds(35, 24, 117, 38);
		ATP_Schedule.add(btnGoToTennisHomepage2);
		
		btnGoToTennisHomepage2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ATP_WTA.setVisible(true);
				ATP_Schedule.setVisible(false);
				Main_window.setVisible(false);
			} 
		});
		
		// dropdown box
		JComboBox<String> atp_schedule_month = new JComboBox<String>();
		atp_schedule_month.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		atp_schedule_month.setBounds(700, 90, 300, 30);
		ATP_Schedule.add(atp_schedule_month);
		
		String[] month = {"January","February","March","April","May","June","July","August","September","October","November"};
		for (String element : month) {
			atp_schedule_month.addItem(element);
		}
		
		JTextArea ATP_month_schedule = new JTextArea(10, 39);
		ATP_month_schedule.setVisible(true);
		ATP_month_schedule.setEditable(false);
		ATP_month_schedule.setFont(new Font("Serif", Font.PLAIN, 25));
		JScrollPane ATP_month_schedule_sp = new JScrollPane(ATP_month_schedule);
		
		ATP_month_schedule_sp.setBounds(240, 130, 800, 500);
		ATP_Schedule.add(ATP_month_schedule_sp);
		
		// show the results
		HashMap<String, ArrayList<TennisLeagueSchedule>> ATP2015Schedule = tennisSchedule.getATPschedule();
		atp_schedule_month.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == atp_schedule_month) {
					JComboBox<String> cb = (JComboBox<String>) e.getSource();
					String SelectedMonth = (String)cb.getSelectedItem();
					ArrayList<TennisLeagueSchedule> month_schedule = ATP2015Schedule.get(SelectedMonth);

					ATP_month_schedule.setText("");
					for (TennisLeagueSchedule element : month_schedule) {
						String name = element.getName();
						String start = element.getStart();
						String end = element.getEnd();
						String type = element.getType();
						String ground = element.getGround();
						String prize = element.getPrize();
						String currency = element.getCurrency();
						
						prize = prize + " " + currency;
												
						ATP_month_schedule.append(name + "  " + start + " to " + end + "\n");
						ATP_month_schedule.append("Type: " + type +  "; Ground: " + ground + "; Prize: " + prize + "\n\n");		
					}
				}
			}
		});
		
		// ATP schedule panel background
		JLabel ATP_Schedule_Background = new JLabel("");
		ATP_Schedule_Background.setVerticalAlignment(SwingConstants.TOP);
		ATP_Schedule_Background.setHorizontalAlignment(SwingConstants.CENTER);
		ATP_Schedule_Background.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/atp_player/atp-game-on-campaign-rafa-roge.jpg")));
		ATP_Schedule_Background.setBounds(0, 0, 1280, 700);
		ATP_Schedule.add(ATP_Schedule_Background);
		
		/**
		 * WTA_Player panel
		 */
		JPanel WTA_Player = new JPanel();
		WTA_Player.setBackground(Color.WHITE);
		frame.getContentPane().add(WTA_Player, "WTA_Player");
		WTA_Player.setLayout(null);
		
		JTextArea WTA_Player_Info  = new JTextArea(10, 20);
		WTA_Player_Info.setVisible(true);
		WTA_Player_Info.setEditable(false);
		WTA_Player_Info.setFont(new Font("Serif", Font.PLAIN, 25));
		JScrollPane WTAPlayerInfo_scroll = new JScrollPane(WTA_Player_Info);
		
		WTAPlayerInfo_scroll.setBounds(600, 100, 640, 550);
		WTA_Player.add(WTAPlayerInfo_scroll);
				
		/* Serena William */
		JLabel SWilliams = new JLabel("");
		SWilliams.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/wta_player/serena-williams-1.jpg")));
		SWilliams.setBounds(64, 153, 80, 80);
		WTA_Player.add(SWilliams);
		
		JButton btnSWil = new JButton("S. Williams");
		btnSWil.setBounds(156, 180, 110, 30);
		WTA_Player.add(btnSWil);
		
		btnSWil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TennisPlayer player = tennisInfo.getTop10WTAplayers().get(0);
				String name = player.getName();
				String ranking = player.getRanking();
				String ranking_points = player.getRanking_points();
				HashMap<String, String> tournament_round = player.getTournament_round();
				
				WTA_Player_Info.setText("Name: " + name + "\n\n" + "Ranking: " + ranking + "\n\n" + "Ranking points: " + ranking_points + "points\n\nTournaments in 2015:\n" );
				
				for (String element : tournament_round.keySet()) {
					WTA_Player_Info.append("     " + element + " - " + tournament_round.get(element) + "\n" );
				}
			} 
		});
		
		/* Halep */
		JLabel Halep = new JLabel("");
		Halep.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/wta_player/simona-halep-2.jpg")));
		Halep.setBounds(64, 262, 80, 80);
		WTA_Player.add(Halep);
		
		JButton btnHal = new JButton("Halep");
		btnHal.setBounds(156, 289, 110, 30);
		WTA_Player.add(btnHal);
		
		btnHal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TennisPlayer player = tennisInfo.getTop10WTAplayers().get(1);
				String name = player.getName();
				String ranking = player.getRanking();
				String ranking_points = player.getRanking_points();
				HashMap<String, String> tournament_round = player.getTournament_round();
				
				WTA_Player_Info.setText("Name: " + name + "\n\n" + "Ranking: " + ranking + "\n\n" + "Ranking points: " + ranking_points + "points\n\nTournaments in 2015:\n" );
				
				for (String element : tournament_round.keySet()) {
					WTA_Player_Info.append("     " + element + " - " + tournament_round.get(element) + "\n" );
				}
			} 
		});
		
		/* Muguruza */
		JLabel Muguruza = new JLabel("");
		Muguruza.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/wta_player/garbine_muguruza_3.jpg")));
		Muguruza.setBounds(64, 366, 80, 80);
		WTA_Player.add(Muguruza);
		
		JButton btnMug = new JButton("Muguruza");
		btnMug.setBounds(156, 394, 110, 30);
		WTA_Player.add(btnMug);
		
		btnMug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TennisPlayer player = tennisInfo.getTop10WTAplayers().get(2);
				String name = player.getName();
				String ranking = player.getRanking();
				String ranking_points = player.getRanking_points();
				HashMap<String, String> tournament_round = player.getTournament_round();
				
				WTA_Player_Info.setText("Name: " + name + "\n\n" + "Ranking: " + ranking + "\n\n" + "Ranking points: " + ranking_points + "points\n\nTournaments in 2015:\n" );
				
				for (String element : tournament_round.keySet()) {
					WTA_Player_Info.append("     " + element + " - " + tournament_round.get(element) + "\n" );
				}
			} 
		});
		
		/* Sharapova */
		JLabel Sharapova = new JLabel("");
		Sharapova.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/wta_player/sarapova-4.jpg")));
		Sharapova.setBounds(64, 473, 80, 80);
		WTA_Player.add(Sharapova);
		
		JButton btnSha = new JButton("Sharapova");
		btnSha.setBounds(156, 496, 110, 30);
		WTA_Player.add(btnSha);
		
		btnSha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TennisPlayer player = tennisInfo.getTop10WTAplayers().get(3);
				String name = player.getName();
				String ranking = player.getRanking();
				String ranking_points = player.getRanking_points();
				HashMap<String, String> tournament_round = player.getTournament_round();
				
				WTA_Player_Info.setText("Name: " + name + "\n\n" + "Ranking: " + ranking + "\n\n" + "Ranking points: " + ranking_points + "points\n\nTournaments in 2015:\n" );
				
				for (String element : tournament_round.keySet()) {
					WTA_Player_Info.append("     " + element + " - " + tournament_round.get(element) + "\n" );
				}
			} 
		});
		
		/* Radwanska */
		JLabel Radwanska = new JLabel("");
		Radwanska.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/wta_player/radwanska-5.jpg")));
		Radwanska.setBounds(64, 581, 80, 80);
		WTA_Player.add(Radwanska);
		
		JButton btnRad = new JButton("Radwanska");
		btnRad.setBounds(156, 607, 110, 30);
		WTA_Player.add(btnRad);
		
		btnRad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TennisPlayer player = tennisInfo.getTop10WTAplayers().get(4);
				String name = player.getName();
				String ranking = player.getRanking();
				String ranking_points = player.getRanking_points();
				HashMap<String, String> tournament_round = player.getTournament_round();
				
				WTA_Player_Info.setText("Name: " + name + "\n\n" + "Ranking: " + ranking + "\n\n" + "Ranking points: " + ranking_points + "points\n\nTournaments in 2015:\n" );
				
				for (String element : tournament_round.keySet()) {
					WTA_Player_Info.append("     " + element + " - " + tournament_round.get(element) + "\n" );
				}
			} 
		});
		
		/* Kvitova */
		JLabel Kvitova = new JLabel("");
		Kvitova.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/wta_player/kvitova-6.jpg")));
		Kvitova.setBounds(307, 153, 80, 80);
		WTA_Player.add(Kvitova);
		
		JButton btnKvi = new JButton("Kvitova");
		btnKvi.setBounds(399, 180, 110, 30);
		WTA_Player.add(btnKvi);
		
		btnKvi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TennisPlayer player = tennisInfo.getTop10WTAplayers().get(5);
				String name = player.getName();
				String ranking = player.getRanking();
				String ranking_points = player.getRanking_points();
				HashMap<String, String> tournament_round = player.getTournament_round();
				
				WTA_Player_Info.setText("Name: " + name + "\n\n" + "Ranking: " + ranking + "\n\n" + "Ranking points: " + ranking_points + "points\n\nTournaments in 2015:\n" );
				
				for (String element : tournament_round.keySet()) {
					WTA_Player_Info.append("     " + element + " - " + tournament_round.get(element) + "\n" );
				}
			} 
		});
		
		/* Venus Williams */
		JLabel VWilliams = new JLabel("");
		VWilliams.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/wta_player/williams-7.jpg")));
		VWilliams.setBounds(307, 262, 80, 80);
		WTA_Player.add(VWilliams);
		
		JButton btnVWi = new JButton("V. Williams");
		btnVWi.setBounds(399, 289, 110, 30);
		WTA_Player.add(btnVWi);
		
		btnVWi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TennisPlayer player = tennisInfo.getTop10WTAplayers().get(6);
				String name = player.getName();
				String ranking = player.getRanking();
				String ranking_points = player.getRanking_points();
				HashMap<String, String> tournament_round = player.getTournament_round();
				
				WTA_Player_Info.setText("Name: " + name + "\n\n" + "Ranking: " + ranking + "\n\n" + "Ranking points: " + ranking_points + "points\n\nTournaments in 2015:\n" );
				
				for (String element : tournament_round.keySet()) {
					WTA_Player_Info.append("     " + element + " - " + tournament_round.get(element) + "\n" );
				}
			} 
		});
		
		/* Pennetta */
		JLabel Pennetta = new JLabel("");
		Pennetta.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/wta_player/pennetta-8.jpg")));
		Pennetta.setBounds(307, 366, 80, 80);
		WTA_Player.add(Pennetta);
		
		JButton btnPen = new JButton("Pennetta");
		btnPen.setBounds(399, 394, 110, 30);
		WTA_Player.add(btnPen);
		
		btnPen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TennisPlayer player = tennisInfo.getTop10WTAplayers().get(7);
				String name = player.getName();
				String ranking = player.getRanking();
				String ranking_points = player.getRanking_points();
				HashMap<String, String> tournament_round = player.getTournament_round();
				
				WTA_Player_Info.setText("Name: " + name + "\n\n" + "Ranking: " + ranking + "\n\n" + "Ranking points: " + ranking_points + "points\n\nTournaments in 2015:\n" );
				
				for (String element : tournament_round.keySet()) {
					WTA_Player_Info.append("     " + element + " - " + tournament_round.get(element) + "\n" );
				}
			} 
		});
		
		/* Safarova */
		JLabel Safarova = new JLabel("");
		Safarova.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/wta_player/safarova-9.jpg")));
		Safarova.setBounds(307, 473, 80, 80);
		WTA_Player.add(Safarova);
		
		JButton btnSaf = new JButton("Safarova");
		btnSaf.setBounds(399, 496, 110, 30);
		WTA_Player.add(btnSaf);
		
		btnSaf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TennisPlayer player = tennisInfo.getTop10WTAplayers().get(8);
				String name = player.getName();
				String ranking = player.getRanking();
				String ranking_points = player.getRanking_points();
				HashMap<String, String> tournament_round = player.getTournament_round();
				
				WTA_Player_Info.setText("Name: " + name + "\n\n" + "Ranking: " + ranking + "\n\n" + "Ranking points: " + ranking_points + "points\n\nTournaments in 2015:\n" );
				
				for (String element : tournament_round.keySet()) {
					WTA_Player_Info.append("     " + element + " - " + tournament_round.get(element) + "\n" );
				}
			} 
		});
		
		
		/* Kerber */
		JLabel Kerber = new JLabel("");
		Kerber.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/wta_player/kerber-10.jpg")));
		Kerber.setBounds(307, 581, 80, 80);
		WTA_Player.add(Kerber);
		
		JButton btnKer = new JButton("Safarova");
		btnKer.setBounds(399, 607, 110, 30);
		WTA_Player.add(btnKer);
		
		btnKer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TennisPlayer player = tennisInfo.getTop10WTAplayers().get(9);
				String name = player.getName();
				String ranking = player.getRanking();
				String ranking_points = player.getRanking_points();
				HashMap<String, String> tournament_round = player.getTournament_round();
				
				WTA_Player_Info.setText("Name: " + name + "\n\n" + "Ranking: " + ranking + "\n\n" + "Ranking points: " + ranking_points + "points\n\nTournaments in 2015:\n" );
				
				for (String element : tournament_round.keySet()) {
					WTA_Player_Info.append("     " + element + " - " + tournament_round.get(element) + "\n" );
				}
			} 
		});
		
		JButton btnGoToTennisHomepage3 = new JButton("Go Back");
		btnGoToTennisHomepage3.setBounds(30, 21, 117, 29);
		WTA_Player.add(btnGoToTennisHomepage3);
		
		btnGoToTennisHomepage3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ATP_WTA.setVisible(true);
				WTA_Player.setVisible(false);
				Main_window.setVisible(false);
			} 
		});
			
		// WTA player panel background
		JLabel WTA_final = new JLabel("");
		WTA_final.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/wta_player/wta_final.jpg")));
		WTA_final.setBounds(0, 0, 1280, 718);
		WTA_Player.add(WTA_final);
		

		/**
		 * WTA_Schedule panel
		 */
		JPanel WTA_Schedule = new JPanel();
		WTA_Schedule.setBackground(Color.WHITE);
		frame.getContentPane().add(WTA_Schedule, "WTA_Schedule");
		WTA_Schedule.setLayout(null);
		
		// go back to tennis homepage
		JButton btnGoToTennisHomepage4 = new JButton("Go Back");
		btnGoToTennisHomepage4.setBounds(35, 24, 117, 38);
		WTA_Schedule.add(btnGoToTennisHomepage4);
		
		btnGoToTennisHomepage4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ATP_WTA.setVisible(true);
				WTA_Schedule.setVisible(false);
				Main_window.setVisible(false);
			} 
		});
		
		// dropdown box
		JComboBox<String> wta_schedule_month = new JComboBox<String>();
		wta_schedule_month.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		wta_schedule_month.setBounds(700, 90, 300, 30);
		WTA_Schedule.add(wta_schedule_month);
		
		for (String element : month) {
			wta_schedule_month.addItem(element);
		}
		
		JTextArea WTA_month_schedule = new JTextArea(10, 39);
		WTA_month_schedule.setVisible(true);
		WTA_month_schedule.setEditable(false);
		WTA_month_schedule.setFont(new Font("Serif", Font.PLAIN, 25));
		JScrollPane WTA_month_schedule_sp = new JScrollPane(WTA_month_schedule);
		
		WTA_month_schedule_sp.setBounds(240, 130, 800, 500);
		WTA_Schedule.add(WTA_month_schedule_sp);
		
		// print out the results
		HashMap<String, ArrayList<TennisLeagueSchedule>> WTA2015Schedule = tennisSchedule.getWTAschedule();
		wta_schedule_month.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == wta_schedule_month) {
					JComboBox<String> cb = (JComboBox<String>) e.getSource();
					String SelectedMonth = (String)cb.getSelectedItem();
					ArrayList<TennisLeagueSchedule> month_schedule = WTA2015Schedule.get(SelectedMonth);

					WTA_month_schedule.setText("");
					for (TennisLeagueSchedule element : month_schedule) {
						String name = element.getName();
						String start = element.getStart();
						String end = element.getEnd();
						String type = element.getType();
						String ground = element.getGround();
						String prize = element.getPrize();
						String currency = element.getCurrency();
						
						prize = prize + " " + currency;
												
						WTA_month_schedule.append(name + "  " + start + " to " + end + "\n");
						WTA_month_schedule.append("Type: " + type +  "; Ground: " + ground + "; Prize: " + prize + "\n\n");		
					}
				}
			}
		});
		
		// WTA schedule panel background
		JLabel WTA_Schedule_Background = new JLabel("");
		WTA_Schedule_Background.setVerticalAlignment(SwingConstants.BOTTOM);
		WTA_Schedule_Background.setHorizontalAlignment(SwingConstants.CENTER);
		WTA_Schedule_Background.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/wta_player/wta-tennis.jpg")));
		WTA_Schedule_Background.setBounds(0, 0, 1280, 700);
		WTA_Schedule.add(WTA_Schedule_Background);
		
		/**
		 * Buttons on Tennis Homepage
		 */
		JButton goToATP_Player_panel = new JButton("ATP Player");
		goToATP_Player_panel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_window.setVisible(false);
				ATP_WTA.setVisible(false);
				ATP_Player.setVisible(true);
			}
		});
		goToATP_Player_panel.setBounds(251, 580, 117, 29);
		ATP_WTA.add(goToATP_Player_panel);
		
		JButton goToATP_Schedule_panel = new JButton("ATP Schedule");
		goToATP_Schedule_panel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_window.setVisible(false);
				ATP_WTA.setVisible(false);
				ATP_Schedule.setVisible(true);
			}
		});
		goToATP_Schedule_panel.setBounds(449, 580, 117, 29);
		ATP_WTA.add(goToATP_Schedule_panel);
		
		
		JButton goWTA_Player_panel = new JButton("WTA Player");
		goWTA_Player_panel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_window.setVisible(false);
				ATP_WTA.setVisible(false);
				WTA_Player.setVisible(true);
			}
		});
		goWTA_Player_panel.setBounds(757, 580, 117, 29);
		ATP_WTA.add(goWTA_Player_panel);
		
		JButton goWTA_Schedule_panel = new JButton("WTA Schedule");
		goWTA_Schedule_panel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_window.setVisible(false);
				ATP_WTA.setVisible(false);
				WTA_Schedule.setVisible(true);
			}
		});
		goWTA_Schedule_panel.setBounds(945, 580, 117, 29);
		ATP_WTA.add(goWTA_Schedule_panel);
		/**
		 * End of Tennis Page
		 */
		
		
		
		/**
		 * Buttons on Main_window.
		 */		
		JButton btnUCL = new JButton("UCL");
		btnUCL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UCL.setVisible(true);
				Main_window.setVisible(false);
			}
		});
		btnUCL.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		btnUCL.setBounds(200, 520, 200, 80);
		Main_window.add(btnUCL);
		
		JButton btnNba = new JButton("NBA");
		btnNba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NBA.setVisible(true);
				Main_window.setVisible(false);
			}
		});
		btnNba.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		btnNba.setBounds(540, 520, 200, 80);
		Main_window.add(btnNba);
		
		
		JButton btnAtpWta = new JButton("ATP & WTA");
		btnAtpWta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ATP_WTA.setVisible(true);
				Main_window.setVisible(false);
			}
		});
		btnAtpWta.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		btnAtpWta.setBounds(880, 520, 200, 80);
		Main_window.add(btnAtpWta);
		
		JLabel lblNewLabel = new JLabel("background");
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/resources/Sports_background.jpg")));
		lblNewLabel.setSize(720, 480);
		lblNewLabel.setBounds(0, 0, 1280, 720);
		Main_window.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "name_2127323497617671");
		
	}
}
