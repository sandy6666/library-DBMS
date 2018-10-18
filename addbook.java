package mp1;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.publisherl.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
public class addbook extends JFrame implements ActionListener
{
	static addbook frame;
	JLabel bid,bname,Author,publisher,pyear,ph,desc,qnty;
	JTextField tbid,tbname,tAuthor,tpublisher,tpyear,tph,tdesc;
	JTextField tqnty;
	Container c;
	JButton exit,delete,add,View_Book,upd;//delete;
	JOptionPane jp = new JOptionPane();
	JMenuBar menuBar,menuBar1;	
	JMenu menu1,menu2; 
	JMenuItem menuItemN,menuItemH,menuItemA,menuItemE;
	Cursor cur;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new addbook();
					frame.setSize(1000,700); 
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public addbook()
	{
		super("Book Form");
		c = getContentPane(); c.setBackground(new Color(14,58,119));
		c.setLayout(null); 
		setBounds(0,0,850,590);
		setFont(new Font("verdana",3,14));
		cur = new Cursor(Cursor.CROSSHAIR_CURSOR);
		setCursor(cur);
		JLabel head=new JLabel("BOOK");	head.setFont(new Font("Viner Hand ITC",1 ,84));
		head.setForeground(Color.WHITE);
		bname=new JLabel("Book Name"); bname.setForeground(Color.white);
		Author=new JLabel("Author"); Author.setForeground(Color.white);
		bid=new JLabel("Book id"); bid.setForeground(Color.white);
		publisher=new JLabel("Publisher"); publisher.setForeground(Color.white);
		pyear=new JLabel("Publish year"); pyear.setForeground(Color.white);
		desc=new JLabel("Describe"); desc.setForeground(Color.white);
		qnty =new JLabel("No of Copies"); qnty.setForeground(Color.white);
		
		tbname = new JTextField();		tbname.setForeground(Color.black); tbname.setBackground(Color.white);
		tbid = new JTextField();		tbid.setForeground(Color.black); tbid.setBackground(Color.white);
		tAuthor=new JTextField(); 			tAuthor.setForeground(Color.black); tAuthor.setBackground(Color.white);
		tpublisher=new JTextField(); 			tpublisher.setForeground(Color.black); tpublisher.setBackground(Color.white);
		tpyear=new JTextField(); 			tpyear.setForeground(Color.black); tpyear.setBackground(Color.white);
		tph=new JTextField(); 			tph.setForeground(Color.black); tph.setBackground(Color.white);
		tdesc=new JTextField(); 		tdesc.setForeground(Color.black); tdesc.setBackground(Color.white);
		tqnty=new JTextField();	tqnty.setForeground(Color.black); tqnty.setBackground(Color.white);
		menuBar = new JMenuBar(); 	
		menu1 = new JMenu("FILE");	menu1.setBackground(Color.white);
		menu1.setMnemonic('F');
		menu2 = new JMenu("Help"); 	
		menu2.setMnemonic('H');	menu2.setBackground(Color.white);
		
		menuItemN = new JMenuItem("NO EXTRA PRivillage",new ImageIcon("NEW.GIF")); menuItemN.setBackground(Color.white);
		menuItemN.setMnemonic('N');
		menuItemE = new JMenuItem("Back",new ImageIcon("back1.PNG")); menuItemE.setBackground(Color.white);
		menuItemE.setMnemonic('B');
		menuItemA = new JMenuItem("About LRS");
		setJMenuBar(menuBar);
		ImageIcon coll = new ImageIcon("e-reading.jpg");
		JLabel LogoColl = new JLabel(coll);
		
		ImageIcon log = new ImageIcon("libraryb.jpg");
		JLabel Coll = new JLabel(log);
        	exit = new JButton("Exit", new ImageIcon("EXIT1.png")); exit.setForeground(Color.black); 
        	add = new JButton("Save", new ImageIcon("Save.gif")); add.setForeground(Color.black); 
        	delete = new JButton("delete", new ImageIcon("delete (1).png")); delete.setForeground(Color.black);
			View_Book = new JButton("View_Book", new ImageIcon("New.gif")); View_Book.setForeground(Color.black);
			View_Book.setFont(new Font("IMPACT",0,14));
			add.setFont(new Font("IMPACT",0,14));
			delete.setFont(new Font("IMPACT",0,14));
			upd=new JButton("Update", new ImageIcon("update.gif")); upd.setForeground(Color.black);
			upd.setFont(new Font("IMPACT",0,14));
			
         	exit.setToolTipText("click to Exit from the library");	
			delete.setToolTipText("click to delete book FROM LIBRARY");	
			add.setToolTipText("click to Add book to LIBRARY");
			upd.setToolTipText("click to Update book to LIBRARY");
			View_Book.setToolTipText("click to View_Book books present in Library");
			tqnty.setToolTipText("Enter Number of copies of book");
			bname.setBounds(80,180,150,20);		bname.setFont(new Font("Impact",0,14));
			Author.setBounds(80,210,150,20);			Author.setFont(new Font("Impact",0,14));
			bid.setBounds(80,150,150,20);			bid.setFont(new Font("Impact",0,14));
			publisher.setBounds(80,240,150,20);			publisher.setFont(new Font("Impact",0,14));
			pyear.setBounds(80,270,150,20);			pyear.setFont(new Font("Impact",0,14));
			desc.setBounds(80,300,150,20);			desc.setFont(new Font("Impact",0,14));
			qnty.setBounds(80,430,150,20);			qnty.setFont(new Font("Impact",0,14));
			head.setBounds(80,30,700,90);
			tbname.setBounds(180,180,150,20);
			tAuthor.setBounds(180,210,150,20);
			tbid.setBounds(180,150,150,20);
			tpublisher.setBounds(180,240,150,20);
			tpyear.setBounds(180,270,150,20);
			tdesc.setBounds(180,300,150,60);
			tqnty.setBounds(180, 430,150,20);
			add.setBounds(10,490,100,40);
			exit.setBounds(450,490,100,40);
		    upd.setBounds(120,490,100,40);
		    View_Book.setBounds(340,490,100,40);
			delete.setBounds(230,490,100,40);
			LogoColl.setBounds(450,150,300,212);
			Coll.setBounds(0,0,1500,800);
		    menu1.add(menuItemN);
			menu1.add(menuItemE);
			menuBar.add(menu1);
			menu2.add(menuItemA);
			menuBar.add(menu2);
			
			
			exit.addActionListener(this);
			delete.addActionListener(this);
			add.addActionListener(this);
			View_Book.addActionListener(this);
			upd.addActionListener(this);
			menuItemN.addActionListener(this);
			menuItemA.addActionListener(this);
			menuItemE.addActionListener(this);
			
			
			c.add(Author);
			c.add(bname);
			c.add(bid);
			c.add(publisher);
			c.add(pyear);
			c.add(desc);
			c.add(tbname);
			c.add(tAuthor);
			c.add(tbid);
			c.add(tpublisher);
			c.add(tpyear);
			c.add(tdesc);
			c.add(exit);
			c.add(add);
			c.add(delete);
			c.add(View_Book);
			c.add(upd);
			c.add(qnty);
			c.add(tqnty);
			c.add(LogoColl);
			c.add(head);
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
	
		if(source==menuItemE)
		{
			admin.main(new String[]{});
			frame.dispose();
		}
		if(str1.equals("delete"))
		{
			  System.out.println("\nOK....");
			  try{
		            //out.print("Hello JSP"); //System.out.println("Hello JSP");
				  	String abid = tbid.getText();
		            String bname = tbname.getText();
		            String author = tAuthor.getText();
		            String publisher = tpublisher.getText();
		            String pyear = tpyear.getText();
		            String des = tdesc.getText();
		        
		            String url="com.mysql.jdbc.Driver";
		            String dburl="jdbc:mysql://localhost:3306/mini?autoReconnect=true&useSSL=false";
		            String uid="root";
		            String passwd="root123";
		     
		             Class.forName(url);
		            Connection con = DriverManager.getConnection(dburl, uid, passwd);
		          
		            PreparedStatement as=con.prepareStatement("delete from copies where bid='"+abid+"'");
		            PreparedStatement ps=con.prepareStatement("delete from book where bid='"+abid+"' and bname='"+bname+"' and author='"+author+"' and publisher='"+publisher+"' and pyear='"+pyear+"' and des='"+des+"'");
		            	
		            int status1=as.executeUpdate();
					int status=ps.executeUpdate();
		            }catch(Exception ex)
		            {
		                System.out.print("Exception : " + ex.getMessage());
		                JOptionPane.showMessageDialog(null, "EXCEPTION");
		                   
		            } 
			  
			try {
				String abid = tbid.getText();
				int no=Integer.parseInt(tqnty.getText());
				System.out.println("\n"+no);
				
				
			}catch(Exception ex)
            {
                System.out.print("Exception : " + ex.getMessage());
                JOptionPane.showMessageDialog(null, "EXCEPTION");
            } 
		}
		if(str1.equals("Update"))
		{
			 System.out.println("\nOK....");
			  try{
		          
				  	String abid = tbid.getText();
		            String bname = tbname.getText();
		            String author = tAuthor.getText();
		            String publisher = tpublisher.getText();
		            String pyear = tpyear.getText();
		            String des = tdesc.getText();
		            int no=Integer.parseInt(tqnty.getText());
		      
		            String url="com.mysql.jdbc.Driver";
		            String dburl="jdbc:mysql://localhost:3306/mini?autoReconnect=true&useSSL=false";
		            String uid="root";
		            String passwd="root123";
		            System.out.println(""+no);
		    
		             Class.forName(url);
		            Connection con = DriverManager.getConnection(dburl, uid, passwd);
		      
		            PreparedStatement ps=con.prepareStatement("update copies set copy="+no+" where bid='"+abid+"'");
		            PreparedStatement as=con.prepareStatement("update book set bname='"+bname+"',author='"+author+"',publisher='"+publisher+"',pyear='"+pyear+"',des='"+des+"' where bid='"+abid+"'");
					int status=ps.executeUpdate();
					int status1=as.executeUpdate();
					JOptionPane.showMessageDialog(null, "Updated Successfully");
		            }catch(Exception ex)
		            {
		                System.out.print("Exception : " + ex.getMessage());
		                JOptionPane.showMessageDialog(null, "EXCEPTION");
		                    
		    } 
		}
		if(str1.equals("Save"))
		{
			  System.out.println("\nOK....");
			  try{
		           
				  	String abid = tbid.getText();
		            String bname = tbname.getText();
		            String author = tAuthor.getText();
		            String publisher = tpublisher.getText();
		            String pyear = tpyear.getText();
		            String des = tdesc.getText();
		            int no=Integer.parseInt(tqnty.getText());
		            String url="com.mysql.jdbc.Driver";
		            String dburl="jdbc:mysql://localhost:3306/mini?autoReconnect=true&useSSL=false";
		            String uid="root";
		            String passwd="root123";
		            Class.forName(url);
		            Connection con = DriverManager.getConnection(dburl, uid, passwd); 
		            PreparedStatement ps=con.prepareStatement("INSERT INTO book values('"+abid+"','"+bname+"','"+author+"','"+publisher+"','"+pyear+"','"+des+"')");
		            PreparedStatement as=con.prepareStatement("INSERT INTO copies values('"+abid+"',"+no+")");
					int status=ps.executeUpdate();
					int status1=as.executeUpdate();
		            }catch(Exception ex)
		            {
		                System.out.print("Exception : " + ex.getMessage());
		                JOptionPane.showMessageDialog(null, "EXCEPTION"); 
		    } 
		}
		if(str1.equals("Exit"))
		{	
		
			frame.dispose();
		}
		if(str1.equals("View_Book"))
		{
			view.main(new String[]{});
		}
		
	}
		
	public static void main(String arg[])
 	{
 		 addbook p4 = new addbook();
		 p4.setResizable(false);
		 

	}

}
