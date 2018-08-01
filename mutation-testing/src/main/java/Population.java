//package MuTesting;
public class Population {

    Individual[] individuals;

    // Construct a population
    public Population(int populationSize, boolean initialise) {
        individuals = new Individual[populationSize];
        // for construct a population we only need to initialize it once for later 
        // generations the initializing is not needed so we use a boolean variable to 
        // control this
        if (initialise) {
            // creates all individuals at given size
            for (int i = 0; i < populationSize(); i++) {
                Individual newIndividual = new Individual();
                newIndividual.generateIndividual();
                newIndividual.setMutationScore();
                saveIndividual(i, newIndividual);
            }
        } else {
        	for (int i = 0; i < populationSize(); i++) {
//        		Individual newIndividual = getIndividual(i);
//        		newIndividual.setMutationScore();
        	}
        }
    }
    
   
    public void saveIndividual(int index, Individual individual) {
        individuals[index] = individual;
    }
    
    // gets a tour from the population given the index of the tour
    public Individual getIndividual(int index) {
        return individuals[index];
    }
    
 // select the best tour
    public Individual getFittest() {
        Individual bestIndividual = individuals[0];
        
        for (int i = 1; i < populationSize(); i++) {
            if (bestIndividual.getFitness() <= getIndividual(i).getFitness()) {
                bestIndividual = getIndividual(i);
            }
        }
        return bestIndividual;
    }

    

    // Gets population size
    public int populationSize() {
        return individuals.length;
    }
}