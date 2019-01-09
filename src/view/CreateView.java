package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.Button;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import org.jdatepicker.JDatePicker;

import controller.ViewManager;

@SuppressWarnings("serial")
public class CreateView extends JPanel implements ActionListener {
	
	private JButton creatorButton;
	private JButton cancelButton;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField datePicker;
	private JTextField phone;
	private JTextField address;
	private JTextField city;
	private JComboBox state;
	private JTextField postal_code;
	private JPasswordField pinField;
	
	private ViewManager manager;		// manages interactions between the views, model, and database
	
	/**
	 * Constructs an instance (or object) of the CreateView class.
	 * 
	 * @param manager
	 */
	
	public CreateView(ViewManager manager) {
		super();
		
		this.manager = manager;
		initialize();
	}
	
	///////////////////// PRIVATE METHODS /////////////////////////////////////////////
	
	/*
	 * Initializes the CreateView components.
	 */
	
	private void initialize() {
		
		initButtons();
		initfirstname();
		initlastname();
		//initdatePicker();
		initphone();
		
		this.add(new javax.swing.JLabel("New Account", javax.swing.SwingConstants.CENTER));
		

		//
		// this is where you should build the CreateView (i.e., all the components that
		// allow the user to enter his or her information and create a new account).
		//
		// feel free to use my layout in LoginView as an example for laying out and
		// positioning your components.
	}
	
	private void initfirstname() {
		JLabel label = new JLabel("First Name", SwingConstants.LEFT);
		
		JTextField initfirstname = new JTextField(30);
		initfirstname.addActionListener(this);
		initfirstname.setVisible(true);
		
		this.add(label);
		this.add(initfirstname);
	}
	
	private void initlastname() {
		JLabel label = new JLabel("Last Name", SwingConstants.LEFT);
		JTextField initlastname = new JTextField(30);
		initlastname.addActionListener(this);
		initlastname.setBounds(100,45,100,45);
		this.add(initlastname);
		initlastname.setVisible(true);
	}
	
	/*private void initdatePicker() {
		JDatePicker initdatePicker = new JDatePicker();
		CreateView.add(initdatePicker);
	}*/
	private void initphone() {
		JLabel label = new JLabel("Phone", SwingConstants.LEFT);
		JTextField initphone = new JTextField(10);
		initphone.addActionListener(this);
		initphone.setVisible(true);
	}
	
	private void initButtons() {
		// TODO Auto-generated method stub
		Button creatorButton = new Button("Create Account:");
		creatorButton.addActionListener(this);
		add(creatorButton);
        
        Button cancelButton = new Button("Cancel Account:");
        cancelButton.addActionListener(this);
        add(cancelButton);
	}
	
	/*
	 * CreateView is not designed to be serialized, and attempts to serialize will throw an IOException.
	 * 
	 * @param oos
	 * @throws IOException
	 */
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		throw new IOException("ERROR: The CreateView class is not serializable.");
	}
	
	///////////////////// OVERRIDDEN METHODS //////////////////////////////////////////
	
	/*
	 * Responds to button clicks and other actions performed in the CreateView.
	 * 
	 * @param e
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source.equals(creatorButton)) {
    	manager.switchTo(ATM.HOME_VIEW);
		} 
			else if (source.equals(cancelButton)) {
		    	manager.switchTo(ATM.LOGIN_VIEW);
				} else 
					manager.switchTo(ATM.LOGIN_VIEW);
		// TODO
		//
		// this is where you'll setup your action listener, which is responsible for
		// responding to actions the user might take in this view (an action can be a
		// user clicking a button, typing in a textfield, etc.).
		//
		// feel free to use my action listener in LoginView.java as an example.
	}
}