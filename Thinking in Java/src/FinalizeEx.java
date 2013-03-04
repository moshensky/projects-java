class EXP{
	String s = "default";
	protected void finalize() {
		System.out.println("I am a finalizer function, which get called before garbage collector");
	}
	void expAppend() {
		s += " appended";
	}
}
public class FinalizeEx {
	
	public static void main(String[] args) {
		System.out.println("This is start");
		for (int i=0; i < 10; i++) {
			EXP x = new EXP();
			x.expAppend();
		}
		
		System.gc();
		System.out.println("This is end");
	}
}
