package IOLogDemo;
import java.io.*;

import java.util.Date;
/**
 * PrintWriter
 * ��־�ļ�
 * �Ӽ�������
 * ÿдһ�Σ���exit������������ϵͳ���¼��ǰ��ʱ�䲢�������־�ļ������·�
 * ���뱣���ϴμ�¼��true
 * @author hc
 *
 */
public class PrintStreamDemo1 {
	public static void main(String args[]){
		//System.in  ��InputStream������
		//��ΪҪ��System.in���õ�InputStreamReader  ����һ��inputStream
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
			System.out.println("�ף���è����");
		}
	}
}
