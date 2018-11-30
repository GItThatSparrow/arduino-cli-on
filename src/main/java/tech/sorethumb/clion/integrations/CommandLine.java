package tech.sorethumb.clion.integrations;

import com.intellij.openapi.diagnostic.Logger;
import tech.sorethumb.clion.constants.ProcessBuilderCommands;
import tech.sorethumb.clion.integrations.ACliC.Core;
import tech.sorethumb.clion.utils.Environment;

import java.io.IOException;

public class CommandLine {
    
    private static final Logger log = Logger.getInstance(CommandLine.class);
    
    private static final String HELP_FIRST_LINE = "Arduino Command Line Interface (arduino-cli).";
    
    static String help () {
        
        ProcessBuilder builder = new ProcessBuilder(ProcessBuilderCommands.HELP);
        return ExecuteCommandLine(builder);
    }
    
    /**
     * This is a generic method for testing wheter or not the {@code arduino-cli} is installed
     *
     * There is a {@code Validate} command in the code, but it's commented out.  This does
     * not validate the installation, it simply checks if it is available at all.
     *
     * @see <a href="https://github.com/arduino/arduino-cli/blob/master/commands/validate/validate.go">Validate</a>
     * @return
     */
    static Boolean hasArduinoCliInstalled () {
        try {
            String getHelp = help();
            return (getHelp.startsWith(HELP_FIRST_LINE));
        } catch (Exception x) {
            log.error("Did not successfully execute the Arduino CLI Command behind the `hasArduinoCliInstalled()` method.");
        }
        return false;
    }
    
    /**
     * Run a command-line operation and get the response in JSON, if it is available.
     *
     * Every command will be passed the {@code --format=json} parameter.
     *
     * @param builder Used to build the command executed
     * @return A complete {@link String} of the execution result.
     */
    protected static String ExecuteCommandLine (ProcessBuilder builder) {
        builder.command().add(0, ProcessBuilderCommands.ARDUINO_CLI);
        /*
        Adding these checks here since the command returns an empty string if the "--format=json" flag is added.
        */
        if(!builder.command().contains(Core.Constants.UPDATE_INDEX) &&
                !builder.command().contains(Core.Constants.INSTALL) &&
                !builder.command().contains(Core.Constants.DOWNLOAD)) {
            log.debug("Adding JSON Flag.");
            builder.command().add(ProcessBuilderCommands.FORMAT_JSON);
        }
        
        if (Environment.isDebugEnv()) {
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
            log.debug(String.format("The command-line operation has exited with a code of: %s", p.exitValue()));
            line = ioThreadHandler.getOutput().toString();
        } catch (IOException | InterruptedException e) {
            line = e.getMessage();
        }
        return line;
    }
}
