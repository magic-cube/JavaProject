package Process2;
/**
 * 基于时间片的轮转调度算法
 * 测试数据
 * -------
 * a 0 4
 * b 1 3
 * c 2 4
 * d 3 2
 * e 4 4
 * -------
 * 输出结果  完成时间
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
	
	int timeCount;   //时间计数器
	int timePice=1;	//时间片
	int number;
	
	List<Process2> list= new ArrayList<Process2>();      //就绪队列
	
	List<Process2> list2=new ArrayList<Process2>();		//存贮进程的list
	
	
	//初始化
	public void printInfo(){
		Scanner in = new Scanner(System.in);
		System.out.println("请输入时间片的大小：");
		timeCount=in.nextInt();
		System.out.println("请输入要添加的进程个数：");
		number=in.nextInt();
		for(int i=0;i<number;i++){
			System.out.print("请依次输入进程的  进程名  到达时间   服务时间"+" ");
			String name=in.next();
			int arriveTime=in.nextInt();
			int serviceTime=in.nextInt();

			//每输入一次，调用工厂类，创建对象并赋值
			Process2 p=Pfactory(name,arriveTime,serviceTime);
			
			list2.add(p);
		}	
			//测试，用以查看添加进去的内容
//			for(Process2 p:list2){
//				System.out.println(p.name+" "+p.arriveTime);
//			}
	}

	//-------------------------------------------------------------------------------
	//工厂类，用于创建Process对象
	public Process2 Pfactory(String name,int arriveTime,int serviceTime){
		return new Process2(name,arriveTime,serviceTime);
	}
	//查找
	public int find(){
		for(int i=0;i<list2.size();i++){
			if(timeCount==list2.get(i).arriveTime){
				return i;
			}else{
				timeCount++;
			}
		}
		return 0;
	}
	
	//先来先服务   list目前为空
	//只运行有限次数，直到所有进程都就绪
	public void FirstCome(){
		//头入队
		list.add(list2.get(find()));
		for(int i=1;i<number;i++){
			//头出队
			Process2 p=list.remove(0);
			timeCount+=timePice;
			p.alTime+=timePice;
			if(p.alTime<p.serviceTime){
				//匹配入队
				list.add(list2.get(find()));
				//头入队
				list.add(p);
			
				
				
			}else{
				System.out.println("....");
				System.out.println("进程："+p.name+"已经执行完毕");
				System.out.println("完成时间为："+timeCount);
				System.out.println("周转时间为："+(timeCount-p.arriveTime));
				System.out.println("带权周转时间为："+(timeCount/p.serviceTime));
				System.out.println();
				//匹配入队
				list.add(list2.get(find()));
			}
		}
		for(Process2 p:list){
			System.out.println(p.name);
		}
	}
	//时间片轮转
	public void run(){
		while(list.size()>0){
			Process2 temp=list.remove(0);
			timeCount+=timePice;              //时间计数器++
			temp.alTime+=timePice;             //已运行时间加时间片
			if(temp.alTime<temp.serviceTime){
				System.out.println("当前运行的进程是："+temp.name);
				list.add(temp);
			}else{
				System.out.println();
				System.out.println("进程："+temp.name+"已执行完毕");
				System.out.println("完成时间："+timeCount+" "+"周转时间："+(timeCount-temp.arriveTime)+" "+"带权周转时间："+" "+(timeCount/temp.serviceTime));
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
