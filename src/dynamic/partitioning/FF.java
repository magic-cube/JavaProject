package dynamic.partitioning;
/**
 * 动态分区分配算法
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FF {
	//空闲分区链
	static List<IdlePartition> list = new LinkedList<IdlePartition>();
//	List<Integer> li = new ArrayList<Integer>(); //作业大小
	int number;  //空白分区个数
	int index=-1; //记录上次上次在空闲分区链中分配的位置
	//int Plength;	//作业的长度
//	int n; //作业的个数
	int g;  //参数G
	public void printInfo(){
		Scanner in = new Scanner(System.in);
		System.out.println("请输入参数G大小：");
		g=in.nextInt();
//		System.out.println("请输入作业个数：");
//		n=in.nextInt();
//		System.out.println("请依次输入每道作业的大小：");
//		for(int i=0;i<n;i++){
//			li.add(in.nextInt());
//		}
		
		System.out.println("请输入空白分区的个数：");
		number=in.nextInt();
		System.out.println("请输入依次输入每个空白分区的大小及起始地址：");
		for(int i=0;i<number;i++){
			
			int a=in.nextInt();
			int address=in.nextInt();
			IdlePartition temp =Factory(a,address);
			
			list.add(temp);
		}
		
		//迭代器，查看list中的内容
//		Iterator<IdlePartition> it=list.iterator();
//		System.out.println("空闲分区表情况：");
//		while(it.hasNext()){
//			IdlePartition temp=it.next();
//			System.out.print(temp.size+"--->");
//		}
//		System.out.println();
	}
	
	//工厂类
	public IdlePartition Factory(int a,int address){
		return new IdlePartition(a,address);
	}
	
	//遍历寻找第一个满足条件的结点
	/*
	 * 首次适应算法
	 * 要求空闲分区链以地址递增的次序链接，分配内存时，从链首开始查找，直至找到一个大小能满足要求的空闲分区
	 * 按照作业的大小，从该分区划分一块内存空间给请求者，，余下空间仍留在空闲链中
	 * 若从链首到链尾都不能找到一个能满足要求的分区，则此次内存分配失败
	 */
	public void find(int plength){
		int PSize=plength;//作业大小
		int KSize;//空闲分区大小
		
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

		System.out.println("空闲分区表情况：");
		for(IdlePartition i:list){
			System.out.print(i.size+"---->");
		}
		System.out.println();
	}
	/*
	 * 循环首次适应算法
	 * NF算法，由首次适应算法演变而来，在为进程分配内存时，不再是每次都从链首开始查找
	 * 而是从上次找到的空闲分区的下一个空闲分区开始查找，直到找到一个能满足要求的空闲分区，
	 * 从中划出一块与请求大小相等的内存空间分配给作业
	 */
	public void find2(int plength){
		int PSize=plength;//作业大小
		int KSize;//空闲分区大小
		
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
		System.out.println("空闲分区表情况：");
		while(it.hasNext()){
			IdlePartition temp=it.next();
			System.out.print(temp.size+"--->");
		}
		System.out.println();
	}
	/*
	 * 最佳适应算法
	 * BT算法，每次为作业分配内存时，总是把能满足要求的，又是最小的空闲分区分配给作业
	 * 避免“大材小用”，为加速寻找，该算法要求所有的空闲分区按照其容量以从大到小的顺序形成一条空闲分区链
	 * 这样，第一次找到的能满足要求的空闲分区，必然是最佳的
	 * 初看挺好，但从宏观角度，每次切割下来的剩余部分总是最小的，这样会在存储器中留下许多难以利用的小空闲区
	 */
	public void find3(int plength){
		//现将空闲分区链从小到大排序
		sort1(list);
		int PSize=plength;//作业大小
		int KSize;//空闲分区大小
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
			//每进行一次分配，重新排序空闲分区链
			sort1(list);
//		}
//		Iterator<IdlePartition> it=list.iterator();
		System.out.println("空闲分区表情况：");
//		while(it.hasNext()){
//			IdlePartition temp=it.next();
//			System.out.print(temp.size+"--->");
//		}
		for(IdlePartition id:list){
			System.out.print(id.size+"-->");
		}
		System.out.println();
		
		
		//可以直接调用fian1（）；
		//find1();
	}
	
	/*
	 * 最坏适应算法
	 */
	public void find4(int plength){
		sort2(list);
		int PSize=plength;//作业大小
		int KSize;//空闲分区大小
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
			//每进行一次分配，重新排序空闲分区链
			sort2(list);
//		}
		Iterator<IdlePartition> it=list.iterator();
		System.out.println("空闲分区表情况：");
		while(it.hasNext()){
			IdlePartition temp=it.next();
			System.out.print(temp.size+"--->");
		}
		System.out.println();
	}
	/*
	 * 按起始地址从小到大排列
	 */
	public static void sort3(List<IdlePartition> list){
		IdlePartition idl= new IdlePartition();
		for(int j=1;j<list.size();j++){
			for(int i=0;i<list.size()-j;i++){
				//假设有序
//				boolean sorted=true;
				if(list.get(i).address>list.get(i+1).address){
					
					//交换空闲分区大小
					int temp=list.get(i).size;
					list.get(i).size=list.get(i+1).size;
					list.get(i+1).size=temp;
					
					//交换空闲分区大小的同时，也必须交换剩余空闲分区大小
					int temp2=list.get(i).sysize;
					list.get(i).sysize=list.get(i+1).sysize;
					list.get(i+1).sysize=temp;
					
					int temp3=list.get(i).address;
					list.get(i).address=list.get(i+1).address;
					list.get(i+1).address=temp;
					
					//sorted=false;   //发生过交换
				}
//				if(sorted){ // 未发生过交换
//					break;
//				}
			}
		}
		
	}
	/*
	 * 按起始地址从大到小排列
	 */
	public static void sort4(List<IdlePartition> list){
		IdlePartition idl= new IdlePartition();
		for(int j=0;j<list.size();j++){
			for(int i=0;i<list.size()-j;i++){
				//假设有序
				boolean sorted=true;
				if(list.get(i).address<list.get(i+1).address){
					
					//交换空闲分区大小
					int temp=list.get(i).size;
					list.get(i).size=list.get(i+1).size;
					list.get(i+1).size=temp;
					
					//交换空闲分区大小的同时，也必须交换剩余空闲分区大小
					int temp2=list.get(i).sysize;
					list.get(i).sysize=list.get(i+1).sysize;
					list.get(i+1).sysize=temp;
					
					sorted=false;   //发生过交换
				}
				if(sorted){ // 未发生过交换
					break;
				}
			}
		}
		
	}
	/*
	 * 空闲分区链排序，从小到大
	 */
	public static void sort1(List<IdlePartition> list){
		IdlePartition idl= new IdlePartition();
		for(int j=0;j<list.size();j++){
			for(int i=0;i<list.size()-j;i++){
				//假设有序
				boolean sorted=true;
				if(list.get(i).size>list.get(i+1).size){
					
					//交换空闲分区大小
					int temp=list.get(i).size;
					list.get(i).size=list.get(i+1).size;
					list.get(i+1).size=temp;
					
					//交换空闲分区大小的同时，也必须交换剩余空闲分区大小
					int temp2=list.get(i).sysize;
					list.get(i).sysize=list.get(i+1).sysize;
					list.get(i+1).sysize=temp;
					
					sorted=false;   //发生过交换
				}
				if(sorted){ // 未发生过交换
					break;
				}
			}
		}
		
	}
	/*
	 * 空闲分区链排序，从大到小
	 */
	public static void sort2(List<IdlePartition> list){
		IdlePartition idl= new IdlePartition();
		for(int j=1;j<list.size();j++){
			for(int i=0;i<list.size()-j;i++){
				//假设有序
				boolean sorted=true;
				if(list.get(i).size<list.get(i+1).size){
					
					//交换空闲分区大小
					int temp=list.get(i).size;
					list.get(i).size=list.get(i+1).size;
					list.get(i+1).size=temp;
					
					//交换空闲分区大小的同时，也必须交换剩余空闲分区大小
					int temp2=list.get(i).sysize;
					list.get(i).sysize=list.get(i+1).sysize;
					list.get(i+1).sysize=temp;
					
					sorted=false;   //发生过交换
				}
				if(sorted){ // 未发生过交换
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
			System.out.println("请选择要使用的分配算法：");
			System.out.println("1.首次适应算法");
			System.out.println("2.循环首次适应算法");
			System.out.println("3.最佳适应算法");
			System.out.println("4.最坏适应算法");
			int x=in.nextInt();
			
			System.out.println("请输入作业的大小：");
			int plength=in.nextInt();
			switch(x){
				case 1:f.find(plength); break;
				case 2:f.find2(plength);break;
				case 3:f.find3(plength); break;
				case 4:f.find4(plength); break;
				
			}
			System.out.println("空闲分区表剩余情况：");
			for(IdlePartition i:list){
				System.out.print(i.sysize+"---->");
			}
			System.out.println();
			System.out.println("是否继续输入：");
			System.out.println("1.继续    0.退出");
			
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
