package intermediate.src.week1_labs.oop.generics;

public class GenericValidator {
    
    public static <T> boolean isValid (T value) {
        if ( value instanceof Integer ) {
            return isValidInteger( (Integer) value );
        } else if ( value instanceof Double ) {
            return isValidDouble( (Double) value );
        } else if ( value instanceof String ) {
            return isValidString( (String) value );
        }
        return false;
    }
    
    private static boolean isValidInteger (Integer value) {
        return value > 0;
    }
    
    private static boolean isValidDouble (Double value) {
        return value >= 0.0 && value <= 100.0;
    }
    
    private static boolean isValidString (String value) {
        return value != null && value.length() >= 5;
    }
    
    public static void main (String[] args) {
        System.out.println( isValid( 25 ) );           // Integer validation: true
        System.out.println( isValid( -10 ) );          // Integer validation: false
        System.out.println( isValid( 50.5 ) );         // Double validation: true
        System.out.println( isValid( 150.0 ) );        // Double validation: false
        System.out.println( isValid( "Hello" ) );      // String validation: true
        System.out.println( isValid( "Hi" ) );         // String validation: false
        System.out.println( isValid( null ) );         // Unsupported validation: false
    }
}
