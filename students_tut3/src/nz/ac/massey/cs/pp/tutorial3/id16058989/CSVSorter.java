package nz.ac.massey.cs.pp.tutorial3.id16058989;
import java.io.*;
import java.util.*;


public class CSVSorter {
	
	public enum Keys { 
		by_id,
		by_fname,
		by_name,
		by_program;
	}
	
	public static void main( String[] args ) {
		
		
		if( args.length < 3 ) {
			
			System.err.print( "CSVSorter\n" +
					"\tInput parameters;\n" +
					"\t\tInputFile\n" +
					"\t\tOutputFile\n" +
					"\t\tSortKey (sort by)\n" );
			
			System.exit(1);
		}
		String _FileIn = args[0];
		String _FileOut = args[1];
		
		
		try { 
			Keys key = Keys.valueOf( args[2] );

			 List<Student> students = importFile( _FileIn );
			
			switch( key ) {
			
				case by_id: Collections.sort( students, new CompareByID() ); break;
				case by_fname: Collections.sort( students, new CompareByFName() ); break;
				case by_name: Collections.sort( students, new CompareByName() ); break;
				case by_program: Collections.sort( students, new CompareByProgram() ); break;
				
			}
			
			exportFile( _FileOut, students );
			
			System.out.println( "The file has been sorted and an output file has been made by the specified name.\n" );
		
		}
		catch( Exception e ) {
			System.out.println( "You have entered an invalid sort key or something went wrong while processing a file." );
		}
		
		
		
	}
	
	public static void exportFile( String file,  List<Student> students ) {
		
		try {
			
			File exportFile = new File( file );
			
			//Create the file & create new FileWriter object
			exportFile.createNewFile();
			FileWriter writer = new FileWriter( exportFile );
			
			writer.write( "student_id,fname,name,program, major" );
			
			writer.write( "\n" );
			for( int i = 0; i < students.size(); i++ ) {
				writer.write( students.get( i ).studentid + "," );
				writer.write( students.get( i ).firstname + "," );
				writer.write( students.get( i ).lastname + "," );
				writer.write( students.get( i ).program + "," );
				writer.write( students.get( i ).major + "," );
				writer.write( "\n" );
				
				
			}
			writer.flush();
			writer.close();
			
		}
		catch( Exception e ) {}
	}
	
	public static List<Student> importFile( String file ) {
		List<Student> students = new ArrayList<Student>();
		String line; String[] tmp;
		
		try {
			
			File importFile = new File( file );
			
			FileReader fread = new FileReader( importFile );
			BufferedReader buffer = new BufferedReader( fread );
			
			
			
			int header = 0;
			while( ( line = buffer.readLine() ) != null ) {
				if( header == 0 ) { 
					header++;
					continue;
				}
				
				tmp = line.split(",");
				students.add ( new Student( Integer.parseInt( tmp[0] ), tmp[1], tmp[2], tmp[3], tmp[4] ) );
			}
			return students;
		}
		catch( Exception e ) {
			
			e.printStackTrace();
		}
		return students;
	}
}
