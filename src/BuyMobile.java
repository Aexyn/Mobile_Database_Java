import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class BuyMobile extends JFrame implements ActionListener{
	Container c;
	JLabel lCustmrName,lAddress,lContactNo,lDate,lWarranty,lModelNo,lPrice,lDatereturn,lWarrantyReturn;
	JTextArea tAddress;
	JTextField tCustmrName,tContactNo,tDate,tMobileNo,tPrice;
	JButton bBuy;
	BuyMobile(){
		c=getContentPane();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		c.setLayout(null);
		setTitle("Buy Mobile");
		c.setBackground(Color.white);
		
		lCustmrName=new JLabel("Customer Name");
		lCustmrName.setBounds(50,50,120,40);
		c.add(lCustmrName);
		
		tCustmrName=new JTextField();
		tCustmrName.setBounds(210,50,120,30);
		c.add(tCustmrName);
		
		lAddress=new JLabel("Address");
		lAddress.setBounds(50,130,120,40);
		c.add(lAddress);
		
	    tAddress=new JTextArea();
		tAddress.setLineWrap(true);
		
		JScrollPane jsp=new JScrollPane(tAddress);
		jsp.setBounds(210,130,220,80);
		c.add(jsp);	
			
		lModelNo=new JLabel("Model Number");
		lModelNo.setBounds(50,220,120,40);
		c.add(lModelNo);
		
		tMobileNo=new JTextField();
		tMobileNo.setBounds(210,220,120,40);
		c.add(tMobileNo);
		
		lPrice=new JLabel("Price");
		lPrice.setBounds(50,290,120,40);
		c.add(lPrice);
		
		tPrice=new JTextField("Rs. ");
		tPrice.setBounds(210,290,120,40);
		c.add(tPrice);
		
		lDate=new JLabel("Date of Purchase");
		lDate.setBounds(50,370,120,40);
		c.add(lDate);
		
		lDatereturn=new JLabel(Date1.DateReturn());
		lDatereturn.setBounds(210,370,120,40);
		c.add(lDatereturn);
		
		
		lWarranty=new JLabel("Warranty");
		lWarranty.setBounds(50,450,120,40);
		c.add(lWarranty);
		
		lWarrantyReturn=new JLabel(Warranty1.WarrantyReturn());
		lWarrantyReturn.setBounds(210,450,120,40);
		c.add(lWarrantyReturn);
		
		bBuy=new JButton(new ImageIcon("googlebuy.png"));
		bBuy.setBounds(150,550,179,28);
		c.add(bBuy);
		bBuy.addActionListener(this);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae){
		JOptionPane.showMessageDialog(c,"Congrats...!!!\nFor your new mobile.. :)");
	}
}