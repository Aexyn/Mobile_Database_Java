import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class DeletePhone extends JFrame implements ActionListener{
	Container c;
	JButton bDelete,bUpdate;
	JTable tPhone;
	DefaultTableModel mPhone;
	JLabel lDel;
	

    public DeletePhone() {
    	c=getContentPane();
    	Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		c.setBackground(Color.WHITE);
		
		lDel=new JLabel("Select Records & click Del to Delete");
		lDel.setFont(new Font("Comic sans ms",0,35));
		lDel.setBounds(10,100,600,35);
		c.add(lDel);
    	
		setExtendedState(JFrame.MAXIMIZED_BOTH);
    	setLayout(null);
    	
    	String []sPhone={"ModelNo","SmartPhone","Cdma","DualSim","Multimedia","Touch","Slider","Flip","QWERTY","MusicPlayer","Wifi","Camera","Bluetooth","3G"};
    	mPhone=new DefaultTableModel(sPhone,0);
    	tPhone=new JTable(mPhone);
    	tPhone.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//
    	tPhone.getColumnModel().getColumn(0).setPreferredWidth(120);//
    	
    	JScrollPane spPhone=new JScrollPane(tPhone);
    	spPhone.setBounds(0,200,1115,350);
    	c.add(spPhone);
    	
	   	bDelete=new JButton(new ImageIcon("Delete.jpg"));
    	bDelete.setBounds(250,600,166,80);
    	c.add(bDelete);
    	bDelete.addActionListener(this);
    	fillTable();
 		bDelete.setVisible(true);

    	setVisible(true);
    	setDefaultCloseOperation(2);    		
    }
    public void fillTable(){
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:DRIVER=Microsoft Access Driver (*.mdb);DBQ=Samsungm.mdb");
			Statement st=con.createStatement();		  
			ResultSet rs=st.executeQuery("Select * from Mobiles1 order by  ModelNo");
			while(rs.next()){
				Vector v=new Vector();
				for(int i=1;i<15;i++){
					String s=rs.getString(i);
					if(s.equalsIgnoreCase("0")){
						s="N";
						setForeground(Color.red);
					}
					else if(s.equalsIgnoreCase("1")){
						s="Y";						
					}
					v.add(s);
				}
				mPhone.addRow(v);
			}
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(c,ex.toString());
		}
	}
	public void actionPerformed(ActionEvent ae){
		Object o=ae.getSource();
		if(o.equals(bDelete)){
			try{				
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:DRIVER=Microsoft Access Driver (*.mdb);DBQ=Samsungm.mdb");
				Statement st=con.createStatement();		  
				
				int []numRows = tPhone.getSelectedRows(); 
				
				
				for(int i=numRows.length; i>0 ; i-- ){
					String s=tPhone.getValueAt(numRows[i-1],0).toString();
					PreparedStatement ps=con.prepareStatement("delete * from Mobiles1 where modelno=?");
					ps.setString(1,s);
					ps.executeUpdate();
				}
				if(tPhone.getSelectedRow()==-1){											
					JOptionPane.showMessageDialog(c,"No Record Selected");				
				}																		
				else{
					for(int i=numRows.length; i>0 ; i-- ) 
						mPhone.removeRow(numRows[i-1]);
					JOptionPane.showMessageDialog(c,"Records Deleted");
				}
				
			}
			catch(Exception ex){
				System.out.println (ex);
			}
		}
	}    
}