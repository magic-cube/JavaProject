package Process1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class TimeTurn {
	private static final int TIME_SLICE=1;
	private int timeCount;   //ʱ������������ʱ��
	List<Process>  list = new ArrayList<Process>();
	
	List<Process> anotherList= new ArrayList<Process>();        //�½���list�����Ա����Ǽ�������
	
//	Process p1,p2,p3,p4,p5;
//	//��ʼ��     ԭʼ�汾
//	public void init(){
//		p1=new Process("p1",4,0);
//		p2=new Process("p2",3,1);
//		p3=new Process("p3",4,2);
//		p4=new Process("p4",2,3);
//		p5=new Process("p5",4,4);
//		
//		
//		p1.setNext(p2);
//		p2.setNext(p3);
//		p3.setNext(p4);
//		p4.setNext(p5);
//		p5.setNext(p1);
//		
//		//��ӵ����̶���
//		Process temp=p1;
//		while(!list.contains(temp)){
//			list.add(temp);
//			temp=temp.next;
//		}
//	}
	
//	public void waitArrive(Process p,int i){
//		p=list.get(i);
//		while((p.arriveTime+1)!=((p.next).arriveTime)){
//			p.alTime++;
//			timeCount++;
//		}
//	}
	//����ʱ��Ƭ�ڵ�ִ�й���
	public void run(int i){
		Process p =list.get(i);
		
		//p.setServiceTime(p.getServiceTime()-TIME_SLICE);	//����ʱ���ȥʱ��Ƭ 
		
		//�����һ�����̵���ʱ�����һ��ʱ��Ƭ�� ��������һ�����̵���ʱ��   ʱ�������ÿ�μ���һ��ʱ��Ƭ��֪�����
//		while((p.getArriveTime()+TIME_SLICE)!=p.next.getArriveTime()){
//			p.setArriveTime(p.getArriveTime()+TIME_SLICE);
//			//timeCount+=TIME_SLICE;
//		}
//		while((p.arriveTime+1)!=((p.next).arriveTime)){
//			p.arriveTime++;
//			timeCount++;
//		}

//
//		if(p.serviceTime-p.alTime<TIME_SLICE){
//			int a=p.serviceTime-p.alTime;
//			p.alTime+=a;
//			timeCount+=a;
//		}else{
			timeCount+=TIME_SLICE;              //ʱ�������++
			p.setAlTime(p.getAlTime()+TIME_SLICE);             //������ʱ���ʱ��Ƭ
//		}
		
		Process temp =list.remove(i);          //��list��ɾ���±�Ϊi��Ԫ��   ���������Ԫ��
		if(p.getAlTime()!=p.getServiceTime()){
			
			System.out.println("��ǰִ�еĽ���Ϊ��"+temp.getName());
			//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			for(int j=0;i<anotherList.size();j++){
				Process p1=anotherList.get(i);
				if(timeCount==p1.arriveTime){
					list.add(p1);
				}
			}
			
			//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				list.add(temp);
			
		}else{     //���������ʱ�䲻���ڷ���ʱ��
			System.out.println();
			System.out.println("���̣�"+temp.getName()+"�Ѿ�ִ����ϣ�����");
			System.out.println("���ʱ��Ϊ��"+timeCount);
			System.out.println("��תʱ��Ϊ��"+(timeCount-temp.getArriveTime()));
			System.out.println("��Ȩ��תʱ��Ϊ��"+(timeCount/temp.getServiceTime()));
			System.out.println();
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
			if(list.indexOf(p)<list.size()){
				if(p.getArriveTime()+TIME_SLICE<p.next.arriveTime){
					p.arriveTime++;
					timeCount++;
				}else{
					this.run(a);
				}
			}
			//this.run(a);
		}
	}
	
	//--------------------------------------------------------------------------------------------------
	public void printInfo(){
		
		Scanner in = new Scanner(System.in);
		System.out.println("������Ҫ��ӵĽ��̸�����");
		int number=in.nextInt();
		for(int i=0;i<number;i++){
			System.out.print("�������������"+" ");
			String name=in.next();
			System.out.print("���������ʱ�䣺"+" ");
			int serviceTime=in.nextInt();
			System.out.print("�����뵽��ʱ�䣺"+" ");
			int arriveTime=in.nextInt();
			
			//ÿ����һ�Σ����ù����࣬�������󲢸�ֵ
			Process p=Pfactory(name,serviceTime,arriveTime);
			
			//��������̶���
			list.add(p);
			anotherList.add(p);
		}
		
		//���ԣ����Բ鿴��ӽ�ȥ������
//		for(Process p:list){
//			System.out.println(p.name+" "+p.arriveTime);
//		}
		
		//����next
		for(int i=0;i<number;i++){
//			list.get(i).setNext(list.get(i+1));
//			if(i==number-1){
//				list.get(number-1).setNext(list.get(0));
//			}
			while(i<=number-1){
				//ָ��������һ����˭
				if(i==number-1){
					list.get(number-1).setNext(list.get(0));
				}else{
					list.get(i).setNext(list.get(i+1));
				}
				i++;
			}
		}
//		p1=new Process("p1",4,0);
//		p2=new Process("p2",3,1);
//		p3=new Process("p3",4,2);
//		p4=new Process("p4",2,3);
//		p5=new Process("p5",4,4);
//		
//		
//		p1.setNext(p2);
//		p2.setNext(p3);
//		p3.setNext(p4);
//		p4.setNext(p5);
//		p5.setNext(p1);
//		
//		//��ӵ����̶���
//		Process temp=p1;
//		while(!list.contains(temp)){
//			list.add(temp);
//			temp=temp.next;
//		}
	}
	//-------------------------------------------------------------------------------
	//�����࣬���ڴ���Process����
	public Process Pfactory(String name,int serviceTime,int arrivTime){
		return new Process(name,serviceTime,arrivTime);
	}
	//--------------------------------------------------------------------------------------------------
	public static void main(String args[]){
		TimeTurn t= new TimeTurn();
//		String s=in.next();
//		int ser=in.nextInt();
//		int arr=in.nextInt();

		t.printInfo();
		//t.init();
		t.processRun();
	}
	
	
	
}
