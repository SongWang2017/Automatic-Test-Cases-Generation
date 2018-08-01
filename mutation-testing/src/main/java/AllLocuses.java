

import java.util.ArrayList;

/**
 * Created specifically for one individual
 *
 */

public class AllLocuses {

    //creats an ArrayList for all cities
    private static ArrayList<Locus> locuses = new ArrayList<Locus>();

    // Adds a city
    public static void addLocus(Locus locus) {
        locuses.add(locus);
    }
    
    // Get a city
    public static Locus getLocus(int index){
        return (Locus)locuses.get(index);
    }
    
    // Get the number of cities
    public static int numberOfLocuses(){
        return locuses.size();
    }
}
