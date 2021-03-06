public class QueueNode implements Comparable<QueueNode>
{
    private int array, index, value;
	public QueueNode(int a, int i, int v)
	{
		value = v;
		index = i;
		array = a;
	}
	public int compareTo(QueueNode n)
	{
		if(value > n.value) return 1;
		if(value < n.value) return -1;
		return 0;
	}
	public int getValue(){return value;}
	
	public int getArray(){return array;}
	
	public int getIndex(){return index;}
}