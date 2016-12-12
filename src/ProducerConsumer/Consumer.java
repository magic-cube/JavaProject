package ProducerConsumer;
/**
 * 消费者类
 * 线程类，会有很多消费者访问，需对缓冲区进行互斥访问
 * @author hc
 *
 */
public class Consumer implements Runnable{
	SynStack ss=null;
	Consumer(SynStack ss){
		this.ss=ss;
	}
	public void run(){
		for(int i=0;i<20;i++){
			ss.pop();
			System.out.println("消费者正在从缓冲区中放拿"+i+"个窝头...");
			try{
				Thread.sleep(500);
			}catch(InterruptedException  e){
				e.printStackTrace();
			}
		}
	}
}
