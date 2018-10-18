package mp1;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

import com.sun.java.swing.plaf.motif.MotifLookAndFeel;

public class ret extends JFrame implements ActionListener
{
	static ret frame;
	Container c;
	JLabel usn,bid;
	JTextField tid,tusn,tbid;
	JButton exit,logout,ret,vi;//logout;
	JOptionPane jp = new JOptionPane();
	JMenuBar menuBar,menuBar1;	
	JMenu menu1,menu2; 
	JMenuItem menuItemN,menuItemH,menuItemA,menuItemE;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ret();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ret()
	{
		super("RETURN BOOK");
		c = getContentPane(); c.setBackground(new Color(14,58,119));
		c.setLayout(null); 
		setBounds(0,0,650,590);
		setFont(new Font("verdana",3,14));
		menuBar = new JMenuBar(); 	
		menu1 = new JMenu("Display");	menu1.setBackground(Color.white);
		menu1.setMnemonic('D');
		menu2 = new JMenu("Help"); 	
		menu2.setMnemonic('H');	menu2.setBackground(Color.white);
		menuItemN = new JMenuItem("Books",new ImageIcon("bok.png")); menuItemN.setBackground(Color.white);
		menuItemN.setMnemonic('B');
		menuItemE = new JMenuItem("Exit",new ImageIcon("Exit1.PNG")); menuItemE.setBackground(Color.white);
		menuItemE.setMnemonic('E');
		menuItemH = new JMenuItem("Borrowers",new ImageIcon("borr.png")); menuItemH.setBackground(Color.white);
		menuItemH.setMnemonic('B');
		menuItemA = new JMenuItem("About LRS",new ImageIcon("help.gif"));
		setJMenuBar(menuBar);
		ImageIcon coll = new ImageIcon("cont.png");
		JLabel LogoColl = new JLabel(coll);
		usn=new JLabel("USN:");		  usn.setForeground(Color.white);	usn.setFont(new Font("IMPACT",0,19));
		bid=new JLabel("Book id:");		 bid.setForeground(Color.white);	bid.setFont(new Font("IMPACT",0,19));
     
       tusn=new JTextField();
       tbid=new JTextField();
		
		exit = new JButton("Back"); exit.setForeground(Color.black); exit.setBackground(Color.white);
        ret=new JButton("Return_Book");	ret.setForeground(Color.black);	ret.setBackground(Color.white);
        logout = new JButton("logout", new ImageIcon("logout.gif")); logout.setForeground(Color.black); logout.setBackground(Color.white);
		vi=new JButton("View", new ImageIcon("logout.gif")); vi.setForeground(Color.black); vi.setBackground(Color.white);
			
		exit.setFont(new Font("Viner Hand ITC",0,14));
		ret.setFont(new Font("Viner Hand ITC",0,14));
		logout.setFont(new Font("Viner Hand ITC",0,14));
		vi.setFont(new Font("Viner Hand ITC",0,14));
			exit.setToolTipText("Exit from the library");	
			logout.setToolTipText("logout");
			
			ImageIcon co = new ImageIcon("wall.jpg");
			JLabel Logo = new JLabel(co);
		
			exit.setBounds(140,400,100,30);
		    logout.setBounds(250,400,100,30);
		    vi.setBounds(360,400,100,30);
		    ret.setBounds(30, 400,100,30);
		  
		    usn.setBounds(30,240,100,30);
		    bid.setBounds(30,280,100,30);
		
		    tusn.setBounds(140,240,200,30);
		    tbid.setBounds(140,280,200,30);
			LogoColl.setBounds(150,0,167,147);
			Logo.setBounds(0,0,1200,600);
		    menu1.add(menuItemN);
		    menu1.add(menuItemH);
			menu1.add(menuItemE);
			menuBar.add(menu1);
			menu2.add(menuItemA);
			menuBar.add(menu2);
			exit.addActionListener(this);
			logout.addActionListener(this);
			ret.addActionListener(this);
			vi.addActionListener(this);
			
			menuItemN.addActionListener(this);
			menuItemH.addActionListener(this);
			menuItemA.addActionListener(this);
			menuItemE.addActionListener(this);
			
			c.add(exit);
			c.add(logout); 
			c.add(ret);
			c.add(vi);
			c.add(LogoColl);
			c.add(usn);
			c.add(bid);
			c.add(tusn);
			c.add(tbid);
			c.add(Logo);
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
			view.main(new String[]{});
		}
		if(source==menuItemH)
		{
			bview.main(new String[]{});
		}
		
		if(str1.equals("Back"))
		{
			admin.main(new String[]{});
			frame.dispose();
		}
		if(str1.equals("Return_Book"))
		{
			try {
				String usr,book;
				usr=tusn.getText();
				book=tbid.getText();
				   System.out.print("Usn : " +usr+ " Book : " +book);
		            
		            String url="com.mysql.jdbc.Driver";
		            String dburl="jdbc:mysql://localhost:3306/mini?autoReconnect=true&useSSL=false";
		            String uid="root";
		            String passwd="root123";
		           
		            Class.forName(url);
		            Connection con = DriverManager.getConnection(dburl, uid, passwd);
		      
		            PreparedStatement ps=con.prepareStatement("DELETE FROM ISSUEBOOK where usn='"+usr+"'AND bid='"+book+"'");
		            int status=ps.executeUpdate();
		            PreparedStatement ps1=con.prepareStatement("update copies set copy=copy+1 where bid='"+book+"'");
	            	 int status2=ps1.executeUpdate();
		            
		            }catch(Exception ex)
		            {
		                System.out.print("Exception : " + ex.getMessage());
		                    // TODO add your handling code here:
		            }
		}
		if(str1.equals("View"))
		{
			iview.main(new String[]{});
		}
	  }
		
	public static void main(String arg[])
 	{
 		 ret p4 = new ret();
		 p4.setResizable(false);
		 

	 }

}
