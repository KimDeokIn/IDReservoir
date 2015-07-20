package p1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*; // File때문에 
import java.util.*;

public class JFileChooserDemo extends JFrame implements ActionListener{

	// 버튼
	JButton openButton;
	JButton saveButton;
	
	// 버튼 담을 판넬
	JPanel buttonPanel;	
	JTextArea fileInfo; // 파일 정보 보여준다.
	
	public JFileChooserDemo() {
		super("파일 열기: JFileChooser 연습!!");
		//openButton = new JButton(new ImageIcon("22.gif"));  // 버튼 객체 생성
		//saveButton  = new JButton(new ImageIcon("233.jpg")); 
		openButton = new JButton("OPEN");  // 버튼 객체 생성
		saveButton  = new JButton("SAVE"); 
		buttonPanel = new JPanel();  // 판넬 객체 생성
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
			int result = chooser.showOpenDialog(this); // 눌렀을때 int형으로 리턴
			if(result == JFileChooser.APPROVE_OPTION){ // 열기 눌렀을 때
				File file = chooser.getSelectedFile();
				fileInfo.append("파일명"+file.getName()+"\n");
				fileInfo.append("파일경로 : "+file.getPath()+"\n");
				fileInfo.append("파일 사이즈:"+file.length()+"\n");
				
				Calendar date = Calendar.getInstance(); // new 못함 : getInstance로 얻어옴
				date.setTimeInMillis(file.lastModified()); // file.lastModified() 마지막 수정일을 얻어 올수 있음.
				
				int year = date.get(Calendar.YEAR);
				int month = date.get(Calendar.MONTH)+1;
				int day = date.get(Calendar.DAY_OF_MONTH);
				
				fileInfo.append("작성날짜 :"+year+"년"+month+"월"+day+"일");
				
			}
		}else if(e.getSource() == saveButton){
			int result = chooser.showSaveDialog(this);
			if(result == JFileChooser.APPROVE_OPTION){
				fileInfo.append(chooser.getSelectedFile().getName()+"저장 하였습니다."+"\n");
			}
		}
	}

	public static void main(String[] args) {
		new JFileChooserDemo();
	}

}
