package chat07;
import java.io.*;
import java.net.*;

public class ChatServer {
	DataInputStream dis=null;
	Socket s=null;
	ServerSocket server=null;
	//�ж��߳��Ƿ񻹻���
	boolean started=false;
	
	public static void main(String[] args) {
		new ChatServer().connect();
	}
	
	public void connect(){
		//�ж��Ƿ�������
		boolean connected=false;
		try {
			server=new ServerSocket(8888);
		}catch(BindException e){
			System.out.println("�˿��ѱ�ռ��");
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
				//�����Ͻ�connected��Ϊtrue
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
