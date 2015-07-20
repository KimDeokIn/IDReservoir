package p1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*; // File������ 
import java.util.*;

public class JFileChooserDemo extends JFrame implements ActionListener{

	// ��ư
	JButton openButton;
	JButton saveButton;
	
	// ��ư ���� �ǳ�
	JPanel buttonPanel;	
	JTextArea fileInfo; // ���� ���� �����ش�.
	
	public JFileChooserDemo() {
		super("���� ����: JFileChooser ����!!");
		//openButton = new JButton(new ImageIcon("22.gif"));  // ��ư ��ü ����
		//saveButton  = new JButton(new ImageIcon("233.jpg")); 
		openButton = new JButton("OPEN");  // ��ư ��ü ����
		saveButton  = new JButton("SAVE"); 
		buttonPanel = new JPanel();  // �ǳ� ��ü ����
		fileInfo = new JTextArea();
		
		buttonPanel.add(openButton);
		buttonPanel.add(saveButton);
		
		add(buttonPanel,BorderLayout.NORTH);
		add(new JScrollPane(fileInfo));
		
		setSize(400,500);
		setVisible(true);
		
		openButton.addActionListener(this);
		saveButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		JFileChooser chooser = new JFileChooser();
		if(e.getSource() == openButton){
			int result = chooser.showOpenDialog(this); // �������� int������ ����
			if(result == JFileChooser.APPROVE_OPTION){ // ���� ������ ��
				File file = chooser.getSelectedFile();
				fileInfo.append("���ϸ�"+file.getName()+"\n");
				fileInfo.append("���ϰ�� : "+file.getPath()+"\n");
				fileInfo.append("���� ������:"+file.length()+"\n");
				
				Calendar date = Calendar.getInstance(); // new ���� : getInstance�� ����
				date.setTimeInMillis(file.lastModified()); // file.lastModified() ������ �������� ��� �ü� ����.
				
				int year = date.get(Calendar.YEAR);
				int month = date.get(Calendar.MONTH)+1;
				int day = date.get(Calendar.DAY_OF_MONTH);
				
				fileInfo.append("�ۼ���¥ :"+year+"��"+month+"��"+day+"��");
				
			}
		}else if(e.getSource() == saveButton){
			int result = chooser.showSaveDialog(this);
			if(result == JFileChooser.APPROVE_OPTION){
				fileInfo.append(chooser.getSelectedFile().getName()+"���� �Ͽ����ϴ�."+"\n");
			}
		}
	}

	public static void main(String[] args) {
		new JFileChooserDemo();
	}

}
