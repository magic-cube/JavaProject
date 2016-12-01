package dynamic.partitioning;
/**
 * 动态分区分配算法
 * 首次适应算法
 * 要求空闲分区链以地址递增的次序链接，分配内存时，从链首开始查找，直至找到一个大小能满足要求的空闲分区
 * 按照作业的大小，从该分区划分一块内存空间给请求者，，余下空间仍留在空闲链中
 * 若从链首到链尾都不能找到一个能满足要求的分区，则此次内存分配失败
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FF {
	//空闲分区链
	static List<IdlePartition> list = new LinkedList<IdlePartition>();
	List<Integer> li = new ArrayList<Integer>(); //作业大小
	int number;  //空白分区个数
	//int Plength;	//作业的长度
	int n; //作业的个数
	int g;  //参数G
	public void printInfo(){
		Scanner in = new Scanner(System.in);
		System.out.println("请输入参数G大小：");
		g=in.nextInt();
		System.out.println("请输入作业个数：");
		n=in.nextInt();
		System.out.println("请依次输入每道作业的大小：");
		for(int i=0;i<n;i++){
			li.add(in.nextInt());
		}
		
		System.out.println("请输入空白分区的个数：");
		number=in.nextInt();
		System.out.println("请输入依次输入每个空白分区的大小，系统会按照输入顺序将空白分区插入空白分区链中：");
		for(int i=0;i<number;i++){
			
			int a=in.nextInt();
			IdlePartition temp =Factory(a);
			list.add(temp);
		}
		
		//迭代器，查看list中的内容
		Iterator<IdlePartition> it=list.iterator();
		System.out.println("空闲分区表情况：");
		while(it.hasNext()){
			IdlePartition temp=it.next();
			System.out.print(temp.size+"--->");
		}
		System.out.println();
	}
	
	//工厂类
	public IdlePartition Factory(int a){
		return new IdlePartition(a);
	}
	
	//遍历寻找第一个满足条件的结点
	/*
	 * 首次适应算法
	 */
	public void find(){
		int PSize;//作业大小
		int KSize;//空闲分区大小
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
	 * 循环首次适应算法
	 */
	public void find2(){
		int PSize;//作业大小
		int KSize;//空闲分区大小
		int index=-1; //记录上次上次在空闲分区链中分配的位置
	
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
		System.out.println("请选择要使用的分配算法：");
		System.out.println("1.首次适应算法");
		System.out.println("2.循环首次适应算法");
		System.out.println("3.最佳适应算法");
		System.out.println("4.最坏适应算法");
		int x=in.nextInt();
		switch(x){
			case 1:f.find(); break;
			case 2:f.find2();; break;
	//		case 1:f.find(); break;
	//		case 1:f.find(); break;
			
		}
		System.out.println("空闲分区表剩余情况：");
		for(IdlePartition i:list){
			System.out.print(i.sysize+"---->");
		}
	}
	
	public static void main(String[] args) {
		menu();
	}

}
