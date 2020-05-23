import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener{

		JMenuBar m;
	JMenu file,staff,student,course,about;
	JMenuItem st1,st2,st3,st4,st5,st6,st7;
	JMenuItem s1,s2,s3,s4,s5,s6,s7;
	JMenuItem c1,c2,c3,c4,c5,c6,c7;
	JMenuItem l1,f1,f2,a1;
	JToolBar tbar;
	JButton t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
		public Main(){
	
			setSize(1000,700);
			setTitle("INSTITUTE MANAGEMENT SYSTEM");
			setIconImage(new ImageIcon("logo.png").getImage());
			Container container = getContentPane();
			JPanel p = new JPanel();
			m=new JMenuBar();
			file=new JMenu("File");
			m.add(file);
			staff=new JMenu("Staff");
			m.add(staff);
			student=new JMenu("Student");
			m.add(student);
			course=new JMenu("Course");
			m.add(course);
			about=new JMenu("About");
			m.add(about);
		//file
		f1=new JMenuItem("Logout",new ImageIcon("images/logout.png"));
		file.add(f1);
		f1.addActionListener(this);
		f2=new JMenuItem("Exit",new ImageIcon("images/exit.png"));
		file.add(f2);
		f2.addActionListener(this);
		
		//about
		a1=new JMenuItem("About",new ImageIcon("images/about.png"));
		about.add(a1);
		a1.addActionListener(this);
		
	

		//Staff
		s1=new JMenuItem("Add Staff",new ImageIcon("images/staff.png"));
		staff.add(s1);
		s1.addActionListener(this);
		s2=new JMenuItem("Edit Staff",new ImageIcon("images/editstaff.png"));
		s2.addActionListener(this);
		staff.add(s2);
		s3=new JMenuItem("Staff Record",new ImageIcon("images/staffrecord.png"));
		staff.add(s3);
		s3.addActionListener(this);
		s4=new JMenuItem("Pay Salary",new ImageIcon("images/pay.png"));
		s4.addActionListener(this);
		staff.add(s4);
		s5=new JMenuItem("Salary Record",new ImageIcon("images/salary.png"));
		staff.add(s5);
		s5.addActionListener(this);


		//Student
		st1=new JMenuItem("Admission form",new ImageIcon("images/admission.png"));
		student.add(st1);
		st1.addActionListener(this);
		st2=new JMenuItem("Edit Student",new ImageIcon("images/editstudent.png"));
		student.add(st2);
		st2.addActionListener(this);
		st3=new JMenuItem("Student Record",new ImageIcon("images/studentrecord.png"));
		student.add(st3);
		st3.addActionListener(this);
		st4=new JMenuItem("Pay fees",new ImageIcon("images/fees.png"));
		student.add(st4);
		st4.addActionListener(this);
		st5=new JMenuItem("Pay fees Record",new ImageIcon("images/feesrecord.png"));
		student.add(st5);
		st5.addActionListener(this);

		//course
		c1=new JMenuItem("Add Course",new ImageIcon("images/course.png"));
		course.add(c1);
		c1.addActionListener(this);
		c2=new JMenuItem("Edit Course",new ImageIcon("images/editcourse.png"));
		course.add(c2);
		c2.addActionListener(this);
		c3=new JMenuItem("Course Record",new ImageIcon("images/courserecord.png"));
		course.add(c3);
		c3.addActionListener(this);

		tbar= new JToolBar();
			t1=new JButton(new ImageIcon("images/staff.png"));
			tbar.add(t1);
			t1.setToolTipText("Add Staff");
			tbar.addSeparator();
			t1.addActionListener(this);
			t2=new JButton(new ImageIcon("images/Editstaff.png"));
			tbar.add(t2);
			t2.setToolTipText("Edit staff details");
			t2.addActionListener(this);
			t3=new JButton(new ImageIcon("images/staffrecord.png"));
			tbar.addSeparator();
			tbar.add(t3);
			t3.setToolTipText("Staff Record");
			t3.addActionListener(this);
			t4=new JButton(new ImageIcon("images/pay.png"));
			tbar.addSeparator();
			tbar.add(t4);
			t4.setToolTipText("Pay Salary");
			t4.addActionListener(this);
			
			t5=new JButton(new ImageIcon("images/salary.png"));
			tbar.addSeparator();
			tbar.add(t5);
			t5.setToolTipText("Salary Record");
			t5.addActionListener(this);

			t6=new JButton(new ImageIcon("images/admission.png"));
			tbar.addSeparator();
			tbar.add(t6);
			t6.setToolTipText("Admission");
			t6.addActionListener(this);

			
			t7=new JButton(new ImageIcon("images/editstudent.png"));
			tbar.addSeparator();
			tbar.add(t7);
			t7.setToolTipText("Edit Student");
			t7.addActionListener(this);
			
			
			t8=new JButton(new ImageIcon("images/studentrecord.png"));
			tbar.addSeparator();
			tbar.add(t8);
			t8.setToolTipText("Student Record");
			t8.addActionListener(this);
			
			t9=new JButton(new ImageIcon("images/fees.png"));
			tbar.addSeparator();
			tbar.add(t9);
			t9.setToolTipText("fees");
			t9.addActionListener(this);
		
			t10=new JButton(new ImageIcon("images/feesrecord.png"));
			tbar.addSeparator();
			tbar.add(t10);
			t10.setToolTipText("Fees Record");
			t10.addActionListener(this);		
			
			add(tbar,BorderLayout.NORTH);	
			setJMenuBar(m);
			container.add(p);
			JLabel main = new JLabel(new ImageIcon("images/main.jpg"));
			add(main,BorderLayout.CENTER);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			
	
		}

	public void actionPerformed(ActionEvent e){
		if(e.getSource()==s1||e.getSource()==t1)
		{  
			new Staff();  	
		}
		if(e.getSource()==s2||e.getSource()==t2)
		{  
			new UpdateStaff(); 	
		}
		if(e.getSource()==s3||e.getSource()==t3)
		{  
			new StaffRecord();
		}
		if(e.getSource()==s4||e.getSource()==t4)
		{  
			new Salary();	
		}
		if(e.getSource()==s5||e.getSource()==t5)
		{  
			new SalaryRecord();	
		}



		if(e.getSource()==st1||e.getSource()==t6)
		{  
			new Admission();  	
		}
		if(e.getSource()==st2||e.getSource()==t7)
		{  
			new UpdateStudent(); 	
		}
		if(e.getSource()==st3||e.getSource()==t8)
		{  
			new StudentRecord();
		}
		if(e.getSource()==st4||e.getSource()==t9)
		{  
			new StudentAccount();	
		}
		if(e.getSource()==st5||e.getSource()==t10)
		{  
			new AccountRecord();	
		}

		if(e.getSource()==c1)
		{  
			new Course();	
		}
		if(e.getSource()==c2)
		{  
			new UpdateCourse();	
		}
		if(e.getSource()==c3)
		{  
			new CourseRecord();	
		}


		if(e.getSource()==f1)
		{  
			dispose();
			new Login();	
		}
		if(e.getSource()==f2)
		{  
			System.exit(0);	
		}
		if(e.getSource()==a1)
		{  
			new About(this);	
		}
	}

	public static void main(String []args){
		
		new Main();
	}

}