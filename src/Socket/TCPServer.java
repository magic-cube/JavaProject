package Socket;
import java.io.*;
import java.net.*;
/**
 * 简单聊天室（点对点通信）
 * 服务端
 * @author hc
 *
 */
public class TCPServer {

	public static void main(String[] args) {
		try{
			ServerSocket ss=new ServerSocket(8888);
			Socket s=ss.accept();
			System.out.println("a client connect");
			//将原始输入流包装成可读入字符串的流
			BufferedReader breader=new BufferedReader(new InputStreamReader(System.in));
			BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			//输出流
			PrintWriter pw=new PrintWriter(s.getOutputStream());
			
			String readLine;
			System.out.println("client:"+br.readLine());
			readLine=breader.readLine();
			//System.out.println("server:"+readLine);
			while(!readLine.equals("exit")){
				//将这行写到客户端
				pw.println(readLine);
				pw.flush();
				System.out.println("client:"+br.readLine());
				readLine=breader.readLine();
			}
		
			//关闭流，关闭socket连接
			breader.close();
			pw.close();
			s.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
