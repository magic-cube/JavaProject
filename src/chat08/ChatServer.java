package chat08;
import java.io.*;
import java.net.*;

public class ChatServer {
	DataInputStream dis=null;
	ServerSocket server=null;
	//判断线程是否还活着
	boolean started=false;
	
	public static void main(String[] args) {
		new ChatServer().start();
	}
	
	public void start(){
		try {
			server=new ServerSocket(8888);
			started=true;
		}catch(BindException e){
			System.out.println("端口已被占用");
			System.exit(0);
		}catch(IOException e){
			e.printStackTrace();
		}
		
		try{
			while(started){
				Socket s=server.accept();
				dis=new DataInputStream(s.getInputStream());			
System.out.println("a client connect");
				Client c=new Client(s);
				new Thread(c).start();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(dis!=null)dis.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	/*
	 * 一条线程对应一个客户端
	 * 更好的方式是异步IO
	 */
	class Client implements Runnable{
		private Socket s;
		private DataInputStream dis=null;
		//判断是否还连接着
		private boolean connected=false;
		Client(Socket s){
			try {
				this.s=s;
				dis=new DataInputStream(s.getInputStream());
				//连接上将connected置为true
				connected=true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
		public void run(){
			String str;
			try {
				while(connected){
					str = dis.readUTF();
//System.out.println("1");
					System.out.println(str);
				}
			} catch(EOFException e){
				System.out.println("client closed");			
			}catch (IOException e) {
				e.printStackTrace();
			}finally{
					try {
						if(dis!=null)dis.close();
						if(s!=null)s.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			}			
		}
	}
}
