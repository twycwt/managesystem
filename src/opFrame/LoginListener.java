package opFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginListener implements ActionListener{
	  public String Name;
	  public String Password;
	  public JFrame frame;
	  public JTextField text;
	  public JPasswordField pw;
	  public LoginListener(JFrame frame,JTextField text,JPasswordField pw){
		  this.frame = frame;
		  this.text = text;
		  this.pw = pw;
	  }
	  @SuppressWarnings("deprecation")
	  public void actionPerformed(ActionEvent e){
		  try{
			  //发送密码和用户名到客户端
			  String user = text.getText();
			  String pass = pw.getText();
			  if((user.equals("twycwt")) && (pass.equals("twy97620")))
			  {
				  //Operation o = new Operation();
				  //o.SetSocket(s);
				  frame.dispose();
				  @SuppressWarnings("unused")
				  Operation operation = new Operation();
			  }
			  else{
				  JTextField text = new JTextField("            用户名或密码错误");
				  JFrame frame = new JFrame();
			      frame.setTitle("错误");
			      frame.setLocation(550,300);
			      frame.setSize(200,100);
			      frame.setDefaultCloseOperation(2);
			      frame.add(text);
			      frame.setVisible(true);
			  } 
		  }catch(Exception e1){}
		    
	  }
}
