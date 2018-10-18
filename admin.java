package mp1;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

import com.sun.java.swing.plaf.motif.MotifLookAndFeel;

public class admin extends JFrame implements ActionListener
{
	static admin frame;
	Container c;
	JButton exit,logout,ad,isue,return1;//logout;
	JOptionPane jp = new JOptionPane();
	JMenuBar menuBar,menuBar1;	
	JMenu menu1,menu2; 
	JMenuItem menuItemN,menuItemH,menuItemA,menuItemE;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public admin()
	{
		super("Admin Page");
		c = getContentPane(); c.setBackground(new Color(14,58,119));
		c.setLayout(null); 
		setBounds(0,0,480,590);
		setFont(new Font("verdana",3,14));
		menuBar = new JMenuBar(); 	
		menu1 = new JMenu("REQUESTED");	menu1.setBackground(Color.white);
		menu1.setMnemonic('R');
		menu2 = new JMenu("Help"); 	
		menu2.setMnemonic('H');	menu2.setBackground(Color.white);
		menuItemN = new JMenuItem("View Requested books",new ImageIcon("NEW.GIF")); menuItemN.setBackground(Color.white);
		menuItemN.setMnemonic('N');
		menuItemE = new JMenuItem("Exit",new ImageIcon("Exit1.PNG")); menuItemE.setBackground(Color.white);
		menuItemE.setMnemonic('E');

		menuItemA = new JMenuItem("About LRS");
		setJMenuBar(menuBar);
        exit = new JButton("Exit", new ImageIcon("EXIT123.PNG")); exit.setForeground(Color.black); exit.setBackground(Color.white);
         logout = new JButton("logout", new ImageIcon("logout.gif")); logout.setForeground(Color.black); logout.setBackground(Color.white);
			ad=new JButton("Book", new ImageIcon("boooks.jpg")); ad.setForeground(Color.black);
			isue=new JButton("issue book", new ImageIcon("isueee.png")); isue.setForeground(Color.black);
			return1=new JButton("return1urn", new ImageIcon("return.png")); return1.setForeground(Color.black);
			exit.setToolTipText("Exit from the library");	
			logout.setToolTipText("logout");
			ad.setToolTipText("Add or delete books.......");
			isue.setToolTipText("Isue/return1urn of book");
			return1.setToolTipText("Isue/return1urn of book");
			ImageIcon coll = new ImageIcon("download.jpg");
			JLabel LogoColl = new JLabel(coll);
			
			exit.setBounds(100,400,100,30);
		    logout.setBounds(255,400,95,30);
		    exit.setFont(new Font("Viner Hand ITC",0,14));
		    logout.setFont(new Font("Viner Hand ITC",0,14));
			ad.setBounds(20,60,250,104);
			isue.setBounds(20,166,250,104);
			LogoColl.setBounds(0,0,900,866);
			
			return1.setBounds(20,272,250,104);
		    menu1.add(menuItemN);
			menu1.add(menuItemE);
			menuBar.add(menu1);
			menu2.add(menuItemA);
			menuBar.add(menu2);
			exit.addActionListener(this);
			logout.addActionListener(this);
			ad.addActionListener(this);
			isue.addActionListener(this);
			return1.addActionListener(this);
			menuItemN.addActionListener(this);
			menuItemA.addActionListener(this);
			menuItemE.addActionListener(this);
			
			c.add(exit);
			c.add(logout); 
			c.add(ad);
			c.add(isue);
			c.add(return1);
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
		if(source==menuItemN)
		{
			rview.main(new String[]{});
		}
		if(str1.equals("Book"))
		{
			addbook.main(new String[]{});
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
		if(str1.equals("issue book"))
		{
			issue.main(new String[]{});
			frame.dispose();
		}
		if(str1.equals("return1urn"))
		{
			ret.main(new String[]{});
			frame.dispose();
		}
	  }
		
	public static void main(String arg[])
 	{
 		 admin p4 = new admin();
		 p4.setResizable(false);
		 

	 }

}
