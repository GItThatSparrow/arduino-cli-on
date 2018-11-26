package tech.sorethumb.clion.models;

import tech.sorethumb.clion.integrations.CommandLine;

/**
 * Represents a small, baseline set of configuration values on
 * the user's system.  Use the {@link CommandLine#configDump()} output as this
 * object's input.
 *
 * NOTE: This class isn't serializable since it's not possible to get a structured
 * response from the {@link CommandLine#configDump()} operation.
 */
public class ConfigDump {
    
    private String proxy_type;// auto
    private String sketchbook_path;// /Users/nickromans/Documents/Arduino
    private String arduino_data;// /Users/nickromans/Library/arduino15
    private String board_manager;// null
    
    
    public ConfigDump(String proxyType, String sbPath, String arduinoData, String boardManager){
        proxy_type = proxyType;
        sketchbook_path = sbPath;
        arduino_data = arduinoData;
        board_manager = boardManager;
    }
    
    public String getProxy_type () {
        return proxy_type;
    }
    
    public void setProxy_type (String proxy_type) {
        this.proxy_type = proxy_type;
    }
    
    public String getSketchbook_path () {
        return sketchbook_path;
    }
    
    public void setSketchbook_path (String sketchbook_path) {
        this.sketchbook_path = sketchbook_path;
    }
    
    public String getArduino_data () {
        return arduino_data;
    }
    
    public void setArduino_data (String arduino_data) {
        this.arduino_data = arduino_data;
    }
    
    public String getBoard_manager () {
        return board_manager;
    }
    
    public void setBoard_manager (String board_manager) {
        this.board_manager = board_manager;
    }
}
