package IOLogDemo;
import java.io.*;
/**
 * 文件拷贝
 * 将目标图片拷贝至桌面
 * @author hc
 *
 */
public class FileCopyDemo {
	/*
	 * 文件拷贝
	 * 参数列表： 源文件路径，目标文件路径
	 */
	public static void fileCopy(String srcPath,String destPath){
//		File src1 = new File(srcPath);
//		File src2 = new File(destPath);
//		fileCopy(src1,src2);
		//当发现src1和src2只用了一次时，使用匿名
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
			//刷新缓存
			os.flush(); 
			//关闭流,一般先打开的后关闭
			os.close();
			is.close();
		}catch(FileNotFoundException e){
			System.out.println("文件未找到");
		}catch(IOException e){
			System.out.println("文件拷贝失败");
		}

	}
	public static void main(String args[]){
		fileCopy("C:/Users/hc/Pictures/Camera Roll/1.jpg","C:/Users/hc/Desktop/test.jpg");
	}
}
