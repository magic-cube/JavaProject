package dynamic.partitioning;
/**
 * ��̬���������㷨
 * �״���Ӧ�㷨
 * Ҫ����з������Ե�ַ�����Ĵ������ӣ������ڴ�ʱ�������׿�ʼ���ң�ֱ���ҵ�һ����С������Ҫ��Ŀ��з���
 * ������ҵ�Ĵ�С���Ӹ÷�������һ���ڴ�ռ�������ߣ������¿ռ������ڿ�������
 * �������׵���β�������ҵ�һ��������Ҫ��ķ�������˴��ڴ����ʧ��
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FF {
	//���з�����
	static List<IdlePartition> list = new LinkedList<IdlePartition>();
	List<Integer> li = new ArrayList<Integer>(); //��ҵ��С
	int number;  //�հ׷�������
	//int Plength;	//��ҵ�ĳ���
	int n; //��ҵ�ĸ���
	int g;  //����G
	public void printInfo(){
		Scanner in = new Scanner(System.in);
		System.out.println("���������G��С��");
		g=in.nextInt();
		System.out.println("��������ҵ������");
		n=in.nextInt();
		System.out.println("����������ÿ����ҵ�Ĵ�С��");
		for(int i=0;i<n;i++){
			li.add(in.nextInt());
		}
		
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
	/*
	 * �״���Ӧ�㷨
	 */
	public void find(){
		int PSize;//��ҵ��С
		int KSize;//���з�����С
		for(int j=0;j<li.size();j++){
			PSize=li.get(j);
			for(int i=0;i<list.size();i++){
				KSize=list.get(i).size;
				if(PSize<=KSize){
					if(KSize-PSize>=g){
						(list.get(i).sysize)-=PSize;
						break;
					}else{
						list.get(i).sysize=0;
						break;
					}
				}
			}
		}
	}
	/*
	 * ѭ���״���Ӧ�㷨
	 */
	public void find2(){
		int PSize;//��ҵ��С
		int KSize;//���з�����С
		int index=-1; //��¼�ϴ��ϴ��ڿ��з������з����λ��
	
		for(int j=0;j<li.size();j++){
			index++;
			if(index==list.size()-1){
				index=0;
			}
			PSize=li.get(j);
			for(int i=index;i<list.size();i++){
				KSize=list.get(i).size;
				if(PSize<=KSize){
					if(KSize-PSize>=g){
						(list.get(i).sysize)-=PSize;
						index=i+1;
						if(index==list.size()-1){
							i=0;
						}
						break;
					}else{
						list.get(i).sysize=0;
						index=i+1;
						if(index==list.size()-1){
							i=0;
						}
						break;
					}
				}
			}
		}
	}
	public static void menu(){
		Scanner in= new Scanner(System.in);
		FF f = new FF();
		f.printInfo();
		System.out.println("��ѡ��Ҫʹ�õķ����㷨��");
		System.out.println("1.�״���Ӧ�㷨");
		System.out.println("2.ѭ���״���Ӧ�㷨");
		System.out.println("3.�����Ӧ�㷨");
		System.out.println("4.���Ӧ�㷨");
		int x=in.nextInt();
		switch(x){
			case 1:f.find(); break;
			case 2:f.find2();; break;
	//		case 1:f.find(); break;
	//		case 1:f.find(); break;
			
		}
		System.out.println("���з�����ʣ�������");
		for(IdlePartition i:list){
			System.out.print(i.sysize+"---->");
		}
	}
	
	public static void main(String[] args) {
		menu();
	}

}
