package nz.ac.massey.cs159272.ass1.id16058989;

import java.util.List;
import java.util.ArrayList;

import java.io.*;
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;




public class StudentDB {
	/**
	 * 
	 * @param students a list of student instances
	 * @param file an existing file handle.
	 * @throws IOException
	 */
	static void save( List<Student> students, File file ) throws IOException {
		XMLEncoder handle = new XMLEncoder( 
				new BufferedOutputStream(
						new FileOutputStream( file )
				)
		);
		
		handle.writeObject( students );
		handle.close();
	}
	
	/**
	 * 
	 * @param students a list of student instances.
	 * @param filename a String containing the output's file name.
	 * @exception FileNotFoundException
	 * @exception Exception
	 */
	static void save( List<Student> students, String filename ) {
		try {
			//"./" current path
			File file = new File( filename );
			
			save( students, file );
		}
		catch( FileNotFoundException e ) {
			System.out.println( "The specified file," + filename + " was not found." );
		}
		catch( Exception e ) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param file an existing file to be imported.
	 * @return a list of student records.
	 * @exception Exception
	 */
	
	@SuppressWarnings("unchecked")
	static List<Student> fetch( File file ) {
		
		List<Student> students = new ArrayList<Student>();
		
		try {
			XMLDecoder handle = new XMLDecoder(
					new BufferedInputStream(
							new FileInputStream( file )
					)
			);
			
			Object obj = handle.readObject();
			handle.close();
			

			if( IsValidStudentList( obj ) ) {
				return (List<Student>) obj;
			}
		
			System.out.println( "Fatal Error: File being imported isn't of supported format." );
			
			
		}
		//catch( FileNotFoundException e ) {
		//	e.printStackTrace();
		//}
		catch( Exception e) {
			System.out.println( "Fatal Error: The file " + file + ", couldn't be found." );
		}
		
		return students;
		
	}
	
	/**
	 * 
	 * @param filename: String of given file name.
	 * @return List<Student>, a list of students fetched.
	 * @throws IOException
	 */
	static List<Student> fetch( String filename ) throws IOException {
		File file = new File( filename );
		return fetch( file );
	}
	
	/**
	 * 
	 * @param students an Object that is assumed a list of Student.
	 * @return true or false.
	 */
	static boolean IsValidStudentList( Object students ) {
		if( students instanceof List<?> ) {
			for( Object instance : ( List<?> ) students ) {
				if( !( instance instanceof Student ) ) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
