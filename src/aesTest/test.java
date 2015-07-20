package aesTest;

public class test {
	
	public static void main(String[] args) throws Exception{
		StringCrypto strc = new StringCrypto();
		
		String s = "wanmiop";
		System.out.println(s);
		s = strc.encrypt("test", s);
		System.out.println(s);
		byte[] b = s.getBytes();
		for(int i=0; i<b.length; i++)
			System.out.print(b[i] + " ");
		System.out.println();
		s = new String(b, 0, b.length);
		System.out.println(s);
		s = strc.decrypt("test", s);
		System.out.println(s);
		System.out.println();
		
		s = "backkom13";
		System.out.println(s);
		s = strc.encrypt("test", s);
		System.out.println(s);
		b = s.getBytes();
		for(int i=0; i<b.length; i++)
			System.out.print(b[i] + " ");
		System.out.println();
		s = new String(b, 0, b.length);
		System.out.println(s);
		s = strc.decrypt("test", s);
		System.out.println(s);
		System.out.println();
		
		s = "http://naver.com";
		System.out.println(s);
		s = strc.encrypt("test", s);
		System.out.println(s);
		b = s.getBytes();
		for(int i=0; i<b.length; i++)
			System.out.print(b[i] + " ");
		System.out.println();
		s = new String(b, 0, b.length);
		System.out.println(s);
		s = strc.decrypt("test", s);
		System.out.println(s);
		System.out.println();
	}
}
