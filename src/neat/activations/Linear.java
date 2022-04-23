package neat.activations;

/**
 * Linear activation function.
 */

public class Linear implements Activation {
	@Override
	public double eval(double input) {
		return input;
	}
}
