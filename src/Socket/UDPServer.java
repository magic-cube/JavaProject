package Socket;
import java.net.*;
/**
 * UDP·þÎñ¶Ë
 * @author hc
 *
 */
public class UDPServer {

	public static void main(String[] args) {
		byte [] buf=new byte[1024];
		try {
			DatagramSocket ds=new DatagramSocket(6666);
			DatagramPacket dp=new DatagramPacket(buf,buf.length);
			while(true){
				ds.receive(dp);
				System.out.println(new String(buf,0,dp.getLength()));
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
