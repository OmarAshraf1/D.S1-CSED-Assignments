
public class test1 {

	public static <K, V> void main(String[] args) {
		TreeDictionary<Integer, Integer> t = new TreeDictionary<Integer, Integer>();

		t.set(3, 133);
		t.set(2, 53);
		t.set(5, 80);

		System.out.println(t.get(3));
	}

}
