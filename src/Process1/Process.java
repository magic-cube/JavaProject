package Process1;
//������
public class Process {
	/*private*/ String name;     //������
	/*private*/ int serviceTime;  //����ʱ��
	/*private*/ int arriveTime;  //����ʱ��
	
	/*private*/ int alTime;     //������ʱ��
	
	Process next;     //ָ���¸����
	
	
	Process(){
		
	}
	//��������         ����    ������  ����ʱ��  ����ʱ��
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
