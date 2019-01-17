package FirstProject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import FirstProject.Main_Cover.close;
public class Design implements ItemListener, ActionListener
{
	Checkbox b1,b2;
	JButton b11;
	Label l;
	JFrame f;
	Design()
	{
		f=new JFrame();
		f.setContentPane(new JLabel(new ImageIcon("D:\\ead.jpg")));
		
		l=new Label("   S E L E C T   Y O U R   O P T I O N ");
		l.setBounds(180,50,300,50);
		f.add(l);
		
		l.setBackground(Color.black);
		
		Font font = new Font("Times New Roman", Font.BOLD, 16);
		l.setFont(font);
		l.setForeground(Color.white);
		
		CheckboxGroup cb = new CheckboxGroup();
		
		b1=new Checkbox(" SYMMETRIC ENCRYPTION ",cb,false);
		b1.setBounds(250,150,200,40);
		f.add(b1);
		
        b1.setBackground(Color.orange);
		
		Font font3=new Font("Times New Roman", Font.BOLD, 12);
		b1.setFont(font3);
		b1.setForeground(Color.black);
		
		b2=new Checkbox(" ASYMMETRIC ENCRYPTION ",cb,false);
		b2.setBounds(250,210,200,40);
		f.add(b2);
		
		b2.setBackground(Color.darkGray);
		
		Font font4=new Font("Times New Roman", Font.BOLD, 12);
		b2.setFont(font4);
		b2.setForeground(Color.white);
		
		b2.addItemListener(this);
		b1.addItemListener(this);
		
		b11=new JButton(" BACK ");
		b11.setBounds(30,450,100,30);
		f.add(b11);
		
		b11.setBackground(Color.black);
		f.add(b11);
		
		Font fb4 = new Font("Algerian", Font.BOLD, 12);
		b11.setFont(fb4);
		b11.setForeground(Color.white);
		
		b11.addActionListener(this);
		
		f.setSize(800,600);  
		f.setLayout(null);  
		f.setVisible(true); 
		
		close cm=new close();
		f.addWindowListener(cm);
	}
	public void itemStateChanged(ItemEvent e) 
	{
		if(e.getSource()==b1)
		{
			f.dispose();
			Symmetric cp=new Symmetric();
			cp.setVisible(true);
		}
		if(e.getSource()==b2)
		{
			f.dispose();
			Asymmetric cp=new Asymmetric();
			cp.setVisible(true);
		}
	}
	public static void main(String args[])
	{
		new Design();  
	} 
	


class close extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
}



public void setVisible(boolean b) {
	// TODO Auto-generated method stub
	
}
@Override
public void actionPerformed(ActionEvent a)
{
	if(a.getSource()==b11)
	{
		f.dispose();
		Main_Cover c=new Main_Cover();
		c.setVisible(true);
	}
}
}
