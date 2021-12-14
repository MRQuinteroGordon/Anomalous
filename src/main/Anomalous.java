package main;
/**
 * Main driver program for the Anomalous game. 
 * @author Michelle Gordon
 * @version 2.4
 */
import java.util.concurrent.TimeUnit;
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
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.SQLException;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Button;
import javax.swing.border.LineBorder;
import java.awt.Component;
import java.awt.SystemColor;

public class Anomalous extends JFrame {

	private JPanel contentPane;
	private JTextField txtfldEnterName;
	Player player;
//	StoryLinkedList story;
	StoryLinkedList2 story2;
	String playerName;
	private JTextField txtFinalHeader;
	private JTextField txtKindlbl;
	private JTextField txtSadLbl;
	private JTextField txtAdvLbl;
	private JTextField txtKscore;
	private JTextField txtSscore;
	private JTextField txtAscore;
	private JTextField txtfldUserName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Anomalous frame = new Anomalous();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
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
		int nanoDivisor = 1000000000;
		long start = System.nanoTime();
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Anomalous.class.getResource("/images/logo.png")));
		setFont(new Font("Nineteen Ninety Three", Font.PLAIN, 12));
		setTitle("Anomalous.exe");
		setBackground(Color.DARK_GRAY);
		setForeground(new Color(0, 0, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 653);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel avatarPanel = new JPanel();
		avatarPanel.setBounds(6, 523, 468, 93);
		contentPane.add(avatarPanel);
		avatarPanel.setLayout(null);
		avatarPanel.setBackground(Color.WHITE);
		
		JLabel lblNetscape = new JLabel("");
		lblNetscape.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNetscape.setIcon(new ImageIcon(Anomalous.class.getResource("/images/netscape_logo.gif")));
		lblNetscape.setBounds(281, 56, 88, 31);
		avatarPanel.add(lblNetscape);
		
		JLabel lbl_ieLogo = new JLabel("");
		lbl_ieLogo.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_ieLogo.setIcon(new ImageIcon(Anomalous.class.getResource("/images/ie_logo.gif")));
		lbl_ieLogo.setBounds(374, 56, 88, 31);
		avatarPanel.add(lbl_ieLogo);
		
		JLabel lbl_powerby = new JLabel("Powered By:");
		lbl_powerby.setFont(new Font("Nineteen Ninety Three", Font.PLAIN, 12));
		lbl_powerby.setBounds(328, 35, 80, 25);
		avatarPanel.add(lbl_powerby);
		
		JLabel lblAvatar = new JLabel("");
		lblAvatar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatar.setIcon(new ImageIcon(Anomalous.class.getResource("/images/avatar.png")));
		lblAvatar.setBounds(16, 14, 67, 64);
		avatarPanel.add(lblAvatar);
		lblAvatar.setVisible(false);
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.WHITE);
		topPanel.setBounds(6, 11, 468, 235);
		contentPane.add(topPanel);
		topPanel.setLayout(null);
		
		JTextPane txtAnomalous = new JTextPane();
		txtAnomalous.setBounds(20, 75, 427, 48);
		topPanel.add(txtAnomalous);
		txtAnomalous.setBackground(Color.WHITE);
		txtAnomalous.setEditable(false);
		txtAnomalous.setForeground(new Color(255, 204, 51));
		txtAnomalous.setFont(new Font("A Goblin Appears!", Font.BOLD, 42));
		txtAnomalous.setText("ANOMALOUS");
		
		JTextPane txtWelcome = new JTextPane();
		txtWelcome.setBounds(156, 29, 156, 34);
		topPanel.add(txtWelcome);
		txtWelcome.setBackground(Color.WHITE);
		txtWelcome.setEditable(false);
		txtWelcome.setFont(new Font("Nineteen Ninety Seven", Font.PLAIN, 20));
		txtWelcome.setText("Welcome to");
		
		JTextPane txtIntFict = new JTextPane();
		txtIntFict.setBounds(36, 155, 396, 34);
		topPanel.add(txtIntFict);
		txtIntFict.setBackground(Color.WHITE);
		txtIntFict.setEditable(false);
		txtIntFict.setText("An Interactive Fiction Story");
		txtIntFict.setFont(new Font("Nineteen Ninety Seven", Font.PLAIN, 20));
		
		JTextPane txtTwist = new JTextPane();
		txtTwist.setBounds(131, 185, 205, 39);
		topPanel.add(txtTwist);
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
		topPanel.add(txtAnomalous_1);
		
		JPanel startPanel = new JPanel();
		startPanel.setBounds(6, 276, 468, 235);
		contentPane.add(startPanel);
		startPanel.setLayout(null);
		
		JTextPane txtEnterName = new JTextPane();
		txtEnterName.setBounds(27, 23, 409, 48);
		startPanel.add(txtEnterName);
		txtEnterName.setBackground(UIManager.getColor("Button.background"));
		txtEnterName.setEditable(false);
		txtEnterName.setFont(new Font("Nineteen Ninety Seven", Font.PLAIN, 18));
		txtEnterName.setText("Please enter your name to start:");
		
		txtfldEnterName = new JTextField();
		txtfldEnterName.setHorizontalAlignment(SwingConstants.LEFT);
		txtfldEnterName.setForeground(new Color(153, 0, 0));
		txtfldEnterName.setToolTipText("Enter Name Here");
		txtfldEnterName.setBounds(122, 76, 219, 29);
		startPanel.add(txtfldEnterName);
		txtfldEnterName.setFont(new Font("Nineteen Ninety Three", Font.PLAIN, 16));
		txtfldEnterName.setColumns(10);
		
		JButton btnStart = new JButton("START");
		btnStart.setBounds(150, 117, 163, 34);
		startPanel.add(btnStart);
		btnStart.setFont(new Font("Nineteen Ninety Seven", Font.BOLD, 20));
		
		JPanel storyPanel = new JPanel();
		storyPanel.setBackground(Color.WHITE);
		storyPanel.setBounds(6, 11, 468, 235);
		contentPane.add(storyPanel);
		storyPanel.setLayout(null);
		
		JTextPane txtStory = new JTextPane();
		txtStory.setText("It’s dark, quiet, and the temperature is perfect under your blankets.  The only reason you have woken from your deep slumber is that your ears have suddenly become aware of a piercing sound grating on your ears.  “Ah, my alarm is going off” you say.  That sleep inertia thing is weighing heavy on you, and you’re dreading leaving the warmth of your blanket.  \n\nYou look toward your alarm clock and:");
		txtStory.setEditable(false);
		txtStory.setFont(new Font("Nineteen Ninety Seven", Font.PLAIN, 14));
		txtStory.setBounds(6, 6, 456, 223);
		storyPanel.add(txtStory);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.WHITE);
		buttonPanel.setBounds(6, 276, 468, 235);
		contentPane.add(buttonPanel);
		buttonPanel.setLayout(null);
		
		JButton btnOptA = new JButton("OPTION A");
		btnOptA.setVerifyInputWhenFocusTarget(false);
		btnOptA.setFocusable(false);
		btnOptA.setFocusTraversalKeysEnabled(false);
		btnOptA.setFocusPainted(false);
		btnOptA.setRequestFocusEnabled(false);
		btnOptA.setForeground(new Color(153, 0, 0));
		btnOptA.setFont(new Font("Nineteen Ninety Three", Font.PLAIN, 16));
		btnOptA.setBounds(6, 37, 117, 29);
		buttonPanel.add(btnOptA);
		
		JButton btnOptB = new JButton("OPTION B");
		btnOptB.setVerifyInputWhenFocusTarget(false);
		btnOptB.setFocusable(false);
		btnOptB.setFocusTraversalKeysEnabled(false);
		btnOptB.setFocusPainted(false);
		btnOptB.setRequestFocusEnabled(false);
		btnOptB.setForeground(new Color(153, 0, 0));
		btnOptB.setFont(new Font("Nineteen Ninety Three", Font.PLAIN, 16));
		btnOptB.setBounds(6, 103, 117, 29);
		buttonPanel.add(btnOptB);
		
		JButton btnOptC = new JButton("OPTION C");
		btnOptC.setVerifyInputWhenFocusTarget(false);
		btnOptC.setFocusable(false);
		btnOptC.setFocusTraversalKeysEnabled(false);
		btnOptC.setFocusPainted(false);
		btnOptC.setRequestFocusEnabled(false);
		btnOptC.setForeground(new Color(153, 0, 0));
		btnOptC.setFont(new Font("Nineteen Ninety Three", Font.PLAIN, 16));
		btnOptC.setBounds(6, 169, 117, 29);
		buttonPanel.add(btnOptC);
		
