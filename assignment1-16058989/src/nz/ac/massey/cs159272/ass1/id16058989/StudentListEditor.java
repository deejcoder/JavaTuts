package nz.ac.massey.cs159272.ass1.id16058989;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.util.List;
import java.util.ArrayList;


public class StudentListEditor extends JPanel implements ActionListener, ListSelectionListener {

	private static final long serialVersionUID = 1L;
	
	

	/*
	 * 				Declarations
	 */
	
	//====[ Application based declarations ]
	static JFrame mainFrame;
	static JList<String> studentList;
	private DefaultListModel<String> studentCollection;

	private enum Actions {
		//Toolbar
		CLOSE_WINDOW (),
		LOAD_STUDENTS (),
		SAVE_STUDENTS (),
		ADD_STUDENT (),
		DELETE_STUDENT (),
		CLONE_STUDENT (),
		//Other
		MODIFY_ADDRESS(),
		MODIFY_COURSE(),
		UPDATE_STUDENTS();
		
		public boolean equals( String other ) {
			if( this.toString() == other ) {
				return true;
			}
			return false;
		}
	}
	
	//Text fields
	JTextField studentIdField;
	JTextField studentFNameField;
	JTextField studentLNameField;
	JFormattedTextField studentDobField;
	JTextField studentAddressField;
	JTextField studentCourseField;
	JButton setButton;
	
	//===
	//====[ Student management based declarations ]===
	public List<Student> students = new ArrayList<Student>();

	
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
		setPreferredSize( new Dimension( 650, 400 ) );
		
		//====[ Toolbar ]===
		
		JToolBar toolbar = new JToolBar();
		CreateButtons( toolbar );
		add( toolbar, BorderLayout.PAGE_START );
		
		//===
		//====[ Student List ]===
		
		JPanel studentListPanel = new JPanel( new BorderLayout() );
		
		studentCollection = new DefaultListModel<String>();
		studentList = new JList<String>( studentCollection );
		studentList.setSelectionMode( ListSelectionModel.SINGLE_INTERVAL_SELECTION );
		studentList.setSelectedIndex( 0 );
		studentList.setAutoscrolls( true );
		studentList.addListSelectionListener( this );
	      
		studentListPanel.add( studentList );
		add( studentListPanel );
		
		//===
		//====[ Student Editing ]===
		
		JPanel editPanel = new JPanel();
		editPanel.setBorder( BorderFactory.createEmptyBorder( 5, 50, 5, 5 ) );
		editPanel.setLayout( new GridBagLayout() );
		
		studentIdField = new JTextField( 20 );
		studentFNameField = new JTextField( 20 );
		studentLNameField = new JTextField( 20 );
		
		DateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" );
		studentDobField = new JFormattedTextField( dateFormat );
		
		

		studentAddressField = new JTextField( 25 );
		studentAddressField.setFocusable( false );
		studentAddressField.setText( "None" );
		studentAddressField.setEditable(false);
		JButton addressButton = CreateButton( ". .", Actions.MODIFY_ADDRESS, "Modify the Address." );
		
		JPanel addressPanel = new JPanel(  new FlowLayout( FlowLayout.LEFT, 0, 0 ) );
		JPanel addressPanelSub = new JPanel( );
		addressPanelSub.add( studentAddressField );
		addressPanelSub.add( addressButton );
		addressPanelSub.setBackground( studentAddressField.getBackground() );
		addressPanelSub.setBorder( studentAddressField.getBorder() );
		studentAddressField.setBorder( null );
		addressPanel.add( addressPanelSub );
		
		
		studentCourseField = new JTextField( 25 );
		studentCourseField.setFocusable( false );
		studentCourseField.setText( "None" );
		studentCourseField.setEditable(false);
		JButton courseButton = CreateButton( ". .", Actions.MODIFY_COURSE, "Modify the Course..." );
		
		JPanel coursePanel = new JPanel(  new FlowLayout( FlowLayout.LEFT, 0, 0 ) );
		JPanel coursePanelSub = new JPanel( );
		coursePanelSub.add( studentCourseField );
		coursePanelSub.add( courseButton );
		coursePanelSub.setBackground( studentCourseField.getBackground() );
		coursePanelSub.setBorder( studentCourseField.getBorder() );
		studentCourseField.setBorder( null );
		coursePanel.add( coursePanelSub );
		
		
		JLabel courseLabel = new JLabel( "Course:" );
		
		
		setButton = CreateButton( "Update", Actions.UPDATE_STUDENTS, "Save changes." );	
		
		editPanel.setSize( 150, 150 );
		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx = 1.0;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.insets = new Insets( 5, 5, 5, 5 );
		
		gc.gridx = 0;
		gc.gridy = 0;
		editPanel.add( new JLabel( "Student ID:"), gc );
		
		gc.gridx = 1;
		gc.gridy = 0;
		editPanel.add( studentIdField, gc );
		
		gc.gridx = 0;
		gc.gridy = 1;
		editPanel.add( new JLabel( "First name:"), gc );
		
		gc.gridx = 1;
		gc.gridy = 1;
		editPanel.add( studentFNameField, gc );
		
		gc.gridx = 0;
		gc.gridy = 2;
		editPanel.add( new JLabel( "Last name:"), gc );
		
		gc.gridx = 1;
		gc.gridy = 2;
		editPanel.add( studentLNameField, gc );
		
		gc.gridx = 0;
		gc.gridy = 3;
		editPanel.add( new JLabel( "Date of birth:"), gc );
		
		gc.gridx = 1;
		gc.gridy = 3;
		editPanel.add( studentDobField, gc );
		
