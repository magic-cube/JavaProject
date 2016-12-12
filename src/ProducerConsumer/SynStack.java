package ProducerConsumer;
/**
 * ���⻺����
 * @author hc
 *
 */
public class SynStack {
	int index=0;
	
	//���ƻ��������洢��Ϊ6
	WoTou [] arrWT=new WoTou[6];
	
	//ȡ��������л������
	public synchronized void push(WoTou w){
		//�����������д���
		if(index==arrWT.length){
			try{
				//��������������
				this.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		//����һ����ʱwait���Ҷ����ϵ��߳�
		this.notify();
		
		arrWT[index]=w;
		index++;
	}
	public synchronized WoTou pop(){
		//�������ս��д���
		if(index==0){
			try{
				//�������գ�����
				this.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		//���Ѵ�ʱwait���Ҷ����ϵ��߳�
		this.notify();
		
		index--;
		return arrWT[index];
	}
}
