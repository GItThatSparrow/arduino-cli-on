package tech.sorethumb.clion.constants.ACliC;

/**
 * Arduino Configuration Commands.
 */
public class Config {
    
    private static final String CONFIG = "config";
    
    @Override
    public String toString()
    {
        return CONFIG;
    }
    
    public static String asString()
    {
        return CONFIG;
    }
    
    /**
     * Prints the current configuration
     */
    public static final String DUMP = "dump";
    
    /**
     * Represents a string to search for in a non-JSON response.
     */
    public static final String proxy_type      = "proxy_type";
    
    /**
     * Represents a string to search for in a non-JSON response.
     */
    public static final String sketchbook_path = "sketchbook_path";
    
    /**
     * Represents a string to search for in a non-JSON response.
     */
    public static final String arduino_data    = "arduino_data";
    
    /**
     * Represents a string to search for in a non-JSON response.
     */
    public static final String board_manager   = "board_manager";
}
