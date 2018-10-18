package mp1;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

import com.sun.java.swing.plaf.motif.MotifLookAndFeel;

public class issue extends JFrame implements ActionListener
{
	static issue frame;
	Container c;
	JLabel id,usn,bid;
	JTextField tid,tusn,tbid;
	JButton exit,logout,isue,vi;//logout;
	JOptionPane jp = new JOptionPane();
	JMenuBar menuBar,menuBar1;	
	JMenu menu1,menu2; 
	JMenuItem menuItemN,menuItemH,menuItemA,menuItemE;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new issue();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public issue()
	{
		super("ISSUE BOOK");
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
		id=new JLabel("ISSUE ID:");	 id.setForeground(Color.white);	id.setFont(new Font("IMPACT",0,19));
		usn=new JLabel("USN:");		  usn.setForeground(Color.white);	usn.setFont(new Font("IMPACT",0,19));
		bid=new JLabel("Book id:");		 bid.setForeground(Color.white);	bid.setFont(new Font("IMPACT",0,19));
       tid=new JTextField();
       tusn=new JTextField();
       tbid=new JTextField();
		
		exit = new JButton("Back"); exit.setForeground(Color.black); exit.setBackground(Color.white);
        isue=new JButton("Issue");	isue.setForeground(Color.black);	isue.setBackground(Color.white);
        logout = new JButton("logout", new ImageIcon("logout.gif")); logout.setForeground(Color.black); logout.setBackground(Color.white);
		vi=new JButton("View", new ImageIcon("logout.gif")); vi.setForeground(Color.black); vi.setBackground(Color.white);
			
		exit.setFont(new Font("Viner Hand ITC",0,14));
		isue.setFont(new Font("Viner Hand ITC",0,14));
		logout.setFont(new Font("Viner Hand ITC",0,14));
		vi.setFont(new Font("Viner Hand ITC",0,14));
			exit.setToolTipText("Click to go back");	
			logout.setToolTipText("Click to login");
			 isue.setToolTipText("Click to Issue Book");
			 vi.setToolTipText("Click to View Issued Books");
			 
			ImageIcon co = new ImageIcon("wall.jpg");
			JLabel Logo = new JLabel(co);
		
			exit.setBounds(140,400,100,30);
		    logout.setBounds(250,400,100,30);
		    vi.setBounds(360,400,100,30);
		    isue.setBounds(30, 400,100,30);
		    id.setBounds(30,200,100,30);
		    usn.setBounds(30,240,100,30);
		    bid.setBounds(30,280,100,30);
		    tid.setBounds(140,200,200,30);
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
			isue.addActionListener(this);
			vi.addActionListener(this);
			
			menuItemN.addActionListener(this);
			menuItemH.addActionListener(this);
			menuItemA.addActionListener(this);
			menuItemE.addActionListener(this);
			
			c.add(exit);
			c.add(logout); 
			c.add(isue);
			c.add(vi);
			c.add(id);
			c.add(LogoColl);
			c.add(usn);
			c.add(bid);
			c.add(tid);
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
		if(str1.equals("Issue"))
		{
			try {
				String usr,book;
				int no=Integer.parseInt(tid.getText());
				usr=tusn.getText();
				book=tbid.getText();
				   System.out.print("Usn : " +usr+ " Book : " +book);
		            
		            String url="com.mysql.jdbc.Driver";
		            String dburl="jdbc:mysql://localhost:3306/mini?autoReconnect=true&useSSL=false";
		            String uid="root";
		            String passwd="root123";
		            String sql = "select*from issuebook where usn='"+usr+"' group by(usn) having count(usn)>1";
		             Class.forName(url);
		            Connection con = DriverManager.getConnection(dburl, uid, passwd);
		            Statement st = con.createStatement();
		            ResultSet rs = st.executeQuery(sql);
		            
		            if(rs.next())
		            {
		            	  JOptionPane.showMessageDialog(null, "USER HAS ALREADY BORROWED 2 books");
		        
		            }
		            else
		            {
		              //  JOptionPane.showMessageDialog(null, "ISSUE POSSIBLE");
		              //  tusn.setText("");
		              //tbid.setText("");
		            	 PreparedStatement ps=con.prepareStatement("INSERT INTO ISSUEBOOK(id,bid,usn) values("+no+",'"+book+"','"+usr+"')");
		            	 int status=ps.executeUpdate();
		            	 PreparedStatement ps1=con.prepareStatement("update copies set copy=copy-1 where bid='"+book+"'");
		            	 int status2=ps1.executeUpdate();
		            }
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
 		 issue p4 = new issue();
		 p4.setResizable(false);
		 

	 }

}
