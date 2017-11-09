package lec_19_class;

import lec_14_and_15_class.linked_list_client;

public class HashTable<K, V> {

	private class HTPair {
		K key;
		V value;

		HTPair(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public boolean equals(Object other) {
			HTPair op = (HTPair) other;
			return this.key.equals(op.key);
		}

		public String toString() {
			return "{" + this.key + ":" + this.value + "}";
		}
	}

	private LinkedList<HTPair>[] bucketArray;
	private int size;
	private static int def_cap = 10;

	HashTable() {
		this(def_cap);
	}

	HashTable(int cap) {
		this.bucketArray = (LinkedList<HTPair>[]) (new LinkedList[cap]);
		// to convert into linkedlist<HTPair>[]
		this.size = 0;
	}

	public void put(K key, V value) throws Exception {
		int bi = hashfunc(key);
		HTPair pta = new HTPair(key, value);
		LinkedList<HTPair> bucket = this.bucketArray[bi];
		if (bucket == null) {
			bucket = new LinkedList<>();
			bucket.addLast(pta);
			this.size++;
			this.bucketArray[bi] = bucket;

		} else {
			int foundAt = bucket.find(pta);
			if (foundAt == -1) {
				bucket.addLast(pta);
				this.size++;
			} else {
				HTPair ov = bucket.getAt(foundAt);
				ov.value = value;
			}
		}
		double limit = (this.size * 1.0) / this.bucketArray.length;
		if (limit > 2) {
			rehash();
		}

	}

	private void rehash() {
		LinkedList<HTPair>[] oba = this.bucketArray;
		this.bucketArray = (LinkedList<HTPair>[]) new LinkedList[2 * oba.length];
		this.size = 0;
		try {
			for (LinkedList<HTPair> ob : oba) {
				while (ob != null && !ob.isEmpty()) {
					HTPair pta = ob.removeFirst();
					this.put(pta.key, pta.value);
				}
			}
		} catch (Exception e) {
			// do nothing
		}
	}

	public V get(K key) throws Exception {
		int bi = hashfunc(key);
		HTPair key_part = new HTPair(key, null);
		LinkedList<HTPair> bucket = this.bucketArray[bi];
		if (bucket == null) {
			return null;
		}
		int foundAt = this.bucketArray[bi].find(key_part);
		if (foundAt == -1) {
			return null;
		} else {
			V val = this.bucketArray[bi].getAt(foundAt).value;
			return val;
		}
	}

	public V remove(K key) throws Exception {
		int bi = hashfunc(key);
		HTPair key_part = new HTPair(key, null);
		LinkedList<HTPair> bucket = this.bucketArray[bi];
		if (bucket == null) {
			return null;
		}

		int foundAt = this.bucketArray[bi].find(key_part);
		if (foundAt == -1) {
			return null;
		} else {
			V val = this.bucketArray[bi].removeAt(foundAt).value;
			return val;
		}
	}

	private int hashfunc(K key) {
		int hc = key.hashCode();
		int temp = (int) Math.abs(hc);
		return (temp % this.bucketArray.length);
	}

	public void display() throws Exception {
		for (int i = 0; i < this.bucketArray.length; i++) {
			if (this.bucketArray[i] == null) {
				System.out.println("null\n*************************");
			} else {
				this.bucketArray[i].display();
			}
			System.out.println();
		}
	}

}
