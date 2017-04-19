package nz.ac.massey.cs159272.ass1.id16058989;

import java.util.*;
import java.text.SimpleDateFormat;

public class loader {
	public static void main( String[] args ) throws Exception {
		Student student = new Student();
		student.setLastName( "Tonks" );
		student.setFirstName( "Dylan" );
		student.setID( "16058989" );
		String dob = "19/08/1997";
		student.setDOB( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dob ) );
		//student.setStreet("test");
		System.out.println( student.getDOB() );
	}

}
