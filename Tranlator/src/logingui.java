import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Window.Type;
import java.awt.Toolkit;

public class logingui {

	public JFrame frmLogIn;
	private JTextField textField;
	private JPasswordField passwordField;
	JLabel lblNewLabel;
	//private mainScreen ms;
	private Register rt;
	private boolean valid;
	JButton btnLogIn;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logingui window = new logingui();
					window.frmLogIn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public logingui() {
		initialize();
		//thread for faster start up
		Thread t1 = new Thread(new Runnable() {
		    @Override
		    public void run() {
		    	rt = new Register();
		    }
		});  
		t1.start();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogIn = new JFrame();
		frmLogIn.setType(Type.POPUP);
		frmLogIn.setBackground(Color.GRAY);
		frmLogIn.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\lugdu\\eclipse-workspace\\StockTrading\\key_icon-01.png"));
		frmLogIn.setTitle("Log In");
		frmLogIn.setBounds(100, 100, 329, 208);
		frmLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogIn.getContentPane().setLayout(null);
		textField = new JTextField();
		textField.setBounds(144, 45, 114, 23);
		frmLogIn.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(144, 79, 114, 23);
		frmLogIn.getContentPane().add(passwordField);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 20));
		lblusername.setBounds(20, 44, 103, 23);
		frmLogIn.getContentPane().add(lblusername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 20));
		lblPassword.setBounds(20, 79, 95, 23);
		frmLogIn.getContentPane().add(lblPassword);
		
		btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals("") || new String (passwordField.getPassword()).equals("")) {
					lblNewLabel.setText("Please make sure all fields are entered");
					return;
				}
				valid = rt.loign(textField.getText(), new String(passwordField.getPassword()));
				lblNewLabel.setText(valid?"Correct log in":"Wrong user name and or password");
				if(valid) {
					frmLogIn.dispose();
					mainScreen ne = new mainScreen();
					ne.setVisible(true);
				}
				
			}
		});
		btnLogIn.setBounds(144, 113, 89, 23);
		frmLogIn.getContentPane().add(btnLogIn);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 292, 23);
		frmLogIn.getContentPane().add(lblNewLabel);
		frmLogIn.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField, passwordField, btnLogIn}));
	}
	
	public void pause(int millis) {
		try {
			Thread.sleep(millis);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isValid() {
		return valid;
	}
}
