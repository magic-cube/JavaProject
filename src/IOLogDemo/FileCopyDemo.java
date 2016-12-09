package IOLogDemo;
import java.io.*;
/**
 * �ļ�����
 * ��Ŀ��ͼƬ����������
 * @author hc
 *
 */
public class FileCopyDemo {
	/*
	 * �ļ�����
	 * �����б� Դ�ļ�·����Ŀ���ļ�·��
	 */
	public static void fileCopy(String srcPath,String destPath){
//		File src1 = new File(srcPath);
//		File src2 = new File(destPath);
//		fileCopy(src1,src2);
		//������src1��src2ֻ����һ��ʱ��ʹ������
		fileCopy(new File(srcPath),new File(destPath));
	}
	/*
	 * ������fileCopy������fileCopy�ȿ��Խ��յ��ļ�����Ҳ���Խ����ļ��Ķ���
	 */
	public static void fileCopy(File srcPath,File destPath){
		InputStream is=null;
		OutputStream os=null;
		try{
			is=new FileInputStream(srcPath);
			os=new FileOutputStream(destPath);
			int b=0;	//bit
			while((b=is.read())!=-1){
				os.write(b);
			}
			//ˢ�»���
			os.flush(); 
			//�ر���,һ���ȴ򿪵ĺ�ر�
			os.close();
			is.close();
		}catch(FileNotFoundException e){
			System.out.println("�ļ�δ�ҵ�");
		}catch(IOException e){
			System.out.println("�ļ�����ʧ��");
		}

	}
	public static void main(String args[]){
		fileCopy("C:/Users/hc/Pictures/Camera Roll/1.jpg","C:/Users/hc/Desktop/test.jpg");
	}
}
