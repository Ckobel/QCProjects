public class myHashMap {
	private final static int TABLE_SIZE = 10000;

	HashEntry[] table;

	myHashMap() {
		table = new HashEntry[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++)
			table[i] = null;
	}
	
	public int size(){
		return TABLE_SIZE;
	}

	public String get(int key) {
		int hash = (key % TABLE_SIZE);
		while (table[hash] != null && table[hash].getKey() != key)

			hash = (hash + 1) % TABLE_SIZE;

		if (table[hash] == null)

			return null;

		else

			return table[hash].getValue();

	}

	public void put(int key, String value) {
		int hash = (key % TABLE_SIZE);
		while (table[hash] != null && table[hash].getKey() != key)

			hash = (hash + 1) % TABLE_SIZE;

		table[hash] = new HashEntry(key, value);

	}

}
