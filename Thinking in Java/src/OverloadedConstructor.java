
public class OverloadedConstructor {
	String s = "default";
	OverloadedConstructor() {
		s += " |this is default constructor| ";
	}
	OverloadedConstructor(String s) {
		this();
		this.s += s;
	}
	void printMemberData() {
		System.out.println(s);
	}
	public static void main(String[] args) {
		OverloadedConstructor x = new OverloadedConstructor("append to end");
		x.printMemberData();
	}
}
