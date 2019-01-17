package FirstProject;
import java.awt.*;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
public class Rsa implements ActionListener 
{
	Label l,l1,l2,l3,l4;
	JLabel lblNewLabel;
	TextArea ta;
	TextField t,t1,t2;
	JButton b1,b11,b111,b2,b3,b4,btnUpload;
	JFrame f;
	File file;
	BufferedReader br=null;
	 BufferedWriter wr=null;
	private File f1,k;
	String name,inputMessage1;
	PublicKey pubKey,pubKey1;
	byte [] encrypted,encrypted1;
	Rsa()
	{
		f=new JFrame();
		f.setContentPane(new JLabel(new ImageIcon("D:\\ead.jpg")));
		
		l=new Label ("     TEXT ENCRYPTION ");
    	l.setBounds(70,30,200,50);
		f.add(l);
		
		l.setBackground(Color.black);
		
		Font font = new Font("Times New Roman", Font.BOLD, 16);
		l.setFont(font);
		l.setForeground(Color.white);
		
		l2=new Label ("     FILE ENCRYPTION ");
    	l2.setBounds(500,30,200,50);
		f.add(l2);
		
		l2.setBackground(Color.black);
		
		Font font1 = new Font("Times New Roman", Font.BOLD, 16);
		l2.setFont(font1);
		l2.setForeground(Color.white);
		
		l3=new Label(" FILE NAME ");
		l3.setBounds(400,140,100,30);
		f.add(l3);
		
		l3.setBackground(Color.black);
		
		Font fl3 = new Font("Times New Roman", Font.BOLD, 12);
		l3.setFont(fl3);
		l3.setForeground(Color.white);
		
		t1=new TextField();
		t1.setBounds(520,140,170,30);
		f.add(t1);
		t1.setBackground(Color.black);
		t1.setForeground(Color.white);
		
		/*b2=new JButton(" BROWSE ");
		b2.setBounds(580,190,100,30);
		f.add(b2);
		
		b2.setBackground(Color.black);
		f.add(b2);
		
		Font fb2 = new Font("Times New Roman", Font.BOLD, 12);
		b2.setFont(fb2);
		b2.setForeground(Color.white);
		
		b2.addActionListener(this);*/
		
		l1=new Label(" SIMPLE DATA ");
		l1.setBounds(30,140,130,30);
		f.add(l1);
		
		l1.setBackground(Color.black);
		
		Font fl1 = new Font("Times New Roman", Font.BOLD, 12);
		l1.setFont(fl1);
		l1.setForeground(Color.white);
		
		ta=new TextArea();
		ta.setBounds(170,120,170,180);
		f.add(ta);
		ta.setBackground(Color.black);
		ta.setForeground(Color.white);
		
		/*l2=new Label(" PUBLIC KEY ");
		l2.setBounds(30,320,110,30);
		f.add(l2);
		
		l2.setBackground(Color.black);
		
		Font fl2 = new Font("Times New Roman", Font.BOLD, 12);
		l2.setFont(fl1);
		l2.setForeground(Color.white);
		
		t=new TextField();
		t.setBounds(170,320,170,30);
		f.add(t);
		t.setBackground(Color.black);
		t.setForeground(Color.white);
		
		l4=new Label(" PUBLIC KEY ");
		l4.setBounds(400,320,110,30);
		f.add(l4);
		
		l4.setBackground(Color.black);
		
		Font fl4 = new Font("Times New Roman", Font.BOLD, 12);
		l4.setFont(fl4);
		l4.setForeground(Color.white);
		
		t2=new TextField();
		t2.setBounds(520,320,170,30);
		f.add(t2);
		t2.setBackground(Color.black);
		t2.setForeground(Color.white);*/
		
		b1=new JButton(" DECRYPT ");
		b1.setBounds(230,370,100,30);
		f.add(b1);
		
		b1.setBackground(Color.black);
		f.add(b1);
		
		Font fb4 = new Font("Times New Roman", Font.BOLD, 12);
		b1.setFont(fb4);
		b1.setForeground(Color.white);
		
		b1.addActionListener(this);
		
		b11=new JButton(" ENCRYPT ");
		b11.setBounds(80,370,100,30);
		f.add(b11);
		
		b11.setBackground(Color.black);
		f.add(b11);
		
		Font fb41 = new Font("Times New Roman", Font.BOLD, 12);
		b11.setFont(fb41);
		b11.setForeground(Color.white);
		
		b11.addActionListener(this);
		
		b111=new JButton(" BACK ");
		b111.setBounds(20,500,100,30);
		f.add(b111);
		
		b111.setBackground(Color.black);
		f.add(b111);
		
		Font fb42 = new Font("Algerian", Font.BOLD, 12);
		b111.setFont(fb42);
		b111.setForeground(Color.white);
		
		b111.addActionListener(this);
		
		btnUpload = new JButton("UPLOAD");
		btnUpload.addActionListener(this);
		btnUpload.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnUpload.setBounds(640,190,100,30);
		btnUpload.setOpaque(false);
		btnUpload.setContentAreaFilled(false);
		btnUpload.setBorderPainted(true);
		f.add(btnUpload);
		btnUpload.addActionListener(this);
		btnUpload.setForeground(Color.white);
		btnUpload.setBackground(Color.black);
		
		lblNewLabel = new JLabel(/*new ImageIcon("/home/ashish/b1.png")*/);
		lblNewLabel.setBounds(84, 65, 434, 257);
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		f.add(lblNewLabel);
		
		b3=new JButton(" DECRYPT ");
		b3.setBounds(580,370,100,30);
		f.add(b3);
		
		b3.setBackground(Color.black);
		f.add(b3);
		
		Font fb31 = new Font("Times New Roman", Font.BOLD, 12);
		b3.setFont(fb31);
		b3.setForeground(Color.white);
		
		b4=new JButton(" ENCRYPT ");
		b4.setBounds(430,370,100,30);
		f.add(b4);
		
		b4.setBackground(Color.black);
		f.add(b4);
		
		Font fb411 = new Font("Times New Roman", Font.BOLD, 12);
		b4.setFont(fb411);
		b4.setForeground(Color.white);
		
		b4.addActionListener(this);
		b3.addActionListener(this);
		
		f.setLayout(null); 
		f.setSize(800,600);  
		f.setVisible(true);
	}
	public static void main(String args[])
	{
		new Rsa();  
	} 
	
