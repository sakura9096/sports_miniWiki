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
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 383);
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
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FIFA.setVisible(false);
				Main_window.setVisible(true);
			}
		});
		btnHome.setBounds(517, 25, 117, 29);
		FIFA.add(btnHome);
		FIFA.setVisible(false);
		
		final JPanel NBA = new JPanel();
		frame.getContentPane().add(NBA, "name_75555177344305");
		NBA.setLayout(null);
		
		JButton btnHome_1 = new JButton("Home");
		btnHome_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NBA.setVisible(false);
				Main_window.setVisible(true);
			}
		});
		btnHome_1.setBounds(503, 28, 117, 29);
		NBA.add(btnHome_1);
		NBA.setVisible(false);
		
		final JPanel ATP_WTA = new JPanel();
		frame.getContentPane().add(ATP_WTA, "name_75561060277162");
		ATP_WTA.setLayout(null);
		
		JButton btnHome_2 = new JButton("Home");
		btnHome_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ATP_WTA.setVisible(false);
				Main_window.setVisible(true);
			}
		});
		btnHome_2.setBounds(506, 31, 117, 29);
		ATP_WTA.add(btnHome_2);
		ATP_WTA.setVisible(false);
		
		JButton btnFifa = new JButton("FIFA");
		btnFifa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FIFA.setVisible(true);
				Main_window.setVisible(false);
			}
		});
		btnFifa.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnFifa.setBounds(74, 167, 140, 50);
		Main_window.add(btnFifa);
		
		JButton btnNba = new JButton("NBA");
		btnNba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NBA.setVisible(true);
				Main_window.setVisible(false);
			}
		});
		btnNba.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnNba.setBounds(254, 167, 140, 50);
		Main_window.add(btnNba);
		
		
		
		JButton btnAtpWta = new JButton("ATP & WTA");
		btnAtpWta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ATP_WTA.setVisible(true);
				Main_window.setVisible(false);
			}
		});
		btnAtpWta.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnAtpWta.setBounds(436, 167, 140, 50);
		Main_window.add(btnAtpWta);
		
		JLabel lblSportsMiniwiki = new JLabel("Sports miniWiki");
		lblSportsMiniwiki.setForeground(Color.YELLOW);
		lblSportsMiniwiki.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		lblSportsMiniwiki.setHorizontalAlignment(SwingConstants.CENTER);
		lblSportsMiniwiki.setBounds(197, 58, 243, 51);
		Main_window.add(lblSportsMiniwiki);
		
		JLabel lblNewLabel = new JLabel("background");
		lblNewLabel.setIcon(new ImageIcon("/Users/yuezhang/Documents/sports_miniWiki/sports_miniWiki/SPORTS-background.jpg"));
		lblNewLabel.setBounds(0, 0, 640, 360);
		Main_window.add(lblNewLabel);

	}
}
