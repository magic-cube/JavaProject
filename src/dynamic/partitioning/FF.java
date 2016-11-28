package dynamic.partitioning;
import java.util.Iterator;
/**
 * ��̬���������㷨
 * �״���Ӧ�㷨
 * Ҫ����з������Ե�ַ�����Ĵ������ӣ������ڴ�ʱ�������׿�ʼ���ң�ֱ���ҵ�һ����С������Ҫ��Ŀ��з���
 * ������ҵ�Ĵ�С���Ӹ÷�������һ���ڴ�ռ�������ߣ������¿ռ������ڿ�������
 * �������׵���β�������ҵ�һ��������Ҫ��ķ�������˴��ڴ����ʧ��
 */
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FF {
	//���з�����
	static List<IdlePartition> list = new LinkedList<IdlePartition>();
	int number;  //�հ׷�������
	int Plength;
	public void printInfo(){
		Scanner in = new Scanner(System.in);
		System.out.println("��������ҵ��С��");
		Plength=in.nextInt();
		System.out.println("������հ׷����ĸ�����");
		number=in.nextInt();
		System.out.println("��������������ÿ���հ׷����Ĵ�С��ϵͳ�ᰴ������˳�򽫿հ׷�������հ׷������У�");
		for(int i=0;i<number;i++){
			
			int a=in.nextInt();
			IdlePartition temp =Factory(a);
			list.add(temp);
		}
		
		//���������鿴list�е�����
		Iterator<IdlePartition> it=list.iterator();
		System.out.println("���з����������");
		while(it.hasNext()){
			IdlePartition temp=it.next();
			System.out.print(temp.size+"--->");
		}
		System.out.println();
	}
	
	//������
	public IdlePartition Factory(int a){
		return new IdlePartition(a);
	}
	
	//����Ѱ�ҵ�һ�����������Ľ��
	public void find(){
		for(int i=0;i<list.size();i++){
			if(Plength<=list.get(i).size){
				(list.get(i).ssize)-=Plength;
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		FF f = new FF();
		f.printInfo();
		f.find();
		System.out.println("���з�����ʣ�������");
		for(IdlePartition i:list){
			System.out.print(i.ssize+"---->");
		}
	}

}
