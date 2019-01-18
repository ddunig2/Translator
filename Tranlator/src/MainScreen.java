import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class MainScreen extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblYouWereLogged;
	private JRadioButton rdbtnEnglishToSpanish;
	private JRadioButton rdbtnSpanishToEnglish;
	private JButton btnTranslate;
	private JLabel label;
	private MyTranslator mt;
	
	public MainScreen() {
		setResizable(false);
		initialize();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	public void initialize() {
		setTitle("Translator");
		label = new JLabel();
		label.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
		label.setBounds(23, 36, 468, 34);
		
		ImageIcon imageIcon1 = new ImageIcon("Translation_Icon.png");
		Image image1 = imageIcon1.getImage();
		Image newimg1 = image1.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(newimg1));;
		lblNewLabel_3.setBounds(2, 0, 41, 42);
		lblNewLabel_3.setVisible(false);
		 
		ImageIcon imageIcon = new ImageIcon("Translation_Icon.png"); 
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(5000, 5000,  java.awt.Image.SCALE_SMOOTH); 
		setIconImage(newimg);
		mt = new MyTranslator();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 182, 113);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(88, 11, 364, 34);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setVisible(false);
				setVisible(false);
				pause(300);
				lblNewLabel_3.setVisible(true);
				lblYouWereLogged.setVisible(false);
				contentPane.remove(lblYouWereLogged);
				contentPane.remove(btnNewButton);
				setBounds(100, 100, 528, 355);
				setVisible(true);
				Thread t1 = new Thread(new Runnable() {
				    @Override
				    public void run() {
				        pause(500);
				        welcomeMessage1("-Welcome to Lu's database program-"
				        		,"-This is a simple translate program using google api-");
				    }
				});  
				t1.start(); 
			}
		});
		btnNewButton.setBounds(53, 36, 59, 23);
		contentPane.add(btnNewButton);
		
		lblYouWereLogged = new JLabel("Sign In Successful.....");
		lblYouWereLogged.setBounds(43, 11, 116, 14);
		contentPane.add(lblYouWereLogged);
		
		rdbtnEnglishToSpanish = new JRadioButton("English to Spanish");
		rdbtnEnglishToSpanish.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnEnglishToSpanish.setBackground(new Color(255, 255, 204));
		rdbtnEnglishToSpanish.setSelected(true);
		rdbtnEnglishToSpanish.setBounds(86, 111, 146, 23);
		contentPane.add(rdbtnEnglishToSpanish);
		
	    rdbtnSpanishToEnglish = new JRadioButton("Spanish to English");
	    rdbtnSpanishToEnglish.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnSpanishToEnglish.setBackground(new Color(255, 255, 204));
		rdbtnSpanishToEnglish.setBounds(295, 111, 146, 23);
		contentPane.add(rdbtnSpanishToEnglish);
		
		ButtonGroup bG = new ButtonGroup();
	    bG.add(rdbtnEnglishToSpanish);
	    bG.add(rdbtnSpanishToEnglish);
		
		JTextArea txtrH = new JTextArea();
		txtrH.setWrapStyleWord(true);
		txtrH.setForeground(new Color(51, 204, 255));
		txtrH.setBackground(new Color(51, 51, 51));
		txtrH.setFont(new Font("MS PGothic", Font.BOLD | Font.ITALIC, 14));
		txtrH.setLineWrap(true);
		txtrH.setBounds(88, 162, 144, 74);
		txtrH.setCaretColor(new Color(255, 255, 204));
		
		contentPane.add(txtrH);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setWrapStyleWord(true);
		textArea_1.setForeground(new Color(102, 204, 255));
		textArea_1.setBackground(new Color(51, 51, 51));
		textArea_1.setFont(new Font("MS PGothic", Font.BOLD | Font.ITALIC, 14));
		textArea_1.setLineWrap(true);
		textArea_1.setBounds(295, 162, 146, 74);
		textArea_1.setCaretColor(new Color(255, 255, 204));
		contentPane.add(textArea_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(new Color(0, 204, 0));
		lblNewLabel_1.setBounds(88, 141, 116, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(new Color(0, 255, 0));
		lblNewLabel_2.setBounds(295, 141, 116, 14);
		contentPane.add(lblNewLabel_2);
		
		btnTranslate = new JButton("Translate");
		btnTranslate.setForeground(Color.BLACK);
		btnTranslate.setToolTipText("Click to translate");
		btnTranslate.setBackground(new Color(255, 255, 255));
		btnTranslate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread t1 = new Thread(new Runnable() {
				    @Override
				    public void run() {
				    	
				    	if(rdbtnEnglishToSpanish.isSelected()) {
							lblNewLabel_1.setText("English");
							lblNewLabel_2.setText("Spanish");
							if(!txtrH.getText().equals("")) {
								textArea_1.setText(
								mt.translateThis(txtrH.getText(), "en", "es"));
							}
						}else {
							lblNewLabel_1.setText("Spanish");
							lblNewLabel_2.setText("English");
							if(!txtrH.getText().equals("")) {
								textArea_1.setText(
								mt.translateThis(txtrH.getText(), "es", "en"));
							}
						}
				    	
				    }
				});  
				t1.start(); 
				
			}
		});
		btnTranslate.setBounds(88, 262, 94, 23);
		contentPane.add(btnTranslate);
		contentPane.add(lblNewLabel_3);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(30, 144, 255)));
		panel.setBounds(70, 101, 392, 192);
		contentPane.add(panel);
		
		
	}
	public void welcomeMessage(String message) {
		int i = 0;
		long timeMillis = System.currentTimeMillis();
		while(i < message.length()) {
			
			double time = Math.round((System.currentTimeMillis() -timeMillis) / 100.00);
			if(time == 1) {
				lblNewLabel.setText(lblNewLabel.getText() + message.substring(i, i+1));
				timeMillis = System.currentTimeMillis();
				i++;
			}
			
		}
	}
	
	public void welcomeMessage1(String message, String message1) {
		for (int i = 0; i < message.length(); i++) {
			pause(30);
			lblNewLabel.setText(lblNewLabel.getText() + message.substring(i, i+1));
		}
		for (int i = 0; i < message1.length(); i++) {
			pause(30);
			label.setText(label.getText() + message1.substring(i, i+1));
		}
	}
	public void pause(int millis) {
		try {
			Thread.sleep(millis);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
