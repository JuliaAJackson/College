import java.util.Comparator;

public class TuitionComparison implements Comparator<Colleges>
	{
	public int compare (Colleges s1, Colleges s2)
		{
		if(s1.getTuition() < s2.getTuition())
			return 1;
		else
			return -1;
		}
	}
