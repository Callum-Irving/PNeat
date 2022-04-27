package neat;

class Connection {
	private int innovation;

	private int srcId;
	private int destId;
	private double weight;
	private boolean expressed;
	private boolean recurrent;

	public Connection(int srcId, int destId, int innovation) {
		this.srcId = srcId;
		this.destId = destId;
		this.innovation = innovation;
		// TODO: Use normal distribution
		this.weight = Math.random() * 2.0 - 1.0;
		this.expressed = true;
		this.recurrent = false;
	}

	protected void setInnovation(int i) {
		this.innovation = i;
	}

	public int getInnovation() {
		return this.innovation;
	}

	public boolean isRecurrent() {
		return this.recurrent;
	}
}
