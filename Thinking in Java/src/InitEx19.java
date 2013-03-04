
public class InitEx19 {
	public static void main(String[] args) {
		String[] s = { "one", "two", "three"};
		InitEx19 initEx199 = new InitEx19();
		initEx199.f("test");
		initEx199.f(s);
		initEx199.f("ine","ine","ine","ine","ine","ine");
	}
	void f(String... s) {
		for (String item : s) {
			System.out.println(item);
		}
	}
}
