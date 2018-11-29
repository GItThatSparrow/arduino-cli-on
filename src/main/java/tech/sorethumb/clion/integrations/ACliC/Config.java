package tech.sorethumb.clion.integrations.ACliC;

import tech.sorethumb.clion.constants.ProcessBuilderCommands;
import tech.sorethumb.clion.integrations.CommandLine;

/**
 * Arduino Configuration Commands.
 */
public class Config extends CommandLine {
    
    /**
     * A command-line operation that returns all configuration settings.
     *
     * This operation is not capable of outputting JSON.
     * @return A key/value output, not JSON.
     */
    public static String dump(){
        ProcessBuilder builder = new ProcessBuilder(
                ProcessBuilderCommands.ARDUINO_CLI,
                Constants.asString(),
                Constants.DUMP);
        return CommandLine.ExecuteCommandLine(builder).trim();
    }
    
    
    /**
     * Arduino Configuration Commands.
     */
    public static class Constants {
        
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
    
}
