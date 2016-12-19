package chat04;
import java.io.IOException;
import java.net.*;

public class ChatServer {

	public static void main(String[] args) {
		try {
			ServerSocket server=new ServerSocket(8888);
			//程序非一蹴而就，暂时用while（true）,之后可以改成一个布尔类型的变量，便于控制
			while(true){
				Socket s=server.accept();
//个人习惯，将调试性语句放在最左边				
System.out.println("a client connect");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
