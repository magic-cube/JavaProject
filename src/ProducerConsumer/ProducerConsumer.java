package ProducerConsumer;
/**
 * ������
 * @author hc
 *
 */
public class ProducerConsumer {
	public static void main(String args[]){
		SynStack ss=new SynStack();
		//ʹ��ͬһ��������
		Producer p=new Producer(ss);
		Consumer c=new Consumer(ss);
		//һ�������ߣ�һ�������ߵ����
		Thread p1=new Thread(p);
		p1.start();
		Thread c1=new Thread(c);
		try{
			c1.sleep(500);
		}catch(Exception e){
			e.printStackTrace();
		}
		c1.start();
	}
}
