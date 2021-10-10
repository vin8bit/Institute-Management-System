import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
public class Admission extends JFrame implements ActionListener {

		JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20;
		JTextField ltf1,ltf2,ltf3,ltf4,ltf6,ltf7,ltf8,ltf9,ltf10,ltf11,ltf12,ltf13,ltf14,ltf15,ltf16,ltf17,ltf18,ltf19,ltf20;
		JTextArea ltf5;
		JButton submit,reset;
		String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20;
		java.time.LocalDateTime now = java.time.LocalDateTime.now();  
		java.time.format.DateTimeFormatter format = java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy");  
        	String is = now.format(format); 
		Connection con;
		Statement stm2;
		ResultSet rs2 ;
		PreparedStatement stm;
		String username = "System";
		String password = "System";
		JRadioButton box1,box2,box3;
		Choice choice3,choice4,choice5;
		ButtonGroup group;
		int pass9,ph,ph2,ph3,ch1;
		public Admission(){
			Container container = getContentPane();
			setLayout(new BorderLayout());
			setTitle("INSTITUTE MANAGEMENT SYSTEM");
			setIconImage(new ImageIcon("logo.png").getImage());
			JPanel panel = new JPanel();
			JPanel panel2 = new JPanel();
			JPanel panel3 = new JPanel();
			panel.setLayout(null);
			
			panel.setBackground(new Color(0,162,232));
			panel2.setBackground(new Color(192,192,192));
			panel2.setLayout(null);
			panel3.setLayout(null);
			panel2.setBounds(20,80,780,400);
			panel2.setBorder(new TitledBorder(new LineBorder(Color.orange, 5),"Fill Details",0,0,new Font("Segoe Script",Font.BOLD,10),Color.red));

			//Label

			JLabel toplabel = new JLabel("Admission form");
			Font font = new Font("Lucida Handwriting",Font.BOLD,26);
			toplabel.setFont(font);
			toplabel.setBounds(300,20,300,40);
			panel.add(toplabel);

			l1 = new JLabel("Student ID:");
			l1.setBounds(20,60,100,20);
			l2 = new JLabel("First Name:");
			l2.setBounds(20,90,100,20);
			l3 = new JLabel("Last Name:");
			l3.setBounds(20,120,100,20);
			l4 = new JLabel("Father Name:");
			l4.setBounds(20,150,100,20);
			l5 = new JLabel("Address:");
			l5.setBounds(20,180,100,20);

			l6 = new JLabel("Gender:");
			l6.setBounds(20,240,100,20);
			l7 = new JLabel("Date of Birth:");
			l7.setBounds(20,270,100,20);
			l8 = new JLabel("Date of Join:");
			l8.setBounds(20,300,100,20);
			l9 = new JLabel("Course:");
			l9.setBounds(20,330,100,20);
			l10 = new JLabel("Phone no:");
			l10.setBounds(20,360,100,20);
			l11 = new JLabel("Email:");
			l11.setBounds(430,60,100,20);
			l12 = new JLabel("Caste:");
			l12.setBounds(430,90,100,20);
			l13 = new JLabel("Religion:");
			l13.setBounds(430,120,100,20);
			l14 = new JLabel("Nationality:");
			l14.setBounds(430,150,100,20);
			l15 = new JLabel("Identification mark : ");
			l15.setBounds(430,180,130,20);
			l16 = new JLabel("Password:");
			l16.setBounds(430,210,100,20);
		
			group = new ButtonGroup();
		box1 = new JRadioButton("Male");
		box1.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e)
	{	if(e.getItemSelectable()==box1){ ltf6.setText("Male"); }
	} });
		box1.setBounds(200,240,60,10);
		panel2.add(box1);
		box2 = new JRadioButton("Female");
		box2.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e)
	{	if(e.getItemSelectable()==box2){ ltf6.setText("Female"); }
	} });
		box2.setBounds(260,240,80,10);
		group.add(box1);
		group.add(box2);
		panel2.add(box2);
		box1.setBackground(new Color(192,192,192));box2.setBackground(new Color(192,192,192));

			panel2.add(l1);
			panel2.add(l2);
			panel2.add(l3);
			panel2.add(l4);
			panel2.add(l5);
			panel2.add(l6);
			panel2.add(l7);
			panel2.add(l8);
			panel2.add(l9);
			panel2.add(l10);
			panel2.add(l11);
			panel2.add(l12);
			panel2.add(l13);
			panel2.add(l14);
			panel2.add(l15);
			panel2.add(l16);
			
		
			

			//TextFields 
			ltf1 = new JTextField();
			ltf1.setBounds(200,60,150,20);
			ltf2 = new JTextField();
			ltf2.setBounds(200,90,150,20);
				


			ltf3 = new JTextField();
			ltf3.setBounds(200,120,150,20);
			ltf4 = new JTextField();
			ltf4.setBounds(200,150,150,20);
			//ltf5 = new JTextField();
			//ltf5.setBounds(200,180,150,20);

			ltf5 = new JTextArea();
			JScrollPane jscroll = new JScrollPane(ltf5,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
			jscroll.setBounds(200,180,200,50);
	

			ltf6 = new JTextField();
			ltf6.setBounds(200,240,150,20);
			ltf7 = new JTextField();
			ltf7.setBounds(200,270,150,20);
			JLabel birth = new JLabel("DD-MM-YYYY");
			birth.setBounds(380,270,150,20);
			panel2.add(birth);
			ltf8 = new JTextField();
			ltf8.setBounds(200,300,150,20);
			ltf9 = new JTextField();
			ltf9.setBounds(200,330,150,20);
					


			ltf10 = new JTextField();
			ltf10.setBounds(200,360,150,20);
			JLabel only10 = new JLabel("Only 10 Digits");
			only10.setBounds(380,360,150,20);
			panel2.add(only10);
			ltf11 = new JTextField();
			ltf11.setBounds(590,60,150,20);
			ltf12 = new JTextField();
			//ltf12.setBounds(590,90,150,20);


		choice3=new  Choice();
		choice3.addItem("");
		choice3.addItem("Genral");
		choice3.addItem("OBC");
		choice3.addItem("SC");
		choice3.addItem("ST");
		choice3.addItem("Other");
		choice3.addItemListener(new ItemListener()
				{
					public void itemStateChanged(ItemEvent v)
					{
						ltf12.setText((String)choice3.getSelectedItem());
					}
				});
		choice3.setBounds(590,90,150,20);
		panel2.add(choice3);

			ltf13 = new JTextField();
			ltf13.setBounds(590,120,150,20);
			ltf14 = new JTextField();
			ltf14.setBounds(590,150,150,20);
			ltf15 = new JTextField();
			ltf15.setBounds(590,180,150,20);
			ltf16 = new JTextField();
			ltf16.setBounds(590,210,150,20);
				


			panel2.add(ltf1);
			panel2.add(ltf2);			
			panel2.add(ltf3);
			panel2.add(ltf4);
			panel2.add(jscroll);
			//panel2.add(ltf6);
			panel2.add(ltf7);
			panel2.add(ltf8);
			panel2.add(ltf9);
			panel2.add(ltf10);
			panel2.add(ltf11);
			panel2.add(ltf12);
			panel2.add(ltf13);
			panel2.add(ltf14);
			panel2.add(ltf15);
			panel2.add(ltf16);
			//panel2.add(ltf17);
			ltf8.setText(is);
		
			
			submit = new JButton("Submit",new ImageIcon("images/add.png"));
			submit.setBounds(250,520,110,30);
			reset = new JButton("Reset",new ImageIcon("images/clear.png"));
			reset.setBounds(450,520,110,30);

			submit.addActionListener(this);
			reset.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					ltf1.setText("");
					ltf2.setText("");
					ltf3.setText("");
					ltf4.setText("");
					ltf5.setText("");
					ltf6.setText("Male");
					ltf7.setText("");
					//ltf8.setText("");
					ltf8.setText(is);
					ltf9.setText("");
					ltf10.setText("");
					ltf11.setText("");
					ltf12.setText("");
					ltf13.setText("");
					ltf14.setText("");
					ltf15.setText("");
					ltf16.setText("");
					
					
					choice3.select(0);
					box1.setSelected(true);
							box2.setSelected(false);
				
				}
			

			});

			
			JLabel limg = new JLabel(new ImageIcon("images/1.png"));
			limg.setBounds(450,230,280,180);
			Font font2=new Font("Rosewood Std",Font.ITALIC,35);
			toplabel.setFont(font2);
			toplabel.setForeground(Color.green);
			
			JLabel limg2 = new JLabel(new ImageIcon("images/2.png"));
			limg2.setBounds(30,5,75,75);
			panel.add(limg2);
			panel2.add(limg);
			
			
			panel.add(panel2);
			panel.add(submit);
			panel.add(reset);
			add(BorderLayout.CENTER,panel);
			setSize(830,650);
			setLocationRelativeTo(null);
			setVisible(true);
		}


	public void actionPerformed(ActionEvent e){
		ph=0; ph2=0; ph3=0; ch1=0; 
		s1 = ltf1.getText();
		s2 = ltf2.getText();
		s3 = ltf3.getText();
		s4 = ltf4.getText();
		s5 = ltf5.getText();
		s6 = ltf6.getText();
		s7 = ltf7.getText();
		s8 = ltf8.getText();
		s9 = ltf9.getText();
		s10 = ltf10.getText();
		s11 = ltf11.getText();
		s12 = ltf12.getText();
		s13 = ltf13.getText();
		s14 = ltf14.getText();
		s15 = ltf15.getText();
		s16 = ltf16.getText();
		if(e.getSource()==submit){
			
			if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty()||s5.isEmpty()||s6.isEmpty()||s7.isEmpty()||s8.isEmpty()||s9.isEmpty()||s10.isEmpty()||s11.isEmpty()||s12.isEmpty()||s13.isEmpty()||s14.isEmpty()||s15.isEmpty()||s16.isEmpty() ){
					JOptionPane.showMessageDialog(this,"Some fields is empty","Error",JOptionPane.ERROR_MESSAGE); 
			}else{ 
				try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
			                               		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
						stm2=con.createStatement();
						rs2=stm2.executeQuery("Select * from vstudent");
							while (rs2.next())
							{
								if(s1.equals(rs2.getString(1)))
								{
									ch1=1; 
									break;
								}
							} 
			
						      } catch(Exception e3){}				
						
						pass9=0;
					   String i = ltf10.getText();
					
					   String i2=ltf1.getText();
					for(int y=0;y<i.length(); ++y)
					{
						 if(i.length()<=9){ pass9=7; ph=1; }
						if(!Character.isDigit(i.charAt(y)))
							{  pass9=7; ph=1;  }
						if(i.length()>10)
							{ pass9=7; ph=1;  }
					}
					
					for(int y2=0;y2<i2.length(); ++y2)
					{
						
						if(!Character.isDigit(i2.charAt(y2)))
						{  pass9=7;  ph3=1; }
					}
					

					if(ch1==0){	
						if(pass9==0)
						{



				try        { 		Class.forName("oracle.jdbc.driver.OracleDriver");
							con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
							stm =  con.prepareStatement("insert into vstudent values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			                		stm.setString(1,s1);
							stm.setString(2,s2);
							stm.setString(3,s3);	
							stm.setString(4,s4);
							stm.setString(5,s5);
							stm.setString(6,s6);
							stm.setString(7,s7);
							stm.setString(8,s8);
							stm.setString(9,s9);
							stm.setString(10,s10);	
							stm.setString(11,s11);
							stm.setString(12,s12);
							stm.setString(13,s13);
							stm.setString(14,s14);
							stm.setString(15,s15);
							stm.setString(16,s16);
							stm.executeUpdate();
							JOptionPane.showMessageDialog(this,"Submit Successful","Success",JOptionPane.INFORMATION_MESSAGE);
							ltf1.setText("");	
				 			ltf2.setText("");
							ltf3.setText("");
							ltf4.setText("");
							ltf5.setText("");
							ltf6.setText("Male");
							ltf7.setText("");
							ltf8.setText("");	
				 			ltf9.setText("");
							ltf10.setText("");
							ltf11.setText("");
							ltf12.setText("");
							ltf13.setText("");
							ltf14.setText("");
							ltf15.setText("");
							ltf16.setText("");
							
							box1.setSelected(true);
							box2.setSelected(false);
							
							
							choice3.select(0);
							

							
							con.close();

							}
						catch(Exception ee){JOptionPane.showMessageDialog(this,ee,"error",JOptionPane.ERROR_MESSAGE);}
							}
						else { 
								if(ph==1){JOptionPane.showMessageDialog(this,"Invalid Phone No","Error",JOptionPane.ERROR_MESSAGE);} 
								if(ph3==1){JOptionPane.showMessageDialog(this,"Student ID only number accepted","Error",JOptionPane.ERROR_MESSAGE);}
								} 						
							}
							else{ if(ch1==1){JOptionPane.showMessageDialog(this,"Student ID already added","Error",JOptionPane.ERROR_MESSAGE);}}						
						       
					


			}
			
			

		}
	}

	public static void main(String [] args){
		
		new Admission();
	}

}
