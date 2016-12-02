package dynamic.partitioning;

public class IdlePartition {
	int size;   //空闲分区大小
	int sysize;	//剩余空间的大小
	int address; //空闲分区的起始地址
	IdlePartition() {
		
	}
	IdlePartition(int size,int address){
		this.size=size;
		this.address=address;
		this.sysize=size;
		
	}

	
	

}
