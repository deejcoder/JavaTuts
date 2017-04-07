package nz.ac.massey.cs.pp.tutorial3.id16058989;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;


public class Student {
	int studentid;
	String firstname;
	String lastname;
	String program;
	String major;
	
	public Student() {}
	
	public Student( int ID, String fname, String lname, String prog, String maj ) {
		studentid = ID;
		firstname = fname;
		lastname = lname;
		program = prog;
		major = maj;
		
	}


}
