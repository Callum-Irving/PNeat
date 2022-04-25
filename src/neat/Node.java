package neat;

import neat.activations.Activation;

class Node {
	private int id;
	private Activation activation;
	private Type type;

	private enum Type {
		Input, Hidden, Output
	}

	public Node(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}
}
