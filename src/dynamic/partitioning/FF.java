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
	List<IdlePartition> list = new LinkedList<IdlePartition>();
	int number;  //�հ׷�������
	public void printInfo(){
		Scanner in = new Scanner(System.in);
		System.out.println("������հ׷����ĸ�����");
		number=in.nextInt();
		System.out.println("��������������ÿ���հ׷����Ĵ�С��ϵͳ�ᰴ������˳�򽫿հ׷�������հ׷������У�");
		for(int i=0;i<number;i++){
			IdlePartition temp =Factory();
			temp.size=in.nextInt();
			list.add(temp);
		}
		
		//���������鿴list�е�����
		Iterator<IdlePartition> it=list.iterator();
		while(it.hasNext()){
			IdlePartition temp=it.next();
			System.out.print(temp.size+"--->");
		}
	}
	
	//������
	public IdlePartition Factory(){
		return new IdlePartition();
	}
	
	public void find(){
		
	}
	
	public static void main(String[] args) {
		FF f = new FF();
		f.printInfo();
		

	}

}
