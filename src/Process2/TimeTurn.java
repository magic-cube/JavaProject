package Process2;
/**
 * ����ʱ��Ƭ����ת�����㷨
 * ��������
 * -------
 * a 0 4
 * b 1 3
 * c 2 4
 * d 3 2
 * e 4 4
 * -------
 * ������  ���ʱ��
 * ---
 * a 12
 * b 10 
 * c 16 
 * d 11
 * e 17
 * -----
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TimeTurn {
	
	int timeCount;   //ʱ�������
	int timePice;	//ʱ��Ƭ
	int number;
	
	List<Process2> list= new ArrayList<Process2>();      //��������
	
	List<Process2> list2=new ArrayList<Process2>();		//�������̵�list
	
	
	//��ʼ��
	public void printInfo(){
		Scanner in = new Scanner(System.in);
		System.out.println("������ʱ��Ƭ�Ĵ�С��");
		timePice=in.nextInt();
		System.out.println("������Ҫ��ӵĽ��̸�����");
		number=in.nextInt();
		for(int i=0;i<number;i++){
			System.out.print("������������̵�  ������  ����ʱ��   ����ʱ��"+" ");
			String name=in.next();
			int arriveTime=in.nextInt();
			int serviceTime=in.nextInt();

			//ÿ����һ�Σ����ù����࣬�������󲢸�ֵ
			Process2 p=Pfactory(name,arriveTime,serviceTime);
			
			list2.add(p);
		}	
			//���ԣ����Բ鿴��ӽ�ȥ������
//			for(Process2 p:list2){
//				System.out.println(p.name+" "+p.arriveTime);
//			}
	}

	//-------------------------------------------------------------------------------
	//�����࣬���ڴ���Process����
	public Process2 Pfactory(String name,int arriveTime,int serviceTime){
		return new Process2(name,arriveTime,serviceTime);
	}
	//����
	public int find(){
		for(int i=0;i<list2.size();i++){
			if(list2.get(i).state!=true){
				if(timeCount==list2.get(i).arriveTime){
					list2.get(i).state=true;
					return i;
				}/*else{
					timeCount++;
				}*/
			}
		}
		return 0;
	}
	
	//�����ȷ���   listĿǰΪ��
	//ֻ�������޴�����ֱ�����н��̶�����
	public void FirstCome(){
		//ͷ���
		//list.add(list2.get(find()));
		
		/*
		 *���赽��ʱ���Ѿ������õ�һ��������� 
		 */
		list.add(list2.get(0));
		timeCount=list.get(0).arriveTime;
		//
		for(int i=1;i<number;i++){
			//ͷ����
			Process2 p=list.remove(0);
			if(p.serviceTime-p.alTime<timePice){
				int a=p.serviceTime-p.alTime;
				timeCount+=a;
				p.alTime+=a;
			}else{
				timeCount+=timePice;
				p.alTime+=timePice;
			}
			if(p.alTime<p.serviceTime){         //δִ����
				//ƥ�����
				list.add(list2.get(find()));
				/*
				 * 
				 */

				//ͷ���
				list.add(p);
			
				
				
			}else{           //ִ������
				System.out.println("....");
//				System.out.println("���̣�"+p.name+"�Ѿ�ִ�����");
//				System.out.println("���ʱ��Ϊ��"+timeCount);
//				System.out.println("��תʱ��Ϊ��"+(timeCount-p.arriveTime));
//				System.out.println("��Ȩ��תʱ��Ϊ��"+(timeCount/p.serviceTime));
//				System.out.println();
				//ƥ�����
//				list.add(list2.get(find()));
			}
		}
		for(Process2 p:list){
			System.out.println(p.name);
		}
	}
	//ʱ��Ƭ��ת
	public void run(){
		while(list.size()>0){
			Process2 temp=list.remove(0);
			if(temp.serviceTime-temp.alTime<timePice){
				int a=temp.serviceTime-temp.alTime;
				timeCount+=a;
				temp.alTime+=a;
			}else{
				timeCount+=timePice;              //ʱ�������++
				temp.alTime+=timePice;             //������ʱ���ʱ��Ƭ
			}
			if(temp.alTime<temp.serviceTime){
				System.out.println("��ǰ���еĽ����ǣ�"+temp.name);
				list.add(temp);
			}else{
				System.out.println();
				System.out.println("���̣�"+temp.name+"��ִ�����");
				System.out.println("���ʱ��Ϊ��"+timeCount);
				System.out.println("��תʱ��Ϊ��"+(timeCount-temp.arriveTime));
				System.out.println("��Ȩ��תʱ��Ϊ��"+(timeCount/temp.serviceTime));
				System.out.println();
			}
		}
	}
	public static void main(String[] args) {
		TimeTurn t = new TimeTurn();
		t.printInfo();
		t.FirstCome();
		t.run();
		
	}

}
