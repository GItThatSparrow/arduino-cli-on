package tech.sorethumb.clion.integrations.ACliC;

import tech.sorethumb.clion.constants.ProcessBuilderCommands;
import tech.sorethumb.clion.integrations.CommandLine;

public class Board extends tech.sorethumb.clion.integrations.CommandLine {
    
    /**
     * Retrieves information about connected boards.
     * @return A string with Fqbn, Port, Name, USB ID and an array of Network Boards.
     */
    public static String BoardList () {
        
        ProcessBuilder builder =
                new ProcessBuilder(ProcessBuilderCommands.ARDUINO_CLI,
                        tech.sorethumb.clion.constants.ACliC.Board.asString(),
                        tech.sorethumb.clion.constants.ACliC.Board.LIST);
        return CommandLine.ExecuteCommandLine(builder);
    }
    
    /**
     * Retrieves information about connected boards.
     * @return A string with Fqbn, Port, Name, USB ID and an array of Network Boards.
     */
    public static String BoardListAll () {
    
        ProcessBuilder builder =
                new ProcessBuilder(
                        ProcessBuilderCommands.ARDUINO_CLI,
                        tech.sorethumb.clion.constants.ACliC.Board.asString(),
                        tech.sorethumb.clion.constants.ACliC.Board.LISTALL);
        return ExecuteCommandLine(builder);
    }
    
    /**
     * Show information about a board, in particular if the board has options to be specified in the FQBN.
     * @param fqbn
     * @return
     */
    public static String BoardDetails (String fqbn){
        ProcessBuilder builder =
                new ProcessBuilder(
                        ProcessBuilderCommands.ARDUINO_CLI,
                        tech.sorethumb.clion.constants.ACliC.Board.asString(),
                        tech.sorethumb.clion.constants.ACliC.Board.DETAILS,
                        fqbn);
        return ExecuteCommandLine(builder);
    }
}
