package KNN;


public class Instance implements Comparable<Instance>{
	double ssc;
	double hsc;
	double uiucgpa;
	double distance;
	double studyHours;
	double semesters;
	double ml;
	double edistance;
	@Override
	public String toString() {
		return "Instance [ssc=" + ssc + ", hsc=" + hsc + ", uiucgpa=" + uiucgpa + ", distance=" + distance
				+ ", studyHours=" + studyHours + ", semesters=" + semesters + ", ml=" + ml + "]";
	}
	
	public int compareTo(Instance e)
	{
		if(edistance>e.distance)
			return 1;
		else if(edistance<e.distance)
			return -1;
		else return 0;
	}	
}
