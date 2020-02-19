package calculator3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class calcTest {

	@Test
	void test() {
		implementation test = new implementation() ;
		
		//Add method test

		assertEquals(10,test.add(5, 5));
		assertEquals(200,test.add(150, 50));
		assertEquals(10000,test.add(8000, 2000));
		assertEquals(0,test.add(-1,1));
		assertEquals(-30,test.add(-50, 20));
		assertEquals(-150,test.add(-50, -100));
		assertEquals(100000000,test.add(90000000, 10000000));
		assertEquals(1000000000,test.add(990000000, 10000000));
		
		
		//Divide method test
		
		
		try {
		test.divide(5, 0) ;
		assertEquals(0.25,test.divide(1,4));	
		assertEquals(1,test.divide(5, 5));
		assertEquals(2.5,test.divide(10,4));
		assertEquals(7.5,test.divide(15,2 ));
		assertEquals(1,test.divide(-5, -5));
		assertEquals(4,test.divide(8, 2));
		assertEquals(0,test.divide(0,20 ));
		assertEquals(0.5,test.divide(1,2 ));
		assertEquals(-5,test.divide(-50,10 ));
		assertEquals(20000,test.divide(100000000,5000 ));
		}catch(RuntimeException r) { 
			System.out.println("You can't divide a number by zero");
		}
	

		
		

		
		
		




		
	}

}
