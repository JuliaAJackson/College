import java.util.Comparator;

public class FeelingComparison implements Comparator<Colleges>
	{
	public int compare (Colleges s1, Colleges s2)
		{
		if(s1.getFeeling() < s2.getFeeling())
			return 1;
		else
			return -1;
		}
	}