//		JTextPane txtOptA = new JTextPane();
		JTextArea txtOptA = new JTextArea();
		txtOptA.setLineWrap(true);
		txtOptA.setEditable(false);
		txtOptA.setText("Hit the snooze button.  You only need five more minutes… plus another twenty-five minutes… maybe plus another fifteen more. ");
		txtOptA.setFont(new Font("Nineteen Ninety Three", Font.PLAIN, 12));
		txtOptA.setBounds(124, 24, 326, 55);
		buttonPanel.add(txtOptA);
		
		JTextArea txtOptB = new JTextArea();
		txtOptB.setLineWrap(true);
		txtOptB.setEditable(false);
		txtOptB.setText("Smash the dismiss button.  Bracing yourself for the shock of the cold air, you throw off your blanket. Whew! It’s great to be alive!");
		txtOptB.setFont(new Font("Nineteen Ninety Three", Font.PLAIN, 12));
		txtOptB.setBounds(124, 91, 326, 55);
		buttonPanel.add(txtOptB);
		
		JTextArea txtOptC = new JTextArea();
		txtOptC.setLineWrap(true);
		txtOptC.setEditable(false);
		txtOptC.setText("Carefully press the dismiss button. Your bed is beckoning you but you need to get to school early for the theatre club presidency meeting. ");
		txtOptC.setFont(new Font("Nineteen Ninety Three", Font.PLAIN, 12));
		txtOptC.setBounds(124, 156, 326, 55);
		buttonPanel.add(txtOptC);
		
		JPanel reportPanel = new JPanel();
		reportPanel.setBackground(new Color(255, 255, 255));
		reportPanel.setBounds(6, 11, 468, 376);
		contentPane.add(reportPanel);
		reportPanel.setLayout(null);
		
