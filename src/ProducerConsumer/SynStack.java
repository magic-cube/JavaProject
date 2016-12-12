package ProducerConsumer;
/**
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
		//叫醒一个此时wait在我对象上的线程
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
