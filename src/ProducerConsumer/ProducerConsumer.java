package ProducerConsumer;
/**
 * ������
 * @author hc
 *
 */
public class ProducerConsumer {
	public static void main(String args[]){
		SynStack ss=new SynStack();
		Producer p=new Producer(ss);
		Consumer c=new Consumer(ss);
		//һ�������ߣ�һ�������ߵ����
		new Thread(p).start();
		new Thread(c).start();
	}
}
