package ProducerConsumer;
/**
 * ��������
 * �߳��࣬���кܶ������߷��ʣ���Ի��������л������
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
			System.out.println("���������ڴӻ������з���"+i+"����ͷ...");
			try{
				Thread.sleep(500);
			}catch(InterruptedException  e){
				e.printStackTrace();
			}
		}
	}
}
