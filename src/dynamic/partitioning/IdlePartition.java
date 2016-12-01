package dynamic.partitioning;

public class IdlePartition {
	int size;   //空闲分区大小
	int sysize;	//剩余空间的大小
	IdlePartition() {
		
	}
	IdlePartition(int size){
		this.size=size;
		this.sysize=size;
	}
}
