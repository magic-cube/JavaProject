package dynamic.partitioning;

public class IdlePartition {
	int size;   //���з�����С
	int sysize;	//ʣ��ռ�Ĵ�С
	int address; //���з�������ʼ��ַ
	IdlePartition() {
		
	}
	IdlePartition(int size,int address){
		this.size=size;
		this.address=address;
		this.sysize=size;
		
	}

	
	

}
