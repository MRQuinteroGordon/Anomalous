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

public class Anomalous extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterNameHere;
	private JTextField txtStuffAndThings;

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
		setTitle("Anomalous.exe");
		setBackground(new Color(51, 204, 51));
		setForeground(new Color(0, 0, 255));
		//setIconImage(Toolkit.getDefaultToolkit().getImage(Anomalous.class.getResource("/images/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 619);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(204, 204, 204));
		separator.setBackground(new Color(204, 204, 204));
		separator.setBounds(0, 257, 440, 7);
		contentPane.add(separator);
		
		JTextPane txtpnWelcomeTo = new JTextPane();
		txtpnWelcomeTo.setEditable(false);
		txtpnWelcomeTo.setFont(new Font("Nineteen Ninety Seven", Font.PLAIN, 20));
		txtpnWelcomeTo.setText("Welcome to");
		txtpnWelcomeTo.setBounds(147, 11, 156, 34);
		contentPane.add(txtpnWelcomeTo);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(204, 204, 204));
		separator_1.setBounds(0, 511, 450, 7);
		contentPane.add(separator_1);
		
		JTextPane txtpnAnomalous = new JTextPane();
		txtpnAnomalous.setEditable(false);
		txtpnAnomalous.setForeground(new Color(255, 204, 51));
		txtpnAnomalous.setFont(new Font("A Goblin Appears!", Font.BOLD, 42));
		txtpnAnomalous.setText("ANOMALOUS");
		txtpnAnomalous.setBounds(5, 79, 440, 48);
		contentPane.add(txtpnAnomalous);
		
		JTextPane txtpnAnInteractiveFiction = new JTextPane();
		txtpnAnInteractiveFiction.setEditable(false);
		txtpnAnInteractiveFiction.setText("An Interactive Fiction Story");
		txtpnAnInteractiveFiction.setFont(new Font("Nineteen Ninety Seven", Font.PLAIN, 20));
		txtpnAnInteractiveFiction.setBounds(27, 142, 396, 34);
		contentPane.add(txtpnAnInteractiveFiction);
		
		JTextPane txtpnWithATwist = new JTextPane();
		txtpnWithATwist.setEditable(false);
		txtpnWithATwist.setText("...With a Twist...");
		txtpnWithATwist.setForeground(new Color(204, 0, 0));
		txtpnWithATwist.setFont(new Font("Nineteen Ninety Seven", Font.ITALIC, 24));
		txtpnWithATwist.setBounds(98, 187, 254, 39);
		contentPane.add(txtpnWithATwist);
		
		JTextPane txtpnPleaseEnterYour = new JTextPane();
		txtpnPleaseEnterYour.setEditable(false);
		txtpnPleaseEnterYour.setFont(new Font("Nineteen Ninety Seven", Font.PLAIN, 18));
		txtpnPleaseEnterYour.setText("Please enter your name to start:");
		txtpnPleaseEnterYour.setBounds(20, 295, 409, 48);
		contentPane.add(txtpnPleaseEnterYour);
		
		txtEnterNameHere = new JTextField();
		txtEnterNameHere.setEditable(false);
		txtEnterNameHere.setToolTipText("Enter name here");
		txtEnterNameHere.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterNameHere.setBackground(new Color(255, 255, 255));
		txtEnterNameHere.setFont(new Font("Nineteen Ninety Three", Font.PLAIN, 19));
		txtEnterNameHere.setBounds(112, 336, 225, 39);
		contentPane.add(txtEnterNameHere);
		txtEnterNameHere.setColumns(10);
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.setFont(new Font("Nineteen Ninety Seven", Font.BOLD, 20));
		btnNewButton.setBounds(143, 383, 163, 34);
		contentPane.add(btnNewButton);
		
		txtStuffAndThings = new JTextField();
		txtStuffAndThings.setFont(new Font("A Goblin Appears!", Font.PLAIN, 11));
		txtStuffAndThings.setText("stuff and things");
		txtStuffAndThings.setEditable(false);
		txtStuffAndThings.setBounds(10, 511, 219, 48);
		contentPane.add(txtStuffAndThings);
		txtStuffAndThings.setColumns(10);
	}
}
