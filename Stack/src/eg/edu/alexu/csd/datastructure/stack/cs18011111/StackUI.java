package eg.edu.alexu.csd.datastructure.stack.cs18011111;
import java.util.Scanner;

/**
 * 
 * @author Omar
 *
 */
public class StackUI {
	
	public static void main(String[] args) {
		Stack stack = new Stack() ;
		Scanner in  = new Scanner(System.in) ;
		int operation ;
		System.out.printf("Insert your operation \n1:Push \n2:Pop \n3:Peek \n4:Get size \n5:Check if empty \n*to stop and print stack press 0 ") ;
		while(true) {

			operation = in.nextInt() ;
			if(operation == 1) {
				System.out.printf("\nEnter element to push");
				int element = in.nextInt() ;
				stack.push(element);	
			}
			else if(operation == 2) {
				System.out.println(stack.pop()) ;
			}
			else if(operation == 3) {
				System.out.println(stack.peek() ) ;
			} 
			else if(operation == 4) {
				System.out.println(stack.size()) ;
			}
			else if(operation == 5) {
				System.out.println(stack.isEmpty()) ;
			}
			else if(operation == 0) {
				stack.print();
				break ;
			}
			else {
				throw new RuntimeException();
			}
			
			
			
		}
	
}

}
