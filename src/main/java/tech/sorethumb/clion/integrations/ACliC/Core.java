package tech.sorethumb.clion.integrations.ACliC;

import tech.sorethumb.clion.constants.ProcessBuilderCommands;
import tech.sorethumb.clion.integrations.CommandLine;

public class Core extends CommandLine {
    
    public static String coreUpdateIndex(){
        ProcessBuilder builder =
                new ProcessBuilder(ProcessBuilderCommands.ARDUINO_CLI,
                        Constants.asString(),
                        Constants.UPDATE_INDEX);
        return CommandLine.ExecuteCommandLine(builder);
    }
    
    /**
     * Retrieves a JSON-formatted list of {@link tech.sorethumb.clion.models.coreIndex.Platform} objects.
     * @return An array of installed {@link tech.sorethumb.clion.models.coreIndex.Platform}s.
     */
    public static String getListJSON(){
        ProcessBuilder builder =
                new ProcessBuilder(ProcessBuilderCommands.ARDUINO_CLI,
                        Constants.asString(),
                        Constants.LIST);
        return CommandLine.ExecuteCommandLine(builder);
    }
    
    /**
     * Downloads one or more cores and corresponding tool dependencies.
     *
     * Usage:
     *   arduino-cli core download [PACKAGER:ARCH[=VERSION]](S) [flags]
     *
     * Examples:
     *   arduino-cli core download arduino:samd       # to download the latest version of arduino SAMD core.
     *   arduino-cli core download arduino:samd=1.6.9 # for a specific version (in this case 1.6.9).
     * @param fqbn
     * @return
     */
    public static String downloadCore(String fqbn){
        ProcessBuilder builder =
                new ProcessBuilder(ProcessBuilderCommands.ARDUINO_CLI,
                        Constants.asString(),
                        Constants.DOWNLOAD,
                        fqbn);
        return CommandLine.ExecuteCommandLine(builder);
    }
    
    /**
     * Downloads a specific version of a core and corresponding tool dependencies.
     * @param fqbn The "Fully Qualified Board Name" to download
     * @param version The specific version of a board core to download
     * @return
     */
    public static String downloadCore(String fqbn, String version){
        ProcessBuilder builder =
                new ProcessBuilder(ProcessBuilderCommands.ARDUINO_CLI,
                        Constants.asString(),
                        Constants.DOWNLOAD,
                        fqbn,
                        version);
        return CommandLine.ExecuteCommandLine(builder);
    }
    
    /**
     * Installs one or more cores and corresponding tool dependencies.
     * @param fqbn
     * @return
     */
    public static String installCore(String fqbn){
        ProcessBuilder builder =
                new ProcessBuilder(ProcessBuilderCommands.ARDUINO_CLI,
                        Constants.asString(),
                        Constants.INSTALL,
                        fqbn);
        return CommandLine.ExecuteCommandLine(builder);
    }
    
    /**
     * Installs a specific version of a core and corresponding tool dependencies.
     * @param fqbn The "Fully Qualified Board Name" to install
     * @param version The specific version of a board core to install
     * @return
     */
    public static String installCore(String fqbn, String version){
        ProcessBuilder builder =
                new ProcessBuilder(ProcessBuilderCommands.ARDUINO_CLI,
                        Constants.asString(),
                        Constants.INSTALL,
                        fqbn,
                        version);
        return CommandLine.ExecuteCommandLine(builder);
    }
    
    /**
     * Uninstalls one or more cores and corresponding tool dependencies.
     * @param fqbn
     * @return
     */
    public static String uninstallCore(String fqbn){
        ProcessBuilder builder =
                new ProcessBuilder(ProcessBuilderCommands.ARDUINO_CLI,
                        Constants.asString(),
                        Constants.UNINSTALL,
                        fqbn);
        return CommandLine.ExecuteCommandLine(builder);
    }
    
    /**
     * Uninstalls a specific version of a core and corresponding tool dependencies.
     * @param fqbn The "Fully Qualified Board Name" to install
     * @param version The specific version of a board core to install
     * @return
     */
    public static String uninstallCore(String fqbn, String version){
        ProcessBuilder builder =
                new ProcessBuilder(ProcessBuilderCommands.ARDUINO_CLI,
                        Constants.asString(),
                        Constants.UNINSTALL,
                        fqbn,
                        version);
        return CommandLine.ExecuteCommandLine(builder);
    }
    
    
    public static class Constants {
        
        private static final String CORE = "core";
        
        /**
         * Returns a string representation of the object. In general, the
         * {@code toString} method returns a string that
         * "textually represents" this object. The result should
         * be a concise but informative representation that is easy for a
         * person to read.
         * It is recommended that all subclasses override this method.
         * <p>
         * The {@code toString} method for class {@code Object}
         * returns a string consisting of the name of the class of which the
         * object is an instance, the at-sign character `{@code @}', and
         * the unsigned hexadecimal representation of the hash code of the
         * object. In other words, this method returns a string equal to the
         * value of:
         * <blockquote>
         * <pre>
         * getClass().getName() + '@' + Integer.toHexString(hashCode())
         * </pre></blockquote>
         *
         * @return a string representation of the object.
         */
        @Override
        public String toString () {
            return CORE;
        }
        
        public static String asString () {
            return CORE;
        }
        
        /**
         * Downloads one or more cores and corresponding tool dependencies.
         */
        public static final String DOWNLOAD = "download";
        /**
         * Installs one or more cores and corresponding tool dependencies.
         */
        public static final String INSTALL = "install";
        /**
         * Shows the list of installed platforms.
         */
        public static final String LIST = "list";
        /**
         * Search for a core in the package index.
         */
        public static final String SEARCH = "search";
        /**
         * Uninstalls one or more cores and corresponding tool dependencies if no more used.
         */
        public static final String UNINSTALL = "uninstall";
        /**
         * Updates the index of cores.
         */
        public static final String UPDATE_INDEX ="update-index";
        /**
         * Upgrades one or all installed platforms to the latest version.
         */
        public static final String UPGRADE = "upgrade";
    }
    
}
