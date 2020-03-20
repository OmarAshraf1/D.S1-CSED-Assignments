package eg.edu.alexu.csd.datastructure.linkedList.csxx_csyy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Polytest {


	/**
	 * To test setpoly method.
	 */
	@Test
	public void test_setpoly() {
		final polynomialsolver test = new polynomialsolver();
				 
		int[][] c = {{3, 7 }, {45, 5 },{176, 3 }, {128, 1 } };
		
		test.setPolynomial('C', c);
		assertEquals("3x^7+45x^5+176x^3+128x",test.print('C'));
		
				
	}
	/**
	 * To test multiply method.
	 */
	@Test
	public void testmultiply() {
		final polynomialsolver test = new polynomialsolver();
				 
		final int[][] a = {{0, 7 }, {0, 5 },
				{0, 3 }, {0, 1 } };
		final int[][] b = {{0, 5 }, {-1, 3 },
				{0, 2 }, {1, 1 }, {-1, 0 } };
		test.setPolynomial('A', a);
		test.setPolynomial('B', b);
		test.multiply('A', 'B');
		assertEquals("", test.print('R'));
	}
	/**
	 *test print
	 */
	@Test
	public void testprint1() {
		polynomialsolver instance = new polynomialsolver();
		instance.setPolynomial('C',
		new int[][] {{3, 7 }, {45, 5 },
			{176, 3 }, {128, 1 } });
		assertEquals(instance.print('C'), 
		"3x^7+45x^5+176x^3+128x");

	}
	
}
