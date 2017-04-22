package nz.ac.massey.cs159272.ass1.id16058989;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

public class TestPersistency {

	List<Student> students = new ArrayList<Student>();
	
	@Before
	@SuppressWarnings("deprecation")
	public void SetupPersistencyTest() {
		
		
		Student student = new Student( "16058989", "Tonks", "Dylan", new Date( 1997, 8, 19 ) );
		Address address = new Address( 18, "Milford St", "Palmerston North", 4412 );
		Course course = new Course( 160202, "Discrete Mathematics" );
		student.setAddress( address );
		student.setCourse( course );
		students.add( student );
		
		student = new Student( "15093849", "Hunt", "Sam", new Date( 1996, 3, 12 ) );
		address = new Address( 21, "Albert St", "Palmerston North", 4400 );
		course = new Course( 159272, "Programming Paradigms" );
		student.setAddress( address );
		student.setCourse( course );
		students.add( student );
		
		student = new Student( "13941923", "Howard", "Ben", new Date( 1994, 4, 5 ) );
		address = new Address( 21, "Church St", "Palmerston North", 4402 );
		course = new Course( 159272, "Programming Paradigms" );
		student.setAddress( address );
		student.setCourse( course );
		students.add( student );
		
		student = new Student( "14341313", "Howard", "Ben", new Date( 1995, 11, 12 ) );
		address = new Address( 8, "Church St", "Palmerston North", 4402 );
		course = new Course( 159271, "Computational Thinking for Problem Solving" );
		student.setAddress( address );
		student.setCourse( course );
		students.add( student );
		
		
	}
	@Test
	public void test() throws IOException {
		
		StudentDB.save( students, "students.xml" );
		List<Student> students2 = StudentDB.fetch( "students.xml" );
		assertEquals( students2, students );
	}

}
