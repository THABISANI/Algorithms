import java.util.ArrayList;
public class Edge
{
	private Vertice origin, destination;
	private String data;// can be "-- for undirected edge or -> for a directed edge;
	private int originIndex, destIndex, weight;// indexes in the origin and destination incident edges
	
	public String toString()
	{
		return origin.getName() + data+ destination.getName() +"   ";
	}
	public Edge(Vertice o, Vertice d, String dat, int ori, int des)
	{
		origin = o;
		destination = d;
		data = dat;
		originIndex = ori;
		destIndex = des;
	}
	public boolean isDirected()
	{
		return data.equals("->");
	}
	public Edge(Vertice o, Vertice d, String dat)
	{
		origin = o;
		
		destination = d;
		data = dat;
		originIndex = -45463;
		destIndex = -75657;
		o.incidentEdges().add(this);						
	}
	public Edge(Vertice o, Vertice d, String dat, int w)
	{
		origin = o;
		weight = w;
		destination = d;
		data = dat;
		originIndex = -45463;
		destIndex = -75657;
		o.incidentEdges().add(this);						
	}
	public Vertice getOrigin()
	{
		return origin;
	}
	public Vertice getDestination()
	{
		return destination;
	}
	public String getData()
	{
		return data;
	}
	public int getWeight()
	{
		return weight;
	}
	public int oIndex()
	{
		return originIndex;
	}
	public int dIndex()
	{
		return destIndex;
	}
	//
	public void setWeight(int w)
	{
		weight = w;
	}
	public void setOrigin(Vertice u)
	{
		origin = u;
	}
	public void setDestination(Vertice v)
	{
		destination = v;
	}
	public void setData(String o)
	{
		data = o;
	}
	public void setOIndex(int x)
	{
	    originIndex = x;
	}
	public void setDIndex(int y)
	{
		destIndex = y;
	}
}