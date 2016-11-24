package Process1;
//进程类
public class Process {
	/*private*/ String name;     //进程名
	/*private*/ int serviceTime;  //服务时间
	/*private*/ int arriveTime;  //到达时间
	
	/*private*/ int alTime;     //已运行时间
	
	Process next;     //指向下个结点
	
	
	Process(){
		
	}
	//构造器，         接收    进程名  服务时间  到达时间
	Process(String name,int serviceTime,int arriveTime){
		this.name=name;
		this.serviceTime=serviceTime;
		this.arriveTime=arriveTime;
	}
	//
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//
	public int getServiceTime() {
		return serviceTime;
	}
	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}
	//
	public int getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(int arriveTime) {
		this.arriveTime = arriveTime;
	}
	//
	public int getAlTime() {
		return alTime;
	}
	public void setAlTime(int alTime) {
		this.alTime = alTime;
	}

	//
	public Process getNext() {
		return next;
	}
	public void setNext(Process next) {
		this.next = next;
	}
	
}
