package chat08;
import java.awt.*;
import java.net.*;
import java.awt.event.*;
import java.io.*;

public class ChatClient extends Frame{
	Socket client=null;
	TextField tfTxt=new TextField();
	TextArea taContent=new TextArea();
	//输出流，在连接时将其初始化,存储好，之后直接用就好了，避免了每次发送都初始化,之后用的也就是同一个流，不存在只能发送一次的情况
	DataOutputStream dos=null;
	
	public static void main(String args[]){
		new ChatClient().launchFrame();
		
	}
	/*
	 * 建立窗口
	 */
	public void launchFrame(){
		this.setLocation(400,300);
		this.setSize(300, 300);
		add(tfTxt,BorderLayout.SOUTH);
		add(taContent,BorderLayout.NORTH);
		//关闭窗口
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				disconnect();
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
	/*
	 * 建立连接
	 */
	public void connect(){
		try {
			client=new Socket("127.0.0.1",8888);
			//一旦连接上，初始化输出流
			dos=new DataOutputStream(client.getOutputStream());
System.out.println("connected!");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/*
	 * 关闭连接，窗口关闭时调用
	 */
	public void disconnect(){
		try {
			client.close();
			dos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/*
	 * 发送数据至客户端
	 */
	public void send(String s){
		try {
			dos.writeUTF(s);
			dos.flush();
			//dos.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	/*
	 * 监听TextField
	 */
	private class TFListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String s=tfTxt.getText().trim();
			send(s);
			taContent.setText(s);
			tfTxt.setText("");
		}
	}
}
