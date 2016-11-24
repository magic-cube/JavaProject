package Process1;

import java.util.ArrayList;
import java.util.List;



public class TimeTurn {
	private static final int TIME_SLICE=1;
	private int timeCount;   //ʱ������������ʱ��
	List<Process>  list = new 
	ArrayList<Process>();
	Process p1,p2,p3,p4,p5;
	//��ʼ��
	public void init(){
		p1=new Process("p1",4,0);
		p2=new Process("p2",3,1);
		p3=new Process("p3",4,2);
		p4=new Process("p4",2,3);
		p5=new Process("p5",4,4);
		
		p1.setNext(p2);
		p2.setNext(p3);
		p3.setNext(p4);
		p4.setNext(p5);
		p5.setNext(p1);
		
		//��ӵ����̶���
		Process temp=p1;
		while(!list.contains(temp)){
			list.add(temp);
			temp=temp.next;
		}
	}
	
	//����ʱ��Ƭ�ڵ�ִ�й���
	public void run(int i){
		Process p =list.get(i);
		p.setAlTime(p.getAlTime()+TIME_SLICE);             //������ʱ���ʱ��Ƭ
		//p.setServiceTime(p.getServiceTime()-TIME_SLICE);	//����ʱ���ȥʱ��Ƭ 
		
		//�����һ�����̵���ʱ�����һ��ʱ��Ƭ�� ��������һ�����̵���ʱ��   ʱ�������ÿ�μ���һ��ʱ��Ƭ��֪�����
//		while((p.getArriveTime()+TIME_SLICE)!=p.next.getArriveTime()){
//			p.setArriveTime(p.getArriveTime()+TIME_SLICE);
//			//timeCount+=TIME_SLICE;
//		}
//		while((p.arriveTime+1)!=p.next.arriveTime){
//			p.arriveTime++;
//			timeCount++;
//		}
		
		timeCount+=TIME_SLICE;              //ʱ�������++
		
		Process temp =list.remove(i);          //��list��ɾ���±�Ϊi��Ԫ��   ���������Ԫ��
		if(p.getAlTime()!=p.getServiceTime()){
			System.out.println("��ǰִ�еĽ���Ϊ��"+temp.getName());
			list.add(temp);
		}else{     //���������ʱ�䲻���ڷ���ʱ��
			System.out.println("���̣�"+temp.getName()+"�Ѿ�ִ����ϣ�����");
			System.out.println("���ʱ��Ϊ��"+timeCount);
		}
		
		
		if(list.size()>0){
			System.out.print("��ʱlist��ֵ��");
			for(int j=0;j<list.size();j++){
				System.out.print(list.get(j).getName()+" ");
			}
				System.out.println();
		}else{
			System.out.println("���̶���Ϊ�գ�");
		}
		
	}
	public int getNext(Process current,List<Process> list){
		Process next = current.getNext();
		int t=0;;
		while(!list.contains(next)){
		next=next.getNext();
		t=list.indexOf(next);
		}
		return t;  
	}
	public void processRun(){
		Process p=list.get(0);
		run(0);
//		while(list.size()>0){
//			int a=list.indexOf(p.next);
//			run(a);
//		}
		while(list.size()>0){

			int a = this.getNext(p, list);
			p = this.list.get(a);
			this.run(a);
		}
	}
	
	
	
	
	public static void main(String args[]){
		TimeTurn t= new TimeTurn();
		t.init();
		t.processRun();
	}
	
	
	
}
