package Process2;



public class Process2 {
	/*private*/ String name;     //������
	/*private*/ int serviceTime;  //����ʱ��
	/*private*/ int arriveTime;  //����ʱ��
	
	/*private*/ int alTime;     //������ʱ��
	
	Process next;     //ָ���¸����
	
	
	Process2(){
		
	}
	//��������         ����    ������    ����ʱ��  ����ʱ��
	Process2(String name,int arriveTime,int serviceTime){
		this.name=name;
		this.serviceTime=serviceTime;
		this.arriveTime=arriveTime;
	}
}
