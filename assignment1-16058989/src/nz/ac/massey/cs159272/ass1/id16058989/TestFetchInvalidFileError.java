package nz.ac.massey.cs159272.ass1.id16058989;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;
import java.util.List;

public class TestFetchInvalidFileError {

	@Test
	public void test() {
		try {
			List<Student> students = StudentDB.fetch( "null.xml" );
			//List<Student> students = StudentDB.fetch( new File( "null.xml" ) );
			assertTrue( students.size() < 1 );
		}
		catch( FileNotFoundException e ) {
			assertTrue( true );
		}
		catch ( Exception e ) {
			assertTrue( false );
		}
	}

}
