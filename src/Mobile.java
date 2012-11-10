import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.Vector;
import javax.swing.border.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Mobile extends JFrame implements ActionListener,KeyListener,MouseListener{
	Container c;
	JCheckBox cMusicplayer,cModelWise,cSpecifications,cWifi,cCamera,cCategory,cStyle,cFeature,cBluetooth,c3G,cBar,cFlip,cQwerty,cTouch,cSlider,cOther,cSmartPhone,cDualSim,cMultemedia,cCdma;
	JButton bSearch;
	ImageIcon ic;
	JLabel j1;
	JLabel lSearch;
	JList lsModel;
	int i = 0,a,b;

	DefaultComboBoxModel mPhoneCategory,mStyle;
	JScrollPane jsp,jsp1;
	Icon chkboxicon,subchkboxicon;
	Dimension d =  Toolkit.getDefaultToolkit().getScreenSize();
	
	JTextField tModel;
	
	Mobile(){
		c = getContentPane();
		
		setLocation(0,0);
		chkboxicon = new MyJcheckBoxIcon();
		subchkboxicon = new MySubCheckBoxIcon();
		setTitle("Mobile Front Page");
		c.setBackground(Color.white);
		c.setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
			
		lSearch = new JLabel("Refine Your Result By:");
		lSearch.setBounds(20,20,320,40);
		c.add(lSearch);
		lSearch.setFont(new Font("Comic Sans MS",2,30));
		lSearch.setBackground(Color.white);

		cModelWise = new JCheckBox(" Model:",chkboxicon);
		cModelWise.setBounds(60,80,150,30);
		c.add(cModelWise);
		cModelWise.addActionListener(this);
		cModelWise.setFont(new Font("Comic Sans MS",2,16));
		cModelWise.setBackground(Color.white);
		
		tModel =  new JTextField();
		tModel.setBounds(250,135,300,40);
		tModel.setFont(new Font("Comic Sans MS",1,15));
		tModel.setText("\tEnter Model Number");
		tModel.setForeground(Color.LIGHT_GRAY);
		c.add(tModel);
		
		lsModel = new JList();
		lsModel.setBounds(250,175,300,140);
		lsModel.setFont(new Font("Comic Sans MS",1,15));
		c.add(lsModel);
		lsModel.setVisible(false);
			
		cSpecifications = new JCheckBox(" Specifications:",chkboxicon);
		cSpecifications.setBounds(60,140,180,30);
		c.add(cSpecifications);
		cSpecifications.addActionListener(this);
		cSpecifications.setFont(new Font("Comic Sans MS",2,16));
		cSpecifications.setBackground(Color.white);
		
		cCategory = new JCheckBox("Category Wise",chkboxicon);
		cCategory.setBounds(100,180,180,30);
		c.add(cCategory);
		cCategory.addActionListener(this);
		cCategory.setFont(new Font("Comic Sans MS",2,16));
		cCategory.setBackground(Color.white);		
	
		cStyle = new JCheckBox("Style Wise",chkboxicon);
		cStyle.setBounds(100,220,180,30);
		c.add(cStyle);
		cStyle.addActionListener(this);
		cStyle.setFont(new Font("Comic Sans MS",2,16));
		cStyle.setBackground(Color.white);
		
		cFeature = new JCheckBox("Features Wise",chkboxicon);
		cFeature.setBounds(100,260,180,30);
		c.add(cFeature);		
		cFeature.addActionListener(this);
		cFeature.setFont(new Font("Comic Sans MS",2,16));
		cFeature.setBackground(Color.white);
		
		cBar = new JCheckBox("Bar",subchkboxicon);
		c.add(cBar);		
		cBar.addActionListener(this);
		cBar.setFont(new Font("Comic Sans MS",2,16));
		cBar.setBackground(Color.white);
		
		cFlip = new JCheckBox("Flip",subchkboxicon);
		c.add(cFlip);		
		cFlip.addActionListener(this);
		cFlip.setFont(new Font("Comic Sans MS",2,16));
		cFlip.setBackground(Color.white);
		
		cQwerty = new JCheckBox("Qwerty",subchkboxicon);
		c.add(cQwerty);		
		cQwerty.addActionListener(this);
		cQwerty.setFont(new Font("Comic Sans MS",2,16));
		cQwerty.setBackground(Color.white);
		
		cTouch = new JCheckBox("Touch",subchkboxicon);
		c.add(cTouch);		
		cTouch.addActionListener(this);
		cTouch.setFont(new Font("Comic Sans MS",2,16));
		cTouch.setBackground(Color.white);
		
		cSlider = new JCheckBox("Slider",subchkboxicon);
		c.add(cSlider);		
		cSlider.addActionListener(this);
		cSlider.setFont(new Font("Comic Sans MS",2,16));
		cSlider.setBackground(Color.white);
		
		cSmartPhone = new JCheckBox("SmartPhone",subchkboxicon);
		c.add(cSmartPhone);		
		cSmartPhone.addActionListener(this);
		cSmartPhone.setFont(new Font("Comic Sans MS",2,16));
		cSmartPhone.setBackground(Color.white);
		
		cMultemedia = new JCheckBox("Multimedia",subchkboxicon);
		c.add(cMultemedia);		
		cMultemedia.addActionListener(this);
		cMultemedia.setFont(new Font("Comic Sans MS",2,16));
		cMultemedia.setBackground(Color.white);
		
		cCdma = new JCheckBox("CDMA",subchkboxicon);
		c.add(cCdma);		
		cCdma.addActionListener(this);
		cCdma.setFont(new Font("Comic Sans MS",2,16));
		cCdma.setBackground(Color.white);
		
		cDualSim = new JCheckBox("DualSim",subchkboxicon);
		c.add(cDualSim);		
		cDualSim.addActionListener(this);
		cDualSim.setFont(new Font("Comic Sans MS",2,16));
		cDualSim.setBackground(Color.white);				
		
		cOther = new JCheckBox("Other",subchkboxicon);
		c.add(cOther);		
		cOther.addActionListener(this);
		cOther.setFont(new Font("Comic Sans MS",2,16));
		cOther.setBackground(Color.white);
		
		cBluetooth = new JCheckBox("Bluetooth",subchkboxicon);
		c.add(cBluetooth);		
		cBluetooth.addActionListener(this);
		cBluetooth.setFont(new Font("Comic Sans MS",2,16));
		cBluetooth.setBackground(Color.white);
		
		cWifi = new JCheckBox("Wifi",subchkboxicon);
		c.add(cWifi);		
		cWifi.addActionListener(this);
		cWifi.setFont(new Font("Comic Sans MS",2,16));
		cWifi.setBackground(Color.white);
		
		cCamera = new JCheckBox("Camera",subchkboxicon);
		c.add(cCamera);		
		cCamera.addActionListener(this);
		cCamera.setFont(new Font("Comic Sans MS",2,16));
		cCamera.setBackground(Color.white);
		
		c3G = new JCheckBox("3G",subchkboxicon);
		c.add(c3G);		
		c3G.addActionListener(this);
		c3G.setFont(new Font("Comic Sans MS",2,16));
		c3G.setBackground(Color.white);
		
		cMusicplayer = new JCheckBox("MusicPlayer",subchkboxicon);
		c.add(cMusicplayer);		
		cMusicplayer.addActionListener(this);
		cMusicplayer.setFont(new Font("Comic Sans MS",2,16));
		cMusicplayer.setBackground(Color.white);
			

		bSearch = new JButton(new ImageIcon("google.png"));
		c.add(bSearch);
		bSearch.addActionListener(this);
		
		tModel.setVisible(false);
		cCategory.setVisible(false);
		cStyle.setVisible(false);
		cFeature.setVisible(false);
		tModel.addMouseListener(this);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
	}

	public void actionPerformed(ActionEvent ae){
		Object o = ae.getSource();
		if(cModelWise.isSelected()){												
			if(a == 2)																
				cSpecifications.setSelected(false);									
			tModel.setVisible(true);
			bSearch.setVisible(true);	
			cSpecifications.setBounds(60,200,180,30);
			
			cCategory.setVisible(false);
			cStyle.setVisible(false);
			cFeature.setVisible(false);
			myFeatures(false);
			myStyle(false);
			myCategory(false);
			cSpecifications.setForeground(Color.lightGray);
			cModelWise.setForeground(Color.black);
			bSearch.setBounds(3*d.width/5-120,135,101,40);
			bSearch.setVisible(true);			
			a = 1;
			if(o.equals(bSearch)){
					setTitle("chal rha h");
					new MobileSpecification(tModel.getText());
			}		
	
		}
		else{
			cSpecifications.setBounds(60,140,180,30);
			tModel.setVisible(false);
			bSearch.setVisible(false);
			tModel.setText("\tEnter Model Number");
			tModel.setForeground(Color.LIGHT_GRAY);
		}
			
		if(cSpecifications.isSelected()){
			cModelWise.setSelected(false);
			a = 2;
			bSearch.setVisible(true);
			int yspc = 0,x = 0;
			tModel.setText("\tEnter Model Number");
			tModel.setForeground(Color.LIGHT_GRAY);
			tModel.setVisible(false);
			cCategory.setVisible(true);
			cStyle.setVisible(true);
			cFeature.setVisible(true);
			cSpecifications.setBounds(60,140,180,30);
			cModelWise.setForeground(Color.lightGray);
			cSpecifications.setForeground(Color.black);
			bSearch.setBounds(3*d.width/5-120,550,101,40);
			
			if(cCategory.isSelected()){	
				myCategory(true);
				yspc += 70;	
				cStyle.setBounds(100,220+yspc,180,30);
				cFeature.setBounds(100,260+yspc,180,30);
				cCategory.setForeground(Color.black);
				myCategoryBounds(x);
				x += 70;
			}
			else{
				cStyle.setBounds(100,220,180,30);
				cFeature.setBounds(100,260,180,30);
				cCategory.setForeground(Color.lightGray);
				myCategory(false);
			}
			if(cStyle.isSelected()){
				
				yspc += 70;
				cFeature.setBounds(100,260+yspc,180,30);
				cStyle.setForeground(Color.black);
				myStyleBounds(x+40);
				x += 70;
				myStyle(true);
			}
			else{
				cStyle.setForeground(Color.lightGray);
				cFeature.setBounds(100,260+yspc,180,30);
				myStyle(false);
			}
			if(cFeature.isSelected()){
				cFeature.setForeground(Color.black);
				cFeature.setBounds(100,260+yspc,180,30);
				myFeaturesBounds(x+80);
				myFeatures(true);
			}
			else{
			
				cFeature.setForeground(Color.lightGray);
				myFeatures(false);
			}
			boolean mp,wf,cmra,bt,net,smrt,mm,cdm,dual,ot,br,flp,qwrty,tch,sldr;
			mp = cMusicplayer.isSelected();
			wf = cWifi.isSelected();
			cmra = cCamera.isSelected();
			bt = cBluetooth.isSelected();
			net = c3G.isSelected();
			smrt = cSmartPhone.isSelected();
			mm = cMultemedia.isSelected();
			cdm = cCdma.isSelected();
			dual = cDualSim.isSelected();
			ot = cOther.isSelected();
			br = cBar.isSelected();
			flp = cFlip.isSelected();
			qwrty = cQwerty.isSelected();
			tch = cTouch.isSelected();
			sldr = cSlider.isSelected();			
			 
			if(o.equals(bSearch)){
				if(cSpecifications.isSelected()){
					new DemoChkBox(smrt,mm,cdm,dual,ot,br,flp,qwrty,tch,sldr,mp,wf,cmra,bt,net);
					SwingUtilities.invokeLater(new Runnable(){
						public void run(){
						}						
					});							
				}		
			}
		}				
		else{
			myCategory(false);
			myFeatures(false);
			myStyle(false);
			cFeature.setVisible(false);
			cStyle.setVisible(false);
			cCategory.setVisible(false);
		}		
	}
	
	public void mousePressed(MouseEvent ev){
	}
	
	public void mouseClicked(MouseEvent ev){
		tModel.setText("");
		tModel.setForeground(Color.black);
	}
	
	public void mouseReleased(MouseEvent ev){
	}
	
	public void mouseEntered(MouseEvent ev){
	}
	
	public void mouseExited(MouseEvent ev){
	}
	
	public void keyTyped(KeyEvent e){
		
	}
	
	public void keyPressed(KeyEvent e){
		
	}
	
	public void keyReleased(KeyEvent e){
		
	}
	
	public void myCategoryBounds(int x){
		cSmartPhone.setBounds(150,210+x,200,30);
		cMultemedia.setBounds(350,210+x,200,30);
		cCdma.setBounds(550,210+x,200,30);
		cDualSim.setBounds(300,250+x,200,30);
		cOther.setBounds(500,250+x,200,30);
	}
	
	public void myStyleBounds(int x){
		cBar.setBounds(150,210+x,200,30);
		cFlip.setBounds(350,210+x,200,30);
		cQwerty.setBounds(550,210+x,200,30);
		cTouch.setBounds(300,250+x,200,30);
		cSlider.setBounds(500,250+x,200,30);
	}
	
	public void myFeaturesBounds(int x){
		cCamera.setBounds(150,210+x,200,30);
		c3G.setBounds(350,210+x,200,30);
		cMusicplayer.setBounds(550,210+x,200,30);
		cWifi.setBounds(300,250+x,200,30);
		cBluetooth.setBounds(500,250+x,200,30);
	}
	
	public void myStyle(boolean b){
		
		cBar.setVisible(b);
		cFlip.setVisible(b);
		cQwerty.setVisible(b);
		cTouch.setVisible(b);
		cSlider.setVisible(b);
	}
	
	public void myCategory(boolean b){
		cSmartPhone.setVisible(b);
		cMultemedia.setVisible(b);
		cCdma.setVisible(b);
		cDualSim.setVisible(b);
		cOther.setVisible(b);
	}
	
	public void myFeatures(boolean b){
		cCamera.setVisible(b);
		c3G.setVisible(b);
		cBluetooth.setVisible(b);
		cWifi.setVisible(b);
		cMusicplayer.setVisible(b);
		
	}
}

