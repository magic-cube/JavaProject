package chat04;
import java.awt.*;
import java.net.*;
import java.awt.event.*;
import java.io.IOException;

public class ChatClient extends Frame{
	
	TextField tfTxt=new TextField();
	TextArea taContent=new TextArea();
	
	public static void main(String args[]){
		new ChatClient().launchFrame();
		
	}
	
	public void launchFrame(){
		this.setLocation(400,300);
		this.setSize(300, 300);
		add(tfTxt,BorderLayout.SOUTH);
		add(taContent,BorderLayout.NORTH);
		//�رմ���
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
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
	
	public void connect(){
		try {
			Socket client=new Socket("127.0.0.1",8888);
System.out.println("connected!");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private class TFListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String s=tfTxt.getText().trim();
			taContent.setText(s);
			tfTxt.setText("");
		}
	}
}
