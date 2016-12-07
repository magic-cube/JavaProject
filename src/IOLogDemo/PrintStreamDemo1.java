package IOLogDemo;
import java.io.*;

import java.util.Date;
/**
 * PrintWriter
 * 日志文件
 * 从键盘输入
 * 每写一次，以exit结束，结束后，系统会记录当前的时间并输出到日志文件的最下方
 * 必须保留上次记录，true
 * @author hc
 *
 */
public class PrintStreamDemo1 {
	public static void main(String args[]){
		//System.in  是InputStream的子类
		//因为要用System.in才用的InputStreamReader  接受一个inputStream
		InputStreamReader isr =new InputStreamReader(System.in);
		BufferedReader br= new BufferedReader(isr);
		try{
			FileWriter fw =new FileWriter("C:/my/MyLog.txt",true);
			PrintWriter log=new PrintWriter(fw);
			
			String s=null;
			while((s=br.readLine())!=null){
				if(s.equalsIgnoreCase("exit")){
					break;
				}
				//System.out.println(s.toUpperCase());
				log.println("-----\n");
				//log.println(s.toUpperCase());
				log.println(s);
				log.flush();
			}
			log.println("-----\n");
			log.println("======"+new Date()+"======");
			log.flush();
			log.close();
		}catch(IOException e){
			System.out.println("咦！有猫饼！");
		}
	}
}
