import java.awt.*;
import javax.swing.*;

class AdminLogon implements Runnable{	
	Thread t;
	AdminLogon() throws InterruptedException{
		JWindow win=new JWindow();
	    JPanel pan1=new JPanel();
		win.add(pan1);
	    pan1.setLayout(null);
	    win.setSize(520,360);   
	    win.setBounds(340,230,510,350);
	    ImageIcon ic=new ImageIcon("admin1.jpg");
		JLabel j1=new JLabel(ic);
		j1.setBounds(0,0,510,350);
		pan1.add(j1);
		t=new Thread(this);
		win.setVisible(true);
		Thread.sleep(3200);
		t.start();
		win.dispose();
  	}
  	public void run(){	
		try{
			new AdminChoice();
		}
		catch(Exception ex){
			System.out.println (ex);
		}
	}
}
