package neat;

import java.util.ArrayList;
import java.util.List;

public class Population {
	private List<Genome> genomes;
	private int size;
	private int innovationCounter;
	private float compatibilityThreshold;
	private boolean recurrent;

	// TODO: Initialize these somehow
	// TODO: Come up with sensible defaults for users who want something working
	// quick
	private float c1 = 1;
	private float c2 = 1;
	private float c3 = 1;

	public Population(int size, boolean recurrent) {
		this.genomes = new ArrayList<Genome>(size);
		this.size = size;
		this.recurrent = recurrent;
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
				if (s.inSpecies(g))
					s.add(g);
				newSpecies = false;
				break;
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
}
