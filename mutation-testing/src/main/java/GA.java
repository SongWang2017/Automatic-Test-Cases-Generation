//package MuTesting;
public class GA {

	// parameters for GA
	// manually run the TSP_GA for multiple times when mutation rate is between
	// 0.08-0.10,
	// the results does not vary too much
	private static final double MUTATION_RATE = 0.0095;
	private static final int NUMBER_CANDIDATES = 4;

	// eolves a population over one generation
	public static Population evolve(Population pop) {
		Population newPopulation = new Population(pop.populationSize(), false);
		
		for (int i = 0; i < newPopulation.populationSize(); i++) {
			// select parents from current population/generation
			Individual parent1 = parentSelection(pop);
			Individual parent2 = parentSelection(pop);
			// crossover parents
			Individual child = crossover(parent1, parent2);
			child.setMutationScore();
			// add child to next generation
			newPopulation.saveIndividual(i, child);
		}

		// mutate
		for (int i = 0; i < newPopulation.populationSize(); i++) {
			mutate(newPopulation.getIndividual(i));
		}

		return newPopulation;
	}

	// crossover
	public static Individual crossover(Individual parent1, Individual parent2) {
		Individual child = new Individual();

		// get the index of the section to be crossed
		int startIndex = (int) (Math.random() * parent1.individualSize());
		int endIndex = (int) (Math.random() * parent1.individualSize());

		// add the section selected to the child
		for (int i = 0; i < child.individualSize(); i++) {

			if (startIndex < endIndex && i > startIndex && i < endIndex) {
				child.setLocus(i, parent1.getLocus(i));
			} else if (startIndex > endIndex) {
				if (!(i < startIndex && i > endIndex)) {
					child.setLocus(i, parent1.getLocus(i));
				}
			}
		}

		// fill the remaining cities of the child
		for (int i = 0; i < parent2.individualSize(); i++) {
			if (!child.containsLocus(parent2.getLocus(i))) {
				for (int j = 0; j < child.individualSize(); j++) {
					if (child.getLocus(j) == null) {
						child.setLocus(j, parent2.getLocus(i));
						break;
					}
				}
			}
		}
		return child;
	}

	// mutate: only swap mutation to make sure each child is valid under TSP
	public static void mutate(Individual individual) {
		for (int indexFirst = 0; indexFirst < individual.individualSize(); indexFirst++) {
			if (Math.random() < MUTATION_RATE) {
				// get a second random position in the tour
				int indexSecond = (int) (individual.individualSize() * Math.random());

				Locus locus1 = individual.getLocus(indexFirst);
				Locus locus2 = individual.getLocus(indexSecond);

				// swap
				individual.setLocus(indexSecond, locus1);
				individual.setLocus(indexFirst, locus2);
			}
		}
	}

	
	

	// selects candidate tour for crossover

	private static Individual parentSelection(Population pop) {
		Population selectPop = new Population(NUMBER_CANDIDATES, false);
		for (int i = 0; i < NUMBER_CANDIDATES; i++) {
			int randomId = (int) (Math.random() * pop.populationSize());
			selectPop.saveIndividual(i, pop.getIndividual(randomId));
		}
		// get the best parent for reproductive
		Individual fittest = selectPop.getFittest();
		return fittest;
	}
}