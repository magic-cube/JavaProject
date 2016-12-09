package IOLogDemo;
import java.io.*;
/*
 * Object流
 * 对象的序列化
 * 直接将一个Object写入硬盘或者网络中
 * 实现Serializable接口，标记性接口，给编译器看，让编译器知道这个类是可以被序列化的
 */
public class ObjcetIO {
	public static void main(String args[]){
		T t =new T();
		try{
			FileOutputStream fos = new FileOutputStream("C:/my/ObjectIo.dat");
			ObjectOutputStream oos= new ObjectOutputStream(fos);
			//将对象写入指定文件
			oos.writeObject(t);
			oos.flush();
			oos.close();
			
			FileInputStream fis= new FileInputStream("C:/my/ObjectIo.dat");
			ObjectInputStream ois= new ObjectInputStream(fis);
			T tRead=(T)ois.readObject();
			System.out.println(tRead.i+" "+tRead.j+" "+tRead.k);
			ois.close();
		}catch(FileNotFoundException e){
			System.out.println("未找到指定文件");
		}catch(IOException e2){
			System.out.println("...");
		}catch(ClassNotFoundException c){
			
		}
	}
}
//实现Serializable接口
class T implements Serializable{
	int i=10;
	int j=15;
	double k=0.25;
}