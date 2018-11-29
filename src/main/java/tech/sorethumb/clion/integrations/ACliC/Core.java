package tech.sorethumb.clion.integrations.ACliC;

import tech.sorethumb.clion.constants.ProcessBuilderCommands;
import tech.sorethumb.clion.integrations.CommandLine;

public class Core extends CommandLine {
    
    public static String coreUpdateIndex(){
        ProcessBuilder builder =
                new ProcessBuilder(ProcessBuilderCommands.ARDUINO_CLI,
                        tech.sorethumb.clion.constants.ACliC.Core.asString(),
                        tech.sorethumb.clion.constants.ACliC.Core.UPDATE_INDEX);
        return CommandLine.ExecuteCommandLine(builder);
    }
    
    /**
     * Retrieves a JSON-formatted list of {@link tech.sorethumb.clion.models.coreIndex.Platform} objects.
     * @return An array of installed {@link tech.sorethumb.clion.models.coreIndex.Platform}s.
     */
    public static String getListJSON(){
        ProcessBuilder builder =
                new ProcessBuilder(ProcessBuilderCommands.ARDUINO_CLI,
                        tech.sorethumb.clion.constants.ACliC.Core.asString(),
                        tech.sorethumb.clion.constants.ACliC.Core.LIST);
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
                        tech.sorethumb.clion.constants.ACliC.Core.asString(),
                        tech.sorethumb.clion.constants.ACliC.Core.DOWNLOAD,
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
                        tech.sorethumb.clion.constants.ACliC.Core.asString(),
                        tech.sorethumb.clion.constants.ACliC.Core.DOWNLOAD,
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
                        tech.sorethumb.clion.constants.ACliC.Core.asString(),
                        tech.sorethumb.clion.constants.ACliC.Core.INSTALL,
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
                        tech.sorethumb.clion.constants.ACliC.Core.asString(),
                        tech.sorethumb.clion.constants.ACliC.Core.INSTALL,
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
                        tech.sorethumb.clion.constants.ACliC.Core.asString(),
                        tech.sorethumb.clion.constants.ACliC.Core.UNINSTALL,
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
                        tech.sorethumb.clion.constants.ACliC.Core.asString(),
                        tech.sorethumb.clion.constants.ACliC.Core.UNINSTALL,
                        fqbn,
                        version);
        return CommandLine.ExecuteCommandLine(builder);
    }
}
