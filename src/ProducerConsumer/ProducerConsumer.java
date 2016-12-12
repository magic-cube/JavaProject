package ProducerConsumer;
/**
 * 测试类
 * @author hc
 *
 */
public class ProducerConsumer {
	public static void main(String args[]){
		SynStack ss=new SynStack();
		Producer p=new Producer(ss);
		Consumer c=new Consumer(ss);
		//一个生产者，一个消费者的情况
		new Thread(p).start();
		new Thread(c).start();
	}
}
