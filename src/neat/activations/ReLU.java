package neat.activations;

/**
 * Rectified Linear Unit activation function. Returns the max of the input and
 * 0.
 */

public class ReLU implements Activation {
	@Override
	public double eval(double input) {
		return Math.max(0, input);
	}
}
