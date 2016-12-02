package dynamic.partitioning;
/**
 * ��̬���������㷨
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FF {
	//���з�����
	static List<IdlePartition> list = new LinkedList<IdlePartition>();
//	List<Integer> li = new ArrayList<Integer>(); //��ҵ��С
	int number;  //�հ׷�������
	int index=-1; //��¼�ϴ��ϴ��ڿ��з������з����λ��
	//int Plength;	//��ҵ�ĳ���
//	int n; //��ҵ�ĸ���
	int g;  //����G
	public void printInfo(){
		Scanner in = new Scanner(System.in);
		System.out.println("���������G��С��");
		g=in.nextInt();
//		System.out.println("��������ҵ������");
//		n=in.nextInt();
//		System.out.println("����������ÿ����ҵ�Ĵ�С��");
//		for(int i=0;i<n;i++){
//			li.add(in.nextInt());
//		}
		
		System.out.println("������հ׷����ĸ�����");
		number=in.nextInt();
		System.out.println("��������������ÿ���հ׷����Ĵ�С����ʼ��ַ��");
		for(int i=0;i<number;i++){
			
			int a=in.nextInt();
			int address=in.nextInt();
			IdlePartition temp =Factory(a,address);
			
			list.add(temp);
		}
		
		//���������鿴list�е�����
//		Iterator<IdlePartition> it=list.iterator();
//		System.out.println("���з����������");
//		while(it.hasNext()){
//			IdlePartition temp=it.next();
//			System.out.print(temp.size+"--->");
//		}
//		System.out.println();
	}
	
	//������
	public IdlePartition Factory(int a,int address){
		return new IdlePartition(a,address);
	}
	
	//����Ѱ�ҵ�һ�����������Ľ��
	/*
	 * �״���Ӧ�㷨
	 * Ҫ����з������Ե�ַ�����Ĵ������ӣ������ڴ�ʱ�������׿�ʼ���ң�ֱ���ҵ�һ����С������Ҫ��Ŀ��з���
	 * ������ҵ�Ĵ�С���Ӹ÷�������һ���ڴ�ռ�������ߣ������¿ռ������ڿ�������
	 * �������׵���β�������ҵ�һ��������Ҫ��ķ�������˴��ڴ����ʧ��
	 */
	public void find(int plength){
		int PSize=plength;//��ҵ��С
		int KSize;//���з�����С
		
		sort3(list);
		
//		for(int j=0;j<li.size();j++){
//			PSize=li.get(j);
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
//		}

		System.out.println("���з����������");
		for(IdlePartition i:list){
			System.out.print(i.size+"---->");
		}
		System.out.println();
	}
	/*
	 * ѭ���״���Ӧ�㷨
	 * NF�㷨�����״���Ӧ�㷨�ݱ��������Ϊ���̷����ڴ�ʱ��������ÿ�ζ������׿�ʼ����
	 * ���Ǵ��ϴ��ҵ��Ŀ��з�������һ�����з�����ʼ���ң�ֱ���ҵ�һ��������Ҫ��Ŀ��з�����
	 * ���л���һ���������С��ȵ��ڴ�ռ�������ҵ
	 */
	public void find2(int plength){
		int PSize=plength;//��ҵ��С
		int KSize;//���з�����С
		
		sort3(list);
//		for(int j=0;j<li.size();j++){
			index+=1;
			if(index==list.size()-1){
				index=0;
			}
//			PSize=li.get(j);
			for(int i=index;i<list.size();i++){
				KSize=list.get(index).size;
				if(PSize<=KSize){
					if(KSize-PSize>=g){
						(list.get(index).sysize)-=PSize;
						i=i+1;
						if(index==list.size()-1){
							i=0;
						}
						break;
					}else{
						list.get(index).sysize=0;
						i=i+1;
						if(index==list.size()-1){
							i=0;
						}
						break;
					}
				}
			}
//		}
		Iterator<IdlePartition> it=list.iterator();
		System.out.println("���з����������");
		while(it.hasNext()){
			IdlePartition temp=it.next();
			System.out.print(temp.size+"--->");
		}
		System.out.println();
	}
	/*
	 * �����Ӧ�㷨
	 * BT�㷨��ÿ��Ϊ��ҵ�����ڴ�ʱ�����ǰ�������Ҫ��ģ�������С�Ŀ��з����������ҵ
	 * ���⡰���С�á���Ϊ����Ѱ�ң����㷨Ҫ�����еĿ��з��������������ԴӴ�С��˳���γ�һ�����з�����
	 * ��������һ���ҵ���������Ҫ��Ŀ��з�������Ȼ����ѵ�
	 * ����ͦ�ã����Ӻ�۽Ƕȣ�ÿ���и�������ʣ�ಿ��������С�ģ��������ڴ洢������������������õ�С������
	 */
	public void find3(int plength){
		//�ֽ����з�������С��������
		sort1(list);
		int PSize=plength;//��ҵ��С
		int KSize;//���з�����С
//		for(int j=0;j<li.size();j++){
//			PSize=li.get(j);
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
			//ÿ����һ�η��䣬����������з�����
			sort1(list);
//		}
//		Iterator<IdlePartition> it=list.iterator();
		System.out.println("���з����������");
//		while(it.hasNext()){
//			IdlePartition temp=it.next();
//			System.out.print(temp.size+"--->");
//		}
		for(IdlePartition id:list){
			System.out.print(id.size+"-->");
		}
		System.out.println();
		
		
		//����ֱ�ӵ���fian1������
		//find1();
	}
	
	/*
	 * ���Ӧ�㷨
	 */
	public void find4(int plength){
		sort2(list);
		int PSize=plength;//��ҵ��С
		int KSize;//���з�����С
//		for(int j=0;j<li.size();j++){
//			PSize=li.get(j);
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
			//ÿ����һ�η��䣬����������з�����
			sort2(list);
//		}
		Iterator<IdlePartition> it=list.iterator();
		System.out.println("���з����������");
		while(it.hasNext()){
			IdlePartition temp=it.next();
			System.out.print(temp.size+"--->");
		}
		System.out.println();
	}
	/*
	 * ����ʼ��ַ��С��������
	 */
	public static void sort3(List<IdlePartition> list){
		IdlePartition idl= new IdlePartition();
		for(int j=1;j<list.size();j++){
			for(int i=0;i<list.size()-j;i++){
				//��������
//				boolean sorted=true;
				if(list.get(i).address>list.get(i+1).address){
					
					//�������з�����С
					int temp=list.get(i).size;
					list.get(i).size=list.get(i+1).size;
					list.get(i+1).size=temp;
					
					//�������з�����С��ͬʱ��Ҳ���뽻��ʣ����з�����С
					int temp2=list.get(i).sysize;
					list.get(i).sysize=list.get(i+1).sysize;
					list.get(i+1).sysize=temp;
					
					int temp3=list.get(i).address;
					list.get(i).address=list.get(i+1).address;
					list.get(i+1).address=temp;
					
					//sorted=false;   //����������
				}
//				if(sorted){ // δ����������
//					break;
//				}
			}
		}
		
	}
	/*
	 * ����ʼ��ַ�Ӵ�С����
	 */
	public static void sort4(List<IdlePartition> list){
		IdlePartition idl= new IdlePartition();
		for(int j=0;j<list.size();j++){
			for(int i=0;i<list.size()-j;i++){
				//��������
				boolean sorted=true;
				if(list.get(i).address<list.get(i+1).address){
					
					//�������з�����С
					int temp=list.get(i).size;
					list.get(i).size=list.get(i+1).size;
					list.get(i+1).size=temp;
					
					//�������з�����С��ͬʱ��Ҳ���뽻��ʣ����з�����С
					int temp2=list.get(i).sysize;
					list.get(i).sysize=list.get(i+1).sysize;
					list.get(i+1).sysize=temp;
					
					sorted=false;   //����������
				}
				if(sorted){ // δ����������
					break;
				}
			}
		}
		
	}
	/*
	 * ���з��������򣬴�С����
	 */
	public static void sort1(List<IdlePartition> list){
		IdlePartition idl= new IdlePartition();
		for(int j=0;j<list.size();j++){
			for(int i=0;i<list.size()-j;i++){
				//��������
				boolean sorted=true;
				if(list.get(i).size>list.get(i+1).size){
					
					//�������з�����С
					int temp=list.get(i).size;
					list.get(i).size=list.get(i+1).size;
					list.get(i+1).size=temp;
					
					//�������з�����С��ͬʱ��Ҳ���뽻��ʣ����з�����С
					int temp2=list.get(i).sysize;
					list.get(i).sysize=list.get(i+1).sysize;
					list.get(i+1).sysize=temp;
					
					sorted=false;   //����������
				}
				if(sorted){ // δ����������
					break;
				}
			}
		}
		
	}
	/*
	 * ���з��������򣬴Ӵ�С
	 */
	public static void sort2(List<IdlePartition> list){
		IdlePartition idl= new IdlePartition();
		for(int j=1;j<list.size();j++){
			for(int i=0;i<list.size()-j;i++){
				//��������
				boolean sorted=true;
				if(list.get(i).size<list.get(i+1).size){
					
					//�������з�����С
					int temp=list.get(i).size;
					list.get(i).size=list.get(i+1).size;
					list.get(i+1).size=temp;
					
					//�������з�����С��ͬʱ��Ҳ���뽻��ʣ����з�����С
					int temp2=list.get(i).sysize;
					list.get(i).sysize=list.get(i+1).sysize;
					list.get(i+1).sysize=temp;
					
					sorted=false;   //����������
				}
				if(sorted){ // δ����������
					break;
				}
			}
		}
		
	}
	
	public static void menu(){
		Scanner in= new Scanner(System.in);
		FF f = new FF();
		f.printInfo();
		while(true){
			System.out.println("��ѡ��Ҫʹ�õķ����㷨��");
			System.out.println("1.�״���Ӧ�㷨");
			System.out.println("2.ѭ���״���Ӧ�㷨");
			System.out.println("3.�����Ӧ�㷨");
			System.out.println("4.���Ӧ�㷨");
			int x=in.nextInt();
			
			System.out.println("��������ҵ�Ĵ�С��");
			int plength=in.nextInt();
			switch(x){
				case 1:f.find(plength); break;
				case 2:f.find2(plength);break;
				case 3:f.find3(plength); break;
				case 4:f.find4(plength); break;
				
			}
			System.out.println("���з�����ʣ�������");
			for(IdlePartition i:list){
				System.out.print(i.sysize+"---->");
			}
			System.out.println();
			System.out.println("�Ƿ�������룺");
			System.out.println("1.����    0.�˳�");
			
			int c=in.nextInt();
			if(c!=1){
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		menu();
	}

}
