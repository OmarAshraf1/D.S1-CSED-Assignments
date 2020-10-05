
public class TreeDictionary<K extends Comparable<K>, V> implements IDictionary<K, V> {
	int length = 0;

	public class HashNode<K, V> {

		public K key;
		public V value;

		HashNode(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	public class TreeNode {
		public Object key;
		public Object value;
		public TreeNode left, right;

		public TreeNode(Object key, Object value) {
			this.key = key;
			this.value = value;
		}
	}

	TreeNode root = null;
	// used to store numbers
	V resget;
	V resremove;

	@Override
	public V get(K key) {

		// by traversing the tree till a key is found using in order traversal

		// a helper function
		inorder(root, key);

		return resget;

	}

	// helper function to get elements
	public void inorder(TreeNode root1, K key) {

		if (root1 == null) {
			return;
		}
		if (key.compareTo((K) flag) == 0) {
			throw new RuntimeException();
		}
		inorder(root1.left, key);
		if (key.compareTo((K) root1.key) == 0) {
			// submit the value to a variable to be used in the main (get) method
			resget = (V) root1.value;
		}
		inorder(root1.right, key);
	}

	@Override
	public V set(K key, V value) {
		// add key and value to tree node
		length++;
		// set by using a helper function (insert)
		root = insert(root, key, value);

		return value;
	}

	// the set helper method
	public TreeNode insert(TreeNode root1, K key, V value) {

		if (root1 == null) {
			root1 = new TreeNode(key, value);
		}
		if (key.compareTo((K) root1.key) < 0) {
			root1.left = insert(root1.left, key, value);
		} else if (key.compareTo((K) root1.key) > 0) {
			root1.right = insert(root1.right, key, value);
		}
		return root1;

	}

	@Override
	public V remove(K key) {

		length--;
		// by using helper function (in order remove)
		inorderremove(root, key);

		return resremove;
	}

	Object flag = -1;

	// helper function to remove elements
	public void inorderremove(TreeNode root1, K key) {

		if (root1 == null) {
			return;
		}
		inorderremove(root1.left, key);
		if (key.compareTo((K) root1.key) == 0) {
			resremove = (V) root1.value;
			root1.key = flag;

		}
		inorderremove(root1.right, key);
	}

	@Override
	public boolean isEmpty() {

		return (length == 0);
	}

}
