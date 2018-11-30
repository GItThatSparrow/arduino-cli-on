package tech.sorethumb.clion.integrations.ACliC;

import tech.sorethumb.clion.constants.ProcessBuilderCommands;
import tech.sorethumb.clion.integrations.CommandLine;

import javax.annotation.Nullable;

/**
 * Upload Arduino sketches.
 *
 * <b>Usage:</b>
 * <code>
 *         arduino-cli upload [flags]
 * </code>
 * <b>Examples:</b>
 * <code>
 *         arduino-cli upload /home/user/Arduino/MySketch
 * </code>
 */
public class Upload extends CommandLine {
    
    String fqbn,input,port;
    Boolean verbose,verify;
    
    /**
     * Upload a compiled program to a board.
     * @param fqbn The Fully Qualified Board Name, e.g.: arduino:avr:uno
     * @param input Input file to be uploaded.
     * @param port Upload port, e.g.: COM10 or /dev/ttyACM0
     * @return
     */
    public static String uploadToBoard(String fqbn, String input, String port){
        ProcessBuilder builder =
                new ProcessBuilder(Constants.asString(),
                        String.format("--%s=%s",Constants.FQBN, fqbn),
                        String.format("--%s=%s",Constants.INPUT, input),
                        String.format("--%s=%s",Constants.PORT, port));
        return ExecuteCommandLine(builder);
    }
    
    /**
     * Upload a compiled program to a board.
     * @param fqbn The Fully Qualified Board Name, e.g.: arduino:avr:uno
     * @param input Input file to be uploaded.
     * @param port Upload port, e.g.: COM10 or /dev/ttyACM0
     * @param verbose Optional, turns on verbose mode.
     * @param verify Optional, Verify uploaded binary after the upload.
     * @return
     */
    public static String uploadToBoard(String fqbn, String input, String port, @Nullable Boolean verbose, @Nullable Boolean verify){
        ProcessBuilder builder =
                new ProcessBuilder(Constants.asString(),
                        String.format("--%s=%s",Constants.FQBN, fqbn),
                        String.format("--%s=%s",Constants.INPUT, input),
                        String.format("--%s=%s",Constants.PORT, port));
        if(verbose != null) builder.command().add(String.format("--%s", Constants.VERBOSE));
        if(verify != null) builder.command().add(String.format("--%s", Constants.VERIFY));
        return ExecuteCommandLine(builder);
    }
    
    /**
     * Get the Fully Qualified Board Name, e.g.: arduino:avr:uno
     */
    public String getFqbn () {
        return fqbn;
    }
    
    /**
     * Set the {@code fqbn}
     *
     * @param fqbn Fully Qualified Board Name, e.g.: arduino:avr:uno
     */
    public void setFqbn (String fqbn) {
        this.fqbn = fqbn;
    }
    
    /**
     * Input file to be uploaded.
     */
    public String getInput () {
        return input;
    }
    
    public void setInput (String input) {
        this.input = input;
    }
    
    /**
     * Upload port, e.g.: COM10 or /dev/ttyACM0
     */
    public String getPort () {
        return port;
    }
    
    public void setPort (String port) {
        this.port = port;
    }
    
    /**
     * Optional, turns on verbose mode.
     */
    public Boolean getVerbose () {
        return verbose;
    }
    
    public void setVerbose (Boolean verbose) {
        this.verbose = verbose;
    }
    
    /**
     * Verify uploaded binary after the upload.
     */
    public Boolean getVerify () {
        return verify;
    }
    
    public void setVerify (Boolean verify) {
        this.verify = verify;
    }
    
    public static class Constants {
        
        public static final String UPLOAD = "upload";
    
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
            return UPLOAD;
        }
        
        public static String asString(){ return UPLOAD; }
        
        /**
         * Fully Qualified Board Name, e.g.: arduino:avr:uno
         */
        public static final String FQBN = "fqbn";
        /**
         * Input file to be uploaded.
         */
        public static final String INPUT = "input";
        /**
         * Upload port, e.g.: COM10 or /dev/ttyACM0
         */
        public static final String PORT = "port";
        /**
         * Optional, turns on verbose mode.
         */
        public static final String VERBOSE = "verbose";
        /**
         * Verify uploaded binary after the upload.
         */
        public static final String VERIFY = "verify";

    }
}
