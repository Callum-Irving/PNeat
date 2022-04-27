package neat;

class Node {
	private int innovation;
	private Type type;

	public enum Type {
		INPUT, HIDDEN, OUTPUT
	}

	public Node(int innovation, Type t) {
		this.innovation = innovation;
		this.type = t;
	}

	public int getInnovation() {
		return this.innovation;
	}
}
