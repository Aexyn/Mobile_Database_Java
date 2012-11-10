import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public  class Add extends JFrame implements  ActionListener{
	Container c;
	JCheckBox chMusicPlayer,chWiFi,chBluetooth,chCamera;
	JComboBox cbCategory,cbStyle,cbNetwork;
	JLabel lModelNo,lCategory,lStyle,lFeatures,lNetwork;
	JTextField tModelno;
	DefaultComboBoxModel mCategory,mStyle,mNetwork;
	JButton bAdd,bNew;
	
    public Add() {
    	c=getContentPane();
    	setSize(800,600);
    	setLayout(null);
    	setTitle("Add Mobile");
    	c.setBackground(Color.WHITE);
    	
    	myLabel();
    	myTextField();
    	myComboBox();
    	myCheckbox();
    	myButton();
    	myActionListener();   	
    	
    	setDefaultCloseOperation(2);
    	setVisible(true);	
    }
    void myLabel(){
    	lModelNo=new JLabel("Model Number");
    	lModelNo.setBounds(50,50,150,30);
    	c.add(lModelNo);
    	
    	lCategory=new JLabel("Category");
    	lCategory.setBounds(50,110,150,30);
    	c.add(lCategory);
    	
    	lStyle=new JLabel("Style");
    	lStyle.setBounds(50,170,150,30);
    	c.add(lStyle);
    	
    	lFeatures=new JLabel("Features:");
    	lFeatures.setBounds(50,230,150,30);
    	c.add(lFeatures);
    	
    	lNetwork=new JLabel("Network");
    	lNetwork.setBounds(200,280,100,30);
    	c.add(lNetwork);
    }
    void myTextField(){
    	tModelno=new JTextField();
    	tModelno.setBounds(200,50,150,30);
    	c.add(tModelno);    	
    }
    void myComboBox(){
    	String []sCategory={"SmartPhone","CDMA","DualSim","Multemedia","other"};
    	mCategory=new DefaultComboBoxModel(sCategory);
    	cbCategory=new JComboBox(mCategory);
    	JScrollPane spCategory=new JScrollPane(cbCategory);
    	spCategory.setBounds(200,110,150,30);
    	c.add(spCategory);

    	String []sStyle={"Touch","Slider","Flip","Qwerty","Bar"};
    	mStyle=new DefaultComboBoxModel(sStyle);
    	cbStyle=new JComboBox(mStyle);
    	JScrollPane spStyle=new JScrollPane(cbStyle);
    	spStyle.setBounds(200,170,150,30);
    	c.add(spStyle);
    	
    	String []sNetwork={"3G","2G"};
    	mNetwork=new DefaultComboBoxModel(sNetwork);
    	cbNetwork=new JComboBox(mNetwork);
    	JScrollPane spNetwork=new JScrollPane(cbNetwork);
    	spNetwork.setBounds(300,280,150,30);
    	c.add(spNetwork);
    }    	
   	void myCheckbox(){
    	chCamera=new JCheckBox("Camera");
    	chCamera.setBounds(195,230,100,30);
    	chCamera.setBackground(Color.WHITE);
    	c.add(chCamera);
    	
    	chMusicPlayer=new JCheckBox("MusicPlayer");
    	chMusicPlayer.setBounds(195,330,150,30);
    	chMusicPlayer.setBackground(Color.WHITE);
    	c.add(chMusicPlayer);
    	
    	chWiFi=new JCheckBox("WiFi");
    	chWiFi.setBounds(195,380,150,30);
    	chWiFi.setBackground(Color.WHITE);
    	c.add(chWiFi);
    	
    	chBluetooth=new JCheckBox("Bluetooth");
    	chBluetooth.setBounds(195,440,150,30);
    	chBluetooth.setBackground(Color.WHITE);
    	c.add(chBluetooth);
    }
    void myActionListener(){
    	chMusicPlayer.addActionListener(this);
    	chCamera.addActionListener(this);
    	chBluetooth.addActionListener(this);
    	chWiFi.addActionListener(this);
    	cbCategory.addActionListener(this);
    	cbNetwork.addActionListener(this);
    	cbStyle.addActionListener(this);
    	chBluetooth.addActionListener(this);
  	 	bAdd.addActionListener(this);
    	bNew.addActionListener(this);   	
    }
    void myButton(){
    	bAdd=new JButton("Add");
    	bAdd.setBounds(150,480,150,30);
    	c.add(bAdd);
    	    	
    	bNew=new JButton("New");
    	bNew.setBounds(300,480,150,30);
    	c.add(bNew);    	
    }

	public  void actionPerformed(ActionEvent ae ){
		Object o=ae.getSource();
		if(o.equals(bAdd)){
			try{			
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:DRIVER=Microsoft Access Driver (*.mdb);DBQ=Samsungm.mdb");
				PreparedStatement ps=con.prepareStatement("Insert into Mobiles1 values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,tModelno.getText());
				for(int i=2;i<6;i++){
					if(cbCategory.getSelectedIndex()==(i-2))
						ps.setBoolean(i,true);
					else
						ps.setBoolean(i,false);	
				}
				for(int i=6;i<10;i++){
					if(cbStyle.getSelectedIndex()==(i-6))
						ps.setBoolean(i,true);
					else
						ps.setBoolean(i,false);						
				}
				if(chCamera.isSelected()){
					ps.setBoolean(12,true);
				}
				else 
					ps.setBoolean(12,false);
					
				
				if(cbNetwork.getSelectedIndex()==0)
					ps.setBoolean(14,true);
				else 
					ps.setBoolean(14,false);
					
				if(chMusicPlayer.isSelected()){
					ps.setBoolean(10,true);
				}
				else 
					ps.setBoolean(10,false);
					
				if(chWiFi.isSelected()){
					ps.setBoolean(11,true);
				}
				else 
					ps.setBoolean(11,false);
					
				if(chBluetooth.isSelected()){
					ps.setBoolean(13,true);
				}
				else 
					ps.setBoolean(13,false);										
							
				int n=ps.executeUpdate();
				if(n>0)
					JOptionPane.showMessageDialog(c,"Saved");
				else
					JOptionPane.showMessageDialog(c,"Sorry");
				con.close();				
			}
			catch(Exception ex){
				System.out.println (ex);
			}					
		}
		if(o.equals(bNew)){
			tModelno.setText("");
			cbCategory.setSelectedIndex(0);
			cbStyle.setSelectedIndex(0);
			cbNetwork.setSelectedIndex(0);
			chWiFi.setSelected(false);
			chCamera.setSelected(false);
			chBluetooth.setSelected(false);
			chMusicPlayer.setSelected(false);
		}
		
	}
	
}