

public class Function1 extends Function {

	@Override
	public double fnValue(double x) {
		if (x==0.0) 
			return Double.MAX_VALUE;
		else 
			return ((0.8 * Math.PI * (x * x)) + (800 / x));
	}
	
	public String toString() {
		return "Minimize the cost of a can that will hold 2 liters of liquid";
	}
	public String answerString(double optVal, double x, double y, double z) {
		return "Minimum cost is $" + String.format("%.2f", optVal) + " with height = " + String.format("%.2f", y) + "cm and radius = " + String.format("%.2f", x) + "cm";
	}
	public double getXVal (double x) {
		return x;
	}
	
	public double getYVal (double x) {
		return (2000 / (Math.PI * (x * x)));
	}
	
	public double getZVal (double x) {
		return -1.0;
	}
}
