import java.util.Comparator;

public class SizeComparison implements Comparator<Colleges>
	{
	public int compare (Colleges s1, Colleges s2)
		{
		if(s1.getStudentBodySize() < s2.getStudentBodySize())
			return 1;
		else
			return -1;
		}
	}