class MyJcheckBoxIcon implements  Icon{
	ImageIcon open  =  new ImageIcon("Open.jpg");
	ImageIcon openhover  =  new ImageIcon("open hover.jpg");
	ImageIcon close  =  new ImageIcon("closed.jpg");
	ImageIcon closehover  =  new ImageIcon("closed hover.jpg");
	ImageIcon imgicon;
	
	public void paintIcon(Component component, Graphics g, int x, int y){
		AbstractButton absbutton  = (AbstractButton) component;
		ButtonModel btnmodel =  absbutton.getModel();
		if(btnmodel.isSelected()){
			if(btnmodel.isRollover())
				imgicon = openhover;
			else
				imgicon = open;
		}		
		else{
			if(btnmodel.isRollover())
				imgicon = closehover;
			else
				imgicon = close;
		}
		Image img = imgicon.getImage();
		g.drawImage(img,8,8,component);
	}
	public int getIconWidth() {
 		return 20;
	}

	public int getIconHeight() {
  		return 20;
	}
}

class MySubCheckBoxIcon implements Icon{
	ImageIcon checked = new ImageIcon("GreenTick.jpg");
	ImageIcon unchecked = new ImageIcon("RedCross.jpg");
	ImageIcon imgicon;
	
	public void paintIcon(Component component,Graphics g,int x,int y){
		AbstractButton absbutton = (AbstractButton) component;
		ButtonModel btnmodel = absbutton.getModel();
		if(btnmodel.isSelected())
			imgicon = checked;
		else
			imgicon = unchecked;
		Image img = imgicon.getImage();
		g.drawImage(img,8,8,component);		
	}
	
	public int getIconWidth() {
 		return 20;
	}

	public int getIconHeight() {
  		return 20;
	}
}

