//package MuTesting;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class RandomSearch {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		final double NUMBER_ITERATION = 20000000;
		String file = "C:/Users/wangsong/Documents/Evolutional Computing and Automation/tsp2.txt";
    	
    	try {

    	    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
    	    
    	    String str;

    	    while (( str = br.readLine()) != null) {   	      
    	    	//String[] xAndY = str.split("    ");
    	    	//double x = Double.valueOf(xAndY[1]);
    	    	//double y = Double.valueOf(xAndY[2]);
    	    	Locus bit = new Locus();
    	        AllLocuses.addLocus(bit);
    	    	//System.out.println(str);    	    	    	    	    	    	    	
    	    }
    	    br.close();
    	    
    	    System.out.println(AllLocuses.numberOfLocuses());

    	} catch (IOException e) {
    	    System.out.println("ERROR: unable to read file " + file);
    	    e.printStackTrace();   
    	}
    	
    	
        
        // measuring the execution time
        long startTime = System.currentTimeMillis();
        
        Individual individual = new Individual();
    	individual.generateIndividual(); 
        double bestFitness = individual.getFitness();
        Individual bestIndividual = (Individual) individual.clone();
        
        
        
        System.out.println("initial distance: " + individual.getFitness());
        // using random search
        for (int i = 0; i < NUMBER_ITERATION; i++)
        {
        	individual.generateIndividual();
        	//Tour newTour = tour;
        	double newFitness = individual.getFitness();
        	if (newFitness > bestFitness)
        	{
        		bestFitness = newFitness;
        		bestIndividual = (Individual) individual.clone();
        		
        	}      	
        	
        }
        
        
        long stopTime = System.currentTimeMillis();
        
        System.out.println("Running time: " + (stopTime - startTime) + "ms");

        // display results
        System.out.println("final distance: " +bestFitness);
        System.out.println("solution:");
        System.out.println(bestIndividual);
    }
		

}
