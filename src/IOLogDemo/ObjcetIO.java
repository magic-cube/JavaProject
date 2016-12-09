package IOLogDemo;
import java.io.*;
/*
 * Object��
 * ��������л�
 * ֱ�ӽ�һ��Objectд��Ӳ�̻���������
 * ʵ��Serializable�ӿڣ�����Խӿڣ��������������ñ�����֪��������ǿ��Ա����л���
 */
public class ObjcetIO {
	public static void main(String args[]){
		T t =new T();
		try{
			FileOutputStream fos = new FileOutputStream("C:/my/ObjectIo.dat");
			ObjectOutputStream oos= new ObjectOutputStream(fos);
			//������д��ָ���ļ�
			oos.writeObject(t);
			oos.flush();
			oos.close();
			
			FileInputStream fis= new FileInputStream("C:/my/ObjectIo.dat");
			ObjectInputStream ois= new ObjectInputStream(fis);
			T tRead=(T)ois.readObject();
			System.out.println(tRead.i+" "+tRead.j+" "+tRead.k);
			ois.close();
		}catch(FileNotFoundException e){
			System.out.println("δ�ҵ�ָ���ļ�");
		}catch(IOException e2){
			System.out.println("...");
		}catch(ClassNotFoundException c){
			
		}
	}
}
//ʵ��Serializable�ӿ�
class T implements Serializable{
	int i=10;
	int j=15;
	double k=0.25;
}