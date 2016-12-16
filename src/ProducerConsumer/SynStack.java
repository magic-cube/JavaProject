package ProducerConsumer;
/**
 * 
 * 互斥缓冲区
 * @author hc
 *
 */
public class SynStack {
	int index=0;
	
	//限制缓冲区最大存储量为6
	WoTou [] arrWT=new WoTou[6];
	
	//取和拿需进行互斥访问
	public synchronized void push(WoTou w){
		//缓冲区满进行处理
		if(index==arrWT.length){
			try{
				//缓冲区满，等着
				this.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		/*
		 * 正常执行情况应该是：
		 * 		if缓冲区满：wait
		 * 		else（不满）notify
		 * 1.没有消费者的话，生产者先生产至缓冲区满，然后申请放，发现缓冲区还是满的，只能一直wait		（消费者同理）
		 * 2.生产者生产至缓冲区满，申请放，满的话wait，等待消费者消费，消费者消费过后缓冲区不满，此时执行notify，按此过程执行
		 * 	 （消费者同理）
		 */
		
		/*
		 * 叫醒一个此时wait在我对象上的线程
		 * 如果注释掉this.notify
		 * 如果生产满了，让此进程wait()，等待消费者消费之后,叫醒该线程，
		 * 消费者消费完了，wait()，等待生产者生产，结果发现此时生产者也在等待，两者陷入死等
		 * （如果未叫醒，则此进程一直wait下去，大家都执行不了）
		 * 这也是一种死锁
		 * 缓冲区空同理
		 */
		this.notify();
		
		arrWT[index]=w;
		index++;
	}
	public synchronized WoTou pop(){
		//缓冲区空进行处理
		if(index==0){
			try{
				//缓冲区空，等着
				this.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		//叫醒此时wait在我对象上的线程
		this.notify();
		
		index--;
		return arrWT[index];
	}
}
