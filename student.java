package mp1;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class student extends JFrame implements ActionListener
{
	static student frame;
	Container c;
	JButton exit,logout,ad,isue,deluser;//logout;
	JOptionPane jp = new JOptionPane();
	JMenuBar menuBar,menuBar1;	
	JMenu menu1,menu2; 
	JMenuItem menuItemN,menuItemH,menuItemA,menuItemE;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new student();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public student()
	{
		super("MAIN");
		c = getContentPane(); c.setBackground(new Color(14,58,119));
		c.setLayout(null); 
		setBounds(0,0,480,590);
		setFont(new Font("verdana",3,14));
		menuBar = new JMenuBar(); 	
		menu1 = new JMenu("FILE");	menu1.setBackground(Color.white);
		menu1.setMnemonic('F');
		menu2 = new JMenu("Help"); 	
		menu2.setMnemonic('H');	menu2.setBackground(Color.white);
		menuItemN = new JMenuItem("NO EXTRA PRivillage",new ImageIcon("NEW.GIF")); menuItemN.setBackground(Color.white);
		menuItemN.setMnemonic('N');
		menuItemE = new JMenuItem("Exit",new ImageIcon("Exit1.PNG")); menuItemE.setBackground(Color.white);
		menuItemE.setMnemonic('E');
		menuItemA = new JMenuItem("About LRS",new ImageIcon("help.gif"));
		setJMenuBar(menuBar);
		ImageIcon coll = new ImageIcon("quot.jpg");
		JLabel LogoColl = new JLabel(coll);
	
        exit = new JButton("Exit"); exit.setForeground(Color.black); exit.setBackground(Color.white);
         logout = new JButton("logout"); logout.setForeground(Color.black); logout.setBackground(Color.white);
			ad=new JButton("View Books", new ImageIcon("view.png")); ad.setForeground(Color.black);
			isue=new JButton("Request Book", new ImageIcon("re.png")); isue.setForeground(Color.black);	isue.setBackground(Color.white);
			
			exit.setToolTipText("Exit from the library");	
			logout.setToolTipText("click to logout");
			ad.setToolTipText("Click to View books.......");
			isue.setToolTipText("Click to Request book");
			exit.setFont(new Font("Viner Hand ITC",0,20));
			logout.setFont(new Font("Viner Hand ITC",0,20));
			exit.setBounds(20,400,100,30);
		    logout.setBounds(121,400,95,30);
			ad.setBounds(20,100,198,68);
			isue.setBounds(20,270,198,68);
			LogoColl.setBounds(0,0,480,580);
		    menu1.add(menuItemN);
			menu1.add(menuItemE);
			menuBar.add(menu1);
			menu2.add(menuItemA);
			menuBar.add(menu2);
			exit.addActionListener(this);
			logout.addActionListener(this);
			ad.addActionListener(this);
			isue.addActionListener(this);
			menuItemN.addActionListener(this);
			menuItemA.addActionListener(this);
			menuItemE.addActionListener(this);
			
			c.add(exit);
			c.add(logout); 
			c.add(ad);
			c.add(isue);
			c.add(LogoColl);
			
			
	}
		
	public void actionPerformed(ActionEvent ae)
	{	
		String str1=(String)ae.getActionCommand();
		Object source = ae.getSource();
		if(source==menuItemA)
		{
			JFrame aboutus = new JFrame("About us");
			aboutus.setSize(700,500);
			aboutus.getContentPane().setLayout(null);
			ImageIcon design = new ImageIcon("about.png");
			JLabel cover = new JLabel(design);
			aboutus.getContentPane().add(cover);
			cover.setBounds(5,0,685,500);
			aboutus.setVisible(true);
		}
	
		if(str1.equals("View Books"))
		{
			view.main(new String[]{});
		
		}
		if(str1.equals("Request Book"))
		{
			reqb.main(new String[]{});
			frame.dispose();
		}
		if(str1.equals("logout"))
		{
			frst.main(new String[]{});
			frame.dispose();
		}
		if(str1.equals("Exit"))
		{
			frame.dispose();
		}
	  }
		
	public static void main(String arg[])
 	{
 		 student p4 = new student();
		 p4.setResizable(false);
		 

	 }

}
