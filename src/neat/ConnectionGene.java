package neat;

class ConnectionGene {
	private int srcId;
	private int destId;
	private double weight;
	private boolean expressed;
	private int innovation;

	public ConnectionGene(int srcId, int destId, int innovation) {
		this.srcId = srcId;
		this.destId = destId;
		this.innovation = innovation;
		// TODO: Use normal distribution
		this.weight = Math.random() * 2.0 - 1.0;
		this.expressed = true;
	}

	public int getInnovation() {
		return this.innovation;
	}
}
