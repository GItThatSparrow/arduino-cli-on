package tech.sorethumb.clion.constants.ACliC;


/**
 * Shows version number of arduino CLI
 */
public class Version {
    
    public static final String regex = "arduino-cli version (\\d+\\.){2}(\\d+)-alpha.preview";
    
    public static final String VERSION = "version";
    
    @Override
    public String toString () {
        return VERSION;
    }
    
    public static String asString () {
        return VERSION;
    }
    
    /**
     * Tests the response against a validation expression.
     * @param actual The string response from the {@code arduino-cli}
     * @return Will respond {@code true} if it is a valid match.
     */
    public static boolean validate (String actual) {
        return actual.trim().matches(regex);
    }
}