//		JTextPane txtCongrats = new JTextPane();
		JTextField txtCongrats = new JTextField();
		txtCongrats.setBorder(null);
		txtCongrats.setHorizontalAlignment(SwingConstants.CENTER);
//		JTextArea txtCongrats = new JTextArea();
		txtCongrats.setEditable(false);
		txtCongrats.setForeground(new Color(153, 0, 0));
		txtCongrats.setFont(new Font("Nineteen Ninety Seven", Font.PLAIN, 20));
		txtCongrats.setText("Congratulations");
		txtCongrats.setBounds(111, 6, 246, 33);
		reportPanel.add(txtCongrats);
		
		JLabel lblBelcherPic = new JLabel("");
		lblBelcherPic.setHorizontalAlignment(SwingConstants.CENTER);
		lblBelcherPic.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblBelcherPic.setIcon(new ImageIcon(Anomalous.class.getResource("/images/tina-original.jpeg")));
		lblBelcherPic.setBounds(38, 72, 392, 209);
		reportPanel.add(lblBelcherPic);
		
		JTextPane txtPersonalityReport = new JTextPane();
		txtPersonalityReport.setEditable(false);
		txtPersonalityReport.setFont(new Font("Nineteen Ninety Seven", Font.PLAIN, 14));
		txtPersonalityReport.setText("You finished the game with the highest score in the kindness trait.  This means you are just like Tina Belcher - sweet, smart, and sensual! ");
		txtPersonalityReport.setBounds(6, 290, 456, 80);
		reportPanel.add(txtPersonalityReport);
		
		txtfldUserName = new JTextField();
		txtfldUserName.setBorder(null);
		txtfldUserName.setText("Username!");
		txtfldUserName.setHorizontalAlignment(SwingConstants.CENTER);
		txtfldUserName.setForeground(new Color(153, 0, 0));
		txtfldUserName.setFont(new Font("Nineteen Ninety Seven", Font.PLAIN, 18));
		txtfldUserName.setEditable(false);
		txtfldUserName.setBounds(111, 39, 246, 33);
		reportPanel.add(txtfldUserName);
		
		JTextArea txtPlayerHistReport = new JTextArea();
		txtPlayerHistReport.setBackground(SystemColor.activeCaption);
		txtPlayerHistReport.setForeground(SystemColor.desktop);
		txtPlayerHistReport.setFont(new Font("Nineteen Ninety Three", Font.PLAIN, 10));
		txtPlayerHistReport.setEditable(false);
		txtPlayerHistReport.setBounds(6, 6, 456, 550);
		reportPanel.add(txtPlayerHistReport);
		txtPlayerHistReport.setVisible(false);
		
		JPanel finalScorePanel = new JPanel();
		finalScorePanel.setBackground(SystemColor.activeCaption);
		finalScorePanel.setBounds(6, 399, 468, 154);
		contentPane.add(finalScorePanel);
		finalScorePanel.setLayout(null);
		
		txtFinalHeader = new JTextField();
		txtFinalHeader.setBorder(null);
		txtFinalHeader.setBounds(84, 6, 300, 31);
		finalScorePanel.add(txtFinalHeader);
		txtFinalHeader.setHorizontalAlignment(SwingConstants.CENTER);
		txtFinalHeader.setForeground(new Color(153, 0, 0));
		txtFinalHeader.setText("FINAL SCORES");
		txtFinalHeader.setFont(new Font("Nineteen Ninety Seven", Font.BOLD, 16));
		txtFinalHeader.setEditable(false);
		txtFinalHeader.setColumns(10);
		
		txtKindlbl = new JTextField();
		txtKindlbl.setBorder(null);
		txtKindlbl.setEditable(false);
		txtKindlbl.setHorizontalAlignment(SwingConstants.RIGHT);
		txtKindlbl.setText("AWKWARD/KIND:");
		txtKindlbl.setForeground(new Color(0, 0, 0));
		txtKindlbl.setFont(new Font("Nineteen Ninety Three", Font.PLAIN, 16));
		txtKindlbl.setBounds(120, 32, 132, 28);
		finalScorePanel.add(txtKindlbl);
		txtKindlbl.setColumns(10);
		
		txtSadLbl = new JTextField();
		txtSadLbl.setBorder(null);
		txtSadLbl.setText("SADDISTIC:");
		txtSadLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSadLbl.setForeground(new Color(0, 0, 0));
		txtSadLbl.setFont(new Font("Nineteen Ninety Three", Font.PLAIN, 16));
		txtSadLbl.setEditable(false);
		txtSadLbl.setColumns(10);
		txtSadLbl.setBounds(120, 59, 132, 28);
		finalScorePanel.add(txtSadLbl);
		
		txtAdvLbl = new JTextField();
		txtAdvLbl.setBorder(null);
		txtAdvLbl.setText("ADVENTUROUS:");
		txtAdvLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		txtAdvLbl.setForeground(new Color(0, 0, 0));
		txtAdvLbl.setFont(new Font("Nineteen Ninety Three", Font.PLAIN, 16));
		txtAdvLbl.setEditable(false);
		txtAdvLbl.setColumns(10);
		txtAdvLbl.setBounds(120, 85, 132, 28);
		finalScorePanel.add(txtAdvLbl);
		
		txtKscore = new JTextField();
		txtKscore.setText("score");
		txtKscore.setHorizontalAlignment(SwingConstants.CENTER);
		txtKscore.setForeground(Color.BLACK);
		txtKscore.setFont(new Font("Nineteen Ninety Three", Font.BOLD, 16));
		txtKscore.setEditable(false);
		txtKscore.setColumns(10);
		txtKscore.setBorder(null);
		txtKscore.setBounds(261, 32, 84, 28);
		finalScorePanel.add(txtKscore);
		
		txtSscore = new JTextField();
		txtSscore.setText("score");
		txtSscore.setHorizontalAlignment(SwingConstants.CENTER);
		txtSscore.setForeground(Color.BLACK);
		txtSscore.setFont(new Font("Nineteen Ninety Three", Font.BOLD, 16));
		txtSscore.setEditable(false);
		txtSscore.setColumns(10);
		txtSscore.setBorder(null);
		txtSscore.setBounds(261, 59, 84, 28);
		finalScorePanel.add(txtSscore);
		
		txtAscore = new JTextField();
		txtAscore.setText("score");
		txtAscore.setHorizontalAlignment(SwingConstants.CENTER);
		txtAscore.setForeground(Color.BLACK);
		txtAscore.setFont(new Font("Nineteen Ninety Three", Font.BOLD, 16));
		txtAscore.setEditable(false);
		txtAscore.setColumns(10);
		txtAscore.setBorder(null);
		txtAscore.setBounds(261, 85, 84, 28);
		finalScorePanel.add(txtAscore);
		
		JPanel playerHistbtnPanel = new JPanel();
		playerHistbtnPanel.setBounds(6, 552, 468, 67);
		contentPane.add(playerHistbtnPanel);
		playerHistbtnPanel.setLayout(null);
		
		JButton btnPlayerHist = new JButton("PAST GAMER SCORES");
		btnPlayerHist.setBounds(42, 18, 384, 31);
		playerHistbtnPanel.add(btnPlayerHist);
		btnPlayerHist.setBackground(new Color(255, 204, 51));
		btnPlayerHist.setFont(new Font("Nineteen Ninety Seven", Font.BOLD, 20));
		btnPlayerHist.setVisible(false);
		
		storyPanel.setVisible(false);
		buttonPanel.setVisible(false);
		reportPanel.setVisible(false);
		finalScorePanel.setVisible(false);
		
		long end = System.nanoTime();
		long duration = end - start;
		double seconds = (double)duration/nanoDivisor;
		System.out.printf("%n%nStarting Game Process Duration: %,d nanoseconds [%.10f seconds]%n", duration, seconds);
		
		/**
		 * Creates a listener for the start button
		 * which will run the username generator method
		 * when clicked.
		 */
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UIManager.put("OptionPane.messageFont", new Font("Nineteen Ninety Seven", Font.PLAIN, 16));
				UIManager.put("OptionPane.buttonFont", new Font("Nineteen Ninety Three", Font.PLAIN, 12));
				playerName = txtfldEnterName.getText();
				if (playerName.length() < 3) {
					UNGenerator ungen = new UNGenerator("Turd Ferguson");
					JOptionPane.showMessageDialog(null, "Your name must be at least 3 characters long.  Don't worry though, I will give you a default.");
					player = new Player(playerName, ungen.username);
				}
				else {
					int nanoDivisor = 1000000000;
					long start = System.nanoTime();
					UNGenerator ungen = new UNGenerator(playerName);
					long end = System.nanoTime();
					long duration = end - start;
					double seconds = (double)duration/nanoDivisor;
					System.out.printf("%n%nUsername Generator Process Duration: %,d nanoseconds [%.10f seconds]%n", duration, seconds);
					player = new Player(playerName, ungen.username);
				}
				
				
				JOptionPane.showMessageDialog(null, "Welcome " + player.name + "!\nYour username is: " + player.username);

				topPanel.setVisible(false);
				startPanel.setVisible(false);
				JOptionPane.showMessageDialog(null, "Signing in... ");				
				storyPanel.setVisible(true);
				buttonPanel.setVisible(true);
				lblAvatar.setVisible(true);
				
				try {
					story2 = new StoryLinkedList2();
				}
				catch (SQLException e2) {
					e2.printStackTrace();
				}
				

				/**
				 * Listener for the Option-A button.  This will be the same code as the 
				 * Option-B and Option-C button listeners, except that this will augment
				 * the player's kind score and pull up story text version A.  
				 * Once the player has gone through all of the story parts 
				 * the screen will change (by setting certain panes to visible and others to
				 * invisible), and present the final report.  
				 */
				btnOptA.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						player.kind += 10;
						StoryNode2 current = story2.traverseList();
						if (current != null) {
							txtStory.setText(current.storyTxta);
							txtOptA.setText(current.actionTxta);
							txtOptB.setText(current.actionTxtb);
							txtOptC.setText(current.actionTxtc);
							player.printScores();
							System.out.println("max is: " + player.max());
						}
						else {
							storyPanel.setVisible(false);
							buttonPanel.setVisible(false);
							lblAvatar.setVisible(false);
							avatarPanel.setVisible(false);
							reportPanel.setVisible(true);
							finalScorePanel.setVisible(true);
							playerHistbtnPanel.setVisible(true);
							txtKscore.setText(String.valueOf(player.kind));
							txtSscore.setText(String.valueOf(player.saddistic));
							txtAscore.setText(String.valueOf(player.adventurous));
							txtfldUserName.setText(player.username + "!");
							String[] reportStuff = report(player.max());
							txtPersonalityReport.setText(reportStuff[0]);
							lblBelcherPic.setIcon(new ImageIcon(Anomalous.class.getResource(reportStuff[1])));
							try {
								player.saveData();
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							btnPlayerHist.setVisible(true);	
						}	
					}
				});
				
				
				btnOptB.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						player.saddistic += 10;
						StoryNode2 current = story2.traverseList();
						if (current != null) {
							txtStory.setText(current.storyTxtb);
							txtOptA.setText(current.actionTxta);
							txtOptB.setText(current.actionTxtb);
							txtOptC.setText(current.actionTxtc);
							player.printScores();
							System.out.println("max is: " + player.max());
						}
						else {
							storyPanel.setVisible(false);
							buttonPanel.setVisible(false);
							lblAvatar.setVisible(false);
							avatarPanel.setVisible(false);
							reportPanel.setVisible(true);
							finalScorePanel.setVisible(true);
							playerHistbtnPanel.setVisible(true);
							txtKscore.setText(String.valueOf(player.kind));
							txtSscore.setText(String.valueOf(player.saddistic));
							txtAscore.setText(String.valueOf(player.adventurous));
							txtfldUserName.setText(player.username + "!");
							String[] reportStuff = report(player.max());
							txtPersonalityReport.setText(reportStuff[0]);
							lblBelcherPic.setIcon(new ImageIcon(Anomalous.class.getResource(reportStuff[1])));
							try {
								player.saveData();
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							btnPlayerHist.setVisible(true);
							
							
						}
						player.printScores();
						System.out.println("max is: " + player.max());
					}
				});
				
				
				btnOptC.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						player.adventurous += 10;
						StoryNode2 current = story2.traverseList();
						if (current != null) {
							txtStory.setText(current.storyTxtc);
							txtOptA.setText(current.actionTxta);
							txtOptB.setText(current.actionTxtb);
							txtOptC.setText(current.actionTxtc);
							player.printScores();
							System.out.println("max is: " + player.max());
						}
						else {
							storyPanel.setVisible(false);
							buttonPanel.setVisible(false);
							lblAvatar.setVisible(false);
							avatarPanel.setVisible(false);
							reportPanel.setVisible(true);
							finalScorePanel.setVisible(true);
							playerHistbtnPanel.setVisible(true);
							txtKscore.setText(String.valueOf(player.kind));
							txtSscore.setText(String.valueOf(player.saddistic));
							txtAscore.setText(String.valueOf(player.adventurous));
							txtfldUserName.setText(player.username + "!");
							String[] reportStuff = report(player.max());
							txtPersonalityReport.setText(reportStuff[0]);
							lblBelcherPic.setIcon(new ImageIcon(Anomalous.class.getResource(reportStuff[1])));
							try {
								player.saveData();
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							btnPlayerHist.setVisible(true);
						}
					}
				});	
			}
		});
		
		
		/**
		 * This button listener will show the user a report with data from
		 * previous players of the game, including the date they played and
		 * the different personality scores they ended with. 
		 */
		btnPlayerHist.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				playerHistbtnPanel.setVisible(false);
				finalScorePanel.setVisible(false);
				lblBelcherPic.setVisible(false);
				txtCongrats.setVisible(false);
				txtPersonalityReport.setVisible(false);
				txtfldUserName.setVisible(false);
				txtPlayerHistReport.setVisible(true);
				txtPlayerHistReport.setBackground(new Color(0, 0, 0));
				reportPanel.setBackground(new Color(0, 0, 0));
				contentPane.setBackground(new Color(0, 0, 0));
				reportPanel.setBounds(6, 11, 468, 550);
				
				//CALL METHOD THAT INSERTS DATA INTO txtPlayerHistReport
				txtPlayerHistReport.setText(histReport());
			}
		});
		
		
