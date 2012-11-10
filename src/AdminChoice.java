/**
 * @(#)AdminChoice.java
 *
 *
 * @author 
 * @version 1.00 2011/11/4
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class AdminChoice extends JFrame implements  ActionListener{
	Container c;
	JButton bBuy,bAdd,bDel,bUser;
	JLabel lChoice,lBuy,lAdd,lDel,lUser;
	
    public AdminChoice() {
    	c=getContentPane();
    	c.setBackground(Color.white);
    	setExtendedState(JFrame.MAXIMIZED_BOTH);
    	setLayout(null);
    	setTitle("Chose any option");
    	
    	lChoice= new JLabel("Choose any option");
    	lChoice.setBounds(100,10,300,50);
    	lChoice.setFont(new Font("Comic Sans MS",2,30));
    	c.add(lChoice);
    	
    	lBuy =new JLabel("Buy Mobile");
    	lBuy.setBounds(150,100,100,50);
    	lBuy.setFont(new Font("Comic Sans MS",2,16));
    	c.add(lBuy);
    	
    	lAdd =new JLabel("Add Mobile");
    	lAdd.setBounds(150,300,100,50);
    	lAdd.setFont(new Font("Comic Sans MS",2,16));
    	c.add(lAdd);
    	
    	lDel =new JLabel("Delete Mobile");
    	lDel.setBounds(150,200,150,50);
    	lDel.setFont(new Font("Comic Sans MS",2,16));
    	c.add(lDel);
    	
    	lUser =new JLabel("Use as User");
    	lUser.setBounds(150,400,100,50);
    	lUser.setFont(new Font("Comic Sans MS",2,16));
    	c.add(lUser);
    	
    	bBuy=new JButton(new ImageIcon("buy.jpg"));
    	bBuy.setBounds(10,100,95,40);
    	c.add(bBuy);
    	bBuy.addActionListener(this);
    	
    	bDel=new JButton(new ImageIcon("recyclebin.jpg"));
    	bDel.setBounds(10,200,42,50);
    	c.add(bDel);
    	bDel.addActionListener(this);
    	
    	bAdd=new JButton(new ImageIcon("add.jpg"));
    	bAdd.setBounds(10,300,50,50);
    	c.add(bAdd);
    	bAdd.addActionListener(this);
    	
    	bUser=new JButton(new ImageIcon("user.jpg"));
    	bUser.setBounds(10,400,43,50);
    	c.add(bUser);
    	bUser.addActionListener(this);
    	
    	setVisible(true);
    	setDefaultCloseOperation(2);
    }
    
    public void actionPerformed(ActionEvent ae){
    	Object o= ae.getSource();
    	try{
    		if(o.equals(bAdd)){
    			new Add();
    		}
    		else if(o.equals(bDel)){
    			new DeletePhone();
    		}
    		else if(o.equals(bBuy)){
    			new BuyMobile();
    		}
    		else if(o.equals(bUser)){
    			new Mobile();
    		}
    	}
    	catch(Exception ex){
    		System.out.println (ex);
    	}
    }
    
    
}