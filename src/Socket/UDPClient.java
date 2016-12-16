package Socket;
import java.net.*;
/**
 * UDP¿Í»§¶Ë
 * @author hc
 *
 */
public class UDPClient {

	public static void main(String[] args) {
		try{
			byte [] buf=(new String("hello").getBytes());
			DatagramSocket ds=new DatagramSocket();
			DatagramPacket dp=new DatagramPacket(buf,buf.length,new InetSocketAddress("127.0.0.1",6666));
			ds.send(dp);
			ds.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
