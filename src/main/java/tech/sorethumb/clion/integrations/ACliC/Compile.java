package tech.sorethumb.clion.integrations.ACliC;

import com.google.gson.annotations.SerializedName;
import tech.sorethumb.clion.integrations.CommandLine;

import java.util.*;
import java.util.stream.Collectors;

import static tech.sorethumb.clion.constants.ProcessBuilderCommands.REGEX_PARAM_NAME_VALUE;

/**
 * Compiles Arduino sketches
 *
 * <b>Usage:</b>
 *   arduino-cli compile [flags]
 *
 * <b>Examples:</b>
 *   arduino-cli compile -b arduino:avr:uno /home/user/Arduino/MySketch
 */
public class Compile extends CommandLine {
    
    private String fqbn = "";
    private String showProperties = "";
    private String preprocess = "";
    private String buildCachePath = "";
    private String exportFile = "";
    private String buildPath = "";
    private String buildProperties = "";
    private WarningLevel warnings = WarningLevel.DEFAULT;
    private String verbose = "";
    private String quiet = "";
    private String vidPid = "";
    EnumMap<WarningLevel, String> enumMap;
    
    public Compile(){
        enumMap = new EnumMap<WarningLevel, String>(WarningLevel.class);
        enumMap.put(WarningLevel.ALL,"all");
        enumMap.put(WarningLevel.DEFAULT, "default");
        enumMap.put(WarningLevel.MORE, "more");
        enumMap.put(WarningLevel.NONE, "none");
    }
    
    public static void run(String fqbn, String Build){
        
    }
    
    public static ArrayList<String> test(Compile compileProject){
        ArrayList<String> params = new ArrayList<>();
        params.add(Constants.COMPILE);
        params.addAll(compileProject.getKeyValueParams());
        
        return params;
    }
    
    public Set<String> getKeyValueParams(){
        Set<String> params = new HashSet<>();
        params.add(getFqbn());
        params.add(getShowProperties());
        params.add(getPreprocess());
        params.add(getBuildCachePath());
        
        params.add(getExportFile());
        params.add(getBuildPath());
        params.add(getBuildProperties());
        
        params.add(getWarnings());
        params.add(getVerbose());
        params.add(getQuiet());
        params.add(getVidPid());
        
        Set<String> fParams = params
                .stream()
                .filter(f-> (f != null && !f.isEmpty()))
                .collect(Collectors.toSet());
        
        return fParams;
    }
    
    /**
     * Fully Qualified Board Name, e.g.: arduino:avr:uno
     */
    @SerializedName("fqdn")
    public String getFqbn () {
        return (fqbn.isEmpty() ? "" : String.format(REGEX_PARAM_NAME_VALUE, Constants.FQBN, fqbn));
    }
    
    /**
     * Fully Qualified Board Name, e.g.: arduino:avr:uno
     */
    public void setFqbn (String fqbn) {
        this.fqbn = fqbn;
    }
    
    /**
     * Show all build properties used instead of compiling.
     */
    public String getShowProperties () {
        return showProperties.isEmpty() ? "" : String.format(REGEX_PARAM_NAME_VALUE, Constants.SHOW_PROPERTIES, showProperties);
    }
    
    /**
     * Show all build properties used instead of compiling.
     */
    public void setShowProperties (String showProperties) {
        this.showProperties = showProperties;
    }
    
    /**
     * Print preprocessed code to stdout instead of compiling.
     */
    public String getPreprocess () {
        return (preprocess.isEmpty() ? "" : String.format(REGEX_PARAM_NAME_VALUE, Constants.PREPROCESS, preprocess));
    }
    
    /**
     * Print preprocessed code to stdout instead of compiling.
     */
    public void setPreprocess (String preprocess) {
        this.preprocess = preprocess;
    }
    
    /**
     * Builds of 'core.a' are saved into this path to be cached and reused.
     */
    public String getBuildCachePath () {
        return (buildCachePath.isEmpty() ? "" : String.format(REGEX_PARAM_NAME_VALUE, Constants.BUILD_CACHE_PATH, buildCachePath));
    }
    
    /**
     * Builds of 'core.a' are saved into this path to be cached and reused.
     */
    public void setBuildCachePath (String buildCachePath) {
        this.buildCachePath = buildCachePath;
    }
    
    /**
     * Filename of the compile exportFile.
     */
    public String getExportFile () {
        return (exportFile.isEmpty() ? "" : String.format(REGEX_PARAM_NAME_VALUE, Constants.EXPORT_FILE, exportFile));
    }
    
