package neat.activations;

/**
 * Hyperbolic tangent function. Kind of like sigmoid.
 */

public class TanH implements Activation {
	@Override
	public double eval(double input) {
		return (Math.exp(input) - Math.exp(-input)) / (Math.exp(input) + Math.exp(-input));
	}
}
