package chat08;
import java.awt.*;
import java.net.*;
import java.awt.event.*;
import java.io.*;

public class ChatClient extends Frame{
	Socket client=null;
	TextField tfTxt=new TextField();
	TextArea taContent=new TextArea();
	//�������������ʱ�����ʼ��,�洢�ã�֮��ֱ���þͺ��ˣ�������ÿ�η��Ͷ���ʼ��,֮���õ�Ҳ����ͬһ������������ֻ�ܷ���һ�ε����
	DataOutputStream dos=null;
	
	public static void main(String args[]){
		new ChatClient().launchFrame();
		
	}
	/*
	 * ��������
	 */
	public void launchFrame(){
		this.setLocation(400,300);
		this.setSize(300, 300);
		add(tfTxt,BorderLayout.SOUTH);
		add(taContent,BorderLayout.NORTH);
		//�رմ���
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				disconnect();
				System.exit(0);
			}
		});
		pack();//�Զ���װ
		//����TestField
		tfTxt.addActionListener(new TFListener());
		this.setVisible(true);
		//��������ã��򿪴��ں�ֱ������
		connect();
	}
	/*
	 * ��������
	 */
	public void connect(){
		try {
			client=new Socket("127.0.0.1",8888);
			//һ�������ϣ���ʼ�������
			dos=new DataOutputStream(client.getOutputStream());
System.out.println("connected!");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/*
	 * �ر����ӣ����ڹر�ʱ����
	 */
	public void disconnect(){
		try {
			client.close();
			dos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/*
	 * �����������ͻ���
	 */
	public void send(String s){
		try {
			dos.writeUTF(s);
			dos.flush();
			//dos.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	/*
	 * ����TextField
	 */
	private class TFListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String s=tfTxt.getText().trim();
			send(s);
			taContent.setText(s);
			tfTxt.setText("");
		}
	}
}
