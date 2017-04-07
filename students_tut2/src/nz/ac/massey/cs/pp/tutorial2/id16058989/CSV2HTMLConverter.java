package nz.ac.massey.cs.pp.tutorial2.id16058989;

//File related dependencies
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

//Data structure related dependencies
import java.util.List;
import java.util.ArrayList;

public class CSV2HTMLConverter {
	public static void main(String[] args) {
		
		//Constants
		String _FileInPath = args[0];
		String _FileOutPath = args[1];
		
		try {
			
			File importFile = new File( _FileInPath );
			
			FileReader fread = new FileReader( importFile );
			BufferedReader buffer = new BufferedReader( fread );
	
			//Variables for storing data and storing row count
			String line; String[] tmp;
			int row = 0;
			
			//Store all student instances inside a list structure
			List<Student> students = new ArrayList<Student>();
			
			while( ( line = buffer.readLine() ) != null ) {
				/*%Loop Invariant% for each line in the import file, split by delim ',',
					create new Student instance using the imported data */
				row++;
				
				//skip the header row
				if( row == 1 ) {
					
					continue;
				}
				
				tmp = line.split( "," );
				students.add ( new Student( Integer.parseInt( tmp[0] ), tmp[1], tmp[2], tmp[3], tmp[4] ) );
				
			}
			
			//Export the imported data to HTML form
			Export2HTML( _FileOutPath, students );
			
			System.out.printf( "The file %s was successfully exported to %s\n", _FileInPath, _FileOutPath );
		}
		catch( Exception error ) {
			error.printStackTrace();
			
		}
		
		
		
	}
	public static void Export2HTML( String file, List<Student> students )throws IOException {
		try {
			File exportFile = new File( file );
			
			//Create the file & create new FileWriter object
			exportFile.createNewFile();
			FileWriter writer = new FileWriter( exportFile );
			
			//Write the initial HTML tags for creating a table
			writer.write( "<table>" );
			
			//The header of the table
			writer.write( 
					"<tr>" +
						"<th>Student ID</th>" +
						"<th>First name</th>" +
						"<th>Last name</th>" +
						"<th>Program</th>" +
						"<th>Major</th>" +
					"</tr>" );
			
			//The content of the table
			for( int i = 0; i < students.size(); i++ ) {
				// %loop invariant% for every student so far, shall it be contained in the table's body
				
				writer.write( "<tr>" );
				
				writer.write( "<td>" + students.get( i ).studentid + "</td>" );
				writer.write( "<td>" + students.get( i ).firstname + "</td>" );
				writer.write( "<td>" + students.get( i ).lastname + "</td>" );
				writer.write( "<td>" + students.get( i ).program + "</td>" );
				writer.write( "<td>" + students.get( i ).major + "</td>" );
				
				writer.write( "</tr>" );
			}
			
			
			writer.write( "</table>" );
			writer.flush();
			writer.close();
		}
		catch( Exception err ) {
			err.printStackTrace();
			
		}
		
	}

}
