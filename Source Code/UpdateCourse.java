import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
public class UpdateCourse extends JFrame implements ActionListener {

		JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20;
		JTextField ltf1,ltf2,ltf3,ltf4,ltf5,ltf6,ltf7,ltf8,ltf9,ltf10,ltf11,ltf12,ltf13,ltf14,ltf15,ltf16,ltf17,ltf18,ltf19,ltf20;
		JButton submit,reset,delete,getstudent;
		String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20;
		Connection con;
		PreparedStatement stm;
		Statement stm2;
		ResultSet rs2 ;
		String username = "System";
		String password = "System";
		String dl="";
		UpdateCourse obj;
		public UpdateCourse(){
			
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
			panel2.setBounds(20,80,780,250);
			panel2.setBorder(new TitledBorder(new LineBorder(Color.green, 5),"Fill Details",0,0,new Font("Segoe Script",Font.BOLD,10),Color.red));
			panel.setBackground(new Color(0,162,232));
			panel2.setBackground(new Color(192,192,192));


			//Label

			JLabel toplabel = new JLabel("Edit Course form");
			Font font = new Font("Rosewood Std",Font.BOLD,33);
			toplabel.setFont(font);
			toplabel.setBounds(280,20,300,40);
			panel.add(toplabel);

			l1 = new JLabel("Course ID:");
			l1.setBounds(200,60,100,20);
			l2 = new JLabel("Course Code:");
			l2.setBounds(200,90,100,20);
			l3 = new JLabel("Course Name:");
			l3.setBounds(200,120,100,20);
			l4 = new JLabel("Course fee:");
			l4.setBounds(200,150,100,20);
			l5 = new JLabel("Course Duration:");
			l5.setBounds(200,180,100,20);
			
			panel2.add(l1);
			panel2.add(l2);
			panel2.add(l3);
			panel2.add(l4);
			panel2.add(l5);
			
			//TextFields 
			ltf1 = new JTextField();
			ltf1.setBounds(400,60,150,20);
			ltf1.setEditable(false);
			ltf2 = new JTextField();
			ltf2.setBounds(400,90,150,20);
			ltf3 = new JTextField();
			ltf3.setBounds(400,120,150,20);
			ltf4 = new JTextField();
			ltf4.setBounds(400,150,150,20);
			ltf5 = new JTextField();
			ltf5.setBounds(400,180,150,20);
			panel2.add(ltf1);
			panel2.add(ltf2);			
			panel2.add(ltf3);
			panel2.add(ltf4);
			panel2.add(ltf5);
			
			submit = new JButton("Update",new ImageIcon("images/add.png"));
			submit.setBounds(200,350,110,30);
			reset = new JButton("Reset",new ImageIcon("images/clear.png"));
			reset.setBounds(340,350,110,30);
			getstudent = new JButton("Get Details",new ImageIcon("images/add1.png"));
			getstudent.addActionListener(new SearchEvent1());
			getstudent.setBounds(480,350,130,30);
			delete = new JButton("Delete",new ImageIcon("images/de.png"));
			delete.addActionListener(new DeleteEvent1());
			delete.setBounds(630,350,120,30);

			submit.addActionListener(this);
			reset.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					ltf1.setText("");
					ltf2.setText("");
					ltf3.setText("");
					ltf4.setText("");
					ltf5.setText("");
									}
			

			});
			JLabel limg3 = new JLabel(new ImageIcon("images/9.png"));
			limg3.setBounds(0,30,210,180);
			JLabel limg = new JLabel(new ImageIcon("images/7.png"));
			limg.setBounds(530,30,280,180);
			
			Font font2=new Font("Rosewood Std",Font.ITALIC,35);
			toplabel.setFont(font2);
			toplabel.setForeground(Color.green);
			
			JLabel limg2 = new JLabel(new ImageIcon("images/8.png"));
			limg2.setBounds(30,5,75,75);
			panel.add(limg2);
			panel2.add(limg);
			panel2.add(limg3);
			
			panel.add(panel2);
			panel.add(submit);
			panel.add(reset);
			panel.add(getstudent);
			panel.add(delete);

			add(BorderLayout.CENTER,panel);
			setSize(830,450);
			setLocationRelativeTo(null);
			setVisible(true);
		}


	public void actionPerformed(ActionEvent e){
		
		s1 = ltf1.getText();
		s2 = ltf2.getText();
		s3 = ltf3.getText();
		s4 = ltf4.getText();
		s5 = ltf5.getText();
		if(e.getSource()==submit){
			
			if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty()||s5.isEmpty() ){
					JOptionPane.showMessageDialog(this,"Some Textfields is empty","Error",JOptionPane.ERROR_MESSAGE); 
			}else{ 

						try{
							Class.forName("oracle.jdbc.driver.OracleDriver");
							Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
      							String query = "delete from vcourse where id1 = ?";
      							PreparedStatement preparedStmt = conn.prepareStatement(query);
      							preparedStmt.setString(1, s1);
      							preparedStmt.execute();
      							conn.close();
				   			} catch(Exception r){}
			




				try        { 		Class.forName("oracle.jdbc.driver.OracleDriver");
							con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
							stm =  con.prepareStatement("insert into vcourse values(?,?,?,?,?)");
			                		stm.setString(1,s1);
							stm.setString(2,s2);
							stm.setString(3,s3);	
							stm.setString(4,s4);
							stm.setString(5,s5);
							stm.executeUpdate();
							JOptionPane.showMessageDialog(this,"Update Successful","Success",JOptionPane.INFORMATION_MESSAGE);
							ltf1.setText("");	
				 			ltf2.setText("");
							ltf3.setText("");
							ltf4.setText("");
							ltf5.setText("");
							
							
							con.close();

							}
						catch(Exception ee){JOptionPane.showMessageDialog(this,ee,"error",JOptionPane.ERROR_MESSAGE);}						
						       
					


			}
			
			

		}
	}




	private class DeleteEvent1 implements ActionListener {
			public void actionPerformed(ActionEvent e){
					if(e.getSource()==delete){
						int de=0;
						dl=JOptionPane.showInputDialog(obj,"Enter Course ID");
						if(!dl.isEmpty()){
								try{ 	Class.forName("oracle.jdbc.driver.OracleDriver");
			                               			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
									stm2=con.createStatement();
									rs2=stm2.executeQuery("Select id1 from vcourse");
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
      									String query = "delete from vcourse where id1 = ?";
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
						dl=JOptionPane.showInputDialog(obj,"Enter Course ID");
						if(!dl.isEmpty()){
								try{ 	Class.forName("oracle.jdbc.driver.OracleDriver");
			                               			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
									stm2=con.createStatement();
									rs2=stm2.executeQuery("Select id1 from vcourse");
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
									rs2= stm2.executeQuery("SELECT  *  FROM vcourse WHERE id1="+dl+" ");
						
									while(rs2.next())
									{
					
									ltf1.setText(rs2.getString(1));
									ltf2.setText(rs2.getString(2));
									ltf3.setText(rs2.getString(3));
									ltf4.setText(rs2.getString(4));
									ltf5.setText(rs2.getString(5));
									
									
									}
									con.close();
					
				          			    }catch(Exception p){JOptionPane.showMessageDialog(obj,p,"Error",JOptionPane.ERROR_MESSAGE);}


							}else{  JOptionPane.showMessageDialog(obj,"Data not found","Error",JOptionPane.ERROR_MESSAGE);}


						}else{ JOptionPane.showMessageDialog(obj,"Textfield is empty","Error",JOptionPane.ERROR_MESSAGE);}
					
					}
			}
			
	
	}

	public static void main(String [] args){
		
		new UpdateCourse();
	}

}