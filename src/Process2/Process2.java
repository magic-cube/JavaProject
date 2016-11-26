package Process2;



public class Process2 {
	/*private*/ String name;     //进程名
	/*private*/ int serviceTime;  //服务时间
	/*private*/ int arriveTime;  //到达时间
	
	/*private*/ int alTime;     //已运行时间
	
	Process next;     //指向下个结点
	
	
	Process2(){
		
	}
	//构造器，         接收    进程名    到达时间  服务时间
	Process2(String name,int arriveTime,int serviceTime){
		this.name=name;
		this.serviceTime=serviceTime;
		this.arriveTime=arriveTime;
	}
}
