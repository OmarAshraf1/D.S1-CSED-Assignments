package eg.edu.alexu.csd.datastructure.queue.csxx_csyy_cszz;
import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
import eg.edu.alexu.csd.datastructure.linkedList.csxx_csyy.singlelinkedlist;
import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

public class QueueLL implements ILinkedBased,IQueue {
	
	ILinkedList q = (ILinkedList) new singlelinkedlist();
	@Override
	public void enqueue(Object item) {
		
		q.add(item);
		
	}
	@Override
	public Object dequeue() {
		
		Object x = q.get(0) ; 
		q.remove(0);
		
		return x ;
		
	}
	@Override
	public boolean isEmpty() {
		
		
		return q.isEmpty() ;
	}
	@Override
	public int size() {
		
		return q.size() ;
	}
	

	

}
