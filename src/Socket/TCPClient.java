package Socket;
import java.io.*;
import java.net.*;
/**
 * ��Ե�����
 * �ͻ���
 * @author hc
 *
 */
public class TCPClient {

	public static void main(String[] args) {
		try{
			Socket s=new Socket("127.0.0.1",8888);
			//��ԭʼ�������װ�ɿ���д���ַ�������
			BufferedReader br2=new BufferedReader(new InputStreamReader(System.in));
			BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			//�����
			PrintWriter pw=new PrintWriter(s.getOutputStream());
			
			System.out.println("server:"+br.readLine());
			String readLine=br2.readLine();
			while(!readLine.equals("exit")){
				//������д�������
				pw.println(readLine);
				pw.flush();
				//System.out.println("client:"+readLine);
				System.out.println("server:"+br.readLine());
				readLine=br2.readLine();
			}
			
			//�ر������ر�socket����
			pw.close();
			br.close();
			s.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
