import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

class Reservoir implements WindowListener{

	private JFrame frame;
	private FileController fcon;
	private final String[] colName = {"ID", "PASSWORD" , "LINK" };
	private DefaultTableModel model;
	private boolean open;
	private JTable table;
	private int size;
	private String currentPath;
	
	/**
	 * Create the application.
	 */
	public Reservoir() {
		frame = new JFrame("ID/PW �����");
		model = new DefaultTableModel(colName, 0);
		fcon = new FileController(this);
		open = false;
		currentPath = "none";
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setBounds(100, 100, 720, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JButton btnAdd = new JButton("Add Data");
		btnAdd.setBounds(188, 397, 97, 23);
		frame.getContentPane().add(btnAdd);
		
		JButton btnDelete = new JButton("Delete Data");
		btnDelete.setBounds(297, 397, 97, 23);
		frame.getContentPane().add(btnDelete);
		
		JButton btnDeleteAll = new JButton("Delete All");
		btnDeleteAll.setBounds(406, 397, 97, 23);
		frame.getContentPane().add(btnDeleteAll);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 714, 387);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmItem_Open = new JMenuItem("Open File");
		mnFile.add(mntmItem_Open);
		
		JMenuItem mntmItem_Save = new JMenuItem("Save");
		mnFile.add(mntmItem_Save);
		
		JMenuItem mntmItem_SaveAs = new JMenuItem("Save As");
		mnFile.add(mntmItem_SaveAs);
		
		JMenuItem mntmItem_Close = new JMenuItem("Close");
		mnFile.add(mntmItem_Close);
		
		JMenuItem mntmItem_Exit = new JMenuItem("Exit");
		mnFile.add(mntmItem_Exit);
		
		JMenu mnWindow = new JMenu("Window");
		menuBar.add(mnWindow);
		
		JMenuItem mntmItem_Font = new JMenuItem("Font");
		mnWindow.add(mntmItem_Font);
		
		JMenuItem mntmItem_Background = new JMenuItem("Background");
		mnWindow.add(mntmItem_Background);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmItem_Instruction = new JMenuItem("Instruction");
		mnHelp.add(mntmItem_Instruction);
		
		JMenuItem mntmItem_Developer = new JMenuItem("Developer");
		mnHelp.add(mntmItem_Developer);
		
		/* ������ �۵� �κ� */
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == mntmItem_Open) {
					// ���� ����
					if (open) {
						String[] buttons = {"Yes" , "No"};
						int setNumber = JOptionPane.showOptionDialog(null, 
								"���� ���̺��� �����Ͻðڽ��ϱ�?", "Save", 0, 
								JOptionPane.INFORMATION_MESSAGE, null, 
								buttons, buttons[0]);
						if (setNumber == 0) {
							fileChooser(true);
						} 
						deleteAll();
					}
					fileChooser(false);
					open = true;
				} else if (obj == mntmItem_Save) {
					// ���� ���� ���� ���� ���� ������ ����
					if (currentPath.equals("none")) { // ������ �����ų� ����� �� ���� ���
						fileChooser(true);
					} else { // �̹� ���� �־� ������ ��ο� �ٷ� ����
						fcon.outFileStream(currentPath);
					}
				} else if (obj == mntmItem_SaveAs) {
					// ���� ���� ������ �ٸ� ���� ������ ����
					fileChooser(true);
				} else if (obj == mntmItem_Close) {
					// ���� ���� ������ ���� (������ ������ ���)
					if (open) {
						String[] buttons = {"Yes" , "No"};
						int setNumber = JOptionPane.showOptionDialog(null, 
								"���� ���̺��� �����Ͻðڽ��ϱ�?", "Save", 0, 
								JOptionPane.INFORMATION_MESSAGE, null, 
								buttons, buttons[0]);
						if (setNumber == 0) {
							fileChooser(true);
						} 
						deleteAll();
						open = false;
						currentPath = "none";
					}
						
				} else if (obj == mntmItem_Exit) {
					// ���α׷� ���� (������ �����ִٸ� ������ ������ ���) 
					if (open) {
						String[] buttons = {"Yes" , "No"};
						int setNumber = JOptionPane.showOptionDialog(null, 
								"���� ���̺��� �����Ͻðڽ��ϱ�?", "Save", 0, 
								JOptionPane.INFORMATION_MESSAGE, null, 
								buttons, buttons[0]);
						if (setNumber == 0) {
							fileChooser(true);
							System.exit(0);
						}
					} else 
						System.exit(0);
				} else if (obj == mntmItem_Font) {
					// ���̺� ��µǴ� ���ڿ��� ��Ʈ ���� (��, ũ��)
					new FontUI(table);
				} else if (obj == mntmItem_Background) {
					// ���̺��� ������ �ٲ�
				} else if (obj == mntmItem_Instruction) {
					// ���α׷� ��� ���
				} else if (obj == mntmItem_Developer) {
					// �������� �ּ�
					JOptionPane.showMessageDialog(null,  
							"http://blog.naver.com/wanmiop", "Developer Blog Address",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (obj == btnAdd) {
					// ���̺� ������ �߰�
					addRow();
				} else if (obj == btnDelete) {
					// ���̺��� ������ ����
					deleteRow();
				} else if (obj == btnDeleteAll) {
					// ��� ������ ����
					deleteAll();
				}
			}
		};
		
