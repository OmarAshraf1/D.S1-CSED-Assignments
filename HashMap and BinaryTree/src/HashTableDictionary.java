public class HashTableDictionary<K, V> implements IDictionary<K, V> {
	int length = 0;

	public class HashNode<K, V> {

		public K key;
		public V value;

		HashNode(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	int n = 11; // size of array
	public HashNode<K, V>[] table = new HashNode[n];

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub

		int count = 0;

		int index = key.hashCode() % n;
		while (table[index] != null) {
			// to handle wrong key inputs
			if (count > n) {
				return null;
			}
			count++;
			if (table[index].key == key) {
				return table[index].value;
			}
			index = (index + 1) % n;
		}

		return null;
	}

	@Override
	public V set(K key, V value) {
		// TODO Auto-generated method stub
		HashNode<K, V> temp = new HashNode<K, V>(key, value);
		// if it is full
		if (length == n) {
			throw new RuntimeException();
		}
		// the hash function
		int probe = key.hashCode() % n;
		// make linear probing if the index array is contained
		while (table[probe] != null && table[probe].key != key) {
			probe = (probe + 1) % n;
		}
		table[probe] = temp;
		length++;
		return value;

	}

	@Override
	public V remove(K key) {

		int count = 0;
		int index = key.hashCode() % n;
		if (key == null) {
			throw new RuntimeException();
		}
		while (table[index] != null) {
			if (count > n) {
				return null;
			}
			count++;
			if (table[index].key == key) {
				HashNode<K, V> temp = table[index];
				// make the array index null to be removed
				table[index] = null;
				length--;
				return temp.value;
			}
			index = (index + 1) % n;
		}

		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (length == 0);
	}

}
