package Process1;

import java.util.ArrayList;
import java.util.List;



public class TimeTurn {
	private static final int TIME_SLICE=1;
	private int timeCount;   //时间计数器，完成时间
	List<Process>  list = new 
	ArrayList<Process>();
	Process p1,p2,p3,p4,p5;
	//初始化
	public void init(){
		p1=new Process("p1",4,0);
		p2=new Process("p2",3,1);
		p3=new Process("p3",4,2);
		p4=new Process("p4",2,3);
		p5=new Process("p5",4,4);
		
		p1.setNext(p2);
		p2.setNext(p3);
		p3.setNext(p4);
		p4.setNext(p5);
		p5.setNext(p1);
		
		//添加到进程队列
		Process temp=p1;
		while(!list.contains(temp)){
			list.add(temp);
			temp=temp.next;
		}
	}
	
	//单个时间片内的执行过程
	public void run(int i){
		Process p =list.get(i);
		p.setAlTime(p.getAlTime()+TIME_SLICE);             //已运行时间加时间片
		//p.setServiceTime(p.getServiceTime()-TIME_SLICE);	//服务时间减去时间片 
		
		//如果上一个进程到达时间加上一个时间片后 不等于下一个进程到达时间   时间计数器每次加上一个时间片，知道相等
//		while((p.getArriveTime()+TIME_SLICE)!=p.next.getArriveTime()){
//			p.setArriveTime(p.getArriveTime()+TIME_SLICE);
//			//timeCount+=TIME_SLICE;
//		}
//		while((p.arriveTime+1)!=p.next.arriveTime){
//			p.arriveTime++;
//			timeCount++;
//		}
		
		timeCount+=TIME_SLICE;              //时间计数器++
		
		Process temp =list.remove(i);          //从list中删除下标为i的元素   并返回这个元素
		if(p.getAlTime()!=p.getServiceTime()){
			System.out.println("当前执行的进程为："+temp.getName());
			list.add(temp);
		}else{     //如果已运行时间不等于服务时间
			System.out.println("进程："+temp.getName()+"已经执行完毕，出队");
			System.out.println("完成时间为："+timeCount);
		}
		
		
		if(list.size()>0){
			System.out.print("此时list的值：");
			for(int j=0;j<list.size();j++){
				System.out.print(list.get(j).getName()+" ");
			}
				System.out.println();
		}else{
			System.out.println("进程队列为空！");
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
			this.run(a);
		}
	}
	
	
	
	
	public static void main(String args[]){
		TimeTurn t= new TimeTurn();
		t.init();
		t.processRun();
	}
	
	
	
}
