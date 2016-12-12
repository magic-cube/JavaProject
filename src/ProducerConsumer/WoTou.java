package ProducerConsumer;
/**
 * 窝头类...
 * javaBean
 * @author hc
 *
 */
public class WoTou {
	//id，用以区分每个窝头...
	int id;
	WoTou(int id){
		this.id=id;
	}
	public String toString(){
		return "WoTou: "+id;
	}
}
