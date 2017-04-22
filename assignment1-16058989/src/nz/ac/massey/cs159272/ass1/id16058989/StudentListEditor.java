package nz.ac.massey.cs159272.ass1.id16058989;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

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
		CLOSE_WINDOW (),
		LOAD_STUDENTS (),
		SAVE_STUDENTS (),
		ADD_STUDENT (),
		DELETE_STUDENT (),
		CLONE_STUDENT ();
		
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
	protected JList studentList;
	protected DefaultListModel studentCollection;
	
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
		
		//Window size
		setPreferredSize( new Dimension( 600, 400 ) );
		
		//====[ Toolbar ]===
		
		JToolBar toolbar = new JToolBar();
		CreateButtons( toolbar );
		add( toolbar, BorderLayout.PAGE_START );
		
		//===
		//====[ Student List ]===
		
		JPanel studentListPanel = new JPanel( new BorderLayout() );
		
		studentCollection = new DefaultListModel();
		studentList = new JList( studentCollection );
		studentList.setSelectionMode( ListSelectionModel.MULTIPLE_INTERVAL_SELECTION );
		studentList.setSelectedIndex( 0 );
	      
		studentListPanel.add( studentList );
		add( studentListPanel );
		
		//===
		//====[ Student Editing ]===
		
		JPanel studentEditPanel = new JPanel( new BorderLayout() );
		add( studentEditPanel );
		
		//===
		//====[ Divider/Split ]===
		
		JSplitPane splitPane = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT, studentListPanel, studentEditPanel );
		add( splitPane );
		
		//===
		
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
		
		button = CreateButton( "Exit", Actions.CLOSE_WINDOW, "Close the application." );
		toolbar.add( button );
		
		toolbar.addSeparator();
		
		button = CreateButton( "Load", Actions.LOAD_STUDENTS, "Load students from a file." );
		toolbar.add( button );
		button = CreateButton( "Save", Actions.SAVE_STUDENTS, "Save students to a file." );
		toolbar.add( button );
		
		toolbar.addSeparator();
		
		button = CreateButton( "Add", Actions.ADD_STUDENT, "Add a new student." );
		toolbar.add( button );
		button = CreateButton( "Duplicate", Actions.CLONE_STUDENT, "Clone a student." );
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
	 * 				Maintaining Student List
	 */
	
	
	private void ResetStudentList() {
		studentCollection.clear();
		for( Student s : students ) {
			studentCollection.addElement( s.getFirstname() + " " + s.getLastname() );
		}
	}
	
	private void AppendStudentListItem( String content ) {
		studentCollection.addElement( content );
	}
	
	private void PopStudentListItem() {
		studentCollection.removeElement( studentCollection.lastElement() );
	}
	
	private void RemoveStudentListItem( int index ) {
		studentCollection.remove( index );
	}
	
	
	
	/*
	 * 				Events & Triggers
	 */
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String cmd = arg0.getActionCommand();
		
		if( Actions.CLOSE_WINDOW.equals( cmd ) ) {
			mainFrame.setVisible( false );
			mainFrame.dispose();
		}
		//====[ Loading/Saving related ]===
		
		if( Actions.LOAD_STUDENTS.equals( cmd ) ) {
			
			FileDialog fileDialog = new FileDialog( mainFrame, "Load Students", FileDialog.LOAD );
			fileDialog.setFile( "*.xml" );
			fileDialog.setVisible( true );
			
			try {
				students = StudentDB.fetch( fileDialog.getDirectory() + fileDialog.getFile() );
				System.out.println( students );
				ResetStudentList();
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
		
		//====[ Record Operations ]===
		
		
		if( Actions.ADD_STUDENT.equals( cmd ) ) {
			
			Student student = new Student();
			students.add( student );
			AppendStudentListItem( "New Student" );
		}
		
		if( Actions.DELETE_STUDENT.equals( cmd ) ) {
			try {
				int index = studentList.getSelectedIndex();
				if( index == -1 ) return;
				
				RemoveStudentListItem( index );
				System.out.println( students );
				students.remove( index );
				System.out.println( students );
			}
			catch( IndexOutOfBoundsException e ) {
				
			}
			currentStudent = 0;
		}
		
		if( Actions.CLONE_STUDENT.equals( cmd ) ) {
			int index = studentList.getSelectedIndex();
			if( index == -1 ) return;
			
			Student student = students.get( index );
			student = student.clone();
			students.add( student );
			AppendStudentListItem( student.getFirstname() + " " + student.getLastname() );
			
		}
		//===

		
	}
}
