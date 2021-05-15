public class Function2 extends Function {

	public String answerString(double optVal, double x, double y, double z) {
		return ("Minimum time is " + String.format("%.2f", optVal) + " seconds and occurs if the dog runs " + String.format("%.2f", x) + " meters down the beach");
	}

	public String toString() {
		return ("Minimize the distance a dog will run and swim to retrieve a ball in the ocean");
	}

	@Override
	public double fnValue(double x) {
		return ( (x / 3) +  2 * Math.sqrt((x * x) - (8 * x) + 25) );
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
