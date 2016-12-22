package chat10;
import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
	DataInputStream dis=null;
	ServerSocket server=null;
	//判断线程是否还活着
	boolean started=false;
	//线程容器
	List<Client> list=new ArrayList<Client>();
	
	
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
				list.add(c);
				
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
		private DataOutputStream dos=null;
		//判断是否还连接着
		private boolean connected=false;
		Client(Socket s){
			try {
				this.s=s;
				dis=new DataInputStream(s.getInputStream());
				dos=new DataOutputStream(s.getOutputStream());
				//连接上将connected置为true
				connected=true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	

		public void send(String str){
			try {
				dos.writeUTF(str);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void run(){
			String str;
			try {
				while(connected){
					str = dis.readUTF();
					for(int i=0;i<list.size();i++){
						Client c=list.get(i);
//						if(c==this){
//							continue;
//						}
						c.send(str);
					}
					System.out.println(str);
				}
			} catch(EOFException e){
				System.out.println("client closed");			
			}catch (IOException e) {
				e.printStackTrace();
			}finally{
					try {
						if(dis!=null){
							dis.close();
							/*
							 * 指向空对象，方便垃圾回收器回收
							 * 无人引用的对象，垃圾回收器会很快回收、
							 * 也可以System.gc(),给垃圾回收器一个建议
							 */
							dis=null;
						}
						if(s!=null){
							s.close();
							s=null;
						}
						if(dos!=null){
							dos.close();
							dos=null;
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			}			

		}
	}
}
