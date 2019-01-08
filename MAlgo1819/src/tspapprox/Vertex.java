package tspapprox;

import alg.countingSort.Sortable;

public class Vertex extends Sortable {
	
	private int id;
	
	/**
	 * Creates a new vertex.
	 * @param id the (unique) id of this vertex
	 */
	public Vertex(int id) {
		this.id = id;
		this.setKey(id);
	}

	/**
	 * Returns the id of this vertex.
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Tests if this vertex is equal to <code>otherVertex</code>.
	 * @param otherVertex
	 * @return true, if and only if both vertices have the same id.
	 */
	public boolean isEqual(Vertex otherVertex) {
		return id == otherVertex.getId();
	}
}
