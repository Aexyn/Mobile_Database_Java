import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;
import java.awt.event.MouseMotionListener;
import javax.swing.table.TableColumnModel;
import javax.swing.table.JTableHeader;
class DemoChkBox extends JFrame implements MouseListener,MouseMotionListener {
	Container cd;
		
	DefaultTableModel mDemoChkBox;
	JTable tDemoChkBox;
	boolean bmp,bwf,bcmra,bbt,bnet,bsmrt,bmm,bcdm,bdual,bot,bbr,bflp,bqwrty,btch,bsldr,bctgry,bstyl;
	int exitHome;
	MyPanel pPics;
	MyPanelWhite pWhite;
	Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
	String []model;

	DemoChkBox(boolean smrt,boolean mm,boolean cdm,boolean dual,boolean ot,boolean br,boolean flp,boolean qwrty,boolean tch,boolean sldr,boolean mp,boolean wf,boolean cmra,boolean bt,boolean net){
		cd=getContentPane();
		setSize(3*d.width/5,d.height);
		setLocation(0,0);
		cd.setBackground(Color.white);
		cd.setLayout(null);
		bsmrt=smrt;
		bmm=mm;
		bcdm=cdm;
		bdual=dual;
		bot=ot;
		bbr=br;
		bflp=flp;
		bqwrty=qwrty;
		btch=tch;
		bsldr=sldr;
		bmp=mp;
		bwf=wf;
		bcmra=cmra;
		bbt=bt;
		bnet=net;
		if(bot==false)
			bctgry=true;
		else
			bctgry=false;
			
		if(bbr==true)
			bstyl=false;
		else
			bstyl=true;			
		
		pPics=new MyPanel();
		pPics.setBounds(200,10,400,350);
		cd.add(pPics);
		
		pWhite=new MyPanelWhite();
		pWhite.setBounds(200,10,400,350);
		cd.add(pWhite);
		
		cd.add(pPics,BorderLayout.CENTER);
	    String s[]={"Model No","Smart Phone","Cdma","Dual Sim","Multimedia","Touch","Slider","Flip","Qwerty","Music Player","Wifi","Camera","Bluetooth","Network"};
		mDemoChkBox=new DefaultTableModel(s,0);
		tDemoChkBox=new JTable(mDemoChkBox);
		tDemoChkBox.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane jsp=new JScrollPane(tDemoChkBox);
		jsp.setBounds(10,380,800,300);
		cd.add(jsp);
		tDemoChkBox.addMouseListener(this); 	
		tDemoChkBox.addMouseMotionListener(this);
		
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:DRIVER=Microsoft Access Driver (*.mdb);DBQ=Samsungm.mdb");
			PreparedStatement ps=con.prepareStatement("Select * from Mobiles1 where (smartphone=? or smartphone=?) and (cdma=? or cdma=?) and (dualsim=? or dualsim=?) and (multimedia=? or multimedia=?) and (touch=? or touch=?) and (slider=? or slider=?) and (flip=? or flip=?) and (qwerty=? or qwerty=?) and (musicPlayer=? or musicplayer=?) and (Wifi=? or wifi=?) and (Camera=? or camera=?) and (BlueTooth=? or BlueTooth=? ) and (NetWork=? or NetWork=?)");
			ps.setBoolean(1,bsmrt);
			ps.setBoolean(2,bctgry);
			ps.setBoolean(3,bcdm);
			ps.setBoolean(4,bctgry);
			ps.setBoolean(5,bdual);
			ps.setBoolean(6,bctgry);
			ps.setBoolean(7,bmm);
			ps.setBoolean(8,bctgry);
			ps.setBoolean(9,btch);
			ps.setBoolean(10,bstyl);
			ps.setBoolean(11,bsldr);
			ps.setBoolean(12,bstyl);
			ps.setBoolean(13,bflp);
			ps.setBoolean(14,bstyl);
			ps.setBoolean(15,bqwrty);
			ps.setBoolean(16,bstyl);
			ps.setBoolean(17,bmp);
			ps.setBoolean(18,true);
			ps.setBoolean(19,bwf);
			ps.setBoolean(20,true);
			ps.setBoolean(21,bcmra);
			ps.setBoolean(22,true);
			ps.setBoolean(23,bbt);
			ps.setBoolean(24,true);
			ps.setBoolean(25,bnet);
			ps.setBoolean(26,true);
			ResultSet rs=ps.executeQuery();
				
			int i=0;
			model= new String[70];
			
			
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString(1));
				v.add(rs.getString(2));
				v.add(rs.getString(3));
				v.add(rs.getString(4));
				v.add(rs.getString(5));
				v.add(rs.getString(6));
				v.add(rs.getString(7));
				v.add(rs.getString(8));
				v.add(rs.getString(9));
				v.add(rs.getString(10));
				v.add(rs.getString(11));
				v.add(rs.getString(12));
				v.add(rs.getString(13));
				v.add(rs.getString(14));
				mDemoChkBox.addRow(v);
				i++;
			}
		}
		catch(Exception ex){
			System.out.println (ex);
		}				
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}	
	
	public void mousePressed(MouseEvent me){
	}
	
	public void mouseReleased(MouseEvent me){		
	}
	
	int oldrow=0;
	int clicks;
	
	public void mouseClicked(MouseEvent me){
		int r=tDemoChkBox.getSelectedRow();
		String name=(String)mDemoChkBox.getValueAt(r,0);
		clicks=me.getClickCount();
		new MobileSpecification(name);			
	}
	
	public void mouseEntered(MouseEvent me){
	}
	
	public void mouseExited(MouseEvent me){
	}

	public void mouseMoved(MouseEvent me){
		int row=tDemoChkBox.rowAtPoint(me.getPoint());
		
		if(row==oldrow){
		}
		else{			
			String name=(String)mDemoChkBox.getValueAt(row,0);
		
			pWhite.setImage(name);
			pPics.setImage(name);
			oldrow=row;
		}
	}
	
	public void mouseDragged(MouseEvent me){
	}
}
class MyPanel extends JPanel{
	Image image;
	int i=0;
	void setImage(String im){
		image=new ImageIcon("smallimages\\"+im+".png").getImage();
		repaint();											
	}
	public void paintComponent(Graphics g){
		g.drawImage(image,0,0,this);
	}
}	
class MyPanelWhite extends JPanel{
	Image image;
	int i=0;
	void setImage(String im){
		image=new ImageIcon("smallimages\\white.png").getImage();
		repaint();
	}
	public void paintComponent(Graphics g){ 			
		g.drawImage(image,0,0,this);		
	}
}		