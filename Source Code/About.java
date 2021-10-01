import java.awt.*;
import javax.swing.*;

public class About 
{
	JDialog jd;
	public About(Main m)
	{
		jd= new JDialog(m);
		jd.setSize(550,500);
		jd.setTitle("AboutIMS");
		jd.setIconImage(new ImageIcon("image/logo.png").getImage());
		jd.setLocationRelativeTo(null);
		jd.setLayout(null);
		JPanel p=new JPanel();
		p.setBounds(0,0,550,500);
		p.setBackground(new Color(192,192,192));
		p.setLayout(null);
		jd.add(p);
		JLabel l1= new JLabel("Make by AVSK Developers");
		l1.setBounds(150,350,550,30);
		l1.setForeground(Color.green);
		JLabel l2= new JLabel("");
		l2.setBounds(170,100,500,30);
		l2.setForeground(Color.blue);
		JLabel l3= new JLabel("Only students help.");
		l3.setBounds(150,100,500,30);
		l3.setForeground(Color.blue);
		JLabel l4= new JLabel("Any college project relatives solutions comment now.");
		l4.setBounds(2,150,550,30);
		l4.setForeground(Color.blue);
		JLabel l5= new JLabel("Note : This project is very simple.");
		l5.setBounds(100,200,500,30);
		l5.setForeground(Color.red);
		JLabel l6= new JLabel(new ImageIcon("images/fax.png"));
		l6.setBounds(50,250,500,70);
		l6.setForeground(Color.red);
		Font f1= new Font("Lucida Calligraphy",Font.BOLD,17);
		l1.setFont(f1);
		p.add(l1);
		l2.setFont(f1);
		p.add(l2);
		l3.setFont(f1);
		p.add(l3);
		l4.setFont(f1);
		p.add(l4);
		l5.setFont(f1);
		p.add(l5);
		p.add(l6);
	
	
	
		jd.setVisible(true);
	}
	
	
}
