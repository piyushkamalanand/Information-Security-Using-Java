package FirstProject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import FirstProject.COVER_pAGE.close;
public class Main_Cover  implements ActionListener
{
	Label l;
	JFrame f;
	JButton b1,b2;
	Main_Cover()
	{
		f=new JFrame();
		f.setContentPane(new JLabel(new ImageIcon("D:\\W.jpg")));
		
		l=new Label(" P R O J E C T   O N   E N C R Y P T I O N   D E C R Y P T I O N  &  I M A G E   C O M P R E S S I O N");
		l.setBounds(20,50,740,70);
		f.add(l);
		
		l.setBackground(Color.black);
		
		Font font = new Font("Times New Roman", Font.BOLD, 16);
		l.setFont(font);
		l.setForeground(Color.white);
		
		b1=new JButton(" ENCRYPTION OF DATA"+ " ");
		b1.setBounds(200,190,200,40);
		f.add(b1);
		
		b1.setBackground(Color.darkGray);
		
		Font font3=new Font("Times New Roman", Font.BOLD, 12);
		b1.setFont(font3);
		b1.setForeground(Color.white);
		
		/*b2=new JButton(" IMAGE COMPRESSION ");
		b2.setBounds(200,250,200,40);
		f.add(b2);
		
		b2.setBackground(Color.darkGray);
		
		Font font4=new Font("Times New Roman", Font.BOLD, 12);
		b2.setFont(font4);
		b2.setForeground(Color.white);
		
		b2.addActionListener(this);*/
		b1.addActionListener(this);
		f.setBackground(Color.white);
		f.setSize(800,600);  
		f.setLayout(null);  
		f.setVisible(true); 
		
		close cm=new close();
		f.addWindowListener(cm);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b1)
		{
			f.dispose();
			Design cp=new Design();
			cp.setVisible(true);
		}
		/*if(e.getSource()==b2)
		{
			uploadd obj=new uploadd();
			f.setVisible(false);
			f.remove(f);
			obj.init();
		}*/
	}
	public static void main(String args[])
	{
		new Main_Cover();  
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
}