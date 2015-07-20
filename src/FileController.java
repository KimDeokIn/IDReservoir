import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;


class FileController {

	private FileInputStream fis;
	private InputStreamReader isr;
	private BufferedReader bfr;
	private FileOutputStream fos;
	private OutputStreamWriter osw;
	private Reservoir reservoir;
	private StringCrypto strCrypto;
	private final String seed = "MadeByBackkom";

	public FileController(Reservoir reservoir) {
		this.reservoir = reservoir;
		strCrypto = new StringCrypto();
	}

	public void setFileInputStream(String directory) {
		try {
			fis = new FileInputStream(directory);
			isr = new InputStreamReader(fis);
			bfr = new BufferedReader(isr);
			
			String line = null;
			LinkedList<String> list = new LinkedList<String>();
			while((line = bfr.readLine()) != null) {
				String set = "";
				for (int i=0; i<3 && line!=null ; i++) {
					String[] split = line.split(" ");
					byte[] data = new byte[split.length];
					for (int j=0; j<data.length; j++)
						data[j] = Byte.parseByte(split[j]);
					String hex = new String(data, 0, data.length);
					set += strCrypto.decrypt(seed, hex) + "|";
					if(i < 2)
						line = bfr.readLine();
				}
				list.add(set);
			}
			reservoir.loadData(list);
			
			bfr.close();
			isr.close();
			fis.close();
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void outFileStream(String directory) {
		try {
			fos = new FileOutputStream(directory);
			osw = new OutputStreamWriter(fos);
			
			LinkedList<String> list = reservoir.saveData();
			int size = list.size();
			String[] item;	
			
			for(int i=0; i<size; i++) {
				item = list.get(i).split("\\|");
				int len = item.length;
				
				for (int j=0; j<len; j++) 
					item[j] = strCrypto.encrypt(seed, item[j]);
				
				for (int j=0; j<len; j++) {
					byte[] data = item[j].getBytes();
					
					for (int k=0; k<data.length; k++)
						osw.write(data[k] + " ");
					osw.write("\n");
				}
 			}
			
			osw.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
