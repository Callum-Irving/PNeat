package neat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Population {
	private List<Genome> genomes;
	private int size;
	private boolean recurrent;

	// TODO: Initialize these somehow
	// TODO: Come up with sensible defaults for users who want something working
	// quick
	private float c1 = 1;
	private float c2 = 1;
	private float c3 = 1;
	private float compatibilityThreshold;

	// Used so that we don't make the same connections with different innovation
	// numbers.
	private int connectionInnovation;
	private HashMap<ConnectionInnovation, Integer> pastConnections;
	private int nodeInnovation;
	private HashMap<NodeInnovation, Integer> pastNodes;

	private class ConnectionInnovation {
		// The innovation numbers of the nodes that the connection connects.
		int srcInnovation, destInnovation;
	}

	private class NodeInnovation {
		// The connection that is interrupted by the node being created.
		int connectionInnovation;
	}

	public Population(int size, boolean recurrent, float compatibilityThreshold, int numInputs, int numOutputs) {
		this.genomes = new ArrayList<Genome>(size);
		this.size = size;
		this.recurrent = recurrent;
		this.compatibilityThreshold = compatibilityThreshold;

		this.nodeInnovation = numInputs + numOutputs;
		this.connectionInnovation = numInputs * numOutputs;
		this.pastConnections = new HashMap<ConnectionInnovation, Integer>();
		this.pastNodes = new HashMap<NodeInnovation, Integer>();
	}

	public void trainOn(Trainer trainer) {
		// Compute fitness values
		for (Genome g : this.genomes) {
			g.setFitness(trainer.evaluate(g));
		}

		this.evolve();
	}

	private void evolve() {
		// Speciate
		ArrayList<Species> species = new ArrayList<>();
		for (Genome g : this.genomes) {
			boolean newSpecies = true;
			for (Species s : species) {
				if (s.inSpecies(g)) {
					s.add(g);
					newSpecies = false;
					break;
				}
			}
			if (newSpecies) {
				species.add(new Species(g));
			}
		}

		ArrayList<Genome> nextGen = new ArrayList<>(this.size);

		// Save the best from each species to the next generation
		for (Species s : species) {
			nextGen.add(s.getBest());
		}

		// TODO: Finish evolve function
		// Do selection and crossover to fill the rest of the spots

		// Sort by fitness
		// Select two parents for each remaining spot
		// Do crossover
		// Mutate child
		// Add to nextGen

		// Replace current generation with next generation
		this.genomes = nextGen;
	}

	public class Species {
		List<Genome> population;
		// The genome that potential members will be checked against
		Genome reference;

		public Species(Genome reference) {
			this.population = new ArrayList<Genome>();
			this.reference = reference;
		}

		public boolean inSpecies(Genome other) {
			return Genome.delta(this.reference, other, c1, c2, c3) < compatibilityThreshold;
		}

		public void add(Genome g) {
			this.population.add(g);
		}

		public Genome getBest() {
			Genome best = this.population.get(0);
			for (Genome g : this.population) {
				if (g.getFitness() > best.getFitness()) {
					best = g;
				}
			}

			return best;
		}
	}

	/**
	 * Get the best genome from the current population.
	 * 
	 * @return the genome with the highest fitness
	 */
	public Genome getBest() {
		Genome best = this.genomes.get(0);
		for (Genome g : this.genomes) {
			if (g.getFitness() > best.getFitness()) {
				best = g;
			}
		}

		return best;
	}

	/**
	 * Get the number of genomes in the population.
	 * 
	 * @return the number of genomes
	 */
	public int size() {
		return this.size;
	}

	// MUTATIONS
	private void mutateGenome(Genome g) {
		// TODO: Top level mutation function
	}

	private void mutateAddConnection(Genome g) {
		// Pick random nodes
		// Check if innovation has already happened
		// Add connection to g
	}

	private void mutateAddNode(Genome g) {
		// Pick random connection
		// Check if innovation has already happened
		// Add node to g
	}
}
