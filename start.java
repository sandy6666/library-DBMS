package mp1;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

import com.sun.java.swing.plaf.motif.MotifLookAndFeel;

public class start extends JFrame implements ActionListener
{
	static start frame;
	JTextField id,name,shift,class1,progress;
	Container c;
	JButton exit,next;//next;
	JOptionPane jp = new JOptionPane();
	JMenuBar menuBar,menuBar1;	
	JMenu menu1,menu2; 
	JMenuItem menuItemN,menuItemA,menuItemE;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new start();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public start()
	{
		super("MAIN");
		c = getContentPane(); c.setBackground(new Color(14,58,119));
		c.setLayout(null); 
		setBounds(0,0,850,590);
		setFont(new Font("verdana",3,14));
		ImageIcon coll = new ImageIcon("collicon.gif");
		JLabel LogoColl = new JLabel(coll);
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
			ImageIcon college = new ImageIcon("Movie2.jpg");
			JLabel colLogo = new JLabel(college);
        exit = new JButton("Exit", new ImageIcon("EXIT.PNG")); exit.setForeground(Color.black); exit.setBackground(Color.white);
         next = new JButton("Next", new ImageIcon("next.png")); next.setForeground(Color.black); next.setBackground(Color.white);
			exit.setToolTipText("Exit from the library");	
			next.setToolTipText("NEXT PAGE FROM LIBRARY");	
			colLogo.setBounds(0,0,850,550);
			exit.setBounds(610,410,200,100);
		    next.setBounds(610,300,200,100);//(670,490,100,30);
			menu1.add(menuItemN);
			menu1.add(menuItemE);
			menuBar.add(menu1);
			menu2.add(menuItemA);
			menuBar.add(menu2);
			exit.addActionListener(this);
			next.addActionListener(this);
			menuItemN.addActionListener(this);
			menuItemA.addActionListener(this);
			menuItemE.addActionListener(this);
			c.add(exit);
			c.add(next);
			c.add(colLogo);	
     
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
	

		if(str1.equals("Next"))
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
 		 start p4 = new start();
		 p4.setResizable(false);
		 

	 }

}
