public class QueueNode implements Comparable<QueueNode>
{
    private int array, index;
	private Coordinate value;
	public QueueNode(int a, int i, Coordinate v)
	{
		value = v;
		index = i;
		array = a;
	}
	public int compareTo(QueueNode n)
	{
		return this.value.compareTo(n.value);
	}
	public Coordinate getValue(){return value;}
	
	public int getArray(){return array;}
	
	public int getIndex(){return index;}
}