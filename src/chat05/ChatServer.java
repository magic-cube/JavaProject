package chat05;
import java.io.*;
import java.net.*;

public class ChatServer {

	public static void main(String[] args) {
		try {
			ServerSocket server=new ServerSocket(8888);
			//�����һ����ͣ���ʱ��while��true��,֮����Ըĳ�һ���������͵ı��������ڿ���
			while(true){
				Socket s=server.accept();
				DataInputStream dis=new DataInputStream(s.getInputStream());
//����ϰ�ߣ��������������������				
System.out.println("a client connect");
				while(true){
					String str=dis.readUTF();
					System.out.println(str);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
