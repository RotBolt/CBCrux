package lec_23_class;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Graph {
	private class vertex {
		String name;
		HashMap<vertex, Integer> neighbours;

		vertex(String name) {
			this.name = name;
			this.neighbours = new HashMap<>();
		}

		public int hashcode() {
			return this.name.hashCode();
		}

		public boolean equals(Object other) {
			vertex v = (vertex) other;
			return this.name.equals(v.name);
		}

		public void display() {
			String rv = this.name + "=>";
			Set<Map.Entry<vertex, Integer>> nbrs = this.neighbours.entrySet();
			for (Map.Entry<vertex, Integer> nbr : nbrs) {
				rv += nbr.getKey().name + "(" + nbr.getValue() + ")" + ", ";
			}
			System.out.println(rv);
		}
	}

	private HashMap<String, vertex> vertices;

	public Graph() {
		this.vertices = new HashMap<>();
	}

	public int num_vertices() {
		return this.vertices.size();
	}

	public void addVertex(String name) {
		if (this.vertices.containsKey(name)) {
			return;
		}
		vertex vtba = new vertex(name);
		this.vertices.put(name, vtba);
	}

	public void addEdge(String v1, String v2, int cost) {
		vertex vtx1 = this.vertices.get(v1);
		vertex vtx2 = this.vertices.get(v2);
		if (vtx1 == null || vtx2 == null || vtx1.neighbours.containsKey(vtx2)) {
			return;
		}
		vtx1.neighbours.put(vtx2, cost);
		vtx2.neighbours.put(vtx1, cost);
	}

	public void removeVertex(String name) {
		if (!this.vertices.containsKey(name)) {
			return;
		}
		vertex vtbr = this.vertices.get(name);
		Set<vertex> nbrs = vtbr.neighbours.keySet();
		for (vertex nbr : nbrs) {
			nbr.neighbours.remove(vtbr);
		}
		this.vertices.remove(name);
	}

	public void removeEdge(String v1, String v2) {
		vertex vtx1 = this.vertices.get(v1);
		vertex vtx2 = this.vertices.get(v2);
		if (vtx1 == null || vtx2 == null || !vtx1.neighbours.containsKey(vtx2)) {
			return;
		}
		vtx1.neighbours.remove(vtx2);
		vtx2.neighbours.remove(vtx1);
	}

	public int num_edges() {
		if (this.num_vertices() == 0) {
			return 0;
		}
		int rv = 0;
		Set<String> names = this.vertices.keySet();
		for (String name : names) {
			vertex v = this.vertices.get(name);
			rv += v.neighbours.size();
		}
		return rv / 2;
	}

	public void display() {
		Set<String> names = this.vertices.keySet();
		for (String name : names) {
			vertex v = this.vertices.get(name);
			v.display();
		}
	}

	public boolean hasPath(String v1, String v2) {
		vertex vtx1 = this.vertices.get(v1);
		vertex vtx2 = this.vertices.get(v2);
		if (vtx1 == null || vtx2 == null) {
			return false;
		}
		HashMap<String, Boolean> explored = new HashMap<>();
		return hasPathBFSI(vtx1, vtx2, explored);
	}

	private boolean haspathDFSR(vertex v1, vertex v2, HashMap<String, Boolean> explored) {
		if (!explored.containsKey(v1.name)) {
			explored.put(v1.name, true);
		} else {
			return false;
		}
		if (v1.neighbours.containsKey(v2)) {
			return true;
		}
		Set<vertex> nbrs = v1.neighbours.keySet();
		for (vertex nbr : nbrs) {
			if (this.haspathDFSR(nbr, v2, explored)) {
				return true;
			}
		}
		return false;
	}

	private boolean hasPathBFSI(vertex v1, vertex v2, HashMap<String, Boolean> explored) {
		LinkedList<vertex> q = new LinkedList<>();
		q.add(v1);
		while (!q.isEmpty()) {
			vertex peek = q.removeFirst();
			if (!explored.containsKey(peek.name)) {
				explored.put(peek.name, true);
				if (peek.neighbours.containsKey(v2)) {
					return true;
				} else {
					Set<vertex> nbrs = peek.neighbours.keySet();
					for (vertex nbr : nbrs) {
						if (!explored.containsKey(nbr)) {
							q.add(nbr);
						}
					}
				}
			}
		}
		return false;
	}

	private boolean hasPathDFSI(vertex v1, vertex v2, HashMap<String, Boolean> explored) {
		LinkedList<vertex> s = new LinkedList<>();
		s.addFirst(v1);
		while (!s.isEmpty()) {
			vertex peek = s.removeFirst();
			if (!explored.containsKey(peek.name)) {
				explored.put(peek.name, true);
				if (peek.neighbours.containsKey(v2)) {
					return true;
				} else {
					Set<vertex> nbrs = peek.neighbours.keySet();
					for (vertex nbr : nbrs) {
						if (!explored.containsKey(nbr)) {
							s.addFirst(nbr);
						}
					}
				}
			}
		}
		return false;
	}

	public void BFT() {
		HashMap<vertex, Boolean> explored = new HashMap<>();
		Collection<vertex> vertices = this.vertices.values();
		LinkedList<vertex> q = new LinkedList<>();
		for (vertex v1 : vertices) {
			if (!explored.containsKey(v1)) {
				q.add(v1);
			}
			while (!q.isEmpty()) {

				vertex peek = q.removeFirst();
				if (!explored.containsKey(peek)) {
					explored.put(peek, true);
					System.out.print(peek.name + "  ");
					Set<vertex> nbrs = peek.neighbours.keySet();
					for (vertex nbr : nbrs) {
						if (!explored.containsKey(nbr)) {
							q.add(nbr);
						}
					}
				}
			}
		}
	}

	public void DFT() {
		HashMap<vertex, Boolean> explored = new HashMap<>();
		Collection<vertex> vertices = this.vertices.values();
		LinkedList<vertex> s = new LinkedList<>();
		for (vertex v1 : vertices) {
			if (!explored.containsKey(v1)) {
				s.addFirst(v1);
			}
			while (!s.isEmpty()) {
				vertex peek = s.removeFirst();
				if (!explored.containsKey(peek)) {
					explored.put(peek, true);
					System.out.print(peek.name + "  ");
					Set<vertex> nbrs = peek.neighbours.keySet();
					for (vertex nbr : nbrs) {
						if (!explored.containsKey(nbr)) {
							s.addFirst(nbr);
						}
					}
				}
			}
		}
	}

	public ArrayList<ArrayList<String>> gcc() {
		Collection<vertex> vertices = this.vertices.values();
		HashMap<vertex, Boolean> explored = new HashMap<>();
		ArrayList<ArrayList<String>> compo = new ArrayList<>();
		LinkedList<vertex> q = new LinkedList<>();
		for (vertex v : vertices) {
			ArrayList<String> sub = new ArrayList<>();

			if (!explored.containsKey(v)) {
				q.add(v);
				explored.put(v, true);
			}

			while (!q.isEmpty()) {
				vertex tba = q.remove();
				sub.add(tba.name);
				Set<vertex> nbrs = tba.neighbours.keySet();

				for (vertex nbr : nbrs) {
					if (!explored.containsKey(nbr)) {
						q.add(nbr);
						explored.put(nbr, true);
					}
				}
			}
			if (sub.size() != 0) {
				compo.add(sub);
			}
		}
		return compo;
	}

	public boolean isbipartite() {
		Collection<vertex> vertices = this.vertices.values();
		HashMap<vertex, String> explored = new HashMap<>();
		// HashMap<vertex, String> colour = new HashMap<>();
		ArrayList<ArrayList<String>> compo = new ArrayList<>();
		LinkedList<vertex> s = new LinkedList<>();

		for (vertex v : vertices) {
			if (!explored.containsKey(v)) {
				s.addFirst(v);
				explored.put(v, "RED");
			}
			while (!s.isEmpty()) {
				vertex tba = s.removeFirst();
				Set<vertex> nbrs = tba.neighbours.keySet();
				for (vertex nbr : nbrs) {
					if (!explored.containsKey(nbr)) {
						s.addFirst(nbr);
						if (explored.get(tba).equals("RED")) {
							explored.put(nbr, "GREEN");
						} else {
							explored.put(nbr, "RED");
						}
					}
					if (explored.containsKey(nbr)) {
						Set<vertex> nbrs_beta = nbr.neighbours.keySet();
						for (vertex nbr_beta : nbrs_beta) {
							if (explored.get(nbr).equals(explored.get(nbr_beta))) {
								return false;
							}
						}
					}
				}
			}
		}
		return true;
	}

	public boolean isCyclic() {
		Collection<vertex> vertices = this.vertices.values();
		HashMap<vertex, vertex> explored = new HashMap<>();
		LinkedList<vertex> s = new LinkedList<>();

		for (vertex v : vertices) {
			if (explored.containsKey(v)) {
				s.addFirst(v);
				explored.put(v, null);
			}
			while (!s.isEmpty()) {
				vertex rvtx = s.removeFirst();
				Set<vertex> nbrs = rvtx.neighbours.keySet();
				for (vertex nbr : nbrs) {
					if (!explored.containsKey(nbr)) {
						s.addFirst(nbr);
						explored.put(nbr, rvtx);
					} else {
						vertex tbc = explored.get(rvtx);
						if (tbc.equals(nbr)) {
							continue;
						} else {
							return false;
						}
					}
				}
			}
		}
		return true ;
	}
}
