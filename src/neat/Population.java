package neat;

import java.util.ArrayList;
import java.util.List;

public class Population {
	private List<Genome> genomes;
	private int size;
	private int innovationCounter;
	private int compatibilityThreshold;
	private boolean recurrent;

	public Population(int size, boolean recurrent) {
		this.genomes = new ArrayList<Genome>(size);
		this.size = size;
		this.recurrent = recurrent;
	}

	public void trainOn(Trainer trainer) {
		// Compute fitnesses
		for (Genome g : this.genomes) {
			g.setFitness(trainer.evaluate(g));
		}

		this.evolve();
	}

	private void evolve() {
		// Speciate
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
}
