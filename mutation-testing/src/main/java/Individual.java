//package MuTesting;
import java.util.ArrayList;
import java.util.Collections;
//import SampleTest;

public class Individual implements Cloneable{

    
    private ArrayList<Locus> individual = new ArrayList<Locus>();
    
    private double mutationScore = 0;
    private double distance = 0;
    public static int input = 0;
   
    
    // default constructor: empty tour
    public Individual(){
        for (int i = 0; i < AllLocuses.numberOfLocuses(); i++) 
        {
            individual.add(null);
        }
        //this.mutationScore = individual.getMutationScore();
        
    }
    
    @SuppressWarnings("unchecked")
	public Individual(ArrayList<Locus> individual){
        this.individual =  (ArrayList<Locus>) individual.clone();
    }
    
    public ArrayList<Locus> getIndividual(){
        return individual;
    }
    // creates a random individual
    public void generateIndividual() {
        // add all cities into the tour
        for (int index = 0; index < AllLocuses.numberOfLocuses(); index++) 
        {
          setLocus(index, AllLocuses.getLocus(index));
        }
        // permutes the tour cities randomly
        Collections.shuffle(individual);
    }

    // gets a  city from the tour
    public Locus getLocus(int tourPosition) {
        return (Locus)individual.get(tourPosition);
    }

    // Sets a city in a given position in the tour
    public void setLocus(int position, Locus locus) {
        individual.set(position, locus);
        // if the tour is changed, reset fitness/distance
        mutationScore = 0;
        distance = 0;
    }
    
    // Gets the tours fitness
    public double getFitness() {
//        if (fitness == 0) {
//            //for minimum length using 1/distance
//        	//fitness = 1/(double)getDistance();
//        	//for maximum length using distance
//        	fitness = (double)getDistance();
//        }
//        return fitness;
    	// call the plugin
		return mutationScore;
    }
    
//    public static int getX() {
//    	return AllLocuses.getLocus(0).getX();
//    }
    
    public void setMutationScore() {
    	setInput();
    	this.mutationScore = ParseHTML.getMutationScore();
    	//return mutationScore;
    	
    }
    
    public void setInput() {
    	int[] temp = new int[AllLocuses.numberOfLocuses()];
    	for (int i = 0; i < AllLocuses.numberOfLocuses(); i ++) {
    		temp[i] = AllLocuses.getLocus(i).getX();
    	}
    	SampleTest.input = temp;
    	
    }
    
//    // Gets the total distance of the tour
//    public double getDistance(){
//    	
////        if (distance == 0) {
////            double totalDistance = 0;
////            for (int cityIndex=0; cityIndex < tourSize(); cityIndex++) {
////                // suppose we travel from aCity to bCity
////                City aCity = getCity(cityIndex);
////                City bCity;
////                // check whether aCity is the last city of the tour, if yes 
////                // set bCity to be the beginning city of the tour
////                if(cityIndex+1 < tourSize()){
////                    bCity = getCity(cityIndex+1);
////                }
////                else{
////                    bCity = getCity(0);
////                }
////                // add the distance between two cities into the total distance
////                totalDistance = totalDistance + aCity.distance(bCity);
////            }
////            distance = totalDistance;
////        }
////        return distance;
//        
//    }

    // number of cities
    public int individualSize() {
        return individual.size();
    }
    
 // check if a city is in the tour
    public boolean containsLocus(Locus locus){
        return individual.contains(locus);
    }
    
    @Override
    public String toString() {
        String geneString = "";
        for (int i = 0; i < individualSize(); i++) {
            geneString += "(" + getLocus(i)+")";
        }
        return geneString;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {

        return super.clone();
    }
    
    
    
}

