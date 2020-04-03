package eg.edu.alexu.csd.datastructure.stack.cs18011111;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator ; 

import java.lang.Math;

/**
 * 
 * @author Omar
 *
 */
public class Postfix implements IExpressionEvaluator {
	/**
	 * Method to convert infix to postfix .
	 *
	 * @param expression
	 *            String to be converted from infix to postfix
	 * @return Result postfix string
	 *
	 *
	 */
	
	@Override
	public String infixToPostfix(String expression) {
		/**
		 * Stack used
		 */
		Stack stack = new Stack();
		/**
		 * The var which will be returned
		 */
		String result = "" ;
		
		
		//if expression begins with -ve sign
		if(expression.charAt(0) == '-') {
			expression =  expression.replaceFirst("-", "0-");
			
		}
		if(expression == null) {
			return null ;
		}
		
		/**
		 * Iterate over the given string
		 */
		for(int i = 0 ; i < expression.length() ; i++) {
			
			if(expression.charAt(i) == ' ' || expression.charAt(i) == ',') { 
				continue;
			}
			
			else if(isoperand(expression.charAt(i)) ) {
				result += expression.charAt(i) ;
			}
			
			else if(isoperator(expression.charAt(i))) {
				
				while(!stack.isEmpty() && hashigherprec((char)stack.peek(),expression.charAt(i)) && (char)stack.peek() != '(' ) {
					result += (char)stack.peek() ;
					stack.pop() ;
				}
				stack.push(expression.charAt(i));
			}
			else if(expression.charAt(i) == '(') {
				stack.push(expression.charAt(i));
			}
			else if(expression.charAt(i) == ')') {
				while(!stack.isEmpty() && (char)stack.peek() != '(') {
					result += (char)stack.peek() ;
					stack.pop();
				}
				stack.pop();
			}
			else {
				if(Character.isLetter(expression.charAt(i)) && Character.isLetter(expression.charAt(i+1)) ) {
					 throw new RuntimeException("Two letters without operation"); 
				}
				 throw new RuntimeException("Wrong expression"); 

			}
			
		}
		while(!stack.isEmpty()) {
			if((char)stack.peek() == '(') {
				 throw new RuntimeException();
			} 
			result += (char)stack.peek() ;
			stack.pop() ;
		}
		return result ;
	}
	/**
	 * Method to evaluate postfix operations .
	 *
	 * @param expression
	 * @return result after rounding the value
	 *
	 *
	 */
	
	@Override
	public int evaluate(String expression) {
		
		if(expression.equals(null) || expression.equals("")) {
			throw new RuntimeException("Now expression to evaluate");
		}
		Stack stack = new Stack();
		
		float result,res ;
		
		float op1 , op2 ;
		
		for(int i = 0 ; i < expression.length() ; i ++) {
			
			if(Character.isAlphabetic(expression.charAt(i))) {
				 throw new RuntimeException("Not a number to evaluate"); 

			}
			
			if(expression.charAt(i) == ' ' || expression.charAt(i) == ',') { 
				continue;
			}
			
			 if(Character.isDigit(expression.charAt(i))) {
				
				 	//if the number is more than one digit
					float operand = 0; 
					while(i<expression.length() && Character.isDigit(expression.charAt(i))) {
						 
						operand = (operand*10) + Float.parseFloat(""+(expression.charAt(i))); 
						i++;
					}
					
					i--;

					// Push operand to stack. 
					stack.push(operand);
			}
			
			else if(isoperator(expression.charAt(i))) {
				op2 = Float.parseFloat(""+stack.pop()) ;
						
				
				op1 = Float.parseFloat(""+stack.pop()) ;
				
				result = perform(expression.charAt(i),op1,op2) ;
				stack.push(result);
			}	
			
		}
		
		res =Float.parseFloat("" + stack.pop());
		 
		return (int)res ;
		
		
	}
	
	/**
	 * Method to return true if its an operand
	 * @param exp
	 * @return true if its an operand
	 * 
	 */
	public boolean isoperand(char exp) {
		if(Character.isLetter(exp) == true || Character.isDigit(exp) == true ) {
			return true ;
		}
		else {
			return false ;
		}
	}
	/**
	 * Method to return true if its an operator
	 * @param exp
	 * @return true if its an operator
	 * 
	 */
	public boolean isoperator(char exp) {
		if(exp == '+' || exp == '-' ||exp == '*' ||exp == '^' ||exp == '/') {
			return true ;
		}
		else {
			return false ;
		}
	}
	/**
	 * Method to compare higher prec
	 * @param peek and new exp
	 * @return true if top is higher
	 */
	public static boolean hashigherprec(char op1, char op2){
	    int op1Weight = GetOperatorWeight(op1);
	    int op2Weight = GetOperatorWeight(op2);
	    if (op1Weight == op2Weight){
	        return true;
	    }
	    return op1Weight>op2Weight? true : false;
	}

	public static int GetOperatorWeight(char op){
	    int weight = -1;
	    switch (op)
	    {
	        case '+':
	        case '-': 
	            weight = 1;
	            break;
	        case '*':
	        case '/':
	            weight = 2;
	            break ;
	        case '^':
	        	weight = 3 ;
	        	break ;
	    }
	    return weight;
	}
	/**
	 * Method to evaluate two operands
	 * @param operator and two operands
	 * @return value of the operation
	 */
	public float perform(char operator,float op1,float op2) {
		float result  ;
		switch(operator) {
		case '+' :
			result = op1 + op2 ;
			break ;
		case '-' :
			result = op1 - op2 ;
			break ;
		case '*' :
			result = op1 * op2 ;
			break ;
		case '/' :
			if(op2 == 0) {
				throw new RuntimeException("Cant divide by zero");
			}
			result = op1 / op2 ;
			break ;
		case '^' :
			result= (int) Math.pow(op1, op2) ;
			break ;
		default:
			 throw new RuntimeException();

		}
		return result ;
	}
	
	
}
