import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.regex.*;
import java.sql.*;

public class SalaryRecord extends JFrame implements ActionListener
{
	JTextField tf1;
	JButton b1,b2;
	String columns[]={"Staff ID","First Name","Last Name","Date","Amount"};
	TableModel tmodel;
	JTable jtable;
	TableRowSorter<TableModel> rsorter;
	
	int z1,z2,z3,z4,z5,z6,z7,z8,z9,z10,z11,z12,z13,z14,z15,z16;
	Connection con;
	Statement stm;
	String username="system";
	String password="system";
	Count1 count=new Count1();
	int g=count.call5();
	Object array[][] = new Object[g][5];
	
	ResultSet rs;
	public SalaryRecord()
	{
	
		
			
		try
			{
			
	
			 Class.forName("oracle.jdbc.driver.OracleDriver");
		            	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
			stm= con.createStatement(); 
			rs= stm.executeQuery("SELECT *  FROM vsalary ");	
			
			while(rs.next())
			{   
				array[z1++][0]=rs.getObject(1);
				array[z2++][1]=rs.getObject(2);
				array[z3++][2]=rs.getObject(3);
				array[z4++][3]=rs.getObject(4);
				array[z5++][4]=rs.getObject(5);
				

				
				
			}      
			con.close();	
				
			}
		catch(Exception e)
		{   	JOptionPane.showMessageDialog(this,e,"Success",JOptionPane.INFORMATION_MESSAGE);
			 } 



		setTitle("INSTITUTE MANAGEMENT SYSTEM");
			setIconImage(new ImageIcon("logo.png").getImage());
		setSize(830,550);
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		
		p1.setBackground(new Color(128,0,255));
		add(p1,BorderLayout.EAST);
		p2.setBackground(new Color(128,0,255));
		add(p2,BorderLayout.NORTH);
		
				
		JLabel l1=new JLabel("Salary Record");
		Font font=new Font("French Script MT",Font.BOLD,25);
		l1.setFont(font);
		p2.add(l1);
		tf1= new JTextField(10);
		p1.add(tf1);		
		b1= new JButton("Search",new ImageIcon("images/se.png"));
		b1.addActionListener(this);
		p1.add(b1);
		tmodel= new DefaultTableModel(array,columns);
		jtable=new JTable(tmodel);
		rsorter = new TableRowSorter<TableModel>(tmodel);
		JScrollPane jspane=new JScrollPane(jtable);
		jtable.setRowSorter(rsorter);
		add(jspane,BorderLayout.CENTER);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent er)
		{
			if(er.getSource()==b1)
				{ 
				String text=tf1.getText();
					if(text.length()==0)
					{     rsorter.setRowFilter(null);  }
					rsorter.setRowFilter(RowFilter.regexFilter(text));
				}
				

		}

public static void main(String []args) throws Exception
	{ new SalaryRecord(); }

}
		