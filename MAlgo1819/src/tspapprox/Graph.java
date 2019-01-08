package tspapprox;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import alg.countingSort.CountingSort;

public class Graph {
	
	private int vertexCounter = 0;
	
	private Map<Integer, Vertex>     vertices;
	private Map<Integer, List<Edge>> adjacencyList;
	
	/**
	 * Creates a new graph
	 */
	public Graph() {
		vertices      = new HashMap<Integer, Vertex>();
		adjacencyList = new HashMap<Integer, List<Edge>>();
	}
	
	/**
	 * Fills the graph with the data from an adjacency matrix.
	 * @param adjacencyMatrix
	 */
	public void initGraph(double[][] adjacencyMatrix) {
		vertexCounter = 0;
		adjacencyList.clear();
		Vertex[] vertices = new Vertex[adjacencyMatrix.length];

		for (int s=0; s<adjacencyMatrix.length; s++) {
			vertices[s] = createVertex();
		}
		
		for (int s=0; s<adjacencyMatrix.length; s++) {
			for (int t=0; t<adjacencyMatrix.length; t++) {
				if (s != t) {
					createEdge(vertices[s], vertices[t], adjacencyMatrix[s][t]);
				}
			}
		}
	}
	
	/**
	 * Creates a new vertex.
	 * @param id the id of the vertex (should be unique)
	 * @return the new vertex
	 */
	public Vertex createVertex(int id) {
		Vertex v = new Vertex(id);
		vertexCounter = Math.max(vertexCounter, id+1);
		vertices.put(v.getId(), v);
		adjacencyList.put(v.getId(), new LinkedList<Edge>());
		return v;
	}
	
	/**
	 * Creates a new vertex.
	 * @return the new vertex
	 */
	public Vertex createVertex() {
		return this.createVertex(vertexCounter);
	}
	
	/**
	 * Creates a new edge.
	 * @param source the source vertex of the edge
	 * @param target the target vertex of the edge
	 * @param weight the weight of the edge
	 * @return the new edge
	 */
	public Edge createEdge(Vertex source, Vertex target, double weight) {
		Edge e = new Edge(source, target, weight);
		adjacencyList.get(source.getId()).add(e);
		return e;
	}
	
	/**
	 * Returns all vertices in this graph as an array.
	 * @return vertices of this graph
	 */
	public Vertex[] getAllVertices() {
		Vertex[] vertexArray = new Vertex[vertices.size()];
		int i = 0;
		for (Vertex v : vertices.values()) {
			vertexArray[i] = v;
			i++;
		}
		(new CountingSort()).sort(vertexArray);
		return vertexArray;
	}
	
	/**
	 * Returns a specific vertex
	 * @param id the id of the vertex
	 * @return the vertex with the id
	 */
	public Vertex getVertex(int id) {
		return vertices.get(id);
	}
	
	/**
	 * Returns the adjacency list (outgoing edges) of the vertex v.
	 * @param v
	 * @return adjacency list of v
	 */
	public List<Edge> getAdjacencyList(Vertex v) {
		return adjacencyList.get(v.getId());
	}

}
