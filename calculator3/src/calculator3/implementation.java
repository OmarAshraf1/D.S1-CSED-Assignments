package calculator3;

//Class implements interface
public class implementation  implements calc {
	
	//Add function
	public int add(int x, int y) {
	 
		return x + y ;
		
	}
	
	//Divide function
	public float divide(int x, int y) throws RuntimeException{
		//Check if y is valid
		if(y == 0) {
			 throw new ArithmeticException("Not finite");			
		}
		else {
			
			return (float)x / (float)y ;	
		}
		
		
		
}
}	
