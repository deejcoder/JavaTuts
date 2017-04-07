package nz.ac.massey.cs.pp.tutorial3.id16058989;

import java.util.Comparator;

public class CompareByID implements Comparator<Student> {
	public int compare( Student a, Student b ) {
		if( a.studentid < b.studentid )
			return -1;
		
		if( a.studentid > b.studentid )
			return 1;
					
		return 0;
	}

}