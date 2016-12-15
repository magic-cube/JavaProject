package Socket;
import java.io.*;
import java.net.*;
/**
 * �������ң���Ե�ͨ�ţ�
 * �����
 * @author hc
 *
 */
public class TCPServer {

	public static void main(String[] args) {
		try{
			ServerSocket ss=new ServerSocket(8888);
			Socket s=ss.accept();
			System.out.println("a client connect");
			//��ԭʼ��������װ�ɿɶ����ַ�������
			BufferedReader breader=new BufferedReader(new InputStreamReader(System.in));
			BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			//�����
			PrintWriter pw=new PrintWriter(s.getOutputStream());
			
			String readLine;
			System.out.println("client:"+br.readLine());
			readLine=breader.readLine();
			//System.out.println("server:"+readLine);
			while(!readLine.equals("exit")){
				//������д���ͻ���
				pw.println(readLine);
				pw.flush();
				System.out.println("client:"+br.readLine());
				readLine=breader.readLine();
			}
		
			//�ر������ر�socket����
			breader.close();
			pw.close();
			s.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