//		String dialupSound = "dialup.wav";
//		musicStuff musicObject = new musicStuff();
//		musicObject.playMusic(dialupSound);	
			
		
	}
	
	/**
	 * this method produces the content for the final report screen.  This includes the description and file location
	 * address for the image of the Belcher character you are matched up with. 
	 * The highScore parameter is what tells the method which image and text to select.  
	 * The content and image file location info is return as a string array.
	 * @param highScore
	 * @return
	 */
	public String[] report(int highScore) {
		String[] stuff = new String[2];
		String tina = "You finished the game with the highest score in the kindness trait.  This means you are just like Tina Belcher - sweet, smart, and sensual! ";
		String louise = "You finished the game with the highest score in the saddistic trait.  This means you are just like Louise Belcher - pure evil in the cutest of ways.";
		String gene = "You finished the game with the highest score in the adventurous trait.  This means you are just like Gene Belcher - a funloving musical genius.";
		
		String tImg = "/images/tina-original.jpeg";
		String lImg = "/images/louise-hell.gif";
		String gImg = "/images/gene-guitarhero.jpeg";
		
		if(highScore == 0) {
			stuff[0] = tina;
			stuff[1] = tImg;
			return stuff;
		}
		else if(highScore == 1){
			stuff[0] = louise;
			stuff[1] = lImg;
			return stuff;
		}
		else if(highScore == 2) {
			stuff[0] = gene;
			stuff[1] = gImg;
			return stuff;
		}
		else {
			stuff[0] = tina;
			stuff[1] = tImg;
			return stuff;
		}
	}
	
	/**
	 * This method produces the content for the player history report.  It calls a method (loadList)
	 * that loads data from the database into an array that can then be printed out on the screen.  
	 * @return
	 */
	public String histReport() {
		//txtPlayerHistReport is where report should be populated

		try {
			String[][] hstRpt = History.loadList();
			String rptContent = "";
			for (int i = 0; i < hstRpt.length; i++) {
				for (int j = 0; j < hstRpt[0].length; j++) {
					rptContent += hstRpt[i][j] + "\t";
				}
				rptContent += "\n";
			}
			return rptContent;
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return "oopsie.  Didn't work!";
	}
}



