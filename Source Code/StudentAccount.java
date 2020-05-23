import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
public class StudentAccount extends JFrame implements ActionListener {

		JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20;
		JTextField ltf1,ltf2,ltf3,ltf4,ltf5,ltf6,ltf7,ltf8,ltf9,ltf10,ltf11,ltf12,ltf13,ltf14,ltf15,ltf16,ltf17,ltf18,ltf19,ltf20;
		JButton submit,reset,delete,getstudent;
		String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20;
		Connection con;
		PreparedStatement stm;
		Statement stm2;
		ResultSet rs2 ;
		java.time.LocalDateTime now = java.time.LocalDateTime.now();  
		java.time.format.DateTimeFormatter format = java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy");  
        	String is = now.format(format); 
		String username = "System";
		String password = "System";
		String dl="";
		StudentAccount obj;
		int pass9;
		public StudentAccount(){
			
			obj= this;
			Container container = getContentPane();
			setTitle("INSTITUTE MANAGEMENT SYSTEM");
			setIconImage(new ImageIcon("logo.png").getImage());
			setLayout(new BorderLayout());
			JPanel panel = new JPanel();
			panel.setLayout(null);
			JPanel panel2 = new JPanel();
			JPanel panel3 = new JPanel();
			panel.setLayout(null);
			panel2.setLayout(null);
			panel3.setLayout(null);
			panel2.setBounds(20,80,780,350);
			panel2.setBorder(new TitledBorder(new LineBorder(Color.green, 5),"Fill Details",0,0,new Font("Segoe Script",Font.BOLD,10),Color.red));
			
			panel2.setBackground(Color.white);

			//Label

			JLabel toplabel = new JLabel("Pay Fees");
			Font font = new Font("Rosewood Std",Font.BOLD,33);
			toplabel.setFont(font);
			toplabel.setBounds(280,20,300,40);
			panel.add(toplabel);

			l1 = new JLabel("Student ID:");
			l1.setBounds(200,60,100,20);
			l2 = new JLabel("First Name:");
			l2.setBounds(200,90,100,20);
			l3 = new JLabel("Last Name:");
			l3.setBounds(200,120,100,20);
			l4 = new JLabel("Course:");
			l4.setBounds(200,150,100,20);
			l5 = new JLabel("Date of pay:");
			l5.setBounds(200,180,100,20);
			l6 = new JLabel("Mode of pay:");
			l6.setBounds(200,210,100,20);
			l7 = new JLabel("Amount:");
			l7.setBounds(200,240,100,20);
			

			panel2.add(l1);
			panel2.add(l2);
			panel2.add(l3);
			panel2.add(l4);
			panel2.add(l5);
			panel2.add(l6);
			panel2.add(l7);
			
		
			

			//TextFields 
			ltf1 = new JTextField();
			ltf1.setBounds(400,60,150,20);
			
			ltf2 = new JTextField();
			ltf2.setBounds(400,90,150,20);
			ltf3 = new JTextField();
			ltf3.setBounds(400,120,150,20);
			ltf4 = new JTextField();
			ltf4.setBounds(400,150,150,20);
			ltf5 = new JTextField();
			ltf5.setBounds(400,180,150,20);
			ltf6 = new JTextField();
			ltf6.setBounds(400,210,150,20);
			ltf7 = new JTextField();
			ltf7.setBounds(400,240,150,20);
			ltf5.setText(is);
			ltf1.setEditable(false);
			ltf2.setEditable(false);
			ltf3.setEditable(false);
			ltf4.setEditable(false);
			ltf5.setEditable(false);
			
			panel2.add(ltf1);
			panel2.add(ltf2);			
			panel2.add(ltf3);
			panel2.add(ltf4);
			panel2.add(ltf5);
			panel2.add(ltf6);
			panel2.add(ltf7);
			
			
			submit = new JButton("Submit",new ImageIcon("images/add.png"));
			submit.setBounds(200,450,110,30);
			reset = new JButton("Reset",new ImageIcon("images/clear.png"));
			reset.setBounds(340,450,110,30);
			getstudent = new JButton("Get Details",new ImageIcon("images/add1.png"));
			getstudent.addActionListener(new SearchEvent1());
			getstudent.setBounds(480,450,130,30);
			delete = new JButton("Delete",new ImageIcon("images/de.png"));
			delete.addActionListener(new DeleteEvent1());
			delete.setBounds(630,450,120,30);

			submit.addActionListener(this);
			reset.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					ltf1.setText("");
					ltf2.setText("");
					ltf3.setText("");
					ltf4.setText("");
					ltf5.setText(is);
					ltf6.setText("");
					ltf7.setText("");
					
				
				}
			

			});
			
			
			
			JLabel limg2 = new JLabel(new ImageIcon("images/4.png"));
			limg2.setBounds(30,5,75,75);
			panel.add(limg2);
			
			
			panel.add(panel2);
			panel.add(submit);
			panel.add(reset);
			panel.add(getstudent);
			panel.add(delete);
			
			add(BorderLayout.CENTER,panel);
			setSize(830,600);
			setLocationRelativeTo(null);
			setVisible(true);
		}


	public void actionPerformed(ActionEvent e){
		pass9=0;
		s1 = ltf1.getText();
		s2 = ltf2.getText();
		s3 = ltf3.getText();
		s4 = ltf4.getText();
		s5 = ltf5.getText();
		s6 = ltf6.getText();
		s7 = ltf7.getText();
		
		if(e.getSource()==submit){
			
			if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty()||s5.isEmpty()||s6.isEmpty()||s7.isEmpty() ){
					JOptionPane.showMessageDialog(this,"Some Textfields is empty","Error",JOptionPane.ERROR_MESSAGE); 
			}else{ 

					 String i2=ltf7.getText();
					
					for(int y2=0;y2<i2.length(); ++y2)
					{
						
						if(!Character.isDigit(i2.charAt(y2)))
						{  pass9=7;   }
					}		

				if(pass9==0)
						{




				try        { 		Class.forName("oracle.jdbc.driver.OracleDriver");
							con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
							stm =  con.prepareStatement("insert  into saccount values(?,?,?,?,?,?,?)");
			                		stm.setString(1,s1);
							stm.setString(2,s2);
							stm.setString(3,s3);	
							stm.setString(4,s4);
							stm.setString(5,s5);
							stm.setString(6,s6);
							stm.setString(7,s7);
							stm.executeUpdate();
							JOptionPane.showMessageDialog(this,"Pay Successful","Success",JOptionPane.INFORMATION_MESSAGE);
							ltf1.setText("");	
				 			ltf2.setText("");
							ltf3.setText("");
							ltf4.setText("");
							ltf5.setText(is);
							ltf6.setText("");
							ltf7.setText("");
							

							
							con.close();

							}
						catch(Exception ee){JOptionPane.showMessageDialog(this,ee,"error",JOptionPane.ERROR_MESSAGE);}	
				}
							else{ JOptionPane.showMessageDialog(this,"Invalid amount","Error",JOptionPane.ERROR_MESSAGE);}					
						       
					


			}
			
			

		}
	}




	private class DeleteEvent1 implements ActionListener {
			public void actionPerformed(ActionEvent e){
					if(e.getSource()==delete){
						int de=0;
						dl=JOptionPane.showInputDialog(obj,"Enter Student ID");
						if(!dl.isEmpty()){
								try{ 	Class.forName("oracle.jdbc.driver.OracleDriver");
			                               			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
									stm2=con.createStatement();
									rs2=stm2.executeQuery("Select id1 from saccount");
									while (rs2.next())
									{
										if(dl.equals(rs2.getString(1)))
										{
											de=1; 
											break;
										}
									} 
									con.close();
								}catch(Exception ep){}
							if(de==1){ 

								try{	
					
									Class.forName("oracle.jdbc.driver.OracleDriver");
									Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
      									String query = "delete from saccount where id1 = ?";
      									PreparedStatement preparedStmt = conn.prepareStatement(query);
      									preparedStmt.setString(1, dl);
      									preparedStmt.execute();
									JOptionPane.showMessageDialog(obj,"Delete Successful","Success",JOptionPane.INFORMATION_MESSAGE);
      									conn.close();
									
					
				          			    }catch(Exception p){JOptionPane.showMessageDialog(obj,p,"Error",JOptionPane.ERROR_MESSAGE);}


							}else{  JOptionPane.showMessageDialog(obj,"Data not found","Error",JOptionPane.ERROR_MESSAGE);}


						}else{ JOptionPane.showMessageDialog(obj,"Textfield is empty","Error",JOptionPane.ERROR_MESSAGE);}
					
					}
			}
			
	
	}



		




	private class SearchEvent1 implements ActionListener {
			public void actionPerformed(ActionEvent e){
					if(e.getSource()==getstudent){
						int de=0;
						dl=JOptionPane.showInputDialog(obj,"Enter Student ID");
						if(!dl.isEmpty()){
								try{ 	Class.forName("oracle.jdbc.driver.OracleDriver");
			                               			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
									stm2=con.createStatement();
									rs2=stm2.executeQuery("Select id1 from vstudent");
									while (rs2.next())
									{
										if(dl.equals(rs2.getString(1)))
										{
											de=1; 
											break;
										}
									} 
									con.close();
								}catch(Exception ep){}
							if(de==1){ 

								try{	
					
									Class.forName("oracle.jdbc.driver.OracleDriver");
									con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
									stm2=con.createStatement();
									rs2= stm2.executeQuery("SELECT  *  FROM vstudent WHERE id1="+dl+" ");
						
									while(rs2.next())
									{
					
									ltf1.setText(rs2.getString(1));
									ltf2.setText(rs2.getString(2));
									ltf3.setText(rs2.getString(3));
									
									ltf4.setText(rs2.getString(9));
									
									
									
									}
									con.close();
					
				          			    }catch(Exception p){JOptionPane.showMessageDialog(obj,p,"Error",JOptionPane.ERROR_MESSAGE);}


							}else{  JOptionPane.showMessageDialog(obj,"Data not found","Error",JOptionPane.ERROR_MESSAGE);}


						}else{ JOptionPane.showMessageDialog(obj,"Textfield is empty","Error",JOptionPane.ERROR_MESSAGE);}
					
					}
			}
			
	
	}

	public static void main(String [] args){
		
		new StudentAccount();
	}

}