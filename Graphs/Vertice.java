import java.util.ArrayList;
public class Vertice implements Comparable<Vertice>
{
	private String name;
	private int indegree, label;
	private ArrayList<Edge> incidentEdges;
	
	
	public Vertice(String d, ArrayList<Edge> bob)
	{
		name = d;
		incidentEdges = bob;
		indegree = 0;
		label = 6756895;
		
		
	}
	
	public int compareTo(Vertice n)
	{
		if(label > n.label) return 1;
		if(label < n.label) return -1;
		return 0;
	}
	public int getLabel(){return label;}
	public void setLabel(int lab){label = lab;}
	public boolean equals(Vertice v)
	{
		return name.equals(v.name);
	}
	public ArrayList<Edge> incidentEdges(){return incidentEdges;}
	public String getName(){return name;}
	 
	public void setName(String o)
	{
		name = o;
	}
	public int indegree(){return indegree;}
	
	public void setIndegree(int x){indegree = x;}
	public String toString()
	{
		return name;
	}
	
}