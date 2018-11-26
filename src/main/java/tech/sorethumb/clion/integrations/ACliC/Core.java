package tech.sorethumb.clion.integrations.ACliC;

import tech.sorethumb.clion.constants.ProcessBuilderCommands;
import tech.sorethumb.clion.integrations.CommandLine;

public class Core extends CommandLine {
    
    public static String coreUpdateIndex(){
        return coreUpdateIndex(false);
    }
    
    private static String coreUpdateIndex (boolean debug) {
        
        ProcessBuilder builder =
                new ProcessBuilder(ProcessBuilderCommands.ARDUINO_CLI,
                        tech.sorethumb.clion.constants.ACliC.Core.asString(),
                        tech.sorethumb.clion.constants.ACliC.Core.UPDATE_INDEX);
        return CommandLine.ExecuteCommandLine(builder, false, debug);
    }
}
