class Test {
	Test(String s) {
		System.out.println(s);
	}
}


public class Exercise16 {
	static String[] s = { "one", "two", "three", "thour" };
	public static void main(String[] args) {
		for (int i=0; i<s.length; i++) {
			System.out.println("s[" + i + "]=" + s[i]);
			
		}
		
		Test[] t1 = new Test[5];
		int i = 1;
		for (@SuppressWarnings("unused") Test t : t1) {
			t = new Test("" + i++);
		}
	}
}
