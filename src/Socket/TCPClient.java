package Socket;
import java.io.*;
import java.net.*;
/**
 * 点对点聊天
 * 客户端
 * @author hc
 *
 */
public class TCPClient {

	public static void main(String[] args) {
		try{
			Socket s=new Socket("127.0.0.1",8888);
			//将原始输出流包装成可以写出字符串的流
			BufferedReader br2=new BufferedReader(new InputStreamReader(System.in));
			BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			//输出流
			PrintWriter pw=new PrintWriter(s.getOutputStream());
			
			System.out.println("server:"+br.readLine());
			String readLine=br2.readLine();
			while(!readLine.equals("exit")){
				//将这行写到服务端
				pw.println(readLine);
				pw.flush();
				//System.out.println("client:"+readLine);
				System.out.println("server:"+br.readLine());
				readLine=br2.readLine();
			}
			
			//关闭流，关闭socket连接
			pw.close();
			br.close();
			s.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
