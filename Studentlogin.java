package mp1;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
public class Studentlogin extends JFrame implements ActionListener
{
	static Studentlogin frame;
	JLabel uname,psw,lbl;
	JTextField tuname;
	JPasswordField tpsw;
	Container c;
	JButton exit,Login;//next;
	JOptionPane jp = new JOptionPane();
	JMenuBar menuBar,menuBar1;	
	JMenu menu1,menu2; 
	JMenuItem menuItemN,menuItemH,menuItemA,menuItemE;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Studentlogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Studentlogin()
	{
		super("MAIN");
		c = getContentPane(); c.setBackground(new Color(14,58,119));
		c.setLayout(null); 
		setBounds(0,0,800,520);
		setFont(new Font("verdana",3,14));
		menuBar = new JMenuBar(); 	
		menu1 = new JMenu("FILE");	menu1.setBackground(Color.white);
		menu1.setMnemonic('F');
		menu2 = new JMenu("Help"); 	
		menu2.setMnemonic('H');	menu2.setBackground(Color.white);
		menuItemN = new JMenuItem("NO EXTRA PRivillage",new ImageIcon("NEW.GIF")); menuItemN.setBackground(Color.white);
		menuItemN.setMnemonic('N');
		menuItemE = new JMenuItem("Exit",new ImageIcon("Exit.PNG")); menuItemE.setBackground(Color.white);
		menuItemE.setMnemonic('E');
		menuItemA = new JMenuItem("About LRS",new ImageIcon("help.gif"));
		setJMenuBar(menuBar);
		ImageIcon coll = new ImageIcon("123.png");
		JLabel LogoColl = new JLabel(coll);
		ImageIcon col = new ImageIcon("b.jpg");
		JLabel LogoCol = new JLabel(col);
		lbl=new JLabel("STUDENT LOGIN");  	lbl.setFont(new Font("IMPACT",0,50));	lbl.setForeground(new Color(14,58,119));
		uname=new JLabel("USER NAME:"); 	uname.setFont(new Font("IMPACT",0,14)); uname.setForeground(Color.black);
		psw=new JLabel("PASSWORD:"); 	psw.setFont(new Font("IMPACT",0,14));		psw.setForeground(Color.black);
        tuname=new JTextField();	
		tpsw=new JPasswordField();
		exit = new JButton("Back", new ImageIcon("EXIT455.PNG")); exit.setForeground(Color.black);
		Login = new JButton("Login", new ImageIcon("EXIT455.PNG")); Login.setForeground(Color.black);
			exit.setToolTipText("Exit from the library");	
			Login.setToolTipText("Click to login as Admin");
			lbl.setBounds(50,20,400,40);
			Login.setBounds(30,200,100,30);
			exit.setBounds(200,200,100,30);
			uname.setBounds(30,100,200,30);
			tuname.setBounds(100,100,200,30);
			psw.setBounds(30,150,200,30);
			tpsw.setBounds(100,150,200,30);
			LogoColl.setBounds(260,0,500,500);
			LogoCol.setBounds(0,0,1000,700);
			menu1.add(menuItemN);
			menu1.add(menuItemE);
			menuBar.add(menu1);
			menu2.add(menuItemA);
			menuBar.add(menu2);
			Login.addActionListener(this);
			exit.addActionListener(this);
			menuItemN.addActionListener(this);
			menuItemA.addActionListener(this);
			menuItemE.addActionListener(this);
			c.add(lbl);
			c.add(exit);
			c.add(uname);
			c.add(psw);
			c.add(tuname);
			c.add(tpsw);	
			c.add(Login);
			c.add(LogoColl);
			c.add(LogoCol);
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
		

		if(str1.equals("Back"))
		{
			frst.main(new String[]{});
			frame.dispose();
		}
		if(str1.equals("Login"))
		{
			try {
			String usr,pass;
			usr=tuname.getText();
			pass=tpsw.getText();
			   System.out.print("Uname : " + uname + " Pwd : " +pass);
	            
	            String url="com.mysql.jdbc.Driver";
	            String dburl="jdbc:mysql://localhost:3306/mini?autoReconnect=true&useSSL=false";
	            String uid="root";
	            String passwd="root123";
	            String sql = "SELECT * FROM S WHERE uname LIKE '"+
	                usr+"' AND psw LIKE '"+pass+"'";
	             Class.forName(url);
	            Connection con = DriverManager.getConnection(dburl, uid, passwd);
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(sql);
	            
	            if(rs.next())
	            {
	               student.main(new String[]{});
	               frame.dispose();
	            }
	            else
	            {
	                JOptionPane.showMessageDialog(null, "InValid User");
	                tuname.setText("");
	                tpsw.setText("");
	            }
	            }catch(Exception ex)
	            {
	                System.out.print("Exception : " + ex.getMessage());
	                    // TODO add your handling code here:
	            }
		}
		
	  }
		
	public static void main(String arg[])
 	{
 		 Studentlogin p4 = new Studentlogin();
		 p4.setResizable(false);
	 }
}