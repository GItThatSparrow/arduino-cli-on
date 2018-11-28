package tech.sorethumb.clion.integrations;

import com.intellij.openapi.diagnostic.Logger;
import tech.sorethumb.clion.constants.ProcessBuilderCommands;

import java.io.IOException;

public class CommandLine {
    
    private static final Logger log = Logger.getInstance(CommandLine.class);
    
    private static final String HELP_FIRST_LINE = "Arduino Command Line Interface (arduino-cli).";
    
    static String help () {
        
        ProcessBuilder builder = new ProcessBuilder(ProcessBuilderCommands.ARDUINO_CLI, ProcessBuilderCommands.HELP);
        return ExecuteCommandLine(builder);
    }
    
    static Boolean hasArduinoCliInstalled () {
        try {
            String getHelp = help();
            return (getHelp.startsWith(HELP_FIRST_LINE));
        } catch (Exception x) {
            log.error("Did not successfully execute the Arduino CLI Command behind the `hasArduinoCliInstalled()` method.");
        }
        return false;
    }
    
    private static String ExecuteCommandLine (ProcessBuilder builder) {
        return ExecuteCommandLine(builder, false);
    }
    
    private static String ExecuteCommandLine (ProcessBuilder builder, boolean debug) {
        return ExecuteCommandLine(builder, false, debug);
    }
    
    protected static String ExecuteCommandLine (ProcessBuilder builder, boolean JSON, boolean DEBUG) {
        if (JSON) {
            log.debug("Adding JSON Flag.");
            builder.command().add(ProcessBuilderCommands.FORMAT_JSON);
        }
        if (DEBUG) {
            log.debug("Adding DEBUG flag.");
            builder.command().add(ProcessBuilderCommands.DEBUG);
        }
        String line;
        try {
            log.debug("Builder Command: " + builder.command());
            Process p = builder.start();
            IOThreadHandler ioThreadHandler = new IOThreadHandler(p.getInputStream());
            ioThreadHandler.start();
            p.waitFor();
            line = ioThreadHandler.getOutput().toString();
        } catch (IOException | InterruptedException e) {
            line = e.getMessage();
        }
        return line;
    }
}
