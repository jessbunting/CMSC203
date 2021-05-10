
public class Function4 extends Function0 {
	@Override
	public double fnValue(double x) {
		return (Math.pow(x,3) - (7*Math.pow(x,2)) + 15*x - 9);
	}
	
	public String toString() {
		return "x^3 - 7*x^2 + 15*x - 9";
	}
}
