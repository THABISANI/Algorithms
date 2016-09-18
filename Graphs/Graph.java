/**
 *<br>Author : Thabisani Sibanda
 *<br>Contacts :thabisonsibz@gmail.com
 *<br>Last updated on 20/08/2016

 *<br>The algorithm detects whether a graph is cyclic 
 *<br>and has the method for calculating the shortest path of an vertex of the graph from an origin vertex
 
 */
import java.util.ArrayList;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Graph
{
	private ArrayList<Vertice> V;
	private ArrayList<Edge> E;
	
	
	public void Dijkstra(Vertice v)
	{
		v.setLabel(0);
		PriorityQueue<Vertice> pq = new PriorityQueue<Vertice>();
		
		for(Vertice vertex : V)
		{
			pq.add(vertex);
		}
		//Set<Vertice> cloud = new HashSet<>();
		while(!pq.isEmpty())
		{
			Vertice u = pq.poll();
			for(Vertice z : getAdjacentVertices(u))
				if(u.getLabel() + edge(u, z).getWeight() < z.getLabel())
					z.setLabel(u.getLabel() + edge(u, z).getWeight());
				
			
		}
		
		
		
	}
	public Edge edge(Vertice u, Vertice v)
	{
		for(Edge e: u.incidentEdges())
		{
			if(e.getDestination().equals(v))
			{
				return e;
			}
		}
		return null;
	}
	public Graph()
	{
		V = new ArrayList<Vertice>();
		E = new ArrayList<Edge>();
		
		
	}
	public ArrayList<Vertice> vertices()
	{
		return V;
	}
	
	public ArrayList<Edge> edges()
	{
		return E;
	}
	public Vertice opposite(Vertice v, Edge e)
	{
		if(v.equals(e.getDestination()))
		{
			return e.getOrigin();
		}
		return e.getDestination();
	}
	public Vertice[] endVertices(Edge e)
	{
		Vertice[] toReturn  = new Vertice[2];
		toReturn[0] = e.getOrigin();
		toReturn[1] = e.getDestination();
		return toReturn;
	}
	public boolean dfs(Vertice current, Set<Vertice> whiteSet, Set<Vertice> graySet, Set<Vertice> blackSet)
	{
		moveVertice(current, whiteSet, graySet);
		for(Vertice neighbor : getAdjacentVertices(current))
		{
			if(blackSet.contains(neighbor))
			{
				continue;
			}
			if(graySet.contains(neighbor))
			{
				return true;
			}
			if(dfs(neighbor, whiteSet, graySet, blackSet))
			{
				return true;
			}
			
		}
		moveVertice(current, graySet, blackSet);
		return false;
	}
	public boolean areAdjacent(Vertice u, Vertice v)
	{
		for(Edge e : u.incidentEdges())
		{
			if(opposite(u, e).equals(v))
			{
				return true;
			}
		}
		return false;
	}
	public boolean hasCycle()
	{
		Set<Vertice> whiteSet = new HashSet<>(),
		              graySet = new HashSet<>(),
		              blackSet = new HashSet<>();
		for(Vertice v : V)
		{
			whiteSet.add(v);
		}
		while(whiteSet.size() > 0)
		{
			Vertice current = whiteSet.iterator().next();
			if(dfs(current, whiteSet, graySet, blackSet))
			{
				return true;
			}
		}
		return false;
	}
	private void moveVertice(Vertice v, Set<Vertice> source, Set<Vertice> destination)
	{
		source.remove(v);
		destination.add(v);
	}
    public void insertVertix(Vertice v)
	{
		V.add(v);
		
	}
	public void insertEdge(Vertice o, Vertice d, String dat, int w)
	{
		insertEdge(new Edge(o,d,dat, w));
	}
	
	
	public ArrayList<Vertice> getAdjacentVertices(Vertice v)
	{
		ArrayList<Vertice> bob = new ArrayList<Vertice>();
		for(Edge e : v.incidentEdges())
		{
			if(v.equals(e.getOrigin()))
			{
				bob.add(e.getDestination());
			}
		}
		return bob;
	}
	
	public Stack<Vertice> topologicalSort()
	{
		Stack<Vertice> stack = new Stack<Vertice>();
		Set<Vertice> visited = new HashSet<>();
		for(Vertice v : V)
		{
			if(visited.contains(v))
			{
				continue;
			}
			sortHelper(v, stack, visited);
		}
		return stack;
		
	}
	private void sortHelper(Vertice v, Stack<Vertice> stack, Set<Vertice> visited)
	{
		visited.add(v);
		for(Vertice child : getAdjacentVertices(v))
		{
			if(visited.contains(child))
			{
				continue;
			}
			sortHelper(child, stack, visited);
		}
		stack.push(v);
	}
	public void insertEdge(Edge e)
	{
	    boolean originIn = false, destIn = false;
		E.add(e);
		for(Vertice v : V)
		{
			if(v.getName().equals(e.getOrigin().getName()))
			{
				e.setOrigin(v);
				e.setOIndex(v.incidentEdges().size());
				v.incidentEdges().add(e);//may give an error if incidentEdges not initialized
				originIn = true;
			}
			if(v.getName().equals(e.getDestination().getName()))
			{
				e.setDestination(v);
				e.setDIndex(v.incidentEdges().size());
				v.incidentEdges().add(e);//may give an error if incidentEdges not initialized
				v.setIndegree(v.indegree() + 1);
				destIn = true;
			}
		}
		if(!originIn)
		{
			V.add(e.getOrigin());
			
			e.setOIndex(0);
		}
		if(!destIn)
		{
			V.add(e.getDestination());
			
			e.setDIndex(0);
			e.getDestination().setIndegree(e.getDestination().indegree() + 1);
		}
		
	}
	public void displayShortestPath()
	{
		for(Vertice v: V)
		{
			System.out.println((V.get(0).getName()+"-->"+v.getName() +"                     ").substring(0, 20) +"Path Length: "+ v.getLabel());
		}
	}
	public void display()
	{
	    System.out.println("Edges of our graph:");
		for(Edge e : E)
		{
			System.out.println(e);
		}
	}
	public void run()
	{
	    
		if(hasCycle())
		{
			System.out.println("Cannot sort a cyclic graph in topological order!!!");
			display();
			
		}
		else
		{
		    System.out.println("The graph is acyclic, topological sort list from left to right:");
			Stack<Vertice> bob = topologicalSort();
			while(!bob.empty())
			{
				System.out.print(bob.pop() + "   ");
			}
			System.out.println();
			
		    Dijkstra(V.get(0));
			displayShortestPath();
		}
		
	}
	public boolean isDirected(Edge e)
	{
		return e.getData().equals("->");
	}
	public static void main(String[] args)
	{
		Graph bob = new Graph();
	
		
	    /*
		digraph Dijkstra {
  		start -> A [label=9];
  		start -> B [label=14];
  		start -> C [label=15];
  		A -> E [label=24];
  		B -> E [label=18];
  		B -> D [label = 30];
  		B -> C [label = 5];
  		D -> F [label = 11];
  		E -> D [label = 2];
  		C -> D [label = 20];
  		C -> goal [label = 44];
  		D -> goal [label = 16];
  		E -> goal [label = 19];   
  		F -> goal [label = 6];}
		*/
		bob.insertEdge(new Vertice("start", new ArrayList<Edge>()), new Vertice("A", new ArrayList<Edge>()), "->",9);
		bob.insertEdge(new Vertice("start", new ArrayList<Edge>()), new Vertice("B", new ArrayList<Edge>()), "->",14);
		bob.insertEdge(new Vertice("start", new ArrayList<Edge>()), new Vertice("C", new ArrayList<Edge>()), "->",15);
		
		bob.insertEdge(new Vertice("A", new ArrayList<Edge>()), new Vertice("E", new ArrayList<Edge>()), "->", 24);
		bob.insertEdge(new Vertice("B", new ArrayList<Edge>()), new Vertice("E", new ArrayList<Edge>()), "->", 18);
		bob.insertEdge(new Vertice("B", new ArrayList<Edge>()), new Vertice("D", new ArrayList<Edge>()), "->", 30);
		bob.insertEdge(new Vertice("B", new ArrayList<Edge>()), new Vertice("C", new ArrayList<Edge>()), "->", 5);
		
		bob.insertEdge(new Vertice("D", new ArrayList<Edge>()), new Vertice("F", new ArrayList<Edge>()), "->", 11);
		bob.insertEdge(new Vertice("E", new ArrayList<Edge>()), new Vertice("D", new ArrayList<Edge>()), "->", 2);
		
		
		bob.insertEdge(new Vertice("C", new ArrayList<Edge>()), new Vertice("D", new ArrayList<Edge>()), "->",20);
	    bob.insertEdge(new Vertice("C", new ArrayList<Edge>()), new Vertice("Goal", new ArrayList<Edge>()), "->", 44);
	    bob.insertEdge(new Vertice("D", new ArrayList<Edge>()), new Vertice("Goal", new ArrayList<Edge>()), "->", 16);
		bob.insertEdge(new Vertice("E", new ArrayList<Edge>()), new Vertice("Goal", new ArrayList<Edge>()), "->", 19);
		bob.insertEdge(new Vertice("F", new ArrayList<Edge>()), new Vertice("Goal", new ArrayList<Edge>()), "->", 6);
	    
		bob.run();
	    
		
		//
		Graph townLink = new Graph();
		System.out.println("Zimbabwean town road network:\nFrom Karoi to Zvishavane:");
		townLink.insertEdge(new Vertice("Karoi", new ArrayList<Edge>()), new Vertice("Chinhoyi", new ArrayList<Edge>()), "->",45);
		townLink.insertEdge(new Vertice("Karoi", new ArrayList<Edge>()), new Vertice("HNP", new ArrayList<Edge>()), "->",250);
		townLink.insertEdge(new Vertice("Karoi", new ArrayList<Edge>()), new Vertice("Gokwe", new ArrayList<Edge>()), "->",133);
		townLink.insertEdge(new Vertice("Karoi", new ArrayList<Edge>()), new Vertice("Shurugwi", new ArrayList<Edge>()), "->",632);
		townLink.insertEdge(new Vertice("Karoi", new ArrayList<Edge>()), new Vertice("Masvingo", new ArrayList<Edge>()), "->",754);
		townLink.insertEdge(new Vertice("Chinhoyi", new ArrayList<Edge>()), new Vertice("Harare", new ArrayList<Edge>()), "->", 100);
		townLink.insertEdge(new Vertice("Chinhoyi", new ArrayList<Edge>()), new Vertice("Chegutu", new ArrayList<Edge>()), "->", 120 );
		townLink.insertEdge(new Vertice("Chegutu", new ArrayList<Edge>()), new Vertice("Kadoma", new ArrayList<Edge>()), "->", 20);
		townLink.insertEdge(new Vertice("Bulawayo", new ArrayList<Edge>()), new Vertice("Gweru", new ArrayList<Edge>()), "->", 350);
		
		townLink.insertEdge(new Vertice("Harare", new ArrayList<Edge>()), new Vertice("Chitungwiza", new ArrayList<Edge>()), "->", 30);
		townLink.insertEdge(new Vertice("Harare", new ArrayList<Edge>()), new Vertice("Kadoma", new ArrayList<Edge>()), "->", 146);
		
		
		townLink.insertEdge(new Vertice("Kadoma", new ArrayList<Edge>()), new Vertice("Kwekwe", new ArrayList<Edge>()), "->",50);
	    townLink.insertEdge(new Vertice("Kwekwe", new ArrayList<Edge>()), new Vertice("Gweru", new ArrayList<Edge>()), "->", 44);
	    townLink.insertEdge(new Vertice("Gweru", new ArrayList<Edge>()), new Vertice("Shurugwi", new ArrayList<Edge>()), "->", 33);
		townLink.insertEdge(new Vertice("Shurugwi", new ArrayList<Edge>()), new Vertice("Zvishavane", new ArrayList<Edge>()), "->", 233);
		townLink.insertEdge(new Vertice("Chitungwiza", new ArrayList<Edge>()), new Vertice("Chivhu", new ArrayList<Edge>()), "->", 245);
	    
		
	    townLink.insertEdge(new Vertice("Chivhu", new ArrayList<Edge>()), new Vertice("Masvingo", new ArrayList<Edge>()), "->",453);
		townLink.insertEdge(new Vertice("Masvingo", new ArrayList<Edge>()), new Vertice("Zvishavane", new ArrayList<Edge>()), "->",134);
		townLink.insertEdge(new Vertice("HNP", new ArrayList<Edge>()), new Vertice("Bulawayo", new ArrayList<Edge>()), "->",89);
		
		townLink.insertEdge(new Vertice("Bulawayo", new ArrayList<Edge>()), new Vertice("Mpalabala", new ArrayList<Edge>()), "->", 265);
		townLink.insertEdge(new Vertice("Mpalabala", new ArrayList<Edge>()), new Vertice("Zvishavane", new ArrayList<Edge>()), "->", 238);
		townLink.insertEdge(new Vertice("Harare", new ArrayList<Edge>()), new Vertice("Marondera", new ArrayList<Edge>()), "->", 165);
		townLink.insertEdge(new Vertice("Marondera", new ArrayList<Edge>()), new Vertice("Mutare", new ArrayList<Edge>()), "->", 675);
		
		townLink.insertEdge(new Vertice("Mutare", new ArrayList<Edge>()), new Vertice("Masvingo", new ArrayList<Edge>()), "->", 387);
		
	    townLink.insertEdge(new Vertice("Shurugwi", new ArrayList<Edge>()), new Vertice("Chibi", new ArrayList<Edge>()), "->", 99);
	    townLink.insertEdge(new Vertice("Chibi", new ArrayList<Edge>()), new Vertice("Zvishavane", new ArrayList<Edge>()), "->", 87);
		townLink.insertEdge(new Vertice("Karoi", new ArrayList<Edge>()), new Vertice("Gokwe", new ArrayList<Edge>()), "->", 253);
		townLink.insertEdge(new Vertice("Gokwe", new ArrayList<Edge>()), new Vertice("Zhombe", new ArrayList<Edge>()), "->", 85);
	    
		
	    townLink.run();
		
	}
	
}