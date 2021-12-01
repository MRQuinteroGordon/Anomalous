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
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Anomalous extends JFrame {

	private JPanel contentPane;
	private JTextField nametxt;

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
		//setIconImage(Toolkit.getDefaultToolkit().getImage(main.Anomalous.class.getResource("/anomalous/images/logo.png")));
		setFont(new Font("Nineteen Ninety Three", Font.PLAIN, 12));
		setTitle("Anomalous.exe");
		setBackground(Color.RED);
		setForeground(new Color(0, 0, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 635);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(204, 204, 204));
		separator.setBackground(new Color(204, 204, 204));
		separator.setBounds(0, 257, 440, 7);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(204, 204, 204));
		separator_1.setBounds(0, 511, 450, 7);
		contentPane.add(separator_1);
		
		JTextPane txtpnPleaseEnterYour = new JTextPane();
		txtpnPleaseEnterYour.setBackground(UIManager.getColor("Button.background"));
		txtpnPleaseEnterYour.setEditable(false);
		txtpnPleaseEnterYour.setFont(new Font("Nineteen Ninety Seven", Font.PLAIN, 18));
		txtpnPleaseEnterYour.setText("Please enter your name to start:");
		txtpnPleaseEnterYour.setBounds(26, 295, 409, 48);
		contentPane.add(txtpnPleaseEnterYour);
		
		JPanel toppanel = new JPanel();
		toppanel.setBounds(0, 11, 468, 235);
		contentPane.add(toppanel);
		toppanel.setLayout(null);
		
		JTextPane txtpnWelcomeTo = new JTextPane();
		txtpnWelcomeTo.setBounds(156, 29, 156, 34);
		toppanel.add(txtpnWelcomeTo);
		txtpnWelcomeTo.setBackground(UIManager.getColor("Button.background"));
		txtpnWelcomeTo.setEditable(false);
		txtpnWelcomeTo.setFont(new Font("Nineteen Ninety Seven", Font.PLAIN, 20));
		txtpnWelcomeTo.setText("Welcome to");
		
		JTextPane txtpnAnomalous = new JTextPane();
		txtpnAnomalous.setBounds(14, 74, 440, 48);
		toppanel.add(txtpnAnomalous);
		txtpnAnomalous.setBackground(UIManager.getColor("Button.background"));
		txtpnAnomalous.setEditable(false);
		txtpnAnomalous.setForeground(new Color(255, 204, 51));
		txtpnAnomalous.setFont(new Font("A Goblin Appears!", Font.BOLD, 42));
		txtpnAnomalous.setText("ANOMALOUS");
		
		JTextPane txtpnAnInteractiveFiction = new JTextPane();
		txtpnAnInteractiveFiction.setBounds(36, 155, 396, 34);
		toppanel.add(txtpnAnInteractiveFiction);
		txtpnAnInteractiveFiction.setBackground(UIManager.getColor("Button.background"));
		txtpnAnInteractiveFiction.setEditable(false);
		txtpnAnInteractiveFiction.setText("An Interactive Fiction Story");
		txtpnAnInteractiveFiction.setFont(new Font("Nineteen Ninety Seven", Font.PLAIN, 20));
		
		JTextPane txtpnWithATwist = new JTextPane();
		txtpnWithATwist.setBounds(131, 185, 205, 39);
		toppanel.add(txtpnWithATwist);
		txtpnWithATwist.setBackground(UIManager.getColor("Button.background"));
		txtpnWithATwist.setEditable(false);
		txtpnWithATwist.setText("with a twist!");
		txtpnWithATwist.setForeground(new Color(204, 0, 0));
		txtpnWithATwist.setFont(new Font("Nineteen Ninety Seven", Font.ITALIC, 24));
		
		JButton start_btn = new JButton("START");
		start_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String playername = nametxt.getText();
				JOptionPane.showMessageDialog(null, "Henlo Fren");
				toppanel.hide();
			}
		});
		start_btn.setFont(new Font("Nineteen Ninety Seven", Font.BOLD, 20));
		start_btn.setBounds(149, 383, 163, 34);
		contentPane.add(start_btn);
		
		nametxt = new JTextField();
		nametxt.setFont(new Font("Nineteen Ninety Three", Font.PLAIN, 16));
		nametxt.setBounds(121, 333, 219, 38);
		contentPane.add(nametxt);
		nametxt.setColumns(10);
		
		
	}
}
