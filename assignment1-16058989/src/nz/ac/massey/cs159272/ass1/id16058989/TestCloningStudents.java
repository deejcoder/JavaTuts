package nz.ac.massey.cs159272.ass1.id16058989;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

public class TestCloningStudents {

	List<Student> students = new ArrayList<Student>();
	Student student = new Student();
	
	@Before
	public void SetupCloningTest() throws Exception {
		

		students.add( student );
		
		student.setId( "16058989" );
		student.setFirstname( "Dylan" );
		student.setLastname( "Tonks" );
		student.setDob( new SimpleDateFormat( "dd/MM/yyyy" ).parse( "19/08/1997" ) );
		
		Address address = student.getAddress();
		address.setHouseno( 18 );
		address.setStreet( "Milford St" );
		address.setTown( "Palmerston North" );
		address.setPostcode( 4412 );
		
		Course course = student.getCourse();
		course.setName( "Discrete Mathematics" );
		course.setNumber( 160202 );
		
	}
	@Test
	public void test() {
		Student newstudent = student.clone();
		assertEquals( newstudent, student );
	}

}
