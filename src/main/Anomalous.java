package main;
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
import java.sql.SQLException;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Button;
import javax.swing.border.LineBorder;

public class Anomalous extends JFrame {

	private JPanel contentPane;
	private JTextField txtfldEnterName;
	Player player;
	StoryLinkedList story;
	String playerName;
	private JTextField txtFinalHeader;
	private JTextField txtKindlbl;
	private JTextField txtSadLbl;
	private JTextField txtAdvLbl;

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
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Anomalous.class.getResource("/images/logo.png")));
		setFont(new Font("Nineteen Ninety Three", Font.PLAIN, 12));
		setTitle("Anomalous.exe");
		setBackground(Color.DARK_GRAY);
		setForeground(new Color(0, 0, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1459, 653);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		startPanel.setBounds(8, 276, 464, 235);
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
		lblAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatar.setIcon(new ImageIcon(Anomalous.class.getResource("/images/tina-original.jpeg")));
		lblAvatar.setBounds(16, 14, 67, 64);
		avatarPanel.add(lblAvatar);
		
		JPanel storyPanel = new JPanel();
		storyPanel.setBackground(Color.WHITE);
		storyPanel.setBounds(486, 11, 468, 235);
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
		buttonPanel.setBounds(484, 276, 468, 235);
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
		
		JTextPane txtOptA = new JTextPane();
		txtOptA.setEditable(false);
		txtOptA.setText("Hit the snooze button.  You only need five more minutes… plus another twenty-five minutes… maybe plus another fifteen more. ");
		txtOptA.setFont(new Font("Nineteen Ninety Three", Font.PLAIN, 12));
		txtOptA.setBounds(124, 24, 326, 55);
		buttonPanel.add(txtOptA);
		
		JTextPane txtOptB = new JTextPane();
		txtOptB.setEditable(false);
		txtOptB.setText("Smash the dismiss button.  Bracing yourself for the shock of the cold air, you throw off your blanket. Whew! It’s great to be alive!");
		txtOptB.setFont(new Font("Nineteen Ninety Three", Font.PLAIN, 12));
		txtOptB.setBounds(124, 91, 326, 55);
		buttonPanel.add(txtOptB);
		
		JTextPane txtOptC = new JTextPane();
		txtOptC.setEditable(false);
		txtOptC.setText("Carefully press the dismiss button. Your bed is beckoning you but you need to get to school early for the theatre club presidency meeting. ");
		txtOptC.setFont(new Font("Nineteen Ninety Three", Font.PLAIN, 12));
		txtOptC.setBounds(124, 156, 326, 55);
		buttonPanel.add(txtOptC);
		
		JPanel reportPanel = new JPanel();
		reportPanel.setBackground(new Color(255, 255, 255));
		reportPanel.setBounds(965, 11, 468, 354);
		contentPane.add(reportPanel);
		reportPanel.setLayout(null);
		
		JTextPane txtCongrats = new JTextPane();
		txtCongrats.setEditable(false);
		txtCongrats.setForeground(new Color(153, 0, 0));
		txtCongrats.setFont(new Font("Nineteen Ninety Seven", Font.PLAIN, 20));
		txtCongrats.setText("Congratulations!");
		txtCongrats.setBounds(120, 6, 228, 28);
		reportPanel.add(txtCongrats);
		
		JLabel lblBelcherPic = new JLabel("");
		lblBelcherPic.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblBelcherPic.setIcon(new ImageIcon(Anomalous.class.getResource("/images/tina-original.jpeg")));
		lblBelcherPic.setBounds(38, 50, 392, 209);
		reportPanel.add(lblBelcherPic);
		
		JTextPane txtPersonalityReport = new JTextPane();
		txtPersonalityReport.setEditable(false);
		txtPersonalityReport.setFont(new Font("Nineteen Ninety Seven", Font.PLAIN, 14));
		txtPersonalityReport.setText("You finished the game with the highest score in the kindness trait.  This means you are just like Tina Belcher - sweet, smart, and sensual! ");
		txtPersonalityReport.setBounds(6, 268, 456, 80);
		reportPanel.add(txtPersonalityReport);
		
		JPanel finalScorePanel = new JPanel();
		finalScorePanel.setBackground(new Color(255, 255, 255));
		finalScorePanel.setBounds(964, 374, 468, 242);
		contentPane.add(finalScorePanel);
		finalScorePanel.setLayout(null);
		
		txtFinalHeader = new JTextField();
		txtFinalHeader.setBounds(84, 6, 300, 38);
		finalScorePanel.add(txtFinalHeader);
		txtFinalHeader.setHorizontalAlignment(SwingConstants.CENTER);
		txtFinalHeader.setForeground(new Color(153, 0, 0));
		txtFinalHeader.setText("FINAL SCORES");
		txtFinalHeader.setFont(new Font("Nineteen Ninety Seven", Font.BOLD, 16));
		txtFinalHeader.setEditable(false);
		txtFinalHeader.setColumns(10);
		
		txtKindlbl = new JTextField();
		txtKindlbl.setEditable(false);
		txtKindlbl.setHorizontalAlignment(SwingConstants.LEFT);
		txtKindlbl.setText("KIND: 250");
		txtKindlbl.setForeground(new Color(0, 0, 0));
		txtKindlbl.setFont(new Font("Nineteen Ninety Three", Font.PLAIN, 16));
		txtKindlbl.setBounds(8, 52, 187, 38);
		finalScorePanel.add(txtKindlbl);
		txtKindlbl.setColumns(10);
		
		txtSadLbl = new JTextField();
		txtSadLbl.setText("SADDISTIC: 200");
		txtSadLbl.setHorizontalAlignment(SwingConstants.LEFT);
		txtSadLbl.setForeground(new Color(0, 0, 0));
		txtSadLbl.setFont(new Font("Nineteen Ninety Three", Font.PLAIN, 16));
		txtSadLbl.setEditable(false);
		txtSadLbl.setColumns(10);
		txtSadLbl.setBounds(8, 92, 187, 38);
		finalScorePanel.add(txtSadLbl);
		
		txtAdvLbl = new JTextField();
		txtAdvLbl.setText("ADVENTUROUS: 300");
		txtAdvLbl.setHorizontalAlignment(SwingConstants.LEFT);
		txtAdvLbl.setForeground(new Color(0, 0, 0));
		txtAdvLbl.setFont(new Font("Nineteen Ninety Three", Font.PLAIN, 16));
		txtAdvLbl.setEditable(false);
		txtAdvLbl.setColumns(10);
		txtAdvLbl.setBounds(8, 132, 187, 38);
		finalScorePanel.add(txtAdvLbl);
		
		storyPanel.setVisible(false);
		buttonPanel.setVisible(false);
		lblAvatar.setVisible(false);
		
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playerName = txtfldEnterName.getText();
				UNGenerator ungen = new UNGenerator(playerName);
				player = new Player(playerName, ungen.username);
				
				UIManager.put("OptionPane.messageFont", new Font("Nineteen Ninety Seven", Font.PLAIN, 16));
				UIManager.put("OptionPane.buttonFont", new Font("Nineteen Ninety Three", Font.PLAIN, 12));
				JOptionPane.showMessageDialog(null, "Welcome " + player.name + "!\nYour username is: " + player.username);

				topPanel.setVisible(false);
				startPanel.setVisible(false);
				JOptionPane.showMessageDialog(null, "Signing in... ");
//				try {
//					TimeUnit.SECONDS.sleep(1);
//				} catch (InterruptedException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				
				storyPanel.setVisible(true);
				buttonPanel.setVisible(true);
				lblAvatar.setVisible(true);
				
				try {
					story = new StoryLinkedList();
					story.printList();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
//				System.out.println(story.head.storyPart);
				
//				try {
//					player.saveData();
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//				}
				
//				String dialupSound = "dialup.wav";
//				musicStuff musicObject = new musicStuff();
//				musicObject.playMusic(dialupSound);
				
				
				
//					btnOptA.addMouseListener(new MouseAdapter() {
//						@Override
//						public void mouseClicked(MouseEvent e) {
//							player.kind += 10;
//							txtStory.setText(story.head.storyTxt[player.max()]);
//							player.printScores();
//							System.out.println("max is: " + player.max());
//						}
//					});
//					
//					btnOptB.addMouseListener(new MouseAdapter() {
//						@Override
//						public void mouseClicked(MouseEvent e) {
//							player.saddistic += 10;
//							txtStory.setText(story.head.storyTxt[player.max()]);
//							player.printScores();
//							System.out.println("max is: " + player.max());
//						}
//					});
//					
//					btnOptC.addMouseListener(new MouseAdapter() {
//						@Override
//						public void mouseClicked(MouseEvent e) {
//							player.adventurous += 10;
//							txtStory.setText(story.head.storyTxt[player.max()]);
//							player.printScores();
//							System.out.println("max is: " + player.max());
//						}
//					});
				
				
				
				btnOptA.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						player.kind += 10;
						txtStory.setText(story.head.storyTxt[player.max()]);
						player.printScores();
						System.out.println("max is: " + player.max());
					}
				});
				
				btnOptB.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						player.saddistic += 10;
						txtStory.setText(story.head.storyTxt[player.max()]);
						player.printScores();
						System.out.println("max is: " + player.max());
					}
				});
				
				btnOptC.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						player.adventurous += 10;
						txtStory.setText(story.head.storyTxt[player.max()]);
						player.printScores();
						System.out.println("max is: " + player.max());
					}
				});
					
			}
		});
		
//		int x = 0;
//		do {
//			String max = player.max();
//			if (max == "kind") {
//				System.out.println(player.max());
//				System.out.println("stuff!");
////				txtStory.setText(story.head.storyTxt[0]);
//				x++;
//			}
//			else if (max == "saddistic") {
//				//stuff
//				System.out.print(max);
//				x++;
//			}
//			else {
//				System.out.print(max);
//				x++;
//			}
//				//LEFT OFF HERE LEFT OFF HERE LEFT OFF HERE LEFT OFF HERE!!!!!!!
//			
//		} while (x <= 10);
		

		
		
		
		
	}
}