    /**
     * Filename of the compile exportFile.
     */
    public void setExportFile (String exportFile) {
        this.exportFile = exportFile;
    }
    
    /**
     * Path where to save compiled files. If omitted, a directory will be created in the default temporary path of your OS.
     */
    public String getBuildPath () {
        return (buildPath.isEmpty() ? "" : String.format(REGEX_PARAM_NAME_VALUE, Constants.BUILD_PATH, buildPath));
    }
    
    /**
     * Path where to save compiled files. If omitted, a directory will be created in the default temporary path of your OS.
     */
    public void setBuildPath (String buildPath) {
        this.buildPath = buildPath;
    }
    
    /**
     * List of custom build properties separated by commas. Or can be used multiple times for multiple properties.
     */
    public String getBuildProperties () {
        return (buildProperties.isEmpty() ? "" : String.format(REGEX_PARAM_NAME_VALUE, Constants.BUILD_PROPERTIES, buildProperties));
    }
    
    /**
     * List of custom build properties separated by commas. Or can be used multiple times for multiple properties.
     */
    public void setBuildProperties (String buildProperties) {
        this.buildProperties = buildProperties;
    }
    
    /**
     * Optional, can be "none", "default", "more" and "all". Defaults to "none".
     * Used to tell gcc which warning level to use (-W flag).
     */
    public String getWarnings () {
        return (warnings == null ? "" : String.format(REGEX_PARAM_NAME_VALUE, Constants.WARNINGS, enumMap.get(warnings)));
    }
    
    /**
     * Optional, can be "none", "default", "more" and "all". Defaults to "none". Used to tell gcc which warning level to use (-W flag).
     */
    public void setWarnings (WarningLevel warnings) {
        this.warnings = warnings;
    }
    
    /**
     * Optional, turns on verbose mode.
     */
    public String getVerbose () {
        return (verbose.isEmpty() ? "" : String.format(REGEX_PARAM_NAME_VALUE, Constants.VERBOSE, verbose));
    }
    
    /**
     * Optional, turns on verbose mode.
     */
    public void setVerbose (String verbose) {
        this.verbose = verbose;
    }
    
    /**
     * Optional, supresses almost every exportFile.
     */
    public String getQuiet () {
        return (quiet.isEmpty() ? "" : String.format(REGEX_PARAM_NAME_VALUE, Constants.QUIET, quiet));
    }
    
    /**
     * Optional, supresses almost every exportFile.
     */
    public void setQuiet (String quiet) {
        this.quiet = quiet;
    }
    
    /**
     * When specified, VID/PID specific build properties are used, if boards supports them.
     */
    public String getVidPid () {
        return (vidPid.isEmpty() ? "" : String.format(REGEX_PARAM_NAME_VALUE, Constants.VIDPID, vidPid));
    }
    
    /**
     * When specified, VID/PID specific build properties are used, if boards supports them.
     */
    public void setVidPid (String vidPid) {
        this.vidPid = vidPid;
    }
    
    public static class Constants {
        
        public static final String COMPILE = "compile";
        
        @Override
        public String toString () {
            return (COMPILE.isEmpty() ? "" : String.format(REGEX_PARAM_NAME_VALUE, Constants.COMPILE, COMPILE));
        }
        
        public static String asString () {
            return (COMPILE.isEmpty() ? "" : String.format(REGEX_PARAM_NAME_VALUE, Constants.COMPILE, COMPILE));
        }
        
        /**
         * Fully Qualified Board Name, e.g.: arduino:avr:uno
         */
        public static final String FQBN = "fqbn";
        /**
         * Show all build properties used instead of compiling.
         */
        public static final String SHOW_PROPERTIES = "show-properties";
        /**
         * Print preprocessed code to stdout instead of compiling.
         */
        public static final String PREPROCESS = "preprocess";
        /**
         * Builds of 'core.a' are saved into this path to be cached and reused.
         */
        public static final String BUILD_CACHE_PATH = "build-cache-path";
        /**
         * Filename of the compile exportFile.
         */
        public static final String EXPORT_FILE = "exportFile";
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
         * Optional, supresses almost every exportFile.
         */
        public static final String QUIET = "quiet";
        /**
         * When specified, VID/PID specific build properties are used, if boards supports them.
         */
        public static final String VIDPID = "vid-pid";
    }
    
    public enum WarningLevel
    {
        NONE,
        DEFAULT,
        MORE,
        ALL
    }
}
