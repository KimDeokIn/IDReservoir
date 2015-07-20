import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class FontUI {

	private JPanel contentPane;
	private JFrame frame;
	private JTable table;
	/**
	 * Create the frame.
	 */
	public FontUI(JTable table) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new JFrame("Font");
					init();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		this.table = table;
	}

	private void init() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		frame.setVisible(true);
	}
}
