package chat04;
import java.io.IOException;
import java.net.*;

public class ChatServer {

	public static void main(String[] args) {
		try {
			ServerSocket server=new ServerSocket(8888);
			//�����һ����ͣ���ʱ��while��true��,֮����Ըĳ�һ���������͵ı��������ڿ���
			while(true){
				Socket s=server.accept();
//����ϰ�ߣ��������������������				
System.out.println("a client connect");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
