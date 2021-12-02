package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Anomalous extends JFrame {

	private JPanel contentPane;
	private JTextField txtfldName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Anomalous frame = new Anomalous();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Anomalous() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Anomalous.class.getResource("/images/logo.png")));
		setFont(new Font("Nineteen Ninety Three", Font.PLAIN, 12));
		setTitle("Anomalous.exe");
		setBackground(Color.DARK_GRAY);
		setForeground(new Color(0, 0, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 635);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel toppanel = new JPanel();
		toppanel.setBackground(Color.WHITE);
		toppanel.setBounds(6, 11, 468, 235);
		contentPane.add(toppanel);
		toppanel.setLayout(null);
		
		JTextPane txtAnomalous = new JTextPane();
		txtAnomalous.setBounds(20, 75, 427, 48);
		toppanel.add(txtAnomalous);
		txtAnomalous.setBackground(Color.WHITE);
		txtAnomalous.setEditable(false);
		txtAnomalous.setForeground(new Color(255, 204, 51));
		txtAnomalous.setFont(new Font("A Goblin Appears!", Font.BOLD, 42));
		txtAnomalous.setText("ANOMALOUS");
		
		JTextPane txtWelcome = new JTextPane();
		txtWelcome.setBounds(156, 29, 156, 34);
		toppanel.add(txtWelcome);
		txtWelcome.setBackground(Color.WHITE);
		txtWelcome.setEditable(false);
		txtWelcome.setFont(new Font("Nineteen Ninety Seven", Font.PLAIN, 20));
		txtWelcome.setText("Welcome to");
		
		JTextPane txtIntFict = new JTextPane();
		txtIntFict.setBounds(36, 155, 396, 34);
		toppanel.add(txtIntFict);
		txtIntFict.setBackground(Color.WHITE);
		txtIntFict.setEditable(false);
		txtIntFict.setText("An Interactive Fiction Story");
		txtIntFict.setFont(new Font("Nineteen Ninety Seven", Font.PLAIN, 20));
		
		JTextPane txtTwist = new JTextPane();
		txtTwist.setBounds(131, 185, 205, 39);
		toppanel.add(txtTwist);
		txtTwist.setBackground(Color.WHITE);
		txtTwist.setEditable(false);
		txtTwist.setText("with a twist!");
		txtTwist.setForeground(new Color(204, 0, 0));
		txtTwist.setFont(new Font("Nineteen Ninety Seven", Font.ITALIC, 24));
		
		JTextPane txtAnomalous_1 = new JTextPane();
		txtAnomalous_1.setText("ANOMALOUS");
		txtAnomalous_1.setForeground(new Color(204, 204, 204));
		txtAnomalous_1.setFont(new Font("A Goblin Appears!", Font.BOLD, 42));
		txtAnomalous_1.setEditable(false);
		txtAnomalous_1.setBackground(Color.WHITE);
		txtAnomalous_1.setBounds(20, 85, 427, 48);
		toppanel.add(txtAnomalous_1);
		
		JPanel startpanel = new JPanel();
		startpanel.setBounds(8, 276, 464, 235);
		contentPane.add(startpanel);
		startpanel.setLayout(null);
		
		JTextPane txtEnterName = new JTextPane();
		txtEnterName.setBounds(27, 23, 409, 48);
		startpanel.add(txtEnterName);
		txtEnterName.setBackground(UIManager.getColor("Button.background"));
		txtEnterName.setEditable(false);
		txtEnterName.setFont(new Font("Nineteen Ninety Seven", Font.PLAIN, 18));
		txtEnterName.setText("Please enter your name to start:");
		
		txtfldName = new JTextField();
		txtfldName.setHorizontalAlignment(SwingConstants.LEFT);
		txtfldName.setForeground(new Color(153, 0, 0));
		txtfldName.setToolTipText("Enter Name Here");
		txtfldName.setBounds(122, 76, 219, 29);
		startpanel.add(txtfldName);
		txtfldName.setFont(new Font("Nineteen Ninety Three", Font.PLAIN, 16));
		txtfldName.setColumns(10);
		
		JButton btnStart = new JButton("START");
		btnStart.setBounds(150, 117, 163, 34);
		startpanel.add(btnStart);
		btnStart.setFont(new Font("Nineteen Ninety Seven", Font.BOLD, 20));
		
		JPanel avatarPanel = new JPanel();
		avatarPanel.setBounds(6, 508, 468, 93);
		contentPane.add(avatarPanel);
		avatarPanel.setLayout(null);
		avatarPanel.setBackground(Color.WHITE);
		
		JLabel lblAvatar = new JLabel("");
		lblAvatar.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAvatar.setIcon(new ImageIcon(Anomalous.class.getResource("/images/netscape_logo.gif")));
		lblAvatar.setBounds(281, 62, 88, 31);
		avatarPanel.add(lblAvatar);
		
		JLabel lbl_ieLogo = new JLabel("");
		lbl_ieLogo.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_ieLogo.setIcon(new ImageIcon(Anomalous.class.getResource("/images/ie_logo.gif")));
		lbl_ieLogo.setBounds(374, 62, 88, 31);
		avatarPanel.add(lbl_ieLogo);
		
		JLabel lbl_powerby = new JLabel("Powered By:");
		lbl_powerby.setFont(new Font("Nineteen Ninety Three", Font.PLAIN, 12));
		lbl_powerby.setBounds(328, 41, 80, 25);
		avatarPanel.add(lbl_powerby);
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String playername = txtfldName.getText();
				UNGenerator ungen = new UNGenerator(playername);
				Player player = new Player(playername, ungen.username);
				
				JOptionPane.showMessageDialog(null, "Henlo Fren!\nYour username was automatically generated\nbased off of your name, " + player.name + ", and is:\n" + player.username);
				toppanel.hide();
				startpanel.hide();
				
//				String dialupSound = "dialup.wav";
//				musicStuff musicObject = new musicStuff();
//				musicObject.playMusic(dialupSound);
//				JOptionPane.showMessageDialog(null, "Signing in... ");
				
				//poop
			}
		});
		
		
		
	}
}