	public static KeyPair buildKeyPair() throws NoSuchAlgorithmException {
        final int keySize = 2048;
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(keySize);      
        return keyPairGenerator.genKeyPair();
    }

    public static byte[] encrypt(PrivateKey privateKey, String message) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");  
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);  

        return cipher.doFinal(message.getBytes());  
    }
    
    public static byte[] decrypt(PublicKey publicKey, byte [] encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");  
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        
        return cipher.doFinal(encrypted);
    }

class close extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
}



@Override
public void actionPerformed(ActionEvent e) 
{
	try
	{
		if(e.getSource()==b11)
		{
				String s=ta.getText();	
	 // generate public and private keys
				KeyPair keyPair = buildKeyPair();
				pubKey = keyPair.getPublic();
				PrivateKey privateKey = keyPair.getPrivate();
    
    // encrypt the message
				encrypted = encrypt(privateKey,s); 
				ta.setText(new String(encrypted));
				System.out.println(new String(encrypted));  // <<encrypted message>>
		}
		if(e.getSource()==b1)
		{
    // decrypt the message
				byte[] secret = decrypt(pubKey, encrypted);
				ta.setText(new String(secret));
				System.out.println(new String(secret));
	}
		
		if(e.getSource()==btnUpload)
		{
			//c=1;
			JFileChooser fc = new JFileChooser();
			StringBuffer buffer;
		    buffer = new StringBuffer();
			FileNameExtensionFilter fg=new FileNameExtensionFilter( "text files " , "txt");
            fc.setFileFilter(fg);
            int result = fc.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                f1 = fc.getSelectedFile();  
                name=f1.toString();  
                System.out.println(name);
                t1.setText(name);
                
                try
        		{
        			FileReader f1=new FileReader(name);
        			br=new BufferedReader(f1);
        			 String l;
        			l=br.readLine();
        			while(l!=null)
        				
        			{
        				inputMessage1=inputMessage1+l+"\n";
        			
        		
        				l=br.readLine();
        			}
        			System.out.println(inputMessage1);
        			br.close();
        			f1.close();
        				// in.close();
        				// System.out.println(s);
                		//inputMessage=ta.getText();
                		//inputMessage=buffer.toString();
                		
                }catch (FileNotFoundException z){ JOptionPane.showMessageDialog(null, "file not found");  }
                catch (IOException z) { z.printStackTrace();  }
            }
         }
		if(e.getSource()==b4)
		{
			KeyPair keyPair1 = buildKeyPair();
			pubKey1 = keyPair1.getPublic();
			PrivateKey privateKey1 = keyPair1.getPrivate();

// encrypt the message
			encrypted1 = encrypt(privateKey1,inputMessage1); 
			System.out.println(new String(encrypted1));
			
			try {
				FileWriter fw=new FileWriter(name);
				wr=new BufferedWriter(fw);
				//String str=;
				wr.write(new String(encrypted1));
				wr.close();
				
			}
			catch(Exception e4) 
			{
			}
		}
		
		if(e.getSource()==b3)
		{
			byte[] secret1 = decrypt(pubKey1, encrypted1);

			System.out.println(new String(secret1));
			
			try {
				FileWriter fw=new FileWriter(name);
				wr=new BufferedWriter(fw);
				//String str=;
				wr.write(new String(secret1));
				wr.close();
				
			}
			catch(Exception e4) 
			{
			}
			
		}
		
	}
	catch(Exception e1)
	{
		
	}
	
	if(e.getSource()==b111)
	{
		f.dispose();
		Asymmetric c=new Asymmetric();
		c.setVisible(true);
	}
	
}
public void setVisible(boolean b) {
	// TODO Auto-generated method stub
	
}
}



