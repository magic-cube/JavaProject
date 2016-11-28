package dynamic.partitioning;
import java.util.Iterator;
/**
 * 动态分区分配算法
 * 首次适应算法
 * 要求空闲分区链以地址递增的次序链接，分配内存时，从链首开始查找，直至找到一个大小能满足要求的空闲分区
 * 按照作业的大小，从该分区划分一块内存空间给请求者，，余下空间仍留在空闲链中
 * 若从链首到链尾都不能找到一个能满足要求的分区，则此次内存分配失败
 */
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FF {
	//空闲分区链
	static List<IdlePartition> list = new LinkedList<IdlePartition>();
	int number;  //空白分区个数
	int Plength;
	public void printInfo(){
		Scanner in = new Scanner(System.in);
		System.out.println("请输入作业大小：");
		Plength=in.nextInt();
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
		System.out.println("空闲分区表剩余情况：");
		for(IdlePartition i:list){
			System.out.print(i.ssize+"---->");
		}
	}

}
