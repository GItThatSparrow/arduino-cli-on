package tech.sorethumb.clion.integrations.ACliC;

public class Compile {
    
    
    
    /**
     * Compiles Arduino sketches
     */
    public static class Constants {
        
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
        public static final String FQBN = "fqbn";
        /**
         * Show all build properties used instead of compiling.
         */
        public static final String SHOWP_ROPERTIES = "show-properties";
        /**
         * Print preprocessed code to stdout instead of compiling.
         */
        public static final String PREPROCESS = "preprocess";
        /**
         * Builds of 'core.a' are saved into this path to be cached and reused.
         */
        public static final String BUILD_CACHE_PATH = "build-cache-path";
        /**
         * Filename of the compile output.
         */
        public static final String EXPORT_FILE = "output";
        /**
         * Path where to save compiled files. If omitted, a directory will be created in the default temporary path of your OS.
         */
        public static final String BUILD_PATH = "build-path";
        /**
         * List of custom build properties separated by commas. Or can be used multiple times for multiple properties.
         */
        public static final String BUILD_PROPERTIES = "build-properties";
        /**
         * Optional, can be "none", "default", "more" and "all". Defaults to "none". Used to tell gcc which warning level to use (-W flag).
         */
        public static final String WARNINGS = "warnings";
        /**
         * Optional, turns on verbose mode.
         */
        public static final String VERBOSE = "verbose";
        /**
         * Optional, supresses almost every output.
         */
        public static final String QUIET = "quiet";
        /**
         * When specified, VID/PID specific build properties are used, if boards supports them.
         */
        public static final String VIDPID = "vid-pid";
    }
    
}
