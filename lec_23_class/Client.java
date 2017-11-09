package lec_23_class;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph();
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("G");
		System.out.println(g.num_vertices());
		System.out.println("****************************");
		g.addEdge("A", "B", 10);
		g.addEdge("A", "D", 40);
		g.addEdge("C", "D", 10);
		g.addEdge("B", "C", 10);
		g.addEdge("D", "E", 2);
		g.addEdge("E", "F", 8);
		g.addEdge("F", "G", 3);
		g.addEdge("E", "G", 3);
		System.out.println("**********************");
		System.out.println(g.num_edges());
		System.out.println("*************************");
		g.display();
		System.out.println("*************************************");
		// g.removeEdge("A", "B");
		// g.removeEdge("A", "D");
		g.display();
		System.out.println("****************************");
		System.out.println(g.hasPath("A", "C"));
		System.out.println("**********************");
		// g.removeEdge("B", "C");
		// g.removeEdge("E", "D");
		// g.DFT();
		//g.removeEdge("E", "F");
		g.removeEdge("D", "E");
		
		Graph g2 = new Graph();
		g2.addVertex("A");
		g2.addVertex("B");
		g2.addVertex("C");
		g2.addEdge("A", "B", 0);
		g2.addEdge("B", "C", 0);
		System.out.println(g2.isCyclic());

	}

}