		/* ������ ��� �κ�  */
		mntmItem_Open.addActionListener(actionListener);
		mntmItem_Save.addActionListener(actionListener);
		mntmItem_SaveAs.addActionListener(actionListener);
		mntmItem_Close.addActionListener(actionListener);
		mntmItem_Exit.addActionListener(actionListener);
		mntmItem_Font.addActionListener(actionListener);
		mntmItem_Background.addActionListener(actionListener);
		mntmItem_Instruction.addActionListener(actionListener);
		mntmItem_Developer.addActionListener(actionListener);
		btnAdd.addActionListener(actionListener);
		btnDelete.addActionListener(actionListener);
		btnDeleteAll.addActionListener(actionListener);
		frame.addWindowListener(this);
		
	}
	
	private void fileChooser(boolean b) {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Dat","dat");
		chooser.setFileFilter(filter);
		chooser.setMultiSelectionEnabled(false);
		
		int ch = 0;
		if (b) 
			ch = chooser.showSaveDialog(null);
		else
			ch = chooser.showOpenDialog(null);
		
		if (ch != JFileChooser.APPROVE_OPTION) { 
			// ������ ���� �ʰ� �ݰų� ������� ��� 
			/*
			 * �ʿ�� ����
			 */
			return;
		}
		
		// ���� ��� ���� false: open, true: save
		String filePath = chooser.getSelectedFile().getPath();
		if (b) 
			fcon.outFileStream(filePath);
		else
			fcon.setFileInputStream(filePath);
		
		currentPath = filePath;
	}
	
	private void addRow() {
		model = (DefaultTableModel)table.getModel();
		model.addRow(new String[]{"","",""});
		open = true;
		size++;
	}
	
	public LinkedList<String> saveData() {
		LinkedList<String> list = new LinkedList<String>();
		model = (DefaultTableModel)table.getModel();
		
		int col = model.getColumnCount();
		for (int i=0; i<size; i++) {
			String data = "";
			for (int j=0; j<col; j++) 
				data += model.getValueAt(i, j) + "|";
			list.add(data);
		}
		
		return list;
	}
		
	public void loadData(LinkedList<String> list) {
		deleteAll();
		model = (DefaultTableModel)table.getModel();
		int len = list.size();
		for (int i=0; i<len; i++) {
			String[] data = list.get(i).split("\\|");
			model.addRow(data);
			size++;
		}
	}
	
	private void deleteRow() {
		int row = table.getSelectedRow();
		if (row >= 0) {
			model = (DefaultTableModel)table.getModel();
			model.removeRow(row);
			size --;
		}
	}
	
	private void deleteAll() {
		model = (DefaultTableModel)table.getModel();
		for (int i=size-1; i>=0; i--)
			model.removeRow(i);
		size = 0;
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// ������ �����ִٸ� ���� ������ ������ ���̺� �� �������� ���
		if (open) {
			String[] buttons = {"Yes" , "No"};
			int setNumber = JOptionPane.showOptionDialog(null, 
					"���� ���̺��� �����Ͻðڽ��ϱ�?", "Save", 0, 
					JOptionPane.INFORMATION_MESSAGE, null, 
					buttons, buttons[0]);
			if (setNumber == 0) {
				if (currentPath.equals("none"))
					fileChooser(true);
				else
					fcon.outFileStream(currentPath);
			} 
			System.exit(0);
		}
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
