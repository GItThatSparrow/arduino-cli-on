package tech.sorethumb.clion.integrations.ACliC;


/**
 * Putting any additional implementation on hold.  Need the ability
 * to create a sketch in the current project.  This is better suited for some of
 * the methods available in the IntelliJ API.
 */
public class Sketch {
    
    /**
     * Creates a new sketch in the default Arduino location,
     * using the provided file name.
     * @param fileName The name of the new sketch.
     * @return The path of the new sketch.
     */
    public static String newSketch(String fileName){
        
        // Returns something like Sketch created in: /Users/username/Documents/Arduino/myNewSketch.ino
        return "ERROR";
    }
    /**
     * Creates a new sketch in the default Arduino location,
     * using the provided file name.
     * @param fileName The name of the new sketch.
     * @return The path of the new sketch.
     */
    public static String newSketch(String Directory, String fileName){
        // Returns something like Sketch created in:
        //      /Users/username/Documents/Arduino/myNewSketch.ino
        // which is a directory. The file is located at..
        //      /Users/username/Documents/Arduino/myNewSketch.ino/myNewSketch.ino.ino
        
        return "ERROR";
    }
    
    /**
     * Arduino CLI Sketch Commands.
     */
    public static class Constants {
        
        public static final String SKETCH = "sketch";
        
        @Override
        public String toString(){ return SKETCH; }
        
        public static String asString() { return SKETCH; }
        
        public static final String NEW = "new";
    }
}
