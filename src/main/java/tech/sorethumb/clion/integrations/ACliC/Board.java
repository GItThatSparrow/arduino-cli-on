package tech.sorethumb.clion.integrations.ACliC;

import com.google.gson.Gson;
import tech.sorethumb.clion.constants.ProcessBuilderCommands;
import tech.sorethumb.clion.integrations.CommandLine;
import tech.sorethumb.clion.models.Boards;

public class Board extends tech.sorethumb.clion.integrations.CommandLine {
    
    
    public static String BoardListJSON () {
        return BoardList(true);
    }
    
    public static String BoardList () {
        return BoardList(false);
    }
    
    private static String BoardList (boolean asJSON) {
        
        ProcessBuilder builder =
                new ProcessBuilder(ProcessBuilderCommands.ARDUINO_CLI,
                        tech.sorethumb.clion.constants.ACliC.Board.asString(),
                        tech.sorethumb.clion.constants.ACliC.Board.LIST);
        return CommandLine.ExecuteCommandLine(builder, asJSON, false);
    }
    
    public static String BoardListAllJSON () {
        return BoardListAll(true);
    }
    
    public static String BoardListAll () {
        return BoardListAll(false);
    }
    
    private static String BoardListAll (boolean asJSON) {
        
        ProcessBuilder builder =
                new ProcessBuilder(
                        ProcessBuilderCommands.ARDUINO_CLI,
                        tech.sorethumb.clion.constants.ACliC.Board.asString(),
                        tech.sorethumb.clion.constants.ACliC.Board.LISTALL);
        return ExecuteCommandLine(builder, asJSON, false);
    }
    
    public static Boards deserialize(String json){
        Gson gson = new Gson();
        Boards boards = (Boards)gson.fromJson(json, Boards.class);
        return boards;
    }
}
