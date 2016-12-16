package Socket;
import java.net.*;
import java.io.*;
/**
 * UDP�ͻ���
 * ����DataOutputStream��ByteArrayStream,�����˷���һ��long���͵���
 * @author hc
 *
 */
public class UDPClient {

	public static void main(String[] args) {
		try{
			long l=10000l;
			ByteArrayOutputStream bos=new ByteArrayOutputStream();
			DataOutputStream dos=new DataOutputStream(bos);
			dos.writeLong(l);
			
			//byte [] buf=(new String("hello").getBytes());
			byte[] buf=bos.toByteArray();
			DatagramSocket ds=new DatagramSocket();
			DatagramPacket dp=new DatagramPacket(buf,buf.length,new InetSocketAddress("127.0.0.1",6666));
			ds.send(dp);
			ds.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
