package tech.sorethumb.clion.integrations.ACliC;

import tech.sorethumb.clion.constants.ProcessBuilderCommands;
import tech.sorethumb.clion.integrations.CommandLine;

public class Version extends CommandLine {
    
    /**
     * Shows version number of arduino CLI
     * @return {"command":"arduino-cli","version":"0.3.2-alpha.preview"}
     */
    public static String getVersion()
    {
        ProcessBuilder builder =
                new ProcessBuilder(Constants.asString());
        return ExecuteCommandLine(builder);
    }
    
    static boolean isVersionValid (){
        String actual = getVersion();
        return validate(actual);
    }
    
    /**
     * Tests the response against a validation expression.
     * @param actual The string response from the {@code arduino-cli}
     * @return Will respond {@code true} if it is a valid match.
     */
    private static boolean validate (String actual) {
        return actual.trim().matches(Constants.regex);
    }
    
    /**
     * Shows version number of arduino CLI
     */
    public static class Constants {
        
        public static final String regex = "\\{\"command\":\"arduino-cli\",\"version\":\"(\\d+\\.){2}(\\d+)-alpha.preview\"\\}";
        
        public static final String VERSION = "version";
        
        @Override
        public String toString () {
            return VERSION;
        }
        
        public static String asString () {
            return VERSION;
        }
    }
    
}
