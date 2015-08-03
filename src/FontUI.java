

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class FontUI extends WindowAdapter implements ActionListener {

	private JPanel contentPane;
	private JFrame frame;
	private JTable table;
	private JButton save_btn;
	private JButton cancel_btn;
	
	/**
	 * Create the frame.
	 */
	public FontUI(JTable table) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					init();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		this.table = table;
	}

	private void init() {
		String[] font = {"±º∏≤√º", "±√º≠√º", "µ∏øÚ√º", "consolas"};
		String[] fontstyle = {"∫∏≈Î", "±‚øÔ¿”≤√", "±Ω∞‘", "±Ω¿∫ ±‚øÔ¿”≤√"};
		String[] size = {"10","11","12","14","16","18","20"};
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		frame = new JFrame("Font");
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 441, 333);
		frame.setContentPane(contentPane);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.addWindowListener(this);
		
		JLabel font_lb = new JLabel("fontlb");
		font_lb.setBounds(12, 10, 172, 15);
		frame.getContentPane().add(font_lb);
		
		JTextArea font_ta = new JTextArea();
		font_ta.setBounds(12, 35, 172, 24);
		frame.getContentPane().add(font_ta);
		
		JLabel fontstyle_lb = new JLabel("fontstylelb");
		fontstyle_lb.setBounds(196, 10, 130, 15);
		frame.getContentPane().add(fontstyle_lb);
		
		JTextArea fontstyle_ta = new JTextArea();
		fontstyle_ta.setBounds(196, 35, 130, 24);
		frame.getContentPane().add(fontstyle_ta);
		
		JLabel size_lb = new JLabel("sizelb");
		size_lb.setBounds(338, 10, 63, 15);
		frame.getContentPane().add(size_lb);
		
		JTextArea size_ta = new JTextArea();
		size_ta.setBounds(338, 35, 63, 24);
		frame.getContentPane().add(size_ta);
		
		JScrollPane font_scroll = new JScrollPane();
		font_scroll.setBounds(12, 58, 172, 118);
		contentPane.add(font_scroll);
		
		JScrollPane fontstyle_scroll = new JScrollPane();
		fontstyle_scroll.setBounds(196, 58, 130, 118);
		contentPane.add(fontstyle_scroll);
		
		JScrollPane size_scroll = new JScrollPane();
		size_scroll.setBounds(338, 58, 63, 118);
		contentPane.add(size_scroll);
		
		JList<String> font_list = new JList<String>();
		font_list.setListData(font);
		font_scroll.setViewportView(font_list);
		
		JList<String> fontstyle_list = new JList<String>();
		fontstyle_list.setListData(fontstyle);
		fontstyle_scroll.setViewportView(fontstyle_list);
		
		JList<String> size_list = new JList<String>();
		size_list.setListData(size);
		size_scroll.setViewportView(size_list);
		
		cancel_btn = new JButton("cancel");
		cancel_btn.setBounds(304, 262, 97, 23);
		frame.getContentPane().add(cancel_btn);
		cancel_btn.addActionListener(this);
		
		save_btn = new JButton("save");
		save_btn.setBounds(196, 262, 97, 23);
		frame.getContentPane().add(save_btn);
		save_btn.addActionListener(this);
		
		JLabel preview_lb = new JLabel("preview");
		preview_lb.setBounds(196, 186, 205, 15);
		contentPane.add(preview_lb);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(196, 199, 205, 2);
		contentPane.add(separator);
		
		JLabel preview = new JLabel("r_preview");
		preview.setBounds(196, 202, 205, 50);
		contentPane.add(preview);
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		frame.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == save_btn) {
			
		} else if (e.getSource() == cancel_btn) {
			frame.dispose();
		}
	}
}
