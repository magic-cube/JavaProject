package ProducerConsumer;
/**
 * 测试类
 * @author hc
 *
 */
public class ProducerConsumer {
	public static void main(String args[]){
		SynStack ss=new SynStack();
		//使用同一个缓冲区
		Producer p=new Producer(ss);
		Consumer c=new Consumer(ss);
		//一个生产者，一个消费者的情况
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
