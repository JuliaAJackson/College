public class Colleges
	{
		String name;
		String location;
		String decisionDate;
		String bestKnownFor;
		int tuition;
		int studentBodySize;
		int feeling;
		String pro;
		String con;
		public Colleges (String n, String l, String a, String b, int t, int s, int f, String p, String c)
			{
				name = n;
				location = l;
				decisionDate = a;
				bestKnownFor = b; 
				tuition = t;
				studentBodySize = s;
				feeling = f;
				pro = p;
				con = c;
			}
		public String getPro()
			{
				return pro;
			}
		public void setPro(String pro)
			{
				this.pro = pro;
			}
		public String getCon()
			{
				return con;
			}
		public void setCon(String con)
			{
				this.con = con;
			}
		public int getFeeling()
			{
				return feeling;
			}
		public void setFeeling(int feeling)
			{
				this.feeling = feeling;
			}
		public String getName()
			{
				return name;
			}
		public void setName(String name)
			{
				this.name = name;
			}
		public String getLocation()
			{
				return location;
			}
		public void setLocation(String location)
			{
				this.location = location;
			}
		public String getApplicationDueDate()
			{
				return decisionDate;
			}
		public void setApplicationDueDate(String applicationDueDate)
			{
				this.decisionDate = applicationDueDate;
			}
		public String getBestKnownFor()
			{
				return bestKnownFor;
			}
		public void setBestKnownFor(String bestKnownFor)
			{
				this.bestKnownFor = bestKnownFor;
			}
		public int getTuition()
			{
				return tuition;
			}
		public void setTuition(int tuition)
			{
				this.tuition = tuition;
			}
		public int getStudentBodySize()
			{
				return studentBodySize;
			}
		public void setStudentBodySize(int averageClassSize)
			{
				this.studentBodySize = averageClassSize;
			}
	// hello	
	}
