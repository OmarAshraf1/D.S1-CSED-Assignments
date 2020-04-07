package eg.edu.alexu.csd.datastructure.queue.csxx_csyy_cszz;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Queuelltest {

	@Test
	void test() {
		QueueLL q = new QueueLL() ;
		for(int i = 0 ; i < 6 ; i++) {   
			q.enqueue(i);
		}
		q.dequeue() ;
		q.dequeue() ;
		assertEquals(3, q.dequeue());
	}

}
