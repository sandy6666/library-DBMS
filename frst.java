package mp1;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
public class frst extends JFrame implements ActionListener
{
	static frst frame;
	JTextField id,name,shift,class1,progress;
	Container c;
	JButton exit,Admin,stud;//next;
	JOptionPane jp = new JOptionPane();
	JMenuBar menuBar,menuBar1;	
	JMenu menu1,menu2; 
	JMenuItem menuItemN,menuItemH,menuItemA,menuItemE;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new frst();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public frst()
	{
		super("MAIN");
		c = getContentPane(); c.setBackground(new Color(0,100,180));
		c.setLayout(null); 
		setBounds(0,0,280,590);
		setFont(new Font("verdana",3,14));
		menuBar = new JMenuBar(); 	
		menu1 = new JMenu("Register");	menu1.setBackground(Color.white);
		menu1.setMnemonic('R');
		menu2 = new JMenu("Help"); 	
		menu2.setMnemonic('H');	menu2.setBackground(Color.white);
		menuItemN = new JMenuItem("Registeration",new ImageIcon("NEW.GIF")); menuItemN.setBackground(Color.white);
		menuItemN.setMnemonic('R');
		menuItemE = new JMenuItem("Exit",new ImageIcon("Exit1.PNG")); menuItemE.setBackground(Color.white);
		menuItemE.setMnemonic('E');
		menuItemA = new JMenuItem("About LRS");
		setJMenuBar(menuBar);
        exit = new JButton("Exit", new ImageIcon("EXIT1.PNG")); exit.setForeground(Color.black);
        Admin=	new JButton("Admin Login",new ImageIcon("Admin.png")); Admin.setForeground(Color.black);
        stud=new JButton("Student Login",new ImageIcon("student.jpg")); stud.setForeground(Color.black);
        ImageIcon coll = new ImageIcon("quot.jpg");
		JLabel LogoColl = new JLabel(coll);
			exit.setToolTipText("Exit from the library");	
			exit.setBounds(30,490,100,30);
			Admin.setBounds(30,100,200,50);
			stud.setBounds(30,260,200,50);
			LogoColl.setBounds(0,0,480,580);
			menu1.add(menuItemN);
			menu1.add(menuItemE);
			menuBar.add(menu1);
			menu2.add(menuItemA);
			menuBar.add(menu2);
			exit.addActionListener(this);
			Admin.addActionListener(this);
			stud.addActionListener(this);
			menuItemN.addActionListener(this);
			menuItemA.addActionListener(this);
			menuItemE.addActionListener(this);
			c.add(exit);
			c.add(Admin);
			c.add(stud);
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
			proj.main(new String[]{});
		}
		
		if(str1.equals("Exit"))
		{
			frame.dispose();
		}
		if(str1.equals("Admin Login"))
		{
			Adminlogin.main(new String[]{});
			frame.dispose();
		}
		if(str1.equals("Student Login"))
		{
			Studentlogin.main(new String[]{});
			frame.dispose();
		}
	  }
		
	public static void main(String arg[])
 	{
 		 frst p4 = new frst();
		 p4.setResizable(false);
	 }
}