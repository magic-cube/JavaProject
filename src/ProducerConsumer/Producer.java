package ProducerConsumer;
/**
 * ��������
 * �߳��࣬�ܶ������߶������������軥����ʻ�����
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
			System.out.println("�����������򻺳����зŵ�"+i+"����ͷ...");
			try{
				Thread.sleep(500);
			}catch(InterruptedException  e){
				e.printStackTrace();
			}
		}
	}
}
