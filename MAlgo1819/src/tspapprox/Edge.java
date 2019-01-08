package tspapprox;

public class Edge {
	
	private double weight;
	private Vertex source;
	private Vertex target;
	
	/**
	 * Creates a new Edge.
	 * @param source source vertex of the edge
	 * @param target target vertex of the edge
	 * @param weight weight of the edge
	 */
	public Edge(Vertex source, Vertex target, double weight) {
		this.source = source;
		this.target = target;
		this.weight = weight;
	}

	/**
	 * Returns the weight of this edge.
	 * @return weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Returns the source of this edge.
	 * @return source
	 */
	public Vertex getSource() {
		return source;
	}
	
	/**
	 * Sets the source of this edge.
	 * @param source
	 */
	public void setSource(Vertex source) {
		this.source = source;
	}

	/**
	 * Returns the target of this edge.
	 * @return target
	 */
	public Vertex getTarget() {
		return target;
	}
	
	/**
	 * Sets the target of this edge.
	 * @param target
	 */
	public void setTarget(Vertex target) {
		this.target = target;
	}
	
	/**
	 * Tests if this edge is equal to <code>otherEdge</code>.
	 * @param otherEdge
	 * @return true, if and only if the sources and targets of the edges are the same.
	 */
	public boolean isEqual(Edge otherEdge) {
		return source.isEqual(otherEdge.getSource()) && target.isEqual(otherEdge.getTarget());
	}

}
