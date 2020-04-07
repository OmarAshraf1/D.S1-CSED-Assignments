package eg.edu.alexu.csd.datastructure.queue.csxx_csyy_cszz;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayQueueTest {

	@Test
	void test1() {
		ArrayQueue q = new ArrayQueue(100);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		
		assertEquals(3, q.size());
		assertEquals(false, q.isEmpty());
		
		assertEquals(1, (int) q.dequeue());
		assertEquals(2, q.size());
		assertEquals(false, q.isEmpty());
		
		assertEquals(2, (int) q.dequeue());
		assertEquals(1, q.size());
		assertEquals(false, q.isEmpty());
		
		assertEquals(3, (int) q.dequeue());
		assertEquals(0, q.size());
		assertEquals(true, q.isEmpty());
		
		RuntimeException b = assertThrows (RuntimeException.class , () -> q.dequeue());
		assertEquals("It's Empty, Sir :(" , b.getMessage() );
		
		}
	
	/** QueueFullException Test */
	@Test
	void test2() {
		ArrayQueue q = new ArrayQueue(3);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(2);

		RuntimeException b = assertThrows (RuntimeException.class , () -> q.enqueue(3));	// QueueFullException message Test
		assertEquals("It's Full, Sir :(" , b.getMessage() );
		
	}
	
	
	@Test
	void test3() {
		ArrayQueue q = new ArrayQueue(100);
		q.enqueue(5);
		q.enqueue(7);
		
		assertEquals(2, q.size());
		assertEquals(false, q.isEmpty());
		assertEquals(5, (int) q.dequeue());
		
		q.enqueue(9);
		assertEquals(7, (int) q.dequeue());
		assertEquals(9, (int) q.dequeue());
		assertEquals(true, q.isEmpty());
		RuntimeException b = assertThrows (RuntimeException.class , () -> q.dequeue());		// QueueEmptyException message Test
		assertEquals("It's Empty, Sir :(" , b.getMessage() );

	}
	
	
	@Test
	void test4() {
		ArrayQueue q = new ArrayQueue(100);
		q.enqueue(6);
		q.enqueue(13);
		
		assertEquals(2, q.size());
		assertEquals(false, q.isEmpty());
		
		q.enqueue(20);
		q.enqueue(24);
		
		assertEquals(4, q.size());
		assertEquals(6, (int) q.dequeue());
		
		q.enqueue(24);
		assertEquals(13, (int) q.dequeue());
		assertEquals(false, q.isEmpty());
	}

}
