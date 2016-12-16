package Socket;
import java.net.*;
import java.io.*;
/**
 * UDP服务端
 * 接受一个long类型数的方法
 * @author hc
 *
 */
public class UDPServer {

	public static void main(String[] args) {
		byte [] buf=new byte[1024];
		long l;
		try {
			DatagramSocket ds=new DatagramSocket(6666);
			DatagramPacket dp=new DatagramPacket(buf,buf.length);
			while(true){
				ds.receive(dp);
				
				ByteArrayInputStream bis=new ByteArrayInputStream(buf);
				DataInputStream dis=new DataInputStream(bis);
				System.out.println(dis.readLong());
				
				//System.out.println(new String(buf,0,dp.getLength()));
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
