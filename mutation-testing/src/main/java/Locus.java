//package MuTesting;
public class Locus {
	int x;
    //double y;
    
    // default constructor
    public Locus(){
    	this.x = (int) (Math.random() * 1000);
//    	if (Math.random() >= 0.5) {
//    		this.x = 0;
//    	} else {
//    		this.x = 1;
//    	}
        //this.x = Math.random();
        //this.y = Math.random();
    }
    
    // Constructor for city with x, y coordinates
    public Locus(int x){//, double y){
        this.x = x;
        //this.y = y;
    }
    
    
    public int getX(){
        return this.x;
    }
    
    
    // calculate the distance to a certain city
//    public double distance(City city){
//        double xDiff = Math.abs(getX() - city.getX());
//        double yDiff = Math.abs(getY() - city.getY());
//        double distance = Math.sqrt( Math.pow(xDiff, 2) + Math.pow(yDiff, 2) );
//        
//        return distance;
//    }
    
    @Override
    //print the city as a pair of x,y cooridnates
    public String toString(){
        return getX() + "";//+", "+getY();
    }

}
