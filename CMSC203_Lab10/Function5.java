
public class Function5 extends Function0 {
	@Override
	public double fnValue(double x) {
		return Math.sin(1/x);
	}
	
	public String toString() {
		return "sin(1/x)";
	}
}
