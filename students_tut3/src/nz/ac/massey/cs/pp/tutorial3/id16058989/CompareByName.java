package nz.ac.massey.cs.pp.tutorial3.id16058989;

import java.util.Comparator;

public class CompareByName implements Comparator<Student> {

	public int compare( Student a, Student b ) {
		int diff = a.lastname.compareTo( b.lastname );
		return diff;
		
	}

}
