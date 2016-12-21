package chat07;
import java.io.*;
import java.net.*;

public class ChatServer {
	DataInputStream dis=null;
	Socket s=null;
	ServerSocket server=null;
	//判断线程是否还活着
	boolean started=false;
	
	public static void main(String[] args) {
		new ChatServer().connect();
	}
	
	public void connect(){
		//判断是否还连接着
		boolean connected=false;
		try {
			server=new ServerSocket(8888);
		}catch(BindException e){
			System.out.println("端口已被占用");
			System.exit(0);
		}catch(IOException e){
			e.printStackTrace();
		}
		try{
			started=true;
			while(started){
				s=server.accept();
				dis=new DataInputStream(s.getInputStream());			
System.out.println("a client connect");
				//连接上将connected置为true
				connected=true;
				while(connected){
					String str=dis.readUTF();
					System.out.println(str);
				}
			}
			dis.close();
		}catch(EOFException e){
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
	
	public void receive(){
		
	}

}
