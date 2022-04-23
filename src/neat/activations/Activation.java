package neat.activations;

public interface Activation {
	/**
	 * @param input the input to the activation function
	 * @return the output of the activation function
	 */
	public double eval(double input);
}
