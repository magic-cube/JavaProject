package chat03;
import java.awt.*;
import java.awt.event.*;

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
	}
	
	private class TFListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String s=tfTxt.getText().trim();
			taContent.setText(s);
			tfTxt.setText("");
		}
		
	}
}
