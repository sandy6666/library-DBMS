package mp1;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class reqb extends JFrame implements ActionListener
{
	static reqb frame;
	JLabel usn,bname;
	JTextField tusn,tbname;
	Container c;
	JButton back,submit;//next;
	JOptionPane jp = new JOptionPane();
	JMenuBar menuBar,menuBar1;	
	JMenu menu1,menu2; 
	JMenuItem menuItemN,menuItemH,menuItemA,menuItemE;
	Cursor cur;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new reqb();
					frame.setSize(785,700); 
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public reqb()
	{
		super("request Book");
		c = getContentPane(); c.setBackground(new Color(14,58,119));
		c.setLayout(null); 
		setBounds(0,0,850,590);
		setFont(new Font("verdana",3,14));
		cur = new Cursor(Cursor.CROSSHAIR_CURSOR);
		setCursor(cur);
		bname=new JLabel("Book"); bname.setForeground(Color.white);	bname.setFont(new Font("Impact",0,24));
		usn=new JLabel("USN"); usn.setForeground(Color.white);		usn.setFont(new Font("Impact",0,24));
		
		
		tbname = new JTextField();		tbname.setForeground(Color.black); tbname.setBackground(Color.white);
		tusn = new JTextField();		tusn.setForeground(Color.black); tusn.setBackground(Color.white);

		
		menuBar = new JMenuBar(); 	
		menu1 = new JMenu("FILE");	menu1.setBackground(Color.white);
		menu1.setMnemonic('F');
		menu2 = new JMenu("Help"); 	
		menu2.setMnemonic('H');	menu2.setBackground(Color.white);
		
		menuItemN = new JMenuItem("NO EXTRA PRivillage",new ImageIcon("NEW.GIF")); menuItemN.setBackground(Color.white);
		menuItemN.setMnemonic('N');
		menuItemE = new JMenuItem("back",new ImageIcon("back.PNG")); menuItemE.setBackground(Color.white);
		menuItemE.setMnemonic('E');
		menuItemH = new JMenuItem("Help library",new ImageIcon("help.gif")); menuItemH.setBackground(Color.white);
		menuItemH.setMnemonic('E');
		menuItemA = new JMenuItem("About LRS");
		setJMenuBar(menuBar);
		ImageIcon coll = new ImageIcon("request.png");
		JLabel LogoColl = new JLabel(coll);
		ImageIcon log = new ImageIcon("libraryb.jpg");
		JLabel Coll = new JLabel(log);
			
        	back = new JButton("back", new ImageIcon("back.PNG")); back.setForeground(Color.black);	back.setBackground(Color.white); //back.setBackground(Color.white);
        	submit = new JButton("Submit", new ImageIcon("submit12.png")); submit.setForeground(Color.black); 	submit.setBackground(Color.white);	
        	submit.setFont(new Font("Viner Hand ITC",0,26));
        	
			
         
         	back.setToolTipText("back from the library");
			bname.setBounds(30,280,150,20);
			usn.setBounds(30,370,150,20);
			tbname.setBounds(180,280,150,23);
			tusn.setBounds(180,370,150,23);
			submit.setBounds(30,450,150,30);
			back.setBounds(230,450,150,30);
			LogoColl.setBounds(0,30,788,150);
			Coll.setBounds(0,0,1500,800);
			
		    
		    menu1.add(menuItemN);
			menu1.add(menuItemE);
			menuBar.add(menu1);
			menu2.add(menuItemH);
			menu2.add(menuItemA);
			menuBar.add(menu2);
			
			
			back.addActionListener(this);
			submit.addActionListener(this);
			menuItemN.addActionListener(this);
			menuItemH.addActionListener(this);
			menuItemA.addActionListener(this);
			menuItemE.addActionListener(this);
		
			c.add(bname);
			c.add(usn);
			c.add(tbname);
			c.add(tusn);
			c.add(back);
			c.add(submit);
			c.add(LogoColl);
			c.add(Coll);
			
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
	

	
		if(str1.equals("Submit"))
		{
			 
			  try{
					String usr=tusn.getText();
					String book=tbname.getText();
		      
		            String url="com.mysql.jdbc.Driver";
		            String dburl="jdbc:mysql://localhost:3306/mini?autoReconnect=true&useSSL=false";
		            String uid="root";
		            String passwd="root123";
		          
		    
		             Class.forName(url);
		            Connection con = DriverManager.getConnection(dburl, uid, passwd);
		      
		            PreparedStatement ps=con.prepareStatement("INSERT INTO Request values('"+usr+"','"+book+"')");
		         
					int status=ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Updated Successfully");
		            }catch(Exception ex)
		            {
		               System.out.print("Exception : " + ex.getMessage());
		               JOptionPane.showMessageDialog(null, "EXCEPTION");
		                    // TODO add your handling code here:
		    
		           } 
			//reqbectLibrary.main(new String[]{});
			//frame.dispose();
		}
		if(str1.equals("back"))
		{
			student.main(new String[]{});
			frame.dispose();
		}
	  }
		
	public static void main(String arg[])
 	{
 		 reqb p4 = new reqb();
		 p4.setResizable(false);
		 

	}

}
