package IOLogDemo;
import java.io.*;
public class CopyDirectory {
	/*
	 * 文件拷贝
	 * 参数列表： 源文件路径，目标文件路径
	 */
	public static void fileCopy(String srcPath,String destPath){
		fileCopy(new File(srcPath),new File(destPath));
	}
	/*
	 * 重载了fileCopy，这样fileCopy既可以接收到文件名，也可以接收文件的对象
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
			System.out.println("文件未找到");
		}catch(IOException e){
			System.out.println("文件拷贝失败");
		}

	}
	/*
	 * 拷贝文件夹细节
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
				//获取下一级目录
				for(File sub:srcPath.listFiles()){
					copyDirDetail(sub,new File(destPath,sub.getName()));
				}
			}
		}catch(FileNotFoundException e){
			System.out.println("未找到该文件");
		}
	}
	public static void main(String args[]){
		File src=new File("C:/Users/hc/Desktop/Creat/git/1");
		File dest=new File("C:/Users/hc/Desktop/Creat/git/3");
		copyDirDetail(src, dest);
	}
}
