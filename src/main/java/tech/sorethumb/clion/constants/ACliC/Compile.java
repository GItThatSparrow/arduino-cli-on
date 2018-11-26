package tech.sorethumb.clion.constants.ACliC;


/**
 * Compiles Arduino sketches
 */
public class Compile {
    
    public static final String COMPILE = "compile";
    
    @Override
    public String toString () {
        return COMPILE;
    }
    
    public static String asString () {
        return COMPILE;
    }
    
    /**
     * Fully Qualified Board Name, e.g.: arduino:avr:uno
     */
    public static final String fqbn = "fqbn";
    /**
     * Show all build properties used instead of compiling.
     */
    public static final String showProperties = "show-properties";
    /**
     * Print preprocessed code to stdout instead of compiling.
     */
    public static final String preprocess = "preprocess";
    /**
     * Builds of 'core.a' are saved into this path to be cached and reused.
     */
    public static final String buildCachePath = "build-cache-path";
    /**
     * Filename of the compile output.
     */
    public static final String exportFile = "output";
    /**
     * Path where to save compiled files. If omitted, a directory will be created in the default temporary path of your OS.
     */
    public static final String buildPath = "build-path";
    /**
     * List of custom build properties separated by commas. Or can be used multiple times for multiple properties.
     */
    public static final String buildProperties = "build-properties";
    /**
     * Optional, can be "none", "default", "more" and "all". Defaults to "none". Used to tell gcc which warning level to use (-W flag).
     */
    public static final String warnings = "warnings";
    /**
     * Optional, turns on verbose mode.
     */
    public static final String verbose = "verbose";
    /**
     * Optional, supresses almost every output.
     */
    public static final String quiet = "quiet";
    /**
     * When specified, VID/PID specific build properties are used, if boards supports them.
     */
    public static final String vidPid = "vid-pid";
}
