package neat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import neat.activations.Activation;
import neat.activations.Linear;
import neat.activations.ReLU;
import neat.activations.TanH;

/**
 * This is a class for representing an individual NEAT genome.
 */

public class Genome {
	private double fitness = 0.0;

	private int nodeCount = 0;
	private int connectionCount = 0;

	private int numInputs;
	private int numOutputs;
	private List<Connection> connections;
	private List<Node> nodes;
	private List<Node> inputs;
	private List<Node> outputs;

	private HashMap<Integer, Double> prevActivations;

	private Activation hiddenAct;
	private Activation outputAct;

	public Genome(int numInputs, int numOutputs, Activation hiddenAct, Activation outputAct) {
		this.connections = new ArrayList<Connection>();
		this.nodes = new ArrayList<Node>();
		this.hiddenAct = hiddenAct;
		this.outputAct = outputAct;

		// Add input nodes
		for (int i = 0; i < numInputs; i++) {
			this.addNode(this.nodeCount, Node.Type.INPUT);
		}

		// Add output nodes
		for (int i = 0; i < numOutputs; i++) {
			this.addNode(this.nodeCount, Node.Type.OUTPUT);
		}

		// Connect all inputs and outputs
		for (Node src : this.inputs) {
			for (Node dest : this.outputs) {
				this.addConnection(src.getInnovation(), dest.getInnovation(), this.connectionCount);
			}
		}
	}

	/**
	 * Predict on a set of inputs.
	 * 
	 * @param inputs array of inputs
	 * @return array of outputs
	 */
	public double[] predict(double[] inputs) {
		// TODO: Add network feed-forward
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
		// Ensure a is the fitter genome
		if (a.fitness < b.fitness) {
			Genome temp = a;
			a = b;
			b = temp;
		}

		// TODO: Implement crossover
		return new Genome(a.numInputs, a.numOutputs, a.hiddenAct, a.outputAct);
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

		// TODO: Implement delta function for genomes

		return (c1 * e / n) + (c2 * d / n) + (c3 * w);
	}

	/**
	 * Returns a summary of all the weights and connections in the network.
	 * 
	 * @return string of weights and connections
	 */
	public String summarize() {
		// TODO: Summarize genome
		return "";
	}

	protected void addNode(int innovation, Node.Type type) {
		Node newNode = new Node(innovation, type);
		switch (type) {
		case INPUT:
			this.inputs.add(newNode);
			this.nodes.add(newNode);
			break;
		case OUTPUT:
			this.outputs.add(newNode);
			this.nodes.add(newNode);
			break;
		case HIDDEN:
			this.nodes.add(newNode);
			break;
		}
		this.nodeCount++;
	}

	// TODO: Add connection mutation
	protected void addConnection(int src, int dest, int innovation) {
		this.connections.add(new Connection(src, dest, innovation));
		this.connectionCount++;
	}

	public double getFitness() {
		return fitness;
	}

	protected void setFitness(double fitness) {
		this.fitness = fitness;
	}
}
