package IOLogDemo;
import java.io.*;
public class CopyDirectory {
	/*
	 * �ļ�����
	 * �����б� Դ�ļ�·����Ŀ���ļ�·��
	 */
	public static void fileCopy(String srcPath,String destPath){
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
			os.flush(); 
			os.close();
			is.close();
		}catch(FileNotFoundException e){
			System.out.println("�ļ�δ�ҵ�");
		}catch(IOException e){
			System.out.println("�ļ�����ʧ��");
		}

	}
	/*
	 * �����ļ���ϸ��
	 */
	public static void copyDirDetail(File srcPath,File destPath){
		InputStream is=null;
		OutputStream os=null;
		try{
			is=new FileInputStream(srcPath);
			os=new FileOutputStream(destPath);
			if(srcPath.isFile()){
				fileCopy(srcPath,destPath);
			}else if(srcPath.isDirectory()){
				srcPath.mkdirs();
				//��ȡ��һ��Ŀ¼
				for(File sub:srcPath.listFiles()){
					copyDirDetail(sub,new File(destPath,sub.getName()));
				}
			}
		}catch(FileNotFoundException e){
			System.out.println("δ�ҵ����ļ�");
		}
	}
	public static void main(String args[]){
		File src=new File("C:/Users/hc/Desktop/Creat/git/1");
		File dest=new File("C:/Users/hc/Desktop/Creat/git/3");
		copyDirDetail(src, dest);
	}
}
