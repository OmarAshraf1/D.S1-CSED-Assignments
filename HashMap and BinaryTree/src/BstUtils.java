import eg.edu.alexu.csd.datastructure.stack.cs18011111.Stack;

public class BstUtils implements IMiscUtils {

	public BinaryTreeNode insert(BinaryTreeNode root, int element) {
		if (root == null) {
			root = new BinaryTreeNode(element);
			return root;
		}
		if ((int) root.element > element) {
			root.left = insert(root.left, element);
		} else if ((int) root.element < element) {
			root.right = insert(root.right, element);

		}
		return root;
	}

	int sum = 0;

	public int sumRange(BinaryTreeNode root, int low, int high) {
		Stack s = new Stack();
		s.push(root);
		while (!s.isEmpty()) {
			BinaryTreeNode temp = (BinaryTreeNode) s.pop();
			if (temp != null) {
				if ((int) temp.element >= low && (int) temp.element <= high) {
					sum += (int) temp.element;
				}
				if ((int) temp.element > low) {
					s.push(temp.left);
				}
				if ((int) temp.element < high) {
					s.push(temp.right);
				}
			}

		}
		return sum;

	}

	public boolean isValidBST(BinaryTreeNode root) {

		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean helper(BinaryTreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}
		int val = (int) root.element;
		if (val < min || val > max) {
			return false;
		}
		return helper(root.left, min, (int) root.element - 1) && helper(root.right, (int) root.element + 1, max);
	}

	public int[] nextSmallerNumber(int[] array) {
		// by using own implemented stack and hash table
		Stack s = new Stack();

		HashTableDictionary<Integer, Integer> hm = new HashTableDictionary<Integer, Integer>();

		int[] res = new int[array.length];
		s.push(array[0]);
		for (int i = 1; i < array.length; i++) {

			if (s.isEmpty()) {
				s.push(array[i]);
				continue;
			}
			while (s.isEmpty() == false && (int) s.peek() > array[i]) {
				hm.set((Integer) s.peek(), i);
				s.pop();
			}
			s.push(array[i]);
		}
		while (s.isEmpty() == false) {
			hm.set((Integer) s.peek(), -1);
			s.pop();
		}
		for (int i = 0; i < array.length; i++) {
			res[i] = hm.get(array[i]);
		}

		return res;
	}

}
