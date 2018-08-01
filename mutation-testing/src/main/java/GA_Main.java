//package MuTesting;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class GA_Main {
	
	

    public static void main(String[] args) {

    	
    		int k = 0;
    	    while (k < 8) {   	      
    	    	Locus locus = new Locus();
    	    	AllLocuses.addLocus(locus);
    	        k++;	    	    	    	    	    	
    	    }
    	    System.out.println(AllLocuses.numberOfLocuses());
    	    
    	    int[] x = new int[2];
    	    x[0] = 3;
    	    x[1] = 9;
//    	    setInput(x);

    	
        // initial population
    	for (int j = 0; j < 1; j++)
        {
        Population pop = new Population(10, true);
        System.out.println("initial mutationScore: " + pop.getFittest().getFitness());
        
        // measuring the execution time
        long startTime = System.currentTimeMillis();
 

        // using GA
        
        
        
        //pop = GA.evolve(pop);
        for (int i = 0; i < 2; i++) {
            pop = GA.evolve(pop);
        }
        
        

        // display results
        System.out.println("final mutationScore: " + pop.getFittest().getFitness());
        System.out.println("solution:");
        System.out.println(pop.getFittest());
        System.out.println(launchPitest.count);
        long stopTime = System.currentTimeMillis();
        
        System.out.println("Running time: " + (stopTime - startTime) + "ms");
        }
                                                  
        
    }
    
//    public static void setInput(int[] x) {
//    	int len = x.length;
//    	SampleTest.x = x[0];
//    	SampleTest.y = x[1];
//    }
        
        
}
