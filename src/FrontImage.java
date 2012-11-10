import java.awt.*;
import javax.swing.*;

class FrontImage implements Runnable{	
	JProgressBar pProgress;
	Thread t;
	FrontImage() throws InterruptedException{
		JWindow win=new JWindow();
	    JPanel pan1=new JPanel();
		win.add(pan1);
	    pan1.setLayout(null);
	    win.setSize(520,360);
	    win.setBounds(340,230,510,350);
	    ImageIcon ic=new ImageIcon("samsung1.jpg");
		JLabel j1=new JLabel(ic);
		j1.setBounds(0,0,510,350);
		pan1.add(j1);
		t=new Thread(this);
		pProgress=new JProgressBar(0,500);
		pProgress.setValue(0);
		pProgress.setForeground(Color.black);
		pProgress.setBackground(Color.DARK_GRAY);
		pProgress.setStringPainted(true);
		win.add(pProgress,BorderLayout.SOUTH);
		
		t.start();
		
		win.setVisible(true);
		Thread.sleep(3200);
		new admin_2();
		win.dispose();
	}
  	public void run(){
		for (int i = 0; i<=500; i++){
			try {
    			Thread.sleep(6);
			}
			catch (Exception ex) {
				System.out.println (ex);
			}
			pProgress.setValue(i);
		}		
	}
}
