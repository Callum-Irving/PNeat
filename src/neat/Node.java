package neat;

import neat.activations.Activation;

class Node {
	private int id;
	private Activation activation;
	private Type type;

	public enum Type {
		INPUT, HIDDEN, OUTPUT
	}

	public Node(int id, Type t) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}
}
