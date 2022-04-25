package neat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This is a class for representing an individual NEAT genome.
 */

public class Genome {
	private double fitness = 0.0;
	private List<Connection> connections;
	private List<Node> nodes;
	private int innovationTracker = 0; // TODO: Should be more global (population class)
	private HashMap<Integer, Double> prevActivations;

	public Genome() {
		this.connections = new ArrayList<Connection>();
		this.nodes = new ArrayList<Node>();
	}

	/**
	 * Predict on a set of inputs.
	 * 
	 * @param inputs array of inputs
	 * @return array of outputs
	 */
	public double[] predict(double[] inputs) {
		// Save previous activations so we can use them for recurrent connections
		return new double[] {};
	}

	/**
	 * Crossover parents and a b to form a new network.
	 * 
	 * @param a the first parent
	 * @param b the second parent
	 * @return the child of the two parents
	 */
	public static Genome crossover(Genome a, Genome b) {
		return new Genome(); // TODO: Implement crossover
	}

	/**
	 * Returns the difference between two genomes. A higher value means they are
	 * less compatible.
	 * 
	 * @param a  the first genome
	 * @param b  the second genome
	 * @param c1 the factor for excess genes
	 * @param c2 the factor for disjoint genes
	 * @param c3 the factor for weight differences
	 * @return the delta between the two genomes
	 */
	public static float delta(Genome a, Genome b, float c1, float c2, float c3) {
		float n = 1; // The maximum amount of genes between the two genomes
		float e = 1; // The number of excess genes
		float d = 1; // The number of disjoint genes
		float w = 1; // The average difference of weights in matching genes (including disabled)
		
		// TODO
		
		return (c1 * e / n) + (c2 * d / n) + (c3 * w);
	}

	/**
	 * Returns a summary of all the weights and connections in the network.
	 * 
	 * @return string of weights and connections
	 */
	public String summarize() {
		return "";
	}

	// TODO
	protected void addNode() {
	}

	// TODO
	protected void addConnection() {
	}

	public double getFitness() {
		return fitness;
	}

	protected void setFitness(double fitness) {
		this.fitness = fitness;
	}
}
