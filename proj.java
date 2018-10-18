package mp1;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
public class proj extends JFrame implements ActionListener
{
	static proj frame;
	JLabel usn,uname,psw,sq,sa,ph,email;
	JTextField tusn,tuname,tpsw,tsq,tsa,tph,temail;
	Container c;
	JButton exit,back,submit;//back;
	JOptionPane jp = new JOptionPane();
	JMenuBar menuBar,menuBar1;	
	JMenu menu1,menu2; 
	JMenuItem menuItemN,menuItemH,menuItemA,menuItemE;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new proj();
					frame.setSize(700,600); 
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public proj()
	{
		super("ADD USER");
		c = getContentPane(); c.setBackground(new Color(14,58,119));
		c.setLayout(null); 
		setBounds(0,0,1000,590);
		setFont(new Font("IMPACT",3,14));
		
		uname=new JLabel("USER NAME"); uname.setForeground(Color.white); uname.setFont(new Font("IMPACT",0,15));
		psw=new JLabel("PASSWORD"); psw.setForeground(Color.white);		 psw.setFont(new Font("IMPACT",0,15));
		usn=new JLabel("USN"); usn.setForeground(Color.white);			 usn.setFont(new Font("IMPACT",0,15));
		sq=new JLabel("Secrer question"); sq.setForeground(Color.white); sq.setFont(new Font("IMPACT",0,15));
		sa=new JLabel("Secrer answer"); sa.setForeground(Color.white);	 sa.setFont(new Font("IMPACT",0,15));
		ph=new JLabel("phone num"); ph.setForeground(Color.white); 		 ph.setFont(new Font("IMPACT",0,15));
		email=new JLabel("email"); email.setForeground(Color.white); 	 email.setFont(new Font("IMPACT",0,15));

		ImageIcon college = new ImageIcon("wa.jpg");
		JLabel colLogo = new JLabel(college);
		ImageIcon re = new ImageIcon("adduser.png");
		JLabel reg = new JLabel(re);
	
		
		
		tuname = new JTextField();		tuname.setForeground(Color.black); tuname.setBackground(Color.white);
		tusn = new JTextField();		tusn.setForeground(Color.black); tusn.setBackground(Color.white);
		tpsw=new JTextField(); 			tpsw.setForeground(Color.black); tpsw.setBackground(Color.white);
		tsq=new JTextField(); 			tsq.setForeground(Color.black); tsq.setBackground(Color.white);
		tsa=new JTextField(); 			tsa.setForeground(Color.black); tsa.setBackground(Color.white);
		tph=new JTextField(); 			tph.setForeground(Color.black); tph.setBackground(Color.white);
		temail=new JTextField(); 		temail.setForeground(Color.black); temail.setBackground(Color.white);
		
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
			
        	exit = new JButton("Exit"); exit.setForeground(Color.black); exit.setBackground(Color.white);
        	submit = new JButton("Submit"); submit.setForeground(Color.black); submit.setBackground(Color.white);
        	exit.setFont(new Font("Viner Hand ITC",1,14));
        	submit.setFont(new Font("Viner Hand ITC",1,14));
			
         
         	exit.setToolTipText("Exit from the library");
         	submit.setToolTipText("Click to register");
			uname.setBounds(05,150,150,20);
			psw.setBounds(05,180,150,20);
			usn.setBounds(05,210,150,20);
			sq.setBounds(05,240,150,20);
			sa.setBounds(05,270,150,20);
			ph.setBounds(05,300,150,20);
			email.setBounds(05,330,150,20);
			colLogo.setBounds(0,0,1000,600);
			reg.setBounds(0,0,415,148);
			
			
			tuname.setBounds(190,150,150,20);	tuname.setToolTipText("Enter You're User Name");
			tpsw.setBounds(190,180,150,20);			tpsw.setToolTipText("Enter You're Password");
			tusn.setBounds(190,210,150,20);			tusn.setToolTipText("Enter You're Usn");
			tsq.setBounds(190,240,150,20);			tsq.setToolTipText("Enter You're Secret question");
			tsa.setBounds(190,270,150,20);			tsa.setToolTipText("Enter You're Secret answer");
			tph.setBounds(190,300,150,20);			tph.setToolTipText("Enter You're Phone Number");
			temail.setBounds(190,330,150,20);		temail.setToolTipText("Enter You're Enail id");
			
			submit.setBounds(05,490,100,30);
			exit.setBounds(230,490,100,30);
			
		    
		    menu1.add(menuItemN);
			menu1.add(menuItemE);
			menuBar.add(menu1);
			menu2.add(menuItemA);
			menuBar.add(menu2);
			
			
			exit.addActionListener(this);
			submit.addActionListener(this);
			menuItemN.addActionListener(this);
			menuItemA.addActionListener(this);
			menuItemE.addActionListener(this);
			
			
			c.add(psw);
			c.add(uname);
			c.add(usn);
			c.add(sq);
			c.add(sa);
			c.add(ph);
			c.add(email);
			c.add(tuname);
			c.add(tpsw);
			c.add(tusn);
			c.add(tsq);
			c.add(tsa);
			c.add(tph);
			c.add(temail);
			c.add(exit);
			c.add(submit);
			c.add(reg);
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
	

	
		if(str1.equals("Submit"))
		{
			  
			  try{
		            //out.print("Hello JSP"); //System.out.println("Hello JSP");
				  	String ausn = tusn.getText();
		            String uname = tuname.getText();
		            String pwd = tpsw.getText();
		            String sq = tsq.getText();
		            String sa = tsa.getText();
		            String ph= tph.getText();
		           // int ph = Integer.parseInt(text);
		            String email = temail.getText();
		          //  System.out.print("Uname : " + uname + " Pwd : " + pwd);
		            String url="com.mysql.jdbc.Driver";
		            String dburl="jdbc:mysql://localhost:3306/mini?autoReconnect=true&useSSL=false";
		            String uid="root";
		            String passwd="root123";
		       //     String sql = "SELECT * FROM login WHERE uname LIKE '"+
		           //     uname+"' AND pwd LIKE '"+pwd+"'";
		             Class.forName(url);
		            Connection con = DriverManager.getConnection(dburl, uid, passwd);
		           /* Statement st = con.createStatement();
		            ResultSet rs = st.executeQuery(sql);
		            
		            if(rs.next())
		            {
		                JOptionPane.showMessageDialog(null, "Valid User");
		            }
		            else
		            {
		                JOptionPane.showMessageDialog(null, "InValid User");
		            }*/
		            PreparedStatement ps=con.prepareStatement("INSERT INTO S values('"+ausn+"','"+uname+"','"+pwd+"','"+sq+"','"+sa+"','"+ph+"','"+email+"')");
				
					int status=ps.executeUpdate();
		            }catch(Exception ex)
		            {
		                System.out.print("Exception : " + ex.getMessage());
		                JOptionPane.showMessageDialog(null, "EXCEPTION");
		                    // TODO add your handling code here:
		    } 
			//ProjectLibrary.main(new String[]{});
			//frame.dispose();
		}
		if(str1.equals("Exit"))
		{
			frame.dispose();
		}
	  }
		
	public static void main(String arg[])
 	{
 		 proj p4 = new proj();
		 p4.setResizable(false);
		 

	}

}
