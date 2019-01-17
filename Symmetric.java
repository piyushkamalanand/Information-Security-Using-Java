package FirstProject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import FirstProject.Design.close;
public class Symmetric implements ItemListener, ActionListener
{
	Checkbox b1,b2,b3;
    Label l;
    JFrame f;
    JButton b11;
    Symmetric()
    {
    	f=new JFrame();
		f.setContentPane(new JLabel(new ImageIcon("D:\\ead.jpg")));
		
    	l=new Label (" ENHANCED SECURITY USING ENCRYPTION AND DECRYPTION ");
    	l.setBounds(50,50,530,70);
		f.add(l);
		
		l.setBackground(Color.black);
		
		Font font = new Font("Times New Roman", Font.BOLD, 16);
		l.setFont(font);
		l.setForeground(Color.white);
		
		CheckboxGroup cb=new CheckboxGroup();
		
		b1=new Checkbox(" DES ",cb,false);
		b1.setBounds(200,150,100,40);
		f.add(b1);
		
        b1.setBackground(Color.orange);
		
		Font font3=new Font("Times New Roman", Font.BOLD, 12);
		b1.setFont(font3);
		b1.setForeground(Color.black);
		
		b2=new Checkbox(" TripleDES ",cb,false);
		b2.setBounds(200,210,100,40);
		f.add(b2);
		
		b2.setBackground(Color.darkGray);
		
		Font font4=new Font("Times New Roman", Font.BOLD, 12);
		b2.setFont(font4);
		b2.setForeground(Color.white);
		
		b3=new Checkbox(" AES ",cb,false);
		b3.setBounds(200,270,100,40);
		f.add(b3);
		
		b3.setBackground(Color.orange);
		
		Font font5=new Font("Times New Roman", Font.BOLD, 12);
		b3.setFont(font5);
		b3.setForeground(Color.white);
		
		b11=new JButton(" BACK ");
		b11.setBounds(30,450,100,30);
		f.add(b1);
		
		b11.setBackground(Color.black);
		f.add(b11);
		
		Font fb4 = new Font("Algerian", Font.BOLD, 12);
		b11.setFont(fb4);
		b11.setForeground(Color.white);
		
		b11.addActionListener(this);
		
		b2.addItemListener(this);
		b1.addItemListener(this);
		b3.addItemListener(this);
		
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
			Des cp=new Des();
			cp.setVisible(true);
		}
		if(e.getSource()==b2)
		{
			f.dispose();
			TripleDes cp=new TripleDes();
			cp.setVisible(true);
		}
		if(e.getSource()==b3)
		{
			f.dispose();
			Aes cp=new Aes();
			cp.setVisible(true);
		}
	}
	public static void main(String args[])
	{
		new Symmetric();  
	} 
	


class close extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
}

public void actionPerformed(ActionEvent a)
{
	if(a.getSource()==b11)
	{
		f.dispose();
		Design c=new Design();
		c.setVisible(true);
	}
}

public void setVisible(boolean b) {
	// TODO Auto-generated method stub
	
}
}
