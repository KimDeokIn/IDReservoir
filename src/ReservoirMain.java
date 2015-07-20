import java.awt.EventQueue;


public class ReservoirMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Reservoir();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
