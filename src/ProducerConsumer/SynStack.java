package ProducerConsumer;
/**
 * 
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
		/*
		 * ����ִ�����Ӧ���ǣ�
		 * 		if����������wait
		 * 		else��������notify
		 * 1.û�������ߵĻ���������������������������Ȼ������ţ����ֻ������������ģ�ֻ��һֱwait		��������ͬ��
		 * 2.��������������������������ţ����Ļ�wait���ȴ����������ѣ����������ѹ��󻺳�����������ʱִ��notify�����˹���ִ��
		 * 	 ��������ͬ��
		 */
		
		/*
		 * ����һ����ʱwait���Ҷ����ϵ��߳�
		 * ���ע�͵�this.notify
		 * ����������ˣ��ô˽���wait()���ȴ�����������֮��,���Ѹ��̣߳�
		 * �������������ˣ�wait()���ȴ�������������������ִ�ʱ������Ҳ�ڵȴ���������������
		 * �����δ���ѣ���˽���һֱwait��ȥ����Ҷ�ִ�в��ˣ�
		 * ��Ҳ��һ������
		 * ��������ͬ��
		 */
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
