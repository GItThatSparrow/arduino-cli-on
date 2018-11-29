package tech.sorethumb.clion.integrations.ACliC;

import tech.sorethumb.clion.constants.ProcessBuilderCommands;
import tech.sorethumb.clion.integrations.CommandLine;

public class Lib extends CommandLine{
    
    /**
     * Shows a list of all installed libraries.
     * @return
     */
    public static String getInstalledLibraries()
    {
        
        ProcessBuilder builder =
                new ProcessBuilder(ProcessBuilderCommands.ARDUINO_CLI,
                        tech.sorethumb.clion.constants.ACliC.Lib.asString(),
                        tech.sorethumb.clion.constants.ACliC.Lib.LIST);
        return CommandLine.ExecuteCommandLine(builder);
    }
    
    /**
     * Include built-in libraries (from platforms and IDE) in listing.
     * @return
     */
    public static String getAllInstalledLibraries()
    {
        
        ProcessBuilder builder =
                new ProcessBuilder(ProcessBuilderCommands.ARDUINO_CLI,
                        tech.sorethumb.clion.constants.ACliC.Lib.asString(),
                        tech.sorethumb.clion.constants.ACliC.Lib.LIST,
                        "all");
        return CommandLine.ExecuteCommandLine(builder);
    }
    
    /**
     * List updatable libraries.
     * @return
     */
    public static String getUpdatableLibraries()
    {
        ProcessBuilder builder =
                new ProcessBuilder(ProcessBuilderCommands.ARDUINO_CLI,
                        tech.sorethumb.clion.constants.ACliC.Lib.asString(),
                        tech.sorethumb.clion.constants.ACliC.Lib.LIST,
                        "updatable");
        return CommandLine.ExecuteCommandLine(builder);
    }
}
