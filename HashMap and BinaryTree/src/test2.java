public class test2 {
	public static void main(String[] args) {

		BstUtils tree = new BstUtils();
		int[] a = { 10, 9, 7, 6, 1, 2 };
		int[] b = new int[a.length];
		b = tree.nextSmallerNumber(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(b[i]);
		}
	}

	static void inorder(BinaryTreeNode root1) {
		if (root1 == null) {
			return;
		}

		inorder(root1.left);
		System.out.println(root1.element);
		inorder(root1.right);

	}

}
