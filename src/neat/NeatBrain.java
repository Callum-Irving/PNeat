package neat;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a class for representing an individual NEAT genome.
 */

public class NeatBrain {
	private List<ConnectionGene> connections;
	private List<NodeGene> nodes;
	private int innovationTracker = 0; // TODO: Should be more global (population class)

	public NeatBrain() {
		this.connections = new ArrayList<ConnectionGene>();
		this.nodes = new ArrayList<NodeGene>();
	}

	/**
	 * Crossover parents and a b to form a new network.
	 * 
	 * @param a the first parent
	 * @param b the second parent
	 * @return the child of the two parents
	 */
	public static NeatBrain crossover(NeatBrain a, NeatBrain b) {
		return new NeatBrain(); // TODO: Implement crossover
	}

	/**
	 * Returns the delta between two genomes. A higher value means they are less
	 * compatible.
	 * 
	 * @param a  the first genome
	 * @param b  the second genome
	 * @param c1 the factor for excess genes
	 * @param c2 the factor for disjoint genes
	 * @param c3 the factor for weight differences
	 * @return the delta between the two genomes
	 */
	public static float compatibility(NeatBrain a, NeatBrain b, float c1, float c2, float c3) {
		float n = 1; // The maximum amount of genes between the two genomes
		float e = 1; // The number of excess genes
		float d = 1; // The number of disjoint genes
		float w = 1; // The average difference of weights in matching genes (including disabled)
		return (c1 * e / n) + (c2 * d / n) + (c3 * w);
	}

	// TODO
	public void addNode() {
	}

	// TODO
	public void addConnection() {
	}
}
