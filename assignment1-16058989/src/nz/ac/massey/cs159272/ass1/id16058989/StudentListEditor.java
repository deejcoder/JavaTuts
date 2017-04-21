package nz.ac.massey.cs159272.ass1.id16058989;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

import java.util.List;
import java.util.ArrayList;

public class StudentListEditor extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	

	/*
	 * 				Declarations
	 */
	
	//====[ Application based declarations ]
	static JFrame mainFrame;

	private enum Actions {
		LOAD_STUDENTS (),
		SAVE_STUDENTS (),
		ADD_STUDENT (),
		DELETE_STUDENT ();
		
		public boolean equals( String other ) {
			if( this.toString() == other ) {
				return true;
			}
			return false;
		}
	}
	
	//===
	//====[ Student management based declarations ]===
	public List<Student> students = new ArrayList<Student>();
	protected int currentStudent = 0;
	
	//===

	
	
	
	/*
	 * 				Initialization Methods
	 */
	
	public static void main( String[] args ) {
		SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                init();
            }
        });
	}
	
	public StudentListEditor() {
		super( new BorderLayout() );
		
		setPreferredSize( new Dimension( 600, 400 ) );
		
		JToolBar toolbar = new JToolBar();
		CreateButtons( toolbar );
		add( toolbar, BorderLayout.PAGE_START );
		
	}
	
	private static void init() {
		mainFrame = new JFrame( "Student Editor" );
		mainFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		mainFrame.add(new StudentListEditor());
		
		mainFrame.pack();
		mainFrame.setVisible( true );
		
	}
	
	
	
	
	
	/*
	 * 				Buttons
	 */
	
	protected void CreateButtons( JToolBar toolbar ) {
		JButton button = null;
		
		button = CreateButton( "Load", Actions.LOAD_STUDENTS, "Load students from a file." );
		toolbar.add( button );
		
		button = CreateButton( "Save", Actions.SAVE_STUDENTS, "Save students to a file." );
		toolbar.add( button );
		
		button = CreateButton( "Add", Actions.ADD_STUDENT, "Add a new student." );
		toolbar.add( button );
		
		button = CreateButton( "Delete", Actions.DELETE_STUDENT, "Delete a student." );
		toolbar.add( button );
	}
	
	protected JButton CreateButton( String text, Actions cmd, String tip ) {
		JButton button = new JButton();
		button.setActionCommand( cmd.toString() );
		button.setToolTipText( tip );
		button.addActionListener( this );
		button.setText( text );
		return button;
	}
	
	
	
	
	/*
	 * 				Events & Triggers
	 */
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String cmd = arg0.getActionCommand();
		
		//====[ Loading/Saving related ]===
		
		if( Actions.LOAD_STUDENTS.equals( cmd ) ) {
			
			FileDialog fileDialog = new FileDialog( mainFrame, "Load Students", FileDialog.LOAD );
			fileDialog.setFile( "*.xml" );
			fileDialog.setVisible( true );
			
			try {
				students = StudentDB.fetch( fileDialog.getDirectory() + fileDialog.getFile() );
				System.out.println( students );
			}
			catch( Exception e ) {
				
			}
		}
		
		if( Actions.SAVE_STUDENTS.equals( cmd ) ) {
			
			FileDialog fileDialog = new FileDialog( mainFrame, "Save Students", FileDialog.SAVE );
			fileDialog.setFile( "students.xml" );
			fileDialog.setVisible( true );
			
			try {
				StudentDB.save( students, fileDialog.getDirectory() + fileDialog.getFile() );
				
			}
			catch( Exception e ) {
				
			}
			
		}
		
		//===
		
		if( Actions.ADD_STUDENT.equals( cmd ) ) {
			
			Student student = new Student();
			students.add( student );
			currentStudent = students.size() - 1;
		}
		
		if( Actions.DELETE_STUDENT.equals( cmd ) ) {
			try {
				students.remove( currentStudent );
			}
			catch( IndexOutOfBoundsException e ) {
				
			}
			currentStudent = 0;
		}

		
	}
}
