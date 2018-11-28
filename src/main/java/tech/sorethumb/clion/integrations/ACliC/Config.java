package tech.sorethumb.clion.integrations.ACliC;

import tech.sorethumb.clion.constants.ProcessBuilderCommands;
import tech.sorethumb.clion.integrations.CommandLine;


public class Config extends CommandLine {
    
    /**
     * A command-line operation that returns all configuration settings.
     * @return
     */
    public static String dump(){
        ProcessBuilder builder = new ProcessBuilder(
                ProcessBuilderCommands.ARDUINO_CLI,
                tech.sorethumb.clion.constants.ACliC.Config.asString(),
                tech.sorethumb.clion.constants.ACliC.Config.DUMP);
        return CommandLine.ExecuteCommandLine(builder, false, false).trim();
    }
}
