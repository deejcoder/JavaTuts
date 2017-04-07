package nz.ac.massey.cs.pp.tutorial3.id16058989;

import java.util.Comparator;

public class CompareByFName implements Comparator<Student> {

	public int compare( Student a, Student b ) {
		int diff = a.firstname.compareTo( b.firstname );
		return diff;
		
	}

}