		gc.gridx = 0;
		gc.gridy = 4;
		editPanel.add( new JLabel( "Address:"), gc );
		
		gc.gridx = 1;
		gc.gridy = 4;
		editPanel.add( addressPanel, gc );
		
		gc.gridx = 0;
		gc.gridy = 5;
		editPanel.add( new JLabel( "Course:"), gc );
		
		gc.gridx = 1;
		gc.gridy = 5;
		editPanel.add( coursePanel, gc );
		
		gc.gridx = 0;
		gc.gridy = 6;
		editPanel.add( setButton, gc );
		
		
		
		add( editPanel );
		editPanel.setMaximumSize( new Dimension( 50, 50 ) );

		
		//===
		//====[ Divider/Split ]===
		
		JSplitPane splitPane = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT, studentListPanel, editPanel );
		splitPane.setDividerLocation( 150 );
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
	
	@SuppressWarnings("unused")
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
		
		//ALL OPERATIONS THAT THE USER MUST SELECT A STUDENT FOR
		int index = studentList.getSelectedIndex();
		if( index == -1 ) return;
		
		Student student;
		try {
			student = students.get( index );
		}
		catch( IndexOutOfBoundsException e ) {
			return; //not a valid student
		}
		
		if( Actions.DELETE_STUDENT.equals( cmd ) ) {
			try {
				
				RemoveStudentListItem( index );
				System.out.println( students );
				students.remove( index );
				System.out.println( students );
			}
			catch( IndexOutOfBoundsException e ) {
				
			}
		}
		
		if( Actions.CLONE_STUDENT.equals( cmd ) ) {
			
			student = student.clone();
			students.add( student );
			AppendStudentListItem( student.getFirstname() + " " + student.getLastname() );
			
		}
		//===

		if( Actions.MODIFY_ADDRESS.equals( cmd ) ) {
			
			Address address = student.getAddress();
		
			JTextField houseNo = new JTextField( 5 );
			JTextField street = new JTextField( 20 );
			JTextField town = new JTextField( 20 );
			
			JPanel addressPanel = new JPanel();
			addressPanel.add(  new JLabel( "House Number:") );
			addressPanel.add( houseNo );
			addressPanel.add( new JLabel( "Street" ) );
			addressPanel.add( street );
			addressPanel.add( new JLabel( "Town" ) );
			addressPanel.add( town );
			
			int result = JOptionPane.showConfirmDialog(null, addressPanel, 
		    		"Enter the new address information...", JOptionPane.OK_CANCEL_OPTION);
		    
		    if( result == JOptionPane.OK_OPTION ) {
		    	address.setHouseno( Integer.parseInt( houseNo.getText() ) );
		    	address.setStreet( street.getText() );
		    	address.setTown( town.getText() );
		    	
		    	//I'm aware this should've...been put into a function "UpdateAddressField" for consistency and revisiting/updating
		    	studentAddressField.setText( address.getHouseno() + " " + address.getStreet() + ", " + address.getTown() );
		    }
			
		}
		
		if( Actions.MODIFY_COURSE.equals( cmd ) ) {
			Course course = student.getCourse();
			
			JTextField number = new JTextField( 8 );
			JTextField name = new JTextField( 20 );
			
			JPanel coursePanel = new JPanel();
			coursePanel.add( new JLabel( "Number:" ) );
			coursePanel.add( number );
			coursePanel.add( new JLabel( "Name:" ) );
			coursePanel.add( name );
			
			int result = JOptionPane.showConfirmDialog( null, coursePanel,
					"Enter the new course information...", JOptionPane.OK_CANCEL_OPTION );
			
			if( result == JOptionPane.OK_OPTION ) {
				//Would have an error message if invalid input was given using catch however...that'll just make more mess, as there is already mess...
				course.setNumber( Integer.parseInt( number.getText() ) );
				course.setName( name.getText() );
				
				studentCourseField.setText( course.getNumber() + " " + course.getName() );
				
			}
			
			
		}
		
		if( Actions.UPDATE_STUDENTS.equals( cmd ) ) {
			
			
			student.setId( studentIdField.getText() );
			student.setFirstname( studentFNameField.getText() );
			student.setLastname( studentLNameField.getText() );
			try {
				student.setDob( new SimpleDateFormat( "dd/MM/yyyy" ).parse( studentDobField.getText() ) );
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			studentCollection.set( index, student.getFirstname() + " " + student.getLastname() );
			
		}
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		JList<?> source = (JList<?>) e.getSource();
		
		//cancel adjustments else calls twice - assure it's the correct JList
		if( source == studentList && !source.getValueIsAdjusting() ) {
			if( source.isSelectionEmpty() ) {
				return;
			}
			else {
				int index = source.getSelectedIndex();
				
				try {
					Student student = students.get( index );
					studentIdField.setText( (String) student.getId() );
					studentFNameField.setText( (String) student.getFirstname() );
					studentLNameField.setText( (String) student.getLastname() );
					studentDobField.setText( (String) new SimpleDateFormat( "dd/MM/yyyy" ).format( student.getDob() ) );
					Address address = student.getAddress();
					studentAddressField.setText( (String) ( address.getHouseno() + " " + address.getStreet() + ", " + address.getTown() ) );
					Course course = student.getCourse();
					studentCourseField.setText( ( String ) ( course.getNumber() + " " + course.getName() ) );
				}
				catch( NullPointerException error ) {
					//do nothing: there exists a field with null.
				}
				catch( Exception error ) {
					error.printStackTrace();
					return;
				}

				System.out.println( "User selected list index: " + index );
				return;
			}
		}
		
		
	}
}
