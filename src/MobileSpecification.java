import java.awt.*;
import javax.swing.*;
class MobileSpecification extends JFrame {
	Container c;
	JInternalFrame iFrame;
	JButton bHome,bPrint,bBack,bMail,bBuy;
	ImageIcon ic;
	MobileSpecification(String name){		
		c=getContentPane();
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		c.setBackground(Color.white);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		c.setLayout(null);
		ic=new ImageIcon("images\\"+name+".png");
		
		JLabel j1=new JLabel(ic);
		JScrollPane jsp=new JScrollPane(j1);
		jsp.setBounds(0,0,950,700);
		c.add(jsp);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}