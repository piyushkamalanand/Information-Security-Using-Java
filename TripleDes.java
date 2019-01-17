package FirstProject;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.sound.midi.spi.MidiDeviceProvider;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;


public class TripleDes implements ActionListener
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
	byte[] encrypted,encrypted1;
	
	byte[] skey = new byte[1000];
	String skeyString,name,inputMessage1;
	static byte[] raw;
	TripleDes()
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
		
		l2=new Label(" PUBLIC KEY ");
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
		t2.setForeground(Color.white);
		
		b11=new JButton(" ENCRYPT ");
		b11.setBounds(80,370,100,30);
		f.add(b11);
		
		b11.setBackground(Color.black);
		f.add(b11);
		
		Font fb41 = new Font("Times New Roman", Font.BOLD, 12);
		b11.setFont(fb41);
		b11.setForeground(Color.white);
		
		b11.addActionListener(this);
		
		b1=new JButton(" DECRYPT ");
		b1.setBounds(230,370,100,30);
		f.add(b1);
		
		b1.setBackground(Color.black);
		f.add(b1);
		
		Font fb4 = new Font("Times New Roman", Font.BOLD, 12);
		b1.setFont(fb4);
		b1.setForeground(Color.white);
		
		b1.addActionListener(this);
		
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
	
	void generateSymmetricKey(int c1) {
		try {
		Random r = new Random();
		int num = r.nextInt(10000);
		String knum = String.valueOf(num);
		byte[] knumb = knum.getBytes();
		skey=getRawKey(knumb);
		skeyString = new String(skey);
		System.out.println("DES Symmetric key = "+skeyString);
		if(c1==1)
		{
		t.setText(skeyString);
		}
		if(c1==0)
		{
			t2.setText(skeyString);	
		}
		}
		catch(Exception e) {
		System.out.println(e);
		}
		}
		private static byte[] getRawKey(byte[] seed) throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance("TRIPLEDES");
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		
		sr.setSeed(seed);
		kgen.init(168, sr);
		SecretKey skey = kgen.generateKey();
		raw = skey.getEncoded();
		return raw;
		}
	
	public static byte[] encrypt(String toEncrypt, String key) throws Exception {
	      // create a binary key from the argument key (seed)
	      SecureRandom sr = new SecureRandom(key.getBytes());
	      KeyGenerator kg = KeyGenerator.getInstance("DESede");
	      kg.init(sr);
	      SecretKey sk = kg.generateKey();
	  
	      // create an instance of cipher
	      Cipher cipher = Cipher.getInstance("DESede");
	  
	      // initialize the cipher with the key
	      cipher.init(Cipher.ENCRYPT_MODE, sk);
	  
	      // enctypt!
	      byte[] encrypted = cipher.doFinal(toEncrypt.getBytes());
	  
	      return encrypted;
	   }
	  
	   public static String decrypt(byte[] toDecrypt, String key) throws Exception {
	      // create a binary key from the argument key (seed)
	      SecureRandom sr = new SecureRandom(key.getBytes());
	      KeyGenerator kg = KeyGenerator.getInstance("DESede");
	      kg.init(sr);
	      SecretKey sk = kg.generateKey();
	  
	      // do the decryption with that key
	      Cipher cipher = Cipher.getInstance("DESede");
	      cipher.init(Cipher.DECRYPT_MODE, sk);
	      byte[] decrypted = cipher.doFinal(toDecrypt);
	  
	      return new String(decrypted);
	   }
	
	public static void main(String args[])
	{
		new TripleDes();  
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
	
	      String toEncrypt = ta.getText();
	      
	      if(e.getSource()==b11)
	      {
	    	  generateSymmetricKey(1);
	      System.out.println("Encrypting...");
	      encrypted = encrypt(toEncrypt, "password");
	      String encryptedData = new String(encrypted);
	      System.out.println("Encrypted text: " + encrypted);
	      ta.setText(encryptedData);
	      }
	      if(e.getSource()==b1)
	      {
	      System.out.println("Decrypting...");
	      String decrypted = decrypt(encrypted, "password");
	      String encryptedData = new String(decrypted);
	      System.out.println("Decrypted text: " + decrypted);
	      ta.setText(encryptedData);
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
	    	  generateSymmetricKey(0);
		      System.out.println("Encrypting...");
		      encrypted1 = encrypt(inputMessage1, "password");
		      String encryptedData1 = new String(encrypted1);
		      System.out.println("Encrypted text: " + encrypted1);
		      try {
					FileWriter fw=new FileWriter(name);
					wr=new BufferedWriter(fw);
					//String str=;
					wr.write(encryptedData1);
					wr.close();
					
				}
				catch(Exception e4) 
				{
				}
	      }
	      
	      if(e.getSource()==b3)
	      {
	    	  System.out.println("Decrypting...");
		      String decrypted1 = decrypt(encrypted1, "password");
		      String encryptedData1 = new String(decrypted1);
		      System.out.println("Decrypted text: " + decrypted1);
		      try {
					FileWriter fw=new FileWriter(name);
					wr=new BufferedWriter(fw);
					//String str=;
					wr.write(decrypted1);
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
	  		Symmetric c=new Symmetric();
	  		c.setVisible(true);
	  	}
	      
}
public void setVisible(boolean b) {
	// TODO Auto-generated method stub
	
}
}


