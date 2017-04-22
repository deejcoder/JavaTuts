package nz.ac.massey.cs159272.ass1.id16058989;

import java.util.*;

import java.text.SimpleDateFormat;

public class TestLoader {
	public static void main( String[] args ) throws Exception {
		
		List<Student> students = new ArrayList<Student>();
		
		Student student = new Student();
		students.add( student );
		
		student.setLastname( "Tonks" );
		student.setFirstname( "Dylan" );
		student.setId( "16058989" );
		String dob = "19/08/1997";
		student.setDob( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dob ) );
		Course course = new Course();
		course.setName( "Discrete Mathematics" );
		course.setNumber( 160202 );
		student.setCourse( course );
		
		
		student = student.clone();
		students.add( student );
		student.setLastname( "Hunt" );
		student.setFirstname( "Sam" );
		student.setId( "16052919");
		dob = "12/02/1997";
		student.setDob( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dob ) );
		Address address = new Address();
		address.setStreet( "Tilbury Ave" );
		address.setHouseno( 21 );
		address.setTown( "Palmerston North" );
		address.setPostcode( 4410 );
		student.setAddress( address );
		
		

		StudentDB.save( students, "students.xml" );
		List<Student> students2 = StudentDB.fetch( "students.xml" );
		StudentDB.save( students2, "students2.xml" );
	}

}
