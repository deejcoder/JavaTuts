public class test {
    public static void main (String[] args) {

    	System.out.println( args[1] );
    	// parse first number from string to integer
        int number1 = Integer.parseInt(args[0]);

        // parse second number from string to integer
        int number2 = Integer.parseInt(args[2]);
        
        switch( args[1] ) {
        	case "+" : System.out.println( number1 + number2 );
        	case "-": System.out.println( number1 - number2 ); break;
        	case "*": System.out.println( number1 * number2 ); break;
        	case "/": System.out.println( number1 / number2 ); break;
        	default: System.out.println( "The input was not read." ); break;
        }
    }
}
