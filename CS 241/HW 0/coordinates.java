
public class coordinates {
	
	//place holders for the data
	private genericPair <Double, Double> john;
		//"john" is a variable, has to be stored in a value that is a generic pair
	
	//constructor 
	coordinates(Double X, Double Y){
		john = new genericPair<Double,Double>();
		john.writeFirst(X);
		john.writeSecond(Y);
			// the generic pair is stored in john 
	}
	
	//instance methods 
	public Double readX() {
		return john.readFirst();
	}
	
	public Double readY() {
		return john.readSecond();
	}
	
	public Double distanceToOrigin() {
		//dont need parameter
		return Math.sqrt(Math.pow(john.readFirst(), 2) + Math.pow(john.readSecond(), 2));
	}
	
	public Boolean equals(coordinates point) {
		//needs parameter
		if { point.readX().equals(john.readFirst()) && point.readY().equals(john.readSecond()) }
		return true; 
		else {return false;}
	}
	
	A.equals(B);
	
	//test method 
	
	public static void main (String [] args) {
		
		coordinates paul = new coordinates(23, 5, 37, 9);
		System.out.println("Coordinate x=" + paul.readX());
		System.out.println("Coordinate y=" + paul.readY());
		System.out.println("The distance to originis d =" + paul.distanceToOrigin());
		System.out.println("The coordinates are" + paul.toString());
		
		coordinates george = new coordinates (2, 0, 3, 0);
		System.out.println(paul.equals(george));
		System.out.println(paul.equals())
		
	}

}


