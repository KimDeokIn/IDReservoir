package p1;

import java.io.*;

public class a {
	public static void main(String[] args) {
		try {
			// String filename = args[0];
			// String filename = "c:/test.dat";
			String filename = "test.bin";
			FileOutputStream out = new FileOutputStream(filename);
			FileInputStream File = new FileInputStream(filename);
			InputStreamReader in = new InputStreamReader(File);

			for (byte i = 1; i <= 10; i++) {
				out.write(i);
			}
			// 1���� 10���� byte �ڵ�� ����. ������ ���°�� �ڵ� �����Ѵ�.
			
			int c;
			String str = new String();
			while ((c = in.read()) != -1) {
				// System.out.print(c + " ");
				str = str + c;
			}
			// ������ ������ �о ȭ�鿡 ����Ѵ�.(����Ʈ ��Ʈ���� ���� ��Ʈ������ ��ȯ�� ���� ���)
			System.out.println(str);

			in.close();
			out.close();

		} catch (IOException ie) {
			System.out.println("������ �������� �ʽ��ϴ�.");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}