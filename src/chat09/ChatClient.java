package chat09;
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
			//连接上就起接收数据的线程
			Client c=new Client(client);
			new Thread(c).start();
//receive();
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
//	/*
//	 * 从客户端接收
//	 */
//	public void receive(){
//		try{
//			while(true){
//				String s=dis.readUTF();
////System.out.println("receive被调用了");
//				System.out.println(s);
//			}
//		}catch(IOException e){
//			e.printStackTrace();
//		}
//	}
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
	/*
	 * 专门起一条线程接收从服务器端传来的数据
	 */
	private class Client implements Runnable{
		private Socket s;
		private DataInputStream dis=null;
		private Boolean isRunning=false;
		Client(Socket s){
			try {
				dis=new DataInputStream(s.getInputStream());
				isRunning=true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void receive(){
			try {
				String str=dis.readUTF();
				System.out.println(str);
				taContent.setText(str);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void run(){
			try{
				while(isRunning){
					receive();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
