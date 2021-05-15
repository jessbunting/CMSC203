
public class Function3 extends Function {

	public String answerString(double optVal, double x, double y, double z) {
		return ("The distance between the given point and the closest point on the parabola is " + String.format("%.2f", optVal)); //+ " at " + x);
	}

	public String toString() {
		return ("Find the minimum distance between the function f(x)=x^2 and the point (0,1)");
	}

	@Override
	public double fnValue(double x) {
		return (Math.sqrt(Math.pow(x, 4) - Math.pow(x, 2) + 1));
	}


	public double getXVal(double x) {
		return x;
	}


	public double getYVal(double x) {
		return -1.0;
	}


	public double getZVal(double x) {
		return -1.0;
	}

}