import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

class admin_2 extends JFrame implements ActionListener,FocusListener, Runnable{
	Container c;
	JLabel lId,lPass,lAdmin;
	JTextField tID;
	JPasswordField pPass;
	JButton bSignIn,bAdminAcc,bGuestAcc;
	Thread t;
	admin_2(){
		c=getContentPane();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		c.setBackground(Color.white);
		c.setLayout(null);
		
		lId=new JLabel("ID");
		lId.setBounds(250,300,60,50);
		lId.setFont(new Font("Comic Sans MS",0,25));		
		c.add(lId);				
		
		lAdmin=new JLabel("User Account");
		lAdmin.setBounds(270,20,500,100);
		lAdmin.setFont(new Font("Comic Sans MS",0,50));
		c.add(lAdmin);
		
		lPass=new JLabel("Password");
		lPass.setBounds(250,380,120,50);
		lPass.setFont(new Font("Comic Sans MS",0,25));
		c.add(lPass);
		
		JTextField abc=new JTextField();
		abc.setBounds(0,0,1,1);
		c.add(abc);
		abc.addFocusListener(this);
		
		tID=new JTextField(" Username");
		tID.setBounds(390,307,300,30);
		c.add(tID);
		tID.addFocusListener(this);
			
		pPass=new JPasswordField(" Password");
		pPass.setBounds(390,387,300,30);
		c.add(pPass);
		pPass.addFocusListener(this);
		
		bSignIn=new JButton(new ImageIcon("signin.png"));
		bSignIn.setBounds(390,450,62,31);
		c.add(bSignIn);
		bSignIn.addActionListener(this);
		
		bAdminAcc=new JButton(new ImageIcon("Adminunhover.jpg"));
		bAdminAcc.setBounds(220,200,250,77);
		c.add(bAdminAcc);
		bAdminAcc.addActionListener(this);
		
		bGuestAcc=new JButton(new ImageIcon("Guestunhover.jpg"));
		bGuestAcc.setBounds(600,200,250,77);
		c.add(bGuestAcc);
		bGuestAcc.addActionListener(this); 
			
		t=new Thread(this);	
		setVisible(true);
		tID.setVisible(false);
 		pPass.setVisible(false);
 		lId.setVisible(false);
 		lPass.setVisible(false);
 		bSignIn.setVisible(false);
		setDefaultCloseOperation(3); 
	}
	
	public void actionPerformed(ActionEvent ae){
		Object o=ae.getSource();
	 	if(o.equals(bAdminAcc)){
	 		bAdminAcc.setIcon(new ImageIcon("adminhover.jpg"));
	 		bGuestAcc.setIcon(new ImageIcon("guestunhover.jpg"));
	 		tID.setVisible(true);
	 		pPass.setVisible(true);
	 		lId.setVisible(true);
	 		lPass.setVisible(true);
	 		bSignIn.setVisible(true);	 		
	 	}
	 	if (o.equals(bSignIn)){
			if(tID.getText().equalsIgnoreCase("Open")&& pPass.getText().equals("Close")){
				try{
					t.start();
				}
				catch(Exception ex){
					System.out.println ("signin"+ex);
				}
			}
			else
				JOptionPane.showMessageDialog(c,"Incorrect Username or Password");
		}
	 	if(o.equals(bGuestAcc)){
	 		bAdminAcc.setIcon(new ImageIcon("adminunhover.jpg"));
	 		bGuestAcc.setIcon(new ImageIcon("guesthover.jpg"));
	 		tID.setVisible(false);
 			pPass.setVisible(false);
 			lId.setVisible(false);
 			lPass.setVisible(false);
 			bSignIn.setVisible(false);
	 		try{
	 			new Mobile();
	 		}
	 		catch(Exception ex){
	 			System.out.println (ex);
	 		}
	 	}	 	
	}
	
	public void run(){
		try{
			new AdminLogon();
		}
		catch(Exception ex){
			System.out.println ("run"+ex);	
		}	
	}
	
	public void focusGained(FocusEvent fe){
	Object o=fe.getSource();
		if(o.equals(tID)){
			if(tID.getText().equalsIgnoreCase(" Username")){
	    		tID.setText("");
	    		tID.setForeground(Color.black);
			}
			if(pPass.getText().equalsIgnoreCase(""))
    			pPass.setText(" Password");	
    	}
    	if (o.equals(pPass)){
	    	if(pPass.getText().equalsIgnoreCase(" Password"))
	    		pPass.setText("");
	    	if(tID.getText().equalsIgnoreCase("")){
	    		tID.setText(" Username");
	    		tID.setForeground(Color.gray);
	    	}
    	}
	}
	public void focusLost(FocusEvent fe){
	}	
}	
	
