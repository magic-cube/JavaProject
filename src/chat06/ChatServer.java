package chat06;
import java.io.*;
import java.net.*;

public class ChatServer {
	DataInputStream dis=null;
	Socket s=null;
	//�ж��߳��Ƿ񻹻���
	boolean started=false;
	public static void main(String[] args) {
		new ChatServer().connect();
	}
	public void connect(){
		//�ж��Ƿ�������
		boolean connected=false;
		try {
			ServerSocket server=new ServerSocket(8888);
			started=true;
			while(started){
				s=server.accept();
				dis=new DataInputStream(s.getInputStream());			
System.out.println("a client connect");
				//�����Ͻ�connected��Ϊtrue
				connected=true;
				while(connected){
					String str=dis.readUTF();
					System.out.println(str);
				}
			}
			dis.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void receive(){
		
	}

}
