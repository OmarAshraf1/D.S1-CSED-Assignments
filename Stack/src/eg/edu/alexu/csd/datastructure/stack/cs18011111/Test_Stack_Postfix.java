package eg.edu.alexu.csd.datastructure.stack.cs18011111;

import org.junit.Assert;
import org.junit.Test;
 
/**
 * 
 * @author Omar
 *  
 */
public class Test_Stack_Postfix { 
		
	
	/**
	 * to test stack
	 */
	@Test
	public void test0() {
			Stack s = new Stack(); 
			s.push(1);
			s.push(2);
			s.push(3);
			s.push(4);
			s.push(5);
			s.pop() ;
			Assert.assertEquals(4, s.peek());
			
		}
	
	/** 
	 * to test evaluate while including a number contains more than one digit
	 * 
	 * 
	 */
	@Test
	public void test1() {
			Postfix exp = new Postfix(); 
			final String test = "22 3 4 * +"; 
			Assert.assertEquals(34, exp.evaluate(test));
			
		}
	
	
	/**
	 * test evaluate method
	 * 
	 * 
	 */
	@Test
	public void test2() {
			Postfix exp = new Postfix();
			final String test = "1 2 + 7 *";
			Assert.assertEquals(21, exp.evaluate(test));
			
		}
	/**
	 * Test infixToPostfix If expression begins with negative sign
	 * 
	 * 
	 */
	@Test
	public void test() {
			Postfix exp = new Postfix();
			final String test = "-51+6";  
			Assert.assertEquals("051-6+", exp.infixToPostfix(test));
			
		}
	
	/**
	 * Test infixToPostfix If expression is no thing
	 */
	@Test
	public void test3() {
		try
        { 
			Postfix exp = new Postfix(); 
			final String test = null; 
			Assert.assertEquals(null, exp.infixToPostfix(test));
        }
        catch(NullPointerException e) {
        	
        }
			
		}
	/**
	 * Test infixToPostfix 
	 */
	@Test
	public void test4() {
			Postfix exp = new Postfix();
			final String test = "22 + 35 * 4";
			Assert.assertEquals("22354*+", exp.infixToPostfix(test));
			
		}
	/**
	 * Test infixToPostfix 
	 */
	@Test
	
	public void test5() {
			Postfix exp = new Postfix();
			final String test = "(1 + 2) * 7";
			Assert.assertEquals("12+7*", exp.infixToPostfix(test));
			
		}
	/**
	 * Test infixToPostfix 
	 */
	@Test
	public void test6() {
			Postfix exp = new Postfix(); 
			final String test = "a / b - c + d * e - a * c";
			Assert.assertEquals("ab/c-de*+ac*-", exp.infixToPostfix(test));
			
		}
	/**
	 * Test infixToPostfix 
	 */
	@Test
	public void test7() {
			Postfix exp = new Postfix();
			final String test = "(a / (b - c + d)) * (e - a) * c";
			Assert.assertEquals("abc-d+/ea-*c*", exp.infixToPostfix(test));
			
		}
	
	
	
	

}
