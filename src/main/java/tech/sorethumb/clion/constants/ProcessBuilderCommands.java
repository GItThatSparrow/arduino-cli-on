package tech.sorethumb.clion.constants;

public class ProcessBuilderCommands {
    
    /**
     * Get the default command-line name of the Arduino CLI.
     */
    public static final String ARDUINO_CLI = "arduino-cli";
    
    /**
     * The output format as JSON.
     */
    public static final String FORMAT_JSON = "--format=json";
    
    /**
     * Enables debug output (super verbose, used to debug the CLI).
     */
    public static final String DEBUG = "--debug";
    
    /**
     * Help about any command
     */
    public static final String HELP = "--help";
    
    public static final String REGEX_PARAM_NAME_VALUE = "--%s \"%s\"";
    
    /*
    *//**
     * Arduino Configuration Commands
     *//*
    public static class Config {
        
        public static final String CONFIG = "config";
        
        @Override
        public String toString () {
            return CONFIG;
        }
        
        public static String asString () {
            return CONFIG;
        }
    }
    
    *//**
     * Arduino Root operations
     *//*
    public static class Core {
        
        public static final String CORE = "core";
        
        @Override
        public String toString () {
            return CORE;
        }
        
        public static String asString () {
            return CORE;
        }
    }
    
    *//**
     * Arduino commands about libraries
     *//*
    public static class Lib {
        
        public static final String LIB = "lib";
        
        @Override
        public String toString () {
            return LIB;
        }
        
        public static String asString () {
            return LIB;
        }
    }*/
    
    /**
     * Arduino CLI Sketch Commands
     */
    public static class Sketch {
        
        public static final String SKETCH = "sketch";
        
        @Override
        public String toString () {
            return SKETCH;
        }
        
        public static String asString () {
            return SKETCH;
        }
    }
    
    /**
     * Upload Arduino sketches
     */
    public static class Upload {
        
        public static final String UPLOAD = "upload";
        
        @Override
        public String toString () {
            return UPLOAD;
        }
        
        public static String asString () {
            return UPLOAD;
        }
    }
    
}
