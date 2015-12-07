package sports_miniWiki;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.CardLayout;

public class Sports_miniWiki {

	private JFrame frame;
	private JPanel Main_window;
	private JPanel FIFA;
	private JPanel NBA;
	private JPanel ATP_WTA;

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
	 */
	public Sports_miniWiki() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Sports miniWiki");
		frame.setBounds(100, 100, 1280, 740);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		final JPanel Main_window = new JPanel();
		frame.getContentPane().add(Main_window, "name_75543461813159");
		Main_window.setLayout(null);
		Main_window.setVisible(true);
		
		final JPanel FIFA = new JPanel();
		frame.getContentPane().add(FIFA, "name_75551392776245");
		FIFA.setLayout(null);
		
		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FIFA.setVisible(false);
				Main_window.setVisible(true);
			}
		});
		btnHome.setBounds(25, 25, 120, 40);
		FIFA.add(btnHome);
		
		JLabel lblFifabackground = new JLabel("FIFA_background");
		lblFifabackground.setIcon(new ImageIcon("/Users/yuezhang/Documents/sports_miniWiki/sports_miniWiki/src/resources/FIFA_background.jpg"));
		lblFifabackground.setBounds(0, 0, 1280, 720);
		FIFA.add(lblFifabackground);
		FIFA.setVisible(false);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(this.getClass().getResource("/resources/NBA_trophy.jpg")));
		lblNewLabel_1.setBounds(0, 0, 1280, 720);
		NBA.add(lblNewLabel_1);
		NBA.setVisible(false);
		
		final JPanel ATP_WTA = new JPanel();
		frame.getContentPane().add(ATP_WTA, "name_75561060277162");
		ATP_WTA.setLayout(null);
		
		JButton btnHome_2 = new JButton("Home");
		btnHome_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnHome_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ATP_WTA.setVisible(false);
				Main_window.setVisible(true);
			}
		});
		btnHome_2.setBounds(25, 25, 120, 40);
		ATP_WTA.add(btnHome_2);
		ATP_WTA.setVisible(false);
		
		JButton btnFifa = new JButton("FIFA");
		btnFifa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FIFA.setVisible(true);
				Main_window.setVisible(false);
			}
		});
		btnFifa.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		btnFifa.setBounds(200, 520, 200, 80);
		Main_window.add(btnFifa);
		
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

	}
}
