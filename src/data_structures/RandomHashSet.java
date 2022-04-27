package data_structures;

import java.util.ArrayList;
import java.util.HashSet;

public class RandomHashSet<T> {
	HashSet<T> set;
	ArrayList<T> data;

	public RandomHashSet() {
		this.set = new HashSet<>();
		this.data = new ArrayList<>();
	}

	public boolean contains(T obj) {
		return this.set.contains(obj);
	}

	public T random_element() {
		if (this.set.size() > 0)
			return this.data.get((int) Math.random() * this.size());
		else
			return null;
	}

	public int size() {
		return this.data.size();
	}

	public void add(T obj) {
		if (this.set.contains(obj))
			return;
		this.set.add(obj);
		this.data.add(obj);
	}

	public void clear() {
		this.set.clear();
		this.data.clear();
	}

	public T get(int index) {
		return this.data.get(index);
	}

	public void remove(int index) {
		this.set.remove(this.data.remove(index));
	}

	public void remove(T obj) {
		this.set.remove(obj);
		this.data.remove(obj);
	}

	public ArrayList<T> getData() {
		return this.data;
	}
}
