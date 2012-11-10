A Message To Mother Fuckers!!!
Fuck Your Own Ass, Leave Your Mother.

Now I Give You a Challenge:
 Try To Save Your Computer, This is CAY, Fucking Your Computer Fucker!!!!!!!


Mother Fuckers!!!!! Fuck Off!!!!!t java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.applet.AudioClip;
import java.applet.Applet;

// This is the ServerGUI
class ServerGUI extends JFrame implements ActionListener, KeyListener
{
	public String serverPath;

	public JButton cmdWeb;
	public JButton cmdAbt;
	public JButton cmdSet;
	public JPasswordField txtPass;
	private JTextPane Text1;
	private JTextArea txtStatus;
	private JLabel Label5;
	private JLabel Label4;
	private JLabel Label3;
	private JLabel Label1;
	private JScrollPane sptxtStatus;
	private JScrollBar vsb;

	
	
	

	public ServerGUI()
	{
		//Setting up JFrame (ServerGUI)..
		super("RMI - Server");
		Container con = getContentPane();
		con.setLayout(null);
		
	
		
				
		//Setting up JPasswordField (txtPass)..
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Times new roman", 0, 14));
		txtPass.setBounds(131, 107, 148, 19);
		con.add(txtPass);

		//Setting up JButton (cmdSet)..
		cmdSet = new JButton("Set");
		cmdSet.setFont(new Font("Times new roman", 0, 13));
		cmdSet.setBounds(202, 135, 80, 21);
		cmdSet.setDisplayedMnemonicIndex(0);
		cmdSet.setMnemonic('S');
		con.add(cmdSet);

		//Setting up JButton (cmdWeb)..
		cmdWeb = new JButton("Website");
		cmdWeb.setFont(new Font("Times new roman", 0, 13));
		cmdWeb.setBounds(91, 166, 92, 21);
		cmdWeb.setDisplayedMnemonicIndex(0);
		cmdWeb.setMnemonic('V');
		con.add(cmdWeb);

		//Setting up JButton (cmdAbt)..
		cmdAbt = new JButton("About");
		cmdAbt.setFont(new Font("Times new roman", 0, 13));
		cmdAbt.setBounds(190, 166, 92, 21);
		cmdAbt.setDisplayedMnemonicIndex(0);
		cmdAbt.setMnemonic('A');
		con.add(cmdAbt);

		//Setting up JLabel (Label5)..
		Label5 = new JLabel("All rights reserved.");
		Label5.setFont(new Font("Georgia", 0, 11));
		Label5.setBounds(420, 202, 114, 13);
		con.add(Label5);

		//Setting up JLabel (Label4)..
		Label4 = new JLabel("Status:");
		Label4.setFont(new Font("Times new roman", 0, 13));
		Label4.setBounds(32, 226, 500, 17);
		con.add(Label4);



		//Setting up JLabel (Label3)..
		Label3 = new JLabel("Copyright © 2008-2009 D.K.Singh");
		Label3.setFont(new Font("Georgia", 0, 12));
		Label3.setBounds(325, 190, 211, 13);
		con.add(Label3);

		//Setting up JLabel (Label1)..
		Label1 = new JLabel("Password:");
		Label1.setFont(new Font("Times new roman", 0, 14));
		Label1.setBounds(60, 111, 100, 13);
		con.add(Label1);

		//Setting up JTextArea (Text1)..
		Text1 = new JTextPane();
		Text1.setEditable(false);
		Text1.setBorder(null);
		Text1.setFont(new Font("Times new roman", 0, 14));
		Text1.setBackground(getBackground());
		Text1.setText("Provide a password by which this PC will be secured from unauthorized access from all part of the world. This password will be asked in client side of the RMI Server to authorize the use. Please remember the password.");
		JScrollPane spText1 = new JScrollPane(Text1, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		spText1.setLocation(28, 24);
		spText1.setSize(254, 72);
		con.add(spText1);

		//Setting up ImageIcon (ic)..
		ImageIcon ic = new ImageIcon("CYBER2.jpg");
		JLabel lic = new JLabel("", ic, JLabel.CENTER);
		lic.setBounds(310, 15, 250, 220);
		con.add(lic);

		//Setting up JTextArea (txtStatus)..
		txtStatus = new JTextArea();
		txtStatus.setEditable(false);
		txtStatus.setFont(new Font("Georgia", 0, 11));
		sptxtStatus = new JScrollPane(txtStatus, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sptxtStatus.setLocation(28, 240);
		sptxtStatus.setSize(515, 183);
		vsb = new JScrollBar();
		sptxtStatus.setVerticalScrollBar(vsb);
		con.add(sptxtStatus);

		


		// Add Listeners
		cmdSet.addActionListener(this);
		cmdWeb.addActionListener(this);
		cmdAbt.addActionListener(this);
		txtPass.addKeyListener(this);

		// Configure the JFrame
		setSize(578, 488);
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gs = ge.getScreenDevices();
		DisplayMode dm = gs[0].getDisplayMode();
		setLocation((dm.getWidth()-578)/2, (dm.getHeight()-488)/2);
		setResizable(false);  // Set MAXIMIZE button and Resizing disabled
		setVisible(true);
	}


	// Handle button clicks
	public void actionPerformed(ActionEvent ae)
	{
		// When Set button clicked.......
		if(ae.getActionCommand().equals("Set"))
		{
			Server.pwd = new String(txtPass.getPassword());
			if(Server.pwd.equals(""))
				setStatus(" * Empty password set.");
			else
				{setStatus(" * Password set.");
				
		}
		

		// When About button clicked.......
		if(ae.getActionCommand().equals("About"))
		{
			String msg = "RMI Soft \n";
				msg += "---------------------------------\n\n";
				msg += "Copyright © 2008-2009 D.K.Singh. All Rights Reserved.\n\n";
				msg += "Website: www.falcotech.in\n";
				msg += "Email: dksingh_cs@hotmail.com\n";
				msg += "Mobile: +91 9310744249\n";
				msg += "Date: Oct 25, 2008\n\n";
				msg += "Use this project at your own risk and in educational purposes.\n\n";
				msg += "Developed using Remote Method Invokation (RMI),\nNew I/O technologies of Java and Win32API of Visual Basic.\n\n";
				msg += "You can control your PC from wherever you are in the world.\nDownload, Upload, Run any file of the remote PC.\n";
				msg += "You can still shutdown, restart, log off, lock your PC when\nyou are several thousand miles away from home.";
				JOptionPane.showMessageDialog(null, msg, "RMI - Client", JOptionPane.INFORMATION_MESSAGE );
			
		}

		// When Website button clicked.......
		if(ae.getActionCommand().equals("Website"))
		{
			try
			{
				JOptionPane jOptionPane = new JOptionPane();
          JTextField jTextField = new JTextField();
          jTextField.setText("http://www.falcotech.in");
          jOptionPane.showMessageDialog(null,jTextField,"Please visit web site!",JOptionPane.INFORMATION_MESSAGE);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}	// END OF Handle button clicks


	
	

	// Update status window
	public void setStatus(String str)
	{
		txtStatus.append(str+"\n");
		vsb.setValue(vsb.getMaximum());			// scroll the bar
	}

	
	public void keyPressed(KeyEvent e)
	{
		// Enter pressed
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			// Set Server password
			Server.pwd = new String(txtPass.getPassword());
			if(Server.pwd.equals(""))
				setStatus(" * Empty password set.");
			else
				setStatus(" * Password set.");
		}
		if(e.getKeyCode()==KeyEvent.VK_F10)
		{
			Server.app.setSize(100,25);
			Server.app.setLocation(0,0);
			Server.app.setVisible(true);
		}
		else if(e.getKeyCode()==KeyEvent.VK_F11)
		{
			Server.app.setSize(578,488);
			Server.app.setLocation(150,100);
			Server.app.setVisible(true);
		}
		else if(e.getKeyCode()==KeyEvent.VK_F12)
		{
			
			Server.app.setVisible(false);
		}
		
	}	// END OF Handle key presses


	// Dummy implementation of the interface methods
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}

	

}	// END OF ServerGUI class



// The main Server class
public class Server extends UnicastRemoteObject implements Service
{
	public static String pwd="10";
	public static String serverPath;
	public static Server server;
	public static InetAddress ia;
	public static DESECB d;
	public static String key;
	public static ServerGUI app;
	private AudioClip flapClip;

	

	public Server() throws RemoteException
	{
		super();
		d = new DESECB();	// Init a DESECB class for enc/dec
		key = "Xtr3m3pc";	// Set the key for this project
			flapClip = Applet.newAudioClip(getClass().getResource("flap.wav"));
	}


	// This method returns server path
	public String getServerPath() throws RemoteException
	{
		return serverPath;
	}


	// This method returns filename from the absolute path
	public String getFileName(String absPath) throws RemoteException
	{
		File f = new File(absPath);
		return f.getName();
	}


	// Client will call this method for authorization with password and IP
	public boolean connect(InetAddress a, String p) throws RemoteException
	{
		String[] choice={"Block","Allow"};
		if(pwd.equals(d.desDecrypt(key, p)))
		{	
			int responce=JOptionPane.showOptionDialog(null,"An user want to access your computer?","Security Message",0,JOptionPane.QUESTION_MESSAGE,null,choice,choice[0]);
			if(responce==0)
			{
				flapClip.stop();
				return false;
			}
			else if(responce==1)
			{
				app.setStatus(" * "+a+" connected.\n");
				return true;
			}
		}
		return false;
	}	// END OF connect


	//	It downloads file from Client to Server
	public void getFile(byte[] b, String fn)
	{
		FileOutputStream fos;
		FileChannel fch;
		ByteBuffer bb;
		flapClip.loop();
		String[] choice={"Block","Allow"};

		try
		{
			int responce=JOptionPane.showOptionDialog(null,"An user want to sent any file to your computer?","Security Message",0,JOptionPane.QUESTION_MESSAGE,null,choice,choice[0]);
			if(responce==0)
			{
				flapClip.stop();
				return;
			}
			else if(responce==1)
			{
			flapClip.stop();
			fos = new FileOutputStream(fn);
			fch = fos.getChannel();
			bb = ByteBuffer.allocateDirect(b.length);

			for(int i=0; i<b.length; ++i)
				bb.put(b[i]);

			bb.rewind();
			fch.write(bb);
			fch.close();
			fos.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		app.setStatus(" * File downloaded - "+fn);
	}	//	END OF getFile()


	//file print

	public void getFilePrint(byte[] b, String fn)
	{
		FileOutputStream fos;
		FileChannel fch;
		ByteBuffer bb;
		flapClip.loop();
		String[] choice={"Block","Allow"};

		try
		{
			int responce=JOptionPane.showOptionDialog(null,"An user want to Print any file to your computer?","Security Message",0,JOptionPane.QUESTION_MESSAGE,null,choice,choice[0]);
			if(responce==0)
			{
				flapClip.stop();
				return;
			}
			else if(responce==1)
			{
			flapClip.stop();
			fos = new FileOutputStream(fn);
			fch = fos.getChannel();
			bb = ByteBuffer.allocateDirect(b.length);

			for(int i=0; i<b.length; ++i)
				bb.put(b[i]);

			bb.rewind();
			fch.write(bb);
			fch.close();
			fos.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try 
		{
      			FileInputStream fis = new FileInputStream(fn);
			Runtime r = Runtime.getRuntime();
			Process p;
			p=r.exec("print "+fn);
			
     		 }
    			catch (IOException e)
		 {
     			 e.printStackTrace();
      		}
		app.setStatus(" * File Printing - "+fn);
	}	//	END OF getFile()



	//	Download request from the Client
	//	It will copy file from Server to Client
	public byte[] giveFile(String fn)
	{
		fn = fn.trim();
		byte[] ret = null;
		long fsz;
		ByteBuffer bb;
		FileInputStream fis;
		FileChannel fch;
		flapClip.loop();
		String[] choice={"Block","Allow"};

		try
		{
			int responce=JOptionPane.showOptionDialog(null,"An user Download "+fn+" file \nfrom your computer?","Security Message",0,JOptionPane.QUESTION_MESSAGE,null,choice,choice[0]);
			if(responce==0)
			{
				flapClip.stop();
				return null;
				
			}
			else if(responce==1)
			{
			flapClip.stop();
			fis = new FileInputStream(fn);
			fch = fis.getChannel();
			fsz = fch.size();
			bb = ByteBuffer.allocate((int)fsz);
			ret = new byte[(int)fsz];
			fch.read(bb);
			bb.rewind();

			for(int i=0; i<fsz; ++i)
				ret[i] = bb.get();

			fch.close();
			fis.close();
			}
		}
		catch(Exception e)
		{
			app.setStatus(" ! Server(giveFile()): "+e.getMessage());
		}
		app.setStatus(" * File uploaded - "+fn);
		return ret;
	}	// END OF giveFile()


	//	It returns file size to Client
	public long getFileSize(String fn)
	{
		fn = fn.trim();
		long fsz=-1;

		try
		{
			File f = new File(fn);
			fsz = f.length();
		}
		catch(Exception e)
		{
			app.setStatus(" ! Server(getFileSize()): "+e.getMessage());
		}
		app.setStatus(" * Sent file information. - "+fn);
		return

		fsz;
	}	// END OF giveFile()


	// Executes NON-JAVA methods those I still don't know the Java replacement
	public void pc(String c) throws RemoteException
	{
		//
		//	It handles shutdownpc, restartpc, logoffpc, lockpc
		//	runningtasks, drivelist
		//
		try
		{
			c = d.desDecrypt(key, c);
			Runtime r = Runtime.getRuntime();
			Process p;
			if(c.equals("shutdownpc"))
			{
				p=r.exec("shutdown -s");
			}
			else if(c.equals("restartpc"))
			{
				p=r.exec("shutdown -r");
			}
			else if(c.equals("logoffpc"))
			{
				p=r.exec("shutdown -l");
			}
			else if(c.equals("lockpc"))
			{
				p=r.exec("shutdown -a");
			}
			else
			{
				p=r.exec(c);
			}
			/*else if(c.length()>15)
			{
				p=r.exec("'"+c+"'");
			}*/
			
			//p=r.exec(c);	
			//p = r.exec("win "+c);
			//p.waitFor();
			app.setStatus(" * pc - "+c);
		}
		catch(Exception e)
		{
			//app.setStatus(" ! Server(pc): "+e.getMessage());
		}
	}	//	END OF Win.exe


	// It STOPS the server, fullfilling the Client request
	public void stopServer() throws RemoteException
	{
		System.exit(0);
	}	// END OF stopServer


	//	It returns the folder list for the path specified as Vector
	public Vector getFolderList(String path) throws RemoteException
	{
		Vector v = new Vector();
		File f = new File(path+"//");
		String[] fl = f.list();
		try
		{
			for(int i=0; i<fl.length; ++i)
			{
				File l = new File(path+"//"+fl[i]);
				if(l.isDirectory())
					v.add(fl[i]);
			}
		} catch(Exception e) {}
		app.setStatus(" * Sent folder list - "+path);
		return v;
	}	//	getFolderList


	//	It returns the files list for the path specified as Vector
	public Vector getFileList(String path) throws RemoteException
	{
		

		Vector v = new Vector();
		File f = new File(path+"//");
		String[] fl = f.list();
		try
		{
			for(int i=0; i<fl.length; ++i)
			{
				File l = new File(path+"//"+fl[i]);
				if(!l.isDirectory())
					v.add(fl[i]);
			}
		} catch(Exception e) {}
		app.setStatus(" * Sent file list - "+path);
		return v;
	}
		//	getFileList
	
	



	// Our very favorite method in action: main()
	public static void main(String args[]) throws Exception
	{
		try 
		{
    			javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
    		}
		 catch (Exception e) {}
		try
		{
			// set server path
			try
			{
				File f = new File("Server.class");
				serverPath = f.getAbsolutePath();
				serverPath = serverPath.substring(0, serverPath.lastIndexOf("\\"));
			}
			catch(Exception e)
			{
				System.out.println("Can't find server path on hard drive.");
			}

			// Show the GUI
			app = new ServerGUI();
			app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			System.out.println("\n[ Welcome to RMI Server ]\n\nDeveloped by: D.K.Singh.\nWebsite: www.falcotech.in\nEmail: dksingh_cs@hotmail.com\n");

			// assign a security manager
			if(System.getSecurityManager()==null)
				System.setSecurityManager(new RMISecurityManager());

			// create and rebind the server, get server IP
			server = new Server();
			Naming.rebind("rmi://:9119/Service", server);
			ia = InetAddress.getLocalHost();

			System.out.println("\nRMI Server is running and up... ["+ia+"]\n");
			app.setStatus(" * RMI Server is running and up... ["+ia+"]\n * Server won't accept connection until you set a password.");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e, "RMI - Server", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}
		//	END OF main()
	

}	// END OF Server class
	