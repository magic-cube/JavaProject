package ProducerConsumer;
/**
 * 生产者类
 * 线程类，很多生产者都会来生产，需互斥访问缓冲区
 * @author hc
 *
 */
public class Producer implements Runnable{
	SynStack ss=null;
	Producer(SynStack ss){
		this.ss=ss;
	}
	public void run(){
		for(int i=0;i<20;i++){
			WoTou w=new WoTou(i);
			ss.push(w);
			System.out.println("生产者正在向缓冲区中放第"+i+"个窝头...");
			try{
				Thread.sleep(500);
			}catch(InterruptedException  e){
				e.printStackTrace();
			}
		}
	}
}
