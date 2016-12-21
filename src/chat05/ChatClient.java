package chat05;
import java.awt.*;
import java.net.*;
import java.awt.event.*;
import java.io.*;

public class ChatClient extends Frame{
	Socket client=null;
	TextField tfTxt=new TextField();
	TextArea taContent=new TextArea();
	
	public static void main(String args[]){
		new ChatClient().launchFrame();
		
	}
	
	public void launchFrame(){
		this.setLocation(400,300);
		this.setSize(300, 300);
		add(tfTxt,BorderLayout.SOUTH);
		add(taContent,BorderLayout.NORTH);
		//关闭窗口
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		pack();//自动包装
		//监听TestField
		tfTxt.addActionListener(new TFListener());
		this.setVisible(true);
		//在这里调用，打开窗口后直接连上
		connect();
	}
	
	public void connect(){
		try {
			client=new Socket("127.0.0.1",8888);
System.out.println("connected!");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void send(String s){
		try {
			DataOutputStream dos=new DataOutputStream(client.getOutputStream());
			dos.writeUTF(s);
			dos.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	private class TFListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String s=tfTxt.getText().trim();
			
			send(s);
			
			taContent.setText(s);
			tfTxt.setText("");
		}
	}
}
