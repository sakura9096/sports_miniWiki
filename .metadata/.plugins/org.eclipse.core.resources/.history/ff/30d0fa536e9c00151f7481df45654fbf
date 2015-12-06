package sports_miniWiki;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
		frame.getContentPane().setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 640, 360);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel lblSportsMiniwiki = new JLabel("Sports miniWiki");
		lblSportsMiniwiki.setHorizontalAlignment(SwingConstants.CENTER);
		lblSportsMiniwiki.setForeground(Color.YELLOW);
		lblSportsMiniwiki.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		lblSportsMiniwiki.setBounds(214, 42, 211, 44);
		mainPanel.add(lblSportsMiniwiki);
		
		JButton btnFifa = new JButton("FIFA");
		btnFifa.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnFifa.setBounds(53, 114, 140, 50);
		mainPanel.add(btnFifa);
		
		JButton btnNba = new JButton("NBA");
		btnNba.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnNba.setBounds(243, 114, 140, 50);
		mainPanel.add(btnNba);
		
		JButton btnAtp = new JButton("ATP & WTA");
		btnAtp.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnAtp.setBounds(449, 114, 140, 50);
		mainPanel.add(btnAtp);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("/Users/yuezhang/Documents/sports_miniWiki/sports_miniWiki/SPORTS-background.jpg"));
		lblNewLabel.setBounds(0, 0, 640, 360);
		mainPanel.add(lblNewLabel);
		
		JPanel FIFA = new JPanel();
		FIFA.setBounds(0, 0, 10, 10);
		frame.getContentPane().add(FIFA);
		
		JPanel NBA = new JPanel();
		NBA.setBounds(0, 0, 10, 10);
		frame.getContentPane().add(NBA);
		
		JPanel ATP_WTA = new JPanel();
		ATP_WTA.setBounds(0, 0, 10, 10);
		frame.getContentPane().add(ATP_WTA);
	}

}
