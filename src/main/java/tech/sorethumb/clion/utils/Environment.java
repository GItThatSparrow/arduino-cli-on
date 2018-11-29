package tech.sorethumb.clion.utils;

public class Environment
{
    public static final String ARDUINO_CLI_DEBUG = "ARDUINO_CLI_DEBUG";
    
    public static boolean isDebugEnv(){
        if(System.getenv().containsKey(ARDUINO_CLI_DEBUG))
        {
            return Boolean.parseBoolean(System.getenv(ARDUINO_CLI_DEBUG));
        }
        return false;
    }
    /**
     * java.lang.management.ManagementFactory.getRuntimeMXBean().
     *         getInputArguments().toArray();
     */
}
